rootProject.name = "yandex-map-kmp"
include(":yandex-map-kmp")
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
