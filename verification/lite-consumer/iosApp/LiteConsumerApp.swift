import LiteConsumer
import SwiftUI

@main
struct LiteConsumerApp: App {
    var body: some Scene {
        WindowGroup {
            MapScreen().ignoresSafeArea()
        }
    }
}

struct MapScreen: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        let token = ProcessInfo.processInfo.arguments.last!
        return SmokeControllerKt.smokeController(token: token)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
