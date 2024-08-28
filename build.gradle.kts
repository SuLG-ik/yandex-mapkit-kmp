import java.util.Properties

plugins {
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.cocoapods).apply(false)
    alias(libs.plugins.compose.plugin).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.buildKonfig).apply(false)
    alias(libs.plugins.publish).apply(false)
    alias(libs.plugins.atomicfu).apply(false)
}

subprojects {
    extra.set("library_version", getProperty("library_version", "null"))

    group = "ru.sulgik.mapkit"
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