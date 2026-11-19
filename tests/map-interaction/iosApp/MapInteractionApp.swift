import MapInteractionFixture
import SwiftUI

@main
struct MapInteractionApp: App {
    var body: some Scene {
        WindowGroup {
            ComposeMapHost()
        }
    }
}

private struct ComposeMapHost: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        let arguments = ProcessInfo.processInfo.arguments
        if arguments.contains("--cluster-image-test") {
            return InteractionViewControllerKt.iconRenderingViewController(clustered: true)
        }
        if arguments.contains("--placemark-image-test") {
            return InteractionViewControllerKt.iconRenderingViewController(clustered: false)
        }
        return InteractionViewControllerKt.interactionViewController()
    }

    func updateUIViewController(_ controller: UIViewController, context: Context) {}
}
