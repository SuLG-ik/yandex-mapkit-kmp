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
        InteractionViewControllerKt.interactionViewController()
    }

    func updateUIViewController(_ controller: UIViewController, context: Context) {}
}
