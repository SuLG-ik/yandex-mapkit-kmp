import com.codingfeline.buildkonfig.compiler.FieldSpec
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.compose.plugin)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.cocoapods)
    alias(libs.plugins.buildKonfig)
}

kotlin {
    android {
        namespace = "ru.sulgik.mapkit.sample"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        androidResources {
            enable = true
        }

        compilations.configureEach {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }
        }
    }

    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "15.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "ComposeApp"
            isStatic = true
        }
        pod("YandexMapsMobile") {
            version = libs.versions.yandex.mapkit.get()
            packageName = "YandexMapKit"
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.okhttp)
        }
        iosMain.dependencies {
            implementation(libs.ktor.darwin)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(libs.coil.compose)
            implementation(libs.coil.ktor)
            api(project(":yandex-mapkit-kmp-compose"))
            implementation(compose.components.uiToolingPreview)
        }
    }
}

buildkonfig {
    packageName = "ru.sulgik.mapkit.sample"
    defaultConfigs {
        buildConfigField(
            FieldSpec.Type.STRING,
            "MAPKIT_API_KEY",
            getMapkitApiKey(),
            const = true
        )
    }
}

fun getMapkitApiKey(): String {
    return try {
        val properties = Properties()
        rootProject.file("local.properties").inputStream().use { properties.load(it) }
        val value = properties.getProperty("MAPKIT_API_KEY", "")
        if (value.isEmpty()) {
            throw InvalidUserDataException("MapKit API key is not provided. Set your API key in the project's local.properties file: `MAPKIT_API_KEY=<your-api-key-value>`.")
        }
        value
    } catch (e: Exception) {
        project.findProperty("signingKey") as String? ?: System.getenv()["signingKey"] ?: ""
    }
}
