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
}

ext {
    set("mapKitApiKey", getMapkitApiKey())
}
fun getMapkitApiKey(): String {
    val properties = Properties()
    project.file("local.properties").inputStream().use { properties.load(it) }
    val value = properties.getProperty("MAPKIT_API_KEY", "")
    if (value.isEmpty()) {
        throw InvalidUserDataException("MapKit API key is not provided. Set your API key in the project's local.properties file: `MAPKIT_API_KEY=<your-api-key-value>`.")
    }
    return value
}

subprojects {
    group = "ru.sulgik.mapkit"
}