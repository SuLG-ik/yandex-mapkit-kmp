rootProject.name = "yandex-mapkit-kmp"
include(":yandex-mapkit-kmp")
include(":yandex-mapkit-kmp-compose")
include(":sample:common")
include(":sample:android")
includeBuild("convention-plugins")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
