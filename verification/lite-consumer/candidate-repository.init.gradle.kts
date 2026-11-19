import org.gradle.api.publish.PublishingExtension
import org.gradle.plugins.signing.Sign

gradle.beforeProject {
    val project = this
    pluginManager.withPlugin("maven-publish") {
        project.extensions.configure<PublishingExtension> {
            repositories.maven {
                name = "LiteConsumer"
                url = project.uri(project.providers.gradleProperty("candidateRepository").get())
            }
        }
        if (!project.providers.gradleProperty("candidateSigning").map(String::toBoolean).getOrElse(false)) {
            project.tasks.withType<Sign>().configureEach {
                enabled = false
            }
        }
    }
}
