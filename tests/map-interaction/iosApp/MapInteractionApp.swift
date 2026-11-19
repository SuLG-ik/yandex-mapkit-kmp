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
        let cameraFlag = "--camera="
        if let argument = CommandLine.arguments.first(where: { $0.hasPrefix(cameraFlag) }) {
            return CameraViewControllerKt.cameraViewController(mode: String(argument.dropFirst(cameraFlag.count)))
        }
        return InteractionViewControllerKt.interactionViewController(
            tapCases: ProcessInfo.processInfo.arguments.contains("--map-tap-cases")
        )
    }

    func updateUIViewController(_ controller: UIViewController, context: Context) {}
}
