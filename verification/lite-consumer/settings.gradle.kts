pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        exclusiveContent {
            forRepository {
                maven {
                    url = uri(providers.gradleProperty("candidateRepository").get())
                }
            }
            filter {
                includeGroup("ru.sulgik.mapkit")
            }
        }
        google()
        mavenCentral()
    }
}

rootProject.name = "lite-consumer"
include(":shared")
if (providers.gradleProperty("consumerPlatform").get() == "android") {
    include(":androidApp")
}
