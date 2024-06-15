import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    id("convention.publication")
    alias(libs.plugins.spotless)
    alias(libs.plugins.cocoapods)
}

group = "ru.sulgik.maps"
version = "1.0"

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "yandex-map-kmp"
            isStatic = true
        }
    }

    cocoapods {
        summary = "Module to add new KMP api for Yandex MapKit"
        homepage = "https://yandex.ru/dev/mapkit/doc"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        framework {
            baseName = "YandexMapKitKMP"
            isStatic = true
        }
        pod("YandexMapsMobile") {
            moduleName = "YandexMapsMobile"
            version = libs.versions.yandex.mapkit.get()
            packageName = "YandexMapKit"
        }
    }

    sourceSets {
        androidMain.dependencies {
            api(libs.yandex.mapkit)
        }
        commonMain.dependencies {
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

android {
    namespace = "ru.sulgik.mapkit"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
