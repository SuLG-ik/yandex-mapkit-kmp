import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.process.ExecOperations
import org.jetbrains.dokka.ExternalDocumentationLink
import org.jetbrains.dokka.ExternalDocumentationLinkImpl
import org.jetbrains.dokka.gradle.DokkaMultiModuleTask
import org.jetbrains.dokka.gradle.GradleExternalDocumentationLinkBuilder
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.dsl.abi.BinariesSource
import org.jetbrains.kotlin.gradle.dsl.abi.ExperimentalAbiValidation
import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import java.io.ByteArrayOutputStream
import java.net.URL
import java.util.Properties
import javax.inject.Inject

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
            targetExclude("**/build/**")
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

private val libraryProjects = dokkaModules.keys.map { ":$it" }

fun libraryTasksNamed(taskName: String): List<TaskCollection<Task>> {
    return libraryProjects.map { path -> project(path).tasks.matching { it.name == taskName } }
}

fun registerLibraryTask(name: String, taskName: String, taskGroup: String, taskDescription: String) {
    tasks.register(name) {
        group = taskGroup
        description = taskDescription
        dependsOn(libraryTasksNamed(taskName))
    }
}

registerLibraryTask(
    name = "libraryAssemble",
    taskName = "assemble",
    taskGroup = "build",
    taskDescription = "Assembles the published modules.",
)

registerLibraryTask(
    name = "libraryCompileIosArm64",
    taskName = "compileKotlinIosArm64",
    taskGroup = "build",
    taskDescription = "Compiles the published modules for the iOS device target.",
)

registerLibraryTask(
    name = "libraryTests",
    taskName = "allTests",
    taskGroup = "verification",
    taskDescription = "Runs the tests of the published modules on every enabled target.",
)

registerLibraryTask(
    name = "libraryIosTests",
    taskName = "iosSimulatorArm64Test",
    taskGroup = "verification",
    taskDescription = "Runs the tests of the published modules on the iOS simulator.",
)

registerLibraryTask(
    name = "libraryLinkIosFramework",
    taskName = "linkPodDebugFrameworkIosArm64",
    taskGroup = "build",
    taskDescription = "Links the Objective-C frameworks of the published modules for the iOS device target.",
)

tasks.register("libraryApiCheck") {
    group = "verification"
    description = "Checks the public API of the published modules against the dumps in api/."
    dependsOn(libraryTasksNamed("checkKotlinAbi"))
    dependsOn(libraryTasksNamed("checkAndroidAbi"))
}

tasks.register("libraryApiDump") {
    group = "verification"
    description = "Rewrites the public API dumps of the published modules."
    dependsOn(libraryTasksNamed("updateKotlinAbi"))
    dependsOn(libraryTasksNamed("updateAndroidAbi"))
}

subprojects {
    extra.set("library_version", getProperty("library_version", "0.0.0"))

    group = "ru.sulgik.mapkit"

    if (name in dokkaModules.keys) {
        apply(plugin = "org.jetbrains.dokka")

        dokka {
            moduleName.set(dokkaModules[name])
        }

        configureAbiValidation()
        configureAndroidAbiValidation()
        configureYandexMapsMobileLinking()
    }
}

private val yandexMapsMobileFrameworks = listOf(
    "CoreLocation",
    "SystemConfiguration",
    "NetworkExtension",
)

fun Project.configureYandexMapsMobileLinking() {
    afterEvaluate {
        val kotlin = extensions.findByType<KotlinMultiplatformExtension>() ?: return@afterEvaluate

        kotlin.targets.withType<KotlinNativeTarget>().configureEach {
            binaries.withType<Framework>().configureEach {
                yandexMapsMobileFrameworks.forEach { linkerOpts("-framework", it) }
            }
        }
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

fun Project.configureAndroidAbiValidation() {
    val referenceDump = layout.projectDirectory.file("api/$name.android.api")

    val dump = tasks.register<AndroidAbiDumpTask>("dumpAndroidAbi") {
        group = "verification"
        description = "Dumps the public API of the Android target into the build directory."
        dumpFile.set(layout.buildDirectory.file("androidAbi/$name.android.api"))
    }

    tasks.register<AndroidAbiUpdateTask>("updateAndroidAbi") {
        group = "verification"
        description = "Rewrites the public API dump of the Android target."
        actualFile.set(dump.flatMap { it.dumpFile })
        referenceFile.set(referenceDump)
    }

    tasks.register<AndroidAbiCheckTask>("checkAndroidAbi") {
        group = "verification"
        description = "Checks the public API of the Android target against the dump in api/."
        actualFile.set(dump.flatMap { it.dumpFile })
        expectedFile.set(referenceDump)
        updateTaskPath.set("$path:updateAndroidAbi")
    }

    afterEvaluate {
        val android = extensions.findByType<KotlinMultiplatformExtension>()
            ?.targets?.findByName("android") ?: return@afterEvaluate
        dump.configure {
            classesDirs.from(android.compilations.getByName("main").output.classesDirs)
        }
    }
}

abstract class AndroidAbiDumpTask : DefaultTask() {

    @get:InputFiles
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val classesDirs: ConfigurableFileCollection

    @get:OutputFile
    abstract val dumpFile: RegularFileProperty

    @get:Inject
    abstract val execOperations: ExecOperations

    @TaskAction
    fun dump() {
        val roots = classesDirs.files.filter(File::isDirectory)
        val classNames = roots.flatMap { root ->
            root.walkTopDown()
                .filter { it.isFile && it.extension == "class" }
                .map { it.relativeTo(root).invariantSeparatorsPath.removeSuffix(".class").replace('/', '.') }
                .filterNot { it.substringAfterLast('.').matches(Regex(".*\\\$\\d+")) }
                .filterNot { it.endsWith("\$WhenMappings") }
                .toList()
        }.sorted()

        val javap = File(File(System.getProperty("java.home"), "bin"), "javap")
        val output = ByteArrayOutputStream()
        if (classNames.isNotEmpty()) {
            execOperations.exec {
                executable = javap.absolutePath
                args("-public", "-classpath", roots.joinToString(File.pathSeparator))
                args(classNames)
                standardOutput = output
            }
        }

        val text = output.toString(Charsets.UTF_8.name())
            .lineSequence()
            .filterNot { it.startsWith("Compiled from") || it.contains("access\$") || it.isBlank() }
            .joinToString(separator = "\n", postfix = "\n")
        dumpFile.get().asFile.apply { parentFile.mkdirs() }.writeText(text)
    }
}

abstract class AndroidAbiUpdateTask : DefaultTask() {

    @get:InputFile
    abstract val actualFile: RegularFileProperty

    @get:OutputFile
    abstract val referenceFile: RegularFileProperty

    @TaskAction
    fun update() {
        actualFile.get().asFile.copyTo(referenceFile.get().asFile, overwrite = true)
    }
}

abstract class AndroidAbiCheckTask : DefaultTask() {

    @get:InputFile
    abstract val actualFile: RegularFileProperty

    @get:InputFiles
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val expectedFile: RegularFileProperty

    @get:Input
    abstract val updateTaskPath: Property<String>

    @TaskAction
    fun check() {
        val expected = expectedFile.get().asFile
        val actual = actualFile.get().asFile
        if (!expected.exists()) {
            throw GradleException("No Android API dump in ${expected.path}, run ${updateTaskPath.get()}")
        }
        if (expected.readText() != actual.readText()) {
            throw GradleException(
                "The public API of the Android target does not match ${expected.path}, " +
                    "run ${updateTaskPath.get()} if the change is intentional",
            )
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
