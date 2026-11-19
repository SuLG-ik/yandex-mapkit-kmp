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
        let arguments = ProcessInfo.processInfo.arguments
        if arguments.contains("--trusted-basemap-poi") {
            return makeTrustedPoiController()
        }
        if arguments.contains("--navigation3") {
            return InteractionViewControllerKt.nav3ViewController()
        }
        if arguments.contains("--decompose-stack") {
            return DecomposeStackViewControllerKt.decomposeStackViewController()
        }
        if arguments.contains("--map-object-membership") {
            return InteractionViewControllerKt.objectMembershipViewController()
        }
        return InteractionViewControllerKt.interactionViewController(
            tapCases: arguments.contains("--map-tap-cases")
        )
    }

    func updateUIViewController(_ controller: UIViewController, context: Context) {}

    private func makeTrustedPoiController() -> UIViewController {
        let files = FileManager.default
        guard let runID = ProcessInfo.processInfo.environment["MAPKIT_TRUSTED_POI_RUN_ID"],
              runID.range(of: "^[0-9]+-[0-9]+$", options: .regularExpression) != nil,
              let cache = files.urls(for: .cachesDirectory, in: .userDomainMask).first else {
            return UIHostingController(rootView: Text("trusted POI handoff unavailable"))
        }
        let handoff = cache.appendingPathComponent("mapkit-poi-key-\(runID)")
        do {
            let data = try Data(contentsOf: handoff)
            try files.removeItem(at: handoff)
            guard let key = String(data: data, encoding: .utf8), !key.isEmpty else {
                return UIHostingController(rootView: Text("trusted POI handoff unavailable"))
            }
            return TrustedPoiViewControllerKt.trustedPoiViewController(apiKey: key)
        } catch {
            return UIHostingController(rootView: Text("trusted POI handoff unavailable"))
        }
    }
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
