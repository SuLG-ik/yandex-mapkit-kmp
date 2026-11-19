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
            expected.append(contentsOf: events)
            awaitTrace()
        }

        ready("Disabled", advance: false)
        touchCenter("polygon", "collection")
        ready("Empty")
        touchCenter("map")
        touchCenter("long", hold: true)
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
