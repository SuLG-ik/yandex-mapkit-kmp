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

    func testCurrentOwnerReceivesNativeEventsAndOldOwnerCancelsPendingWork() {
        continueAfterFailure = false
        let app = XCUIApplication()
        app.launchArguments.append("--listener-ownership")
        app.launch()

        var expected = ["fresh root owner=1", "subscribed owner=1 listener=1"]
        waitForOwnershipTrace(expected, in: app)
        tapOwnershipAction("Recompose with memory pressure", in: app)
        expected.append("memory probe owner=1")
        waitForOwnershipTrace(expected, in: app)
        tapOwnershipAction("Add object", in: app)
        expected += ["native add owner=1 listener=1", "added owner=1"]
        waitForOwnershipTrace(expected, in: app)

        tapOwnershipAction("Replace listener", in: app)
        expected += ["unsubscribed owner=1 listener=1", "subscribed owner=1 listener=2"]
        waitForOwnershipTrace(expected, in: app)
        tapOwnershipAction("Add object", in: app)
        expected += ["native add owner=1 listener=2", "retired listener held owner=1", "added owner=1"]
        waitForOwnershipTrace(expected, in: app)

        tapOwnershipAction("Unsubscribe listener", in: app)
        expected.append("unsubscribed owner=1 listener=2")
        waitForOwnershipTrace(expected, in: app)
        tapOwnershipAction("Add object", in: app)
        expected += ["retired listener held owner=1", "added owner=1"]
        waitForOwnershipTrace(expected, in: app)
        tapOwnershipAction("Subscribe listener", in: app)
        expected.append("subscribed owner=1 listener=3")
        waitForOwnershipTrace(expected, in: app)

        tapOwnershipAction("Queue callback and reopen", in: app)
        expected.append("pending owner=1 listener=3")
        let remount = [
            "unsubscribed owner=1 listener=3",
            "cancelled owner=1 listener=3",
            "fresh root owner=2",
            "subscribed owner=2 listener=1",
        ]
        waitForOwnershipTrace(expected, remount: remount, in: app)

        tapOwnershipAction("Release pending callback", in: app)
        waitForOwnershipTrace(expected, remount: remount, suffix: ["released pending callback"], in: app)
        tapOwnershipAction("Add object", in: app)
        waitForOwnershipTrace(
            expected,
            remount: remount,
            suffix: ["released pending callback", "native add owner=2 listener=1", "added owner=2"],
            in: app
        )
    }

    private func tapOwnershipAction(_ label: String, in app: XCUIApplication) {
        let action = app.buttons[label]
        XCTAssertTrue(action.waitForExistence(timeout: 10), "Missing \(label). \(app.debugDescription)")
        let frame = action.frame
        XCTAssertTrue(action.isHittable, "Cannot tap \(label) at \(frame)")
        XCTAssertTrue(app.windows.firstMatch.frame.contains(frame), "\(label) is outside the window at \(frame)")
        XCTAssertGreaterThanOrEqual(min(frame.width, frame.height), 44, "Touch target for \(label) is \(frame)")
        action.coordinate(withNormalizedOffset: CGVector(dx: 0.5, dy: 0.5)).tap()
    }

    private func waitForOwnershipTrace(
        _ prefix: [String],
        remount: [String] = [],
        suffix: [String] = [],
        in app: XCUIApplication
    ) {
        let element = app.staticTexts["listener-ownership-trace"]
        let count = prefix.count + remount.count + suffix.count
        let condition = NSPredicate { object, _ in
            guard let trace = object as? XCUIElement, trace.exists else { return false }
            return trace.label.components(separatedBy: " | ").count >= count
        }
        let expectation = XCTNSPredicateExpectation(predicate: condition, object: element)
        let result = XCTWaiter.wait(for: [expectation], timeout: 10)
        let actual = element.exists ? element.label : app.debugDescription
        XCTAssertEqual(result, .completed, "Waiting for \(prefix + remount + suffix). Events: \(actual)")
        let events = actual.components(separatedBy: " | ")
        XCTAssertEqual(Array(events.prefix(prefix.count)), prefix, actual)
        let remainder = events.dropFirst(prefix.count)
        XCTAssertEqual(remainder.prefix(remount.count).sorted(), remount.sorted(), actual)
        XCTAssertEqual(Array(remainder.dropFirst(remount.count)), suffix, actual)
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
