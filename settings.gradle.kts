rootProject.name = "yandex-mapkit-kmp"
include(":yandex-mapkit-kmp")
include(":yandex-mapkit-kmp-moko")
include(":yandex-mapkit-kmp-moko-compose")
include(":yandex-mapkit-kmp-compose")
include(":yandex-mapkit-kmp-compose-resources")
include(":sample:composeApp")
include(":sample:androidApp")

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
