plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "ru.sulgik.liteconsumer"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "ru.sulgik.liteconsumer"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.androidx.activity.compose)
}

tasks.register("verifyLiteSdk") {
    doLast {
        val selectedVersions = configurations.getByName("debugRuntimeClasspath").incoming.resolutionResult
            .allComponents
            .mapNotNull { it.moduleVersion }
            .filter { it.group == "com.yandex.android" && it.name == "maps.mobile" }
            .map { it.version }
        val expected = libs.versions.yandex.mapkit.get()
        check(expected.endsWith("-lite") && selectedVersions == listOf(expected)) {
            "Expected exactly one com.yandex.android:maps.mobile:$expected, resolved $selectedVersions"
        }
        logger.lifecycle("Verified com.yandex.android:maps.mobile:$expected")
    }
}
