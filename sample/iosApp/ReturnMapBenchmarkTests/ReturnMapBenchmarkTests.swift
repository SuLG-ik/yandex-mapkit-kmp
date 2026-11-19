import XCTest

final class ReturnMapBenchmarkTests: XCTestCase {
    @MainActor
    func testReturnToMapCohort() throws {
        continueAfterFailure = false
        let cohort = try XCTUnwrap(ProcessInfo.processInfo.environment["MAPKIT_RETURN_COHORT"])
        XCUIDevice.shared.orientation = .portrait
        let app = XCUIApplication()

        launch(app, phase: "cold", cohort: cohort)
        tap(app, "Open after clearing app data")
        tapReadyViewport(in: app)

        tap(app, "Details (unmount map)")
        tap(app, "Return to map")
        tapReadyViewport(in: app)

        tap(app, "Other tab (retain map)")
        tap(app, "Return to map")
        tapReadyViewport(in: app)
        waitForTrialEnd(in: app)

        app.terminate()
        XCTAssertTrue(app.wait(for: .notRunning, timeout: 10))
        launch(app, phase: "restart", cohort: cohort)
        tap(app, "Open after process restart")
        tapReadyViewport(in: app)
        waitForTrialEnd(in: app)
    }

    @MainActor
    private func launch(_ app: XCUIApplication, phase: String, cohort: String) {
        app.launchEnvironment["MAPKIT_RETURN_BENCHMARK_PHASE"] = phase
        app.launchEnvironment["MAPKIT_RETURN_BENCHMARK_COHORT"] = cohort
        app.launch()
        tap(app, "Measure return to map")
        tap(app, "Native view only")
    }

    @MainActor
    private func tap(_ app: XCUIApplication, _ label: String) {
        let control = element(in: app, label: label)
        XCTAssertTrue(control.waitForExistence(timeout: 40), "Missing benchmark control: \(label)")
        XCTAssertTrue(control.isEnabled, "Benchmark control is disabled: \(label)")
        control.tap()
    }

    @MainActor
    private func waitForTrialEnd(in app: XCUIApplication) {
        XCTAssertTrue(element(in: app, label: "Details (unmount map)").waitForExistence(timeout: 35))
    }

    @MainActor
    private func tapReadyViewport(in app: XCUIApplication) {
        let ready = element(
            in: app,
            label: "Tap near the map center once",
            identifier: "return-map-benchmark-ready"
        )
        XCTAssertTrue(ready.waitForExistence(timeout: 35), "The sample did not report a usable projection.")
        let viewport = element(
            in: app,
            label: "Return map benchmark viewport",
            identifier: "return-map-benchmark-viewport"
        )
        XCTAssertTrue(viewport.exists, "The sample did not expose the benchmark viewport.")
        let bounds = viewport.frame
        XCTAssertEqual(bounds.width, 260, accuracy: 1)
        XCTAssertEqual(bounds.height, 260, accuracy: 1)
        XCTAssertTrue(app.frame.contains(bounds), "The viewport must be fully visible.")
        let origin = app.coordinate(withNormalizedOffset: .zero)
        let center = origin.withOffset(CGVector(dx: bounds.midX - app.frame.minX, dy: bounds.midY - app.frame.minY))
        Thread.sleep(forTimeInterval: 0.35)
        center.tap()
    }

    @MainActor
    private func element(in app: XCUIApplication, label: String, identifier: String? = nil) -> XCUIElement {
        app.descendants(matching: .any).matching(
            NSPredicate(format: "label == %@ OR identifier == %@", label, identifier ?? label)
        ).firstMatch
    }
}
