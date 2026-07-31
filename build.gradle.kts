import com.diffplug.gradle.spotless.SpotlessExtension
import org.jetbrains.dokka.ExternalDocumentationLink
import org.jetbrains.dokka.ExternalDocumentationLinkImpl
import org.jetbrains.dokka.gradle.DokkaMultiModuleTask
import org.jetbrains.dokka.gradle.GradleExternalDocumentationLinkBuilder
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.dsl.abi.BinariesSource
import org.jetbrains.kotlin.gradle.dsl.abi.ExperimentalAbiValidation
import java.net.URL
import java.util.Properties

plugins {
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.android.kmp.library).apply(false)
    alias(libs.plugins.cocoapods).apply(false)
    alias(libs.plugins.compose.plugin).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.buildKonfig).apply(false)
    alias(libs.plugins.publish).apply(false)
    alias(libs.plugins.spotless).apply(false)
    alias(libs.plugins.dokka)
}

private val ktlintVersion = libs.versions.ktlint.get()

private val ktlintRules = mapOf(
    "ktlint_code_style" to "intellij_idea",
    "ktlint_standard_max-line-length" to "disabled",
    "ktlint_standard_function-expression-body" to "disabled",
    "ktlint_standard_package-name" to "disabled",
    "ktlint_standard_property-naming" to "disabled",
    "ktlint_standard_function-naming" to "disabled",
    "ktlint_standard_filename" to "disabled",
)

allprojects {
    apply(plugin = "com.diffplug.spotless")

    extensions.configure<SpotlessExtension> {
        kotlin {
            target("src/**/*.kt")
            targetExclude("**/build/**", "**/MapObjectStatesRestorationTest.kt")
            ktlint(ktlintVersion).editorConfigOverride(ktlintRules)
        }
        kotlinGradle {
            target("*.gradle.kts")
            ktlint(ktlintVersion).editorConfigOverride(ktlintRules)
        }
    }
}

private val dokkaModules = mapOf(
    "yandex-mapkit-kmp" to "Yandex MapKit SDK KMP",
    "yandex-mapkit-kmp-compose" to "Yandex MapKit KMP SDK Compose Utils",
    "yandex-mapkit-kmp-moko" to "Yandex MapKit KMP SDK MOKO Utils",
    "yandex-mapkit-kmp-moko-compose" to "Yandex MapKit KMP SDK MOKO Compose Utils",
)

subprojects {
    extra.set("library_version", getProperty("library_version", "0.0.0"))

    group = "ru.sulgik.mapkit"

    if (name in dokkaModules.keys) {
        apply(plugin = "org.jetbrains.dokka")

        dokka {
            moduleName.set(dokkaModules[name])
        }

        configureAbiValidation()
    }
}

@OptIn(ExperimentalAbiValidation::class)
fun Project.configureAbiValidation() {
    afterEvaluate {
        val kotlin = extensions.findByType<KotlinProjectExtension>() ?: return@afterEvaluate

        kotlin.abiValidation {
            referenceDumpDir.set(layout.projectDirectory.dir("api"))
            binariesSource.set(BinariesSource.MAIN_COMPILATION)
        }
    }
}

dependencies {
    dokkaModules.keys.forEach {
        dokka(project(":$it"))
    }
}

dokka {
    dokkaPublications.html {
        moduleName.set("Yandex MapKit KMP")
        moduleVersion.set(getProperty("library_version", "0.0.0"))
        outputDirectory.set(rootDir.resolve("docs/kdoc"))
    }
}

fun Project.getProperty(name: String, defaultValue: String): String {
    return getProperty(name) ?: defaultValue
}

fun Project.getProperty(name: String): String? {
    return getEnvironmentProperty(name)
        ?: rootProject.getLocalProperty(name)
        ?: rootProject.findProperty(name)?.toString()
}

fun getEnvironmentProperty(name: String, defaultValue: String): String? {
    return getEnvironmentProperty(name) ?: defaultValue
}

fun getEnvironmentProperty(name: String): String? {
    return System.getenv()[name]
}

fun Project.getLocalProperty(name: String, defaultValue: String): String {
    return getLocalProperty(name) ?: defaultValue
}

fun Project.getLocalProperty(name: String): String? {
    return getLocalProperties().getProperty(name)
}

fun Project.getLocalProperties(): Properties {
    return loadLocalProperties()
}

fun Project.loadLocalProperties(fileName: String = "local.properties"): Properties {
    return Properties().also { properties ->
        try {
            file(fileName).inputStream().use { properties.load(it) }
        } catch (e: Exception) {
            logger.info("$fileName not found, skip loading properties")
        }
    }
}
