import org.gradle.api.artifacts.result.UnresolvedDependencyResult

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.plugin)
    alias(libs.plugins.compose.compiler)
}

val platform = providers.gradleProperty("consumerPlatform").get()
val candidateVersion = providers.gradleProperty("candidateVersion").get()
val edition = providers.gradleProperty("mapkitEdition").orElse("lite").get()
val artifactSuffix = if (edition == "full") "-full" else ""
val sdkVersion = libs.versions.yandex.mapkit.get().removeSuffix("-lite") + "-" + edition
val withMoko = providers.gradleProperty("withMokoResources").orElse("false").get().toBoolean()
val mixEditions = providers.gradleProperty("mixMapKitEditions").orElse("false").get().toBoolean()
val withResources = providers.gradleProperty("withComposeResources").get() == "true"

if (platform == "android") {
    apply(plugin = libs.plugins.android.kmp.library.get().pluginId)
} else {
    apply(plugin = libs.plugins.cocoapods.get().pluginId)
}

kotlin {
    if (platform == "android") {
        extensions.configure<com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget>("android") {
            namespace = "ru.sulgik.liteconsumer.shared"
            compileSdk = libs.versions.android.compileSdk.get().toInt()
            minSdk = libs.versions.android.minSdk.get().toInt()
            androidResources { enable = true }
        }
    } else {
        iosSimulatorArm64()
        extensions.configure<org.jetbrains.kotlin.gradle.plugin.cocoapods.CocoapodsExtension>("cocoapods") {
            summary = "Standalone MapKit Lite consumer"
            homepage = "https://github.com/SuLG-ik/yandex-mapkit-kmp"
            version = "1.0"
            ios.deploymentTarget = "15.0"
            podfile = project.file("../iosApp/Podfile")
            framework {
                baseName = "LiteConsumer"
                isStatic = true
                linkerOpts("-framework", "SystemConfiguration", "-framework", "NetworkExtension")
            }
            pod("YandexMapsMobile") {
                version = sdkVersion
                packageName = "YandexMapKit"
            }
        }
    }

    sourceSets.commonMain {
        kotlin.srcDir(if (edition == "full") "src/fullMain/kotlin" else "src/liteMain/kotlin")
        if (withResources) {
            kotlin.srcDir("src/resourcesMain/kotlin")
        } else {
            kotlin.srcDir("src/noResourcesMain/kotlin")
        }
        dependencies {
            api(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.ui)
            implementation("ru.sulgik.mapkit:yandex-mapkit-kmp$artifactSuffix:$candidateVersion")
            implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-compose$artifactSuffix:$candidateVersion")
            if (withResources) {
                implementation(compose.components.resources)
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-compose-resources$artifactSuffix:$candidateVersion")
            }
            if (withMoko) {
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-moko$artifactSuffix:$candidateVersion")
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-moko-compose$artifactSuffix:$candidateVersion")
            }
            if (mixEditions) {
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp:$candidateVersion")
            }
        }
    }
}

compose.resources {
    packageOfResClass = "ru.sulgik.liteconsumer.generated.resources"
    if (withResources) {
        customDirectory(
            sourceSetName = "commonMain",
            directoryProvider = provider { layout.projectDirectory.dir("src/resourcesMain/composeResources") },
        )
    }
}

tasks.register("verifyMixedMapKitEditions") {
    doLast {
        val configurationName = if (platform == "android") {
            "androidCompileClasspath"
        } else {
            "iosSimulatorArm64CompileKlibraries"
        }
        val resolution = configurations.getByName(configurationName).incoming.resolutionResult
        val failures = resolution.allDependencies.filterIsInstance<UnresolvedDependencyResult>()
            .map { it.failure.stackTraceToString() }
        check(failures.any { it.contains("Choose either MapKit Lite or Full") }) {
            "Expected Gradle to reject mixed MapKit editions. Resolution errors:\n${failures.joinToString("\n")}"
        }
        logger.lifecycle("Mixed MapKit editions rejected by the Full artifact's Lite exclusion constraint")
    }
}
