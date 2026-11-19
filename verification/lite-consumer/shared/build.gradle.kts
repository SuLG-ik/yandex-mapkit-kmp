plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.plugin)
    alias(libs.plugins.compose.compiler)
}

val platform = providers.gradleProperty("consumerPlatform").get()
val candidateVersion = providers.gradleProperty("candidateVersion").get()
val sdkVersion = libs.versions.yandex.mapkit.get()
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
        sourceSets.getByName("androidMain").dependencies {
            implementation(libs.yandex.mapkit)
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
        if (withResources) {
            kotlin.srcDir("src/resourcesMain/kotlin")
        } else {
            kotlin.srcDir("src/noResourcesMain/kotlin")
        }
        dependencies {
            api(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.ui)
            implementation("ru.sulgik.mapkit:yandex-mapkit-kmp:$candidateVersion")
            implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-compose:$candidateVersion")
            if (withResources) {
                implementation(compose.components.resources)
                implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-compose-resources:$candidateVersion")
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
