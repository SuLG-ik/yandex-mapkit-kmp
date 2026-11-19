plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.plugin)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.cocoapods)
}

version = "1.0"

kotlin {
    iosSimulatorArm64()

    cocoapods {
        name = "MapInteractionFixture"
        summary = "Test host for native MapKit gestures"
        homepage = "https://github.com/SuLG-ik/yandex-mapkit-kmp"
        ios.deploymentTarget = "16.0"
        podfile = file("iosApp/Podfile")
        framework {
            baseName = "MapInteractionFixture"
            isStatic = true
        }
        pod("YandexMapsMobile") {
            version = libs.versions.yandex.mapkit.get()
            packageName = "YandexMapKit"
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.decompose)
            implementation(libs.decompose.compose)
            implementation(compose.animation)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(libs.navigation3.ui)
            implementation(libs.navigation.event.compose)
            implementation(libs.coil.compose)
            implementation(project(":yandex-mapkit-kmp-compose"))
        }
    }
}
