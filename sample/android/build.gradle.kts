plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.plugin)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "ru.sulgik.mapkit.app"
    compileSdk = 34
    defaultConfig {
        applicationId = "ru.sulgik.mapkit.app"
        minSdk = 24
        targetSdk = 34
        versionCode = 4
        versionName = "0.1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(compose.ui)
    implementation(compose.material3)
    implementation(project(":sample:common"))
    implementation(libs.androidx.activity.compose)
}