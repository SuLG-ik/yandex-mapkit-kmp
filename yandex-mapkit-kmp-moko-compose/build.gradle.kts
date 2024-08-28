import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.cocoapods)
    alias(libs.plugins.compose.plugin)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.publish)
}

val supportIosTarget = project.property("skipIosTarget") != "true"
version = extra["library_version"].toString()

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
        publishLibraryVariants("release")
    }

    if (supportIosTarget) {
        iosX64()
        iosArm64()
        iosSimulatorArm64()

        cocoapods {
            ios.deploymentTarget = "15.0"
            framework {
                baseName = "YandexMapKitKMPMokoCompose"
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
            api(project(":yandex-mapkit-kmp-moko"))
            api(libs.moko.resources.compose)
            implementation(compose.runtime)
            implementation(compose.ui)
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

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}

android {
    namespace = "ru.sulgik.mapkit.moko.compose"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}


if (version != "null") {
    mavenPublishing {
        coordinates(group.toString(), name, version.toString())
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

        signAllPublications()
        configure(
            KotlinMultiplatform(
                javadocJar = JavadocJar.Empty(),
                sourcesJar = true,
                androidVariantsToPublish = listOf("release"),
            )
        )

        pom {
            name.set("Yandex MapKit KMP SDK MOKO Compose Utils")
            description.set("Yandex MapKit KMP SDK is a Kotlin-first SDK for Yandex MapKit. It's API is similar to the Yandex MapKit SDK but also supports multiplatform projects and compose multiplaform, enabling you to use MapKit directly from your common source targeting iOS or Android.")
            inceptionYear.set("2024")
            url.set("https://github.com/SuLG-ik/yandex-mapkit-kmp")
            licenses {
                license {
                    name.set("The Apache License, Version 2.0")
                    url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                }
            }
            developers {
                developer {
                    id.set("sulgik")
                    name.set("Vladimir Nenashkin")
                    url.set("https://github.com/SuLG-ik/yandex-mapkit-kmp")
                }
            }
            scm {
                url.set("https://github.com/SuLG-ik/yandex-mapkit-kmp")
                connection.set("scm:git:git://github.com/SuLG-ik/yandex-mapkit-kmp.git")
                developerConnection.set("scm:git:ssh://git@github.com/SuLG-ik/yandex-mapkit-kmp.git")
            }
        }
    }
}