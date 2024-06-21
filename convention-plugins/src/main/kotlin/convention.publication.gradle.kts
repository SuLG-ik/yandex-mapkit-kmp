import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar

plugins {
    id("maven-publish")
    id("signing")
}

group = "ru.sulgik"

val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

signing {
    val signingKey: String? = project.findProperty("signingKey") as String? ?: System.getenv("signingKey")
    val signingPassword: String? = project.findProperty("signingPassword") as String? ?: System.getenv("signingPassword")
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications)
}

configure<PublishingExtension> {

    tasks.withType<Sign>().configureEach {
        onlyIf { !project.gradle.startParameter.taskNames.any { "MavenLocal" in it } }
    }

    repositories {
        maven {
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2")

            credentials {
                username = project.findProperty("sonatypeUsername") as String? ?: System.getenv("sonatypeUsername")
                password = project.findProperty("sonatypePassword") as String? ?: System.getenv("sonatypePassword")
            }
        }
    }

    publications.all {
        this as MavenPublication
        artifact(javadocJar)

        pom {
            groupId = "ru.sulgik"
            name.set("yandex-mapkit-kmp")
            description.set("Yandex MapKit KMP SDK is a Kotlin-first SDK for Yandex MapKit. It's API is similar to the Yandex MapKit SDK but also supports multiplatform projects and compose multiplaform, enabling you to use MapKit directly from your common source targeting iOS or Android.")
            url.set("https://github.com/SuLG-ik/yandex-mapkit-kmp")
            inceptionYear.set("2024")

            scm {
                url.set("https://github.com/SuLG-ik/yandex-mapkit-kmp")
                connection.set("scm:git:https://github.com/SuLG-ik/yandex-mapkit-kmp.git")
                developerConnection.set("scm:git:scm:git:https://github.com/SuLG-ik/yandex-mapkit-kmp.git")
                tag.set("HEAD")
            }

            issueManagement {
                system.set("GitHub Issues")
                url.set("https://github.com/SuLG-ik/yandex-mapkit-kmp/issues")
            }

            developers {
                developer {
                    name.set("Vladimir Nenashkin")
                    email.set("nenashkinvov@gmail.com")
                }
            }

            licenses {
                license {
                    name.set("The Apache Software License, Version 2.0")
                    url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    distribution.set("repo")
                    comments.set("A business-friendly OSS license")
                }
            }
        }
    }

}

val signingTasks = tasks.withType<Sign>()
tasks.withType<AbstractPublishToMaven>().configureEach {
    mustRunAfter(signingTasks)
}