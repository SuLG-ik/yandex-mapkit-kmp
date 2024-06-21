import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    id("convention.publication")
    alias(libs.plugins.compose.plugin)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.cocoapods)
}

val supportIosTarget = project.property("skipIosTarget") != "true"
version = libs.versions.project.version.get()

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    if (supportIosTarget) {
        iosX64()
        iosArm64()
        iosSimulatorArm64()

        cocoapods {
            ios.deploymentTarget = "15.0"
            framework {
                baseName = "YandexMapKitKMPCompose"
            }
            noPodspec()
            pod("YandexMapsMobile") {
                version = libs.versions.yandex.mapkit.get()
                packageName = "YandexMapKit"
            }
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                progressiveMode = true
                if (name.lowercase().contains("ios")) {
                    optIn("kotlinx.cinterop.ExperimentalForeignApi")
                    optIn("kotlinx.cinterop.BetaInteropApi")
                }
            }
        }
        androidMain.dependencies {
        }
        commonMain.dependencies {
            api(project(":yandex-mapkit-kmp"))
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

    }

    //https://kotlinlang.org/docs/native-objc-interop.html#export-of-kdoc-comments-to-generated-objective-c-headers
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        compilations["main"].compileTaskProvider {
            compilerOptions {
                freeCompilerArgs.add("-Xexport-kdoc")
            }
        }
    }

}


tasks.withType<KotlinCompilationTask<*>> {
    compilerOptions.freeCompilerArgs.add("-opt-in=kotlinx.cinterop.ExperimentalForeignApi")
}


android {
    namespace = "ru.sulgik.mapkit.compose"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
