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
        let arguments = ProcessInfo.processInfo.arguments
        if arguments.last == "mapkit-suggestions" {
            return SmokeControllerKt.suggestionsController()
        }
        if arguments.count >= 3 && arguments.last == "live-search" {
            let token = arguments[arguments.count - 2]
            let keyFile = FileManager.default.temporaryDirectory.appendingPathComponent("live-search-key")
            defer { try? FileManager.default.removeItem(at: keyFile) }
            let key = (try? String(contentsOf: keyFile, encoding: .utf8)) ?? ""
            return SmokeControllerKt.liveSearchController(token: token, apiKey: key)
        }
        return SmokeControllerKt.smokeController(token: arguments.last!)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
