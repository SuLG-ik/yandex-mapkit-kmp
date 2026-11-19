import XCTest

final class MapInteractionTests: XCTestCase {
    func testMapAcceptsTouchAfterMountAndReopen() {
        continueAfterFailure = false
        let app = XCUIApplication()
        app.launch()

        tapReadyMap(app, screen: 1)
        app.buttons["Close map"].tap()
        waitForEvent("unmount screen=1 map=1", in: app)
        app.buttons["Open map"].tap()
        tapReadyMap(app, screen: 2)

        XCTAssertEqual(
            trace(in: app),
            """
            mount screen=1 map=1
            ready screen=1 map=1
            tap screen=1 map=1
            unmount screen=1 map=1
            mount screen=2 map=2
            ready screen=2 map=2
            tap screen=2 map=2
            """
        )
    }

    func testMapTapsRespectHitOrderConsumptionAndCurrentCallbacks() {
        continueAfterFailure = false
        let app = XCUIApplication()
        app.launchArguments.append("--map-tap-cases")
        app.launch()
        var expected: [String] = []
        var lastMapTapUp: TimeInterval? = nil

        func awaitTrace() {
            let expectedTrace = expected.joined(separator: "\n")
            let element = app.staticTexts["fixture-trace"]
            let hasTrace = NSPredicate { object, _ in
                guard let trace = object as? XCUIElement, trace.exists else { return false }
                return trace.label == expectedTrace
            }
            let expectation = XCTNSPredicateExpectation(predicate: hasTrace, object: element)
            let outcome = XCTWaiter.wait(for: [expectation], timeout: 10)
            XCTAssertEqual(outcome, .completed, "Expected:\n\(expectedTrace)\nActual:\n\(trace(in: app))")
        }

        func ready(_ name: String, advance: Bool = true) {
            if advance {
                app.buttons["Next tap case"].tap()
            }
            expected.append("ready \(name)")
            awaitTrace()
        }

        func touchCenter(_ events: String..., hold: Bool = false) {
            if let lastMapTapUp {
                let remaining = lastMapTapUp + 0.301 - ProcessInfo.processInfo.systemUptime
                if remaining > 0 {
                    Thread.sleep(forTimeInterval: remaining)
                }
            }
            let target = app.descendants(matching: .any).matching(
                NSPredicate(format: "label == %@", "fixture-tap-map")
            ).firstMatch
            XCTAssertTrue(target.waitForExistence(timeout: 10), "Missing map. Events: \(trace(in: app))")
            let center = target.coordinate(withNormalizedOffset: CGVector(dx: 0.5, dy: 0.5))
            if hold {
                center.press(forDuration: 0.9)
            } else {
                center.tap()
            }
            lastMapTapUp = ProcessInfo.processInfo.systemUptime
            expected.append(contentsOf: events)
            awaitTrace()
        }

        ready("Disabled", advance: false)
        touchCenter()
        ready("Empty")
        touchCenter("map")
        touchCenter("long", hold: true)
        ready("PolygonOnly")
        touchCenter("polygon", "collection", "map")
        ready("PlacemarkConsumes")
        touchCenter("placemark")
        ready("PlacemarkPropagates")
        touchCenter("placemark", "collection")
        ready("PlacemarkHidden")
        touchCenter("polygon")
        ready("PlacemarkRestored")
        touchCenter("placemark")
        ready("PlacemarkRemoved")
        touchCenter("polygon", "collection", "replacement")
        ready("HandlerRemoved")
        touchCenter("polygon", "collection")
        ready("HandlerRestored")
        touchCenter("polygon", "collection", "restored")
    }

    func testPanAndPinchSettleAndRespectGestureFlags() {
        let app = launchCameraFixture("Gestures")
        waitForEvent("gestures enabled", in: app)
        let map = app.descendants(matching: .any).matching(
            NSPredicate(format: "label == %@", "camera gesture map")
        ).firstMatch
        XCTAssertTrue(map.waitForExistence(timeout: 10), trace(in: app))

        drag(on: map)
        waitForEvent("pan finished", in: app)
        map.pinch(withScale: 2, velocity: 1)
        waitForEvent("zoom finished", in: app)

        app.buttons["Disable gestures"].tap()
        waitForEvent("gestures disabled", in: app)
        drag(on: map)
        map.pinch(withScale: 2, velocity: 1)
        app.buttons["Check disabled gestures"].tap()
        waitForEvent("disabled gestures held camera", in: app)
        XCTAssertEqual(
            trace(in: app),
            """
            gestures enabled
            pan finished
            zoom finished
            gestures disabled
            disabled gestures held camera
            """
        )
    }

    func testSupersededAndDisposedMovesKeepTheirMapIdentity() {
        let app = launchCameraFixture("Animation")
        waitForEvent("animation ready 1", in: app)
        app.buttons["Supersede animated move"].tap()
        waitForEvent("replacement finished 1", in: app)
        app.buttons["Leave during a move"].tap()
        waitForEvent("animation detached 1", in: app)
        app.buttons["Reopen animation map"].tap()
        waitForEvent("animation ready 2", in: app)
        app.buttons["Move the new map"].tap()
        waitForEvent("new animation finished 2", in: app)
        XCTAssertEqual(
            trace(in: app),
            """
            animation ready 1
            first animation moving 1
            first animation cancelled 1
            replacement finished 1
            leaving while moving 1
            animation detached 1
            animation ready 2
            new animation finished 2
            """
        )
    }

    func testSimulatedPositionDrivesBothMountedMapsWithoutGps() {
        let app = launchCameraFixture("Location")
        waitForEvent("location applied 1", in: app)
        app.buttons["Hide simulated location"].tap()
        waitForEvent("location hidden 1", in: app)
        app.buttons["Remount location map"].tap()
        waitForEvent("location applied 2", in: app)
        XCTAssertEqual(trace(in: app), "location applied 1\nlocation hidden 1\nlocation applied 2")
    }

    private func launchCameraFixture(_ mode: String) -> XCUIApplication {
        continueAfterFailure = false
        let app = XCUIApplication()
        app.launchArguments = ["--camera=\(mode)"]
        app.launch()
        return app
    }

    private func drag(on map: XCUIElement) {
        let start = map.coordinate(withNormalizedOffset: CGVector(dx: 0.34, dy: 0.5))
        let end = map.coordinate(withNormalizedOffset: CGVector(dx: 0.70, dy: 0.5))
        start.press(forDuration: 0.1, thenDragTo: end)
    }

    private func tapReadyMap(_ app: XCUIApplication, screen: Int) {
        let identity = "screen=\(screen) map=\(screen)"
        waitForEvent("ready \(identity)", in: app)

        let target = app.descendants(matching: .any).matching(
            NSPredicate(format: "label BEGINSWITH %@", "fixture-target \(identity) ")
        ).firstMatch
        guard target.waitForExistence(timeout: 10) else {
            XCTFail("Missing projected target. Events: \(trace(in: app))")
            return
        }

        let fields = target.label.split(separator: " ")
        guard fields.count == 5, let x = Double(fields[3]), let y = Double(fields[4]) else {
            XCTFail("Invalid projected target: \(target.label)")
            return
        }
        target.coordinate(withNormalizedOffset: CGVector(dx: x, dy: y)).tap()
        waitForEvent("tap \(identity)", in: app)
    }

    private func waitForEvent(_ event: String, in app: XCUIApplication) {
        let element = app.staticTexts["fixture-trace"]
        let containsEvent = NSPredicate { object, _ in
            guard let trace = object as? XCUIElement, trace.exists else { return false }
            return trace.label.split(whereSeparator: \.isNewline).contains(Substring(event))
        }
        let expectation = XCTNSPredicateExpectation(predicate: containsEvent, object: element)
        let outcome = XCTWaiter.wait(for: [expectation], timeout: 10)
        XCTAssertEqual(outcome, .completed, "Waiting for \(event). Events: \(trace(in: app))")
    }

    private func trace(in app: XCUIApplication) -> String {
        let element = app.staticTexts["fixture-trace"]
        return element.exists ? element.label : "<missing fixture-trace>\n\(app.debugDescription)"
    }
}
