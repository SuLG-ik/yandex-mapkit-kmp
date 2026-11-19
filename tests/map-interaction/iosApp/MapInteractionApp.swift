import MapInteractionFixture
import SwiftUI

@main
struct MapInteractionApp: App {
    var body: some Scene {
        WindowGroup {
            if ProcessInfo.processInfo.arguments.contains("--lifecycle-scenario") {
                LifecycleHost()
            } else if ProcessInfo.processInfo.arguments.contains("--trusted-basemap-poi") {
                TrustedPoiHost()
            } else {
                ComposeMapHost()
            }
        }
    }
}

private struct ComposeMapHost: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        let arguments = ProcessInfo.processInfo.arguments
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
}

private struct TrustedPoiHost: View {
    @State private var controller: UIViewController?
    @State private var handoffFailed = false

    var body: some View {
        if let controller {
            TrustedPoiController(controller: controller)
        } else if handoffFailed {
            Text("trusted POI handoff unavailable")
        } else {
            Color.clear.task {
                if let key = await receiveKey() {
                    controller = TrustedPoiViewControllerKt.trustedPoiViewController(apiKey: key)
                } else {
                    handoffFailed = true
                }
            }
        }
    }

    @MainActor
    private func receiveKey() async -> String? {
        let files = FileManager.default
        guard let runID = ProcessInfo.processInfo.environment["MAPKIT_TRUSTED_POI_RUN_ID"],
              runID.range(of: "^[0-9]+-[0-9]+$", options: .regularExpression) != nil,
              let library = files.urls(for: .libraryDirectory, in: .userDomainMask).first else {
            return nil
        }
        let directory = library.appendingPathComponent("TrustedPoi", isDirectory: true)
        let ready = directory.appendingPathComponent("\(runID).ready")
        let handoff = directory.appendingPathComponent("\(runID).key")
        let consumed = directory.appendingPathComponent("\(runID).consumed")
        do {
            try files.createDirectory(
                at: directory, withIntermediateDirectories: true, attributes: [.posixPermissions: 0o700]
            )
            guard !files.fileExists(atPath: handoff.path), !files.fileExists(atPath: consumed.path) else {
                return nil
            }
            try Data().write(to: ready, options: .withoutOverwriting)
            for _ in 0..<200 {
                if files.fileExists(atPath: handoff.path) { break }
                try await Task.sleep(nanoseconds: 100_000_000)
            }
            try Task.checkCancellation()
            let data = try Data(contentsOf: handoff)
            try files.removeItem(at: handoff)
            guard let key = String(data: data, encoding: .utf8), !key.isEmpty else {
                return nil
            }
            try Data().write(to: consumed, options: .withoutOverwriting)
            return key
        } catch {
            return nil
        }
    }
}

private struct TrustedPoiController: UIViewControllerRepresentable {
    let controller: UIViewController

    func makeUIViewController(context: Context) -> UIViewController { controller }
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
