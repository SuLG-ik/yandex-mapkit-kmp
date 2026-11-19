import MapInteractionFixture
import SwiftUI

@main
struct MapInteractionApp: App {
    var body: some Scene {
        WindowGroup {
            if ProcessInfo.processInfo.arguments.contains("--lifecycle-scenario") {
                LifecycleHost()
            } else {
                ComposeMapHost()
            }
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

private struct LifecycleHost: View {
    @State private var scenario = MapLifecycleScenario()
    @State private var attached = true

    var body: some View {
        VStack {
            Button(attached ? "Detach map host" : "Attach map host") { attached.toggle() }
            if attached {
                LifecycleComposeHost(scenario: scenario)
            }
        }
    }
}

private struct LifecycleComposeHost: UIViewControllerRepresentable {
    let scenario: MapLifecycleScenario

    func makeUIViewController(context: Context) -> UIViewController {
        MapLifecycleViewControllerKt.lifecycleViewController(scenario: scenario)
    }

    func updateUIViewController(_ controller: UIViewController, context: Context) {}
}
