import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
#if DEBUG && targetEnvironment(simulator)
    private let benchmarkPhase = ProcessInfo.processInfo.environment["MAPKIT_RETURN_BENCHMARK_PHASE"]
    @State private var benchmarkReady = false
#endif

    init() {
#if DEBUG && targetEnvironment(simulator)
        if benchmarkPhase != nil {
            return
        }
#endif
        AppKt.doInitMapKit()
    }

    var body: some Scene {
        WindowGroup {
#if DEBUG && targetEnvironment(simulator)
            if let phase = benchmarkPhase, !benchmarkReady {
                Color.clear.task {
                    await configureReturnMapBenchmark(phase: phase)
                    benchmarkReady = true
                }
            } else {
                ContentView()
            }
#else
            ContentView()
#endif
        }
    }
}

#if DEBUG && targetEnvironment(simulator)
@MainActor
private func configureReturnMapBenchmark(phase: String) async {
    guard phase == "cold" || phase == "restart" else {
        fatalError("Invalid return-to-map benchmark phase.")
    }
    guard let cohort = ProcessInfo.processInfo.environment["MAPKIT_RETURN_BENCHMARK_COHORT"], !cohort.isEmpty else {
        fatalError("Missing return-to-map benchmark cohort.")
    }
    let files = FileManager.default
    let directory = files.urls(for: .libraryDirectory, in: .userDomainMask)[0]
        .appendingPathComponent("ReturnMapBenchmark", isDirectory: true)
    let keyFile = directory.appendingPathComponent("\(phase).key")
    let metricsFile = directory.appendingPathComponent("baseline.metrics")
    do {
        try files.createDirectory(at: directory, withIntermediateDirectories: true, attributes: [.posixPermissions: 0o700])
        guard files.fileExists(atPath: metricsFile.path) == (phase == "restart"),
              !files.fileExists(atPath: keyFile.path) else {
            fatalError("Unexpected return-to-map benchmark state at launch.")
        }
        let readyFile = directory.appendingPathComponent("\(phase).ready")
        try Data().write(to: readyFile, options: .withoutOverwriting)
        for _ in 0..<400 {
            if files.fileExists(atPath: keyFile.path) {
                break
            }
            try await Task.sleep(nanoseconds: 100_000_000)
        }
        let key = try String(contentsOf: keyFile, encoding: .utf8)
        try files.removeItem(at: keyFile)
        guard !key.isEmpty else {
            fatalError("The return-to-map benchmark credential is missing.")
        }
        if !files.fileExists(atPath: metricsFile.path) {
            guard files.createFile(atPath: metricsFile.path, contents: nil, attributes: [.posixPermissions: 0o600]) else {
                fatalError("Could not create the return-to-map metric file.")
            }
        }
        let writer = try FileHandle(forWritingTo: metricsFile)
        try writer.seekToEnd()
        AppKt.doInitMapKitForReturnBenchmark(apiKey: key, cohort: cohort, writeMetric: { row in
            do {
                try writer.write(contentsOf: Data((row + "\n").utf8))
            } catch {
                fatalError("Could not write the return-to-map metric.")
            }
        })
    } catch {
        fatalError("Could not initialize the return-to-map benchmark.")
    }
}
#endif
