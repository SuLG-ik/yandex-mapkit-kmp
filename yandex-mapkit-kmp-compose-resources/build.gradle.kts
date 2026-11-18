import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.SourcesJar
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.compose.plugin)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.cocoapods)
    alias(libs.plugins.publish)
}

val supportIosTarget = project.property("skipIosTarget") != "true"
version = extra["library_version"].toString()

compose.resources {
    generateResClass = never
}

kotlin {
    android {
        namespace = "ru.sulgik.mapkit.compose.resources"
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

    if (supportIosTarget) {
        iosArm64()
        iosSimulatorArm64()

        cocoapods {
            ios.deploymentTarget = "15.0"
            framework {
                baseName = "YandexMapKitKMPComposeResources"
            }
            noPodspec()
            pod("YandexMapsMobile") {
                version = libs.versions.yandex.mapkit.get()
                packageName = "YandexMapKit"
            }
        }
    }

    sourceSets.commonMain.dependencies {
        api(project(":yandex-mapkit-kmp-compose"))
        api(compose.components.resources)
        implementation(compose.runtime)
        implementation(compose.ui)
    }

    explicitApi()
}

if (version != "null") {
    mavenPublishing {
        coordinates(group.toString(), name, version.toString())
        publishToMavenCentral()

        signAllPublications()
        configure(
            KotlinMultiplatform(
                javadocJar = JavadocJar.Empty(),
                sourcesJar = SourcesJar.Sources(),
            ),
        )

        pom {
            name.set("Yandex MapKit KMP Compose Resources")
            description.set("Use Compose Multiplatform drawable resources as images in Yandex MapKit KMP.")
            inceptionYear.set("2026")
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
