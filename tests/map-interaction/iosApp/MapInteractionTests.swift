import XCTest

final class DecomposeStackTests: XCTestCase {
    func testStoppedChildrenRetainStateAndDestroyedChildrenReleaseTheMap() {
        continueAfterFailure = false
        let app = XCUIApplication()
        app.launchArguments.append("--decompose-stack")
        app.launch()

        ready("A1.1", initialA, in: app)
        app.buttons["Save A viewport"].tap()
        ready("A1.1", savedA, in: app)
        tapMap("A1.1", in: app)
        expect(["show D1", "tap A1.1", "stop A1", "unsubscribe A1.1", "overlap A1 D1", "release A1.1"], in: app)
        app.buttons["Pop details"].tap()
        expect(["destroy D1", "hide D1"], in: app)
        ready("A1.2", savedA.withMarker(markerA), in: app)

        tapMap("A1.2", in: app)
        expect(["show D2", "tap A1.2", "unsubscribe A1.2", "release A1.2"], in: app)
        app.buttons["Pop details"].tap()
        expect(["destroy D2", "hide D2"], in: app)
        ready("A1.3", savedA.withMarker(markerA), in: app)

        app.buttons["Push B"].tap()
        expect(["release A1.3", "overlap A1 B1"], in: app)
        ready("B1.1", initialB, in: app)
        tapMap("B1.1", in: app)
        expect(["show D3", "tap B1.1", "release B1.1"], in: app)
        app.buttons["Pop details"].tap()
        expect(["destroy D3", "hide D3"], in: app)
        ready("B1.2", initialB.withMarker(markerB), in: app)

        app.buttons["Front A"].tap()
        expect(["release B1.2"], in: app)
        ready("A1.4", savedA.withMarker(markerA), in: app)
        app.buttons["Front B"].tap()
        expect(["release A1.4"], in: app)
        ready("B1.3", initialB.withMarker(markerB), in: app)
        app.buttons["Replace with C"].tap()
        expect([
            "stop B1", "destroy B1", "unsubscribe B1.3", "overlap B1 C1", "overlap windows B1.3 C1.1", "fade held"
        ], in: app)
        ready("C1.1", initialC, in: app)
        tapMap("C1.1", in: app)
        expect(["overlap tap B1.3 C1.1"], in: app)
        XCTAssertFalse(trace(in: app).contains("release B1.3"), trace(in: app).joined(separator: "\n"))
        app.buttons["Finish fade"].tap()
        expect(["release B1.3"], in: app)

        XCUIDevice.shared.press(.home)
        let background = NSPredicate { object, _ in
            guard let application = object as? XCUIApplication else { return false }
            return application.state == .runningBackground || application.state == .runningBackgroundSuspended
        }
        XCTAssertEqual(
            XCTWaiter.wait(for: [XCTNSPredicateExpectation(predicate: background, object: app)], timeout: 10),
            .completed
        )
        app.activate()
        expect(["parent stop", "stop C1", "unsubscribe C1.1"], in: app)
        expect(["parent start", "start C1", "subscribe C1.1"], count: 2, in: app)
        tapMap("C1.1", in: app)
        expect(["show D4", "tap C1.1", "release C1.1"], in: app)
        XCTAssertTrue(app.buttons["Pop details"].waitForExistence(timeout: 10))

        let events = trace(in: app)
        XCTAssertEqual(events.filter { $0.hasPrefix("tap ") }, ["tap A1.1", "tap A1.2", "tap B1.1", "tap C1.1"])
        XCTAssertEqual(events.filter { $0 == "unsubscribe C1.1" }.count, 2, events.joined(separator: "\n"))
        XCTAssertEqual(events.filter { $0 == "attach C1.1" }.count, 1, events.joined(separator: "\n"))
        XCTAssertEqual(events.filter { $0 == "parent stop" }.count, 1, events.joined(separator: "\n"))
        XCTAssertEqual(events.filter { $0 == "parent start" }.count, 2, events.joined(separator: "\n"))
        XCTAssertEqual(events.filter { $0 == "overlap tap B1.3 C1.1" }.count, 1, events.joined(separator: "\n"))
        XCTAssertEqual(events.filter { $0 == "unsubscribe B1.3" }.count, 1, events.joined(separator: "\n"))
        guard let unsubscribe = events.firstIndex(of: "unsubscribe B1.3"),
              let destroy = events.firstIndex(of: "destroy B1"),
              let overlapTap = events.firstIndex(of: "overlap tap B1.3 C1.1"),
              let release = events.firstIndex(of: "release B1.3") else {
            XCTFail("Missing B1 teardown. Events: \(events)")
            return
        }
        XCTAssertLessThan(unsubscribe, destroy, events.joined(separator: "\n"))
        XCTAssertLessThan(overlapTap, release, events.joined(separator: "\n"))
        XCTAssertLessThan(destroy, release, events.joined(separator: "\n"))
        XCTAssertFalse(events.contains { $0.hasPrefix("unexpected") || $0 == "destroy A1" }, events.joined(separator: "\n"))
    }

    private func ready(_ id: String, _ expected: Scene, in app: XCUIApplication) {
        expect(["subscribe \(id)"], in: app)
        waitFor("native scene for \(id): \(expected)", in: app) { lines in
            guard let lastScene = lines.last(where: { $0.hasPrefix("scene \(id) ") }) else { return false }
            return expected.matches(lastScene)
        }
    }

    private func tapMap(_ id: String, in app: XCUIApplication) {
        let target = app.descendants(matching: .any).matching(
            NSPredicate(format: "label BEGINSWITH %@", "decompose-target \(id) ")
        ).firstMatch
        guard target.waitForExistence(timeout: 10) else {
            XCTFail("Missing projected target \(id). Events: \(trace(in: app))")
            return
        }
        let fields = target.label.split(separator: " ")
        guard fields.count == 4, let x = Double(fields[2]), let y = Double(fields[3]) else {
            XCTFail("Invalid projected target: \(target.label)")
            return
        }
        target.coordinate(withNormalizedOffset: CGVector(dx: x, dy: y)).tap()
    }

    private func expect(_ events: [String], count: Int = 1, in app: XCUIApplication) {
        waitFor("\(events) x\(count)", in: app) { lines in
            events.allSatisfy { event in lines.filter { $0 == event }.count >= count }
        }
    }

    private func waitFor(_ description: String, in app: XCUIApplication, condition: @escaping ([String]) -> Bool) {
        let element = app.staticTexts["decompose-trace"]
        let containsEvents = NSPredicate { object, _ in
            guard let trace = object as? XCUIElement, trace.exists else { return app.state == .notRunning }
            return condition(trace.label.split(whereSeparator: \.isNewline).map(String.init))
        }
        let predicate = XCTNSPredicateExpectation(predicate: containsEvents, object: element)
        let outcome = XCTWaiter.wait(for: [predicate], timeout: 10)
        guard app.state != .notRunning else {
            XCTFail("MapInteractionApp terminated while waiting for \(description). See the simulator and crash diagnostics.")
            return
        }
        XCTAssertEqual(outcome, .completed, "Waiting for \(description). Events: \(trace(in: app))")
    }

    private func trace(in app: XCUIApplication) -> [String] {
        let element = app.staticTexts["decompose-trace"]
        return element.exists
            ? element.label.split(whereSeparator: \.isNewline).map(String.init)
            : ["<missing decompose-trace>", app.debugDescription]
    }

    private struct Geo {
        let latitude: Double
        let longitude: Double

        func matches(_ latitudeField: Substring, _ longitudeField: Substring) -> Bool {
            guard let actualLatitude = Double(latitudeField), let actualLongitude = Double(longitudeField) else { return false }
            return abs(latitude - actualLatitude) < 0.0001 && abs(longitude - actualLongitude) < 0.0001
        }
    }

    private struct Scene {
        let target: Geo
        let zoom: Double
        var marker: Geo? = nil

        func withMarker(_ geo: Geo) -> Scene {
            Scene(target: target, zoom: zoom, marker: geo)
        }

        func matches(_ line: String) -> Bool {
            let fields = line.split(separator: " ")
            guard (6...7).contains(fields.count), target.matches(fields[2], fields[3]),
                  let actualZoom = Double(fields[4]), abs(zoom - actualZoom) < 0.01 else { return false }
            guard let marker else { return fields.count == 6 && fields[5] == "none" }
            return fields.count == 7 && marker.matches(fields[5], fields[6])
        }
    }

    private let initialA = Scene(target: Geo(latitude: 55.751225, longitude: 37.629540), zoom: 16)
    private let savedA = Scene(target: Geo(latitude: 55.751525, longitude: 37.629840), zoom: 17)
    private let markerA = Geo(latitude: 55.751625, longitude: 37.629540)
    private let initialB = Scene(target: Geo(latitude: 59.939800, longitude: 30.314600), zoom: 16)
    private let markerB = Geo(latitude: 59.940200, longitude: 30.314600)
    private let initialC = Scene(target: Geo(latitude: 56.838900, longitude: 60.605700), zoom: 16)
}


final class MapInteractionTests: XCTestCase {
    func testTrustedBasemapPoiTap() throws {
        guard let runID = ProcessInfo.processInfo.environment["MAPKIT_TRUSTED_POI_RUN_ID"] else {
            throw XCTSkip("Runs only in the trusted iOS service suite")
        }
        continueAfterFailure = false
        let app = XCUIApplication()
        app.launchArguments.append("--trusted-basemap-poi")
        app.launchEnvironment["MAPKIT_TRUSTED_POI_RUN_ID"] = runID
        app.launch()

        let map = app.descendants(matching: .any)
            .matching(NSPredicate(format: "label == %@", "trusted-poi-map"))
            .firstMatch
        let trace = app.staticTexts["trusted-poi-trace"]
        let arm = app.buttons["Arm POI callback case"]

        func events() -> [String] {
            return trace.exists ? trace.label.split(separator: "\n").map(String.init) : []
        }

        func waitForEvents(timeout: TimeInterval, matching: @escaping ([Substring]) -> Bool) -> Bool {
            let predicate = NSPredicate { object, _ in
                guard let text = object as? XCUIElement, text.exists else { return false }
                return matching(text.label.split(separator: "\n"))
            }
            let result = XCTWaiter.wait(
                for: [XCTNSPredicateExpectation(predicate: predicate, object: trace)],
                timeout: timeout
            )
            return result == .completed
        }

        func waitFor(_ event: String, timeout: TimeInterval) -> Bool {
            return waitForEvents(timeout: timeout) { $0.contains(Substring(event)) }
        }

        func matchesTap(_ line: String, kind: String, action: String, at point: CGVector) -> Bool {
            let fields = line.split(separator: " ")
            guard fields.count == 4, fields[0] == Substring(kind), fields[1] == Substring(action),
                  let x = Double(fields[2]), let y = Double(fields[3]) else { return false }
            return abs(x - Double(point.dx)) <= 0.02 && abs(y - Double(point.dy)) <= 0.02
        }

        var lastMapTap: TimeInterval?
        func tapMap(at position: CGVector) {
            if let lastMapTap {
                let remaining = lastMapTap + 0.35 - ProcessInfo.processInfo.systemUptime
                if remaining > 0 {
                    Thread.sleep(forTimeInterval: remaining)
                }
            }
            map.coordinate(withNormalizedOffset: position).tap()
            lastMapTap = ProcessInfo.processInfo.systemUptime
        }

        guard map.waitForExistence(timeout: 25), arm.exists else {
            XCTFail("MAPKIT_TRUSTED_POI runner-or-fixture")
            return
        }
        guard waitFor("native viewport loaded", timeout: 25) else {
            XCTFail("MAPKIT_TRUSTED_POI provider-or-network")
            return
        }
        let deadline = ProcessInfo.processInfo.systemUptime + 34
        var found: CGVector?
        var baseline = ["native viewport loaded"]
        let positions: [CGFloat] = [0.50, 0.31, 0.69, 0.15, 0.85, 0.42, 0.58]
        scan: for y in positions {
            for x in positions {
                if ProcessInfo.processInfo.systemUptime >= deadline {
                    break scan
                }
                let position = CGVector(dx: x, dy: y)
                guard events() == baseline else {
                    XCTFail("MAPKIT_TRUSTED_POI runner-or-fixture")
                    return
                }
                let knownEvents = baseline.count
                tapMap(at: position)
                let wait = min(4, max(0.01, deadline - ProcessInfo.processInfo.systemUptime))
                guard waitForEvents(timeout: wait, matching: { $0.count > knownEvents }) else {
                    XCTFail("MAPKIT_TRUSTED_POI provider-or-network")
                    return
                }
                let observed = events()
                guard observed.count == knownEvents + 1, Array(observed.prefix(knownEvents)) == baseline,
                      let acknowledgement = observed.last else {
                    XCTFail("MAPKIT_TRUSTED_POI runner-or-fixture")
                    return
                }
                baseline = observed
                if acknowledgement == "native POI found" {
                    found = position
                    break scan
                }
                guard matchesTap(acknowledgement, kind: "native", action: "miss", at: position) else {
                    XCTFail("MAPKIT_TRUSTED_POI runner-or-fixture")
                    return
                }
            }
        }
        guard let hit = found else {
            XCTFail("MAPKIT_TRUSTED_POI provider-or-network")
            return
        }
        guard events() == baseline else {
            XCTFail("MAPKIT_TRUSTED_POI runner-or-fixture")
            return
        }

        arm.tap()
        guard waitFor("consume armed", timeout: 4) else {
            XCTFail("MAPKIT_TRUSTED_POI runner-or-fixture")
            return
        }
        tapMap(at: hit)
        guard waitFor("consumed POI", timeout: 4) else {
            XCTFail("MAPKIT_TRUSTED_POI wrapper-or-result-shape")
            return
        }
        Thread.sleep(forTimeInterval: 0.45)
        let consumed = baseline + ["consume armed", "consumed POI"]
        guard events() == consumed else {
            XCTFail("MAPKIT_TRUSTED_POI wrapper-or-result-shape")
            return
        }

        arm.tap()
        guard waitFor("propagate armed", timeout: 4) else {
            XCTFail("MAPKIT_TRUSTED_POI runner-or-fixture")
            return
        }
        tapMap(at: hit)
        guard waitFor("declined POI", timeout: 4) else {
            XCTFail("MAPKIT_TRUSTED_POI wrapper-or-result-shape")
            return
        }
        Thread.sleep(forTimeInterval: 0.45)
        let prefix = consumed + ["propagate armed", "declined POI"]
        let actual = events()
        guard actual.count == prefix.count + 1, Array(actual.prefix(prefix.count)) == prefix else {
            XCTFail("MAPKIT_TRUSTED_POI wrapper-or-result-shape")
            return
        }
        guard matchesTap(actual[prefix.count], kind: "map", action: "tap", at: hit) else {
            XCTFail("MAPKIT_TRUSTED_POI wrapper-or-result-shape")
            return
        }
    }

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

final class MapObjectMembershipTests: XCTestCase {
    func testKeyedObjectsKeepIdentityAndClustersFollowTheCurrentDataset() {
        continueAfterFailure = false
        let app = XCUIApplication()
        app.launchArguments.append("--map-object-membership")
        app.launch()

        let cases = [
            ("Initial", "marker:initial"),
            ("ShiftedLine", "line"),
            ("FormerLine", "map"),
            ("CircleCenter", "circle"),
            ("PolygonCenter", "polygon"),
            ("ChildrenHidden", "map"),
            ("ChildrenShown", "circle"),
            ("ParentHidden", "map"),
            ("Reordered", "marker:reordered"),
            ("ReorderedRemove", "map"),
            ("Cleared", "map"),
            ("Repopulated", "marker:repopulated"),
            ("Clustered", "cluster:a1,a2"),
            ("Scattered", "item:a1"),
            ("ClusterReplaced", "cluster:b1,b2"),
        ]
        var expected: [String] = []
        for (index, testCase) in cases.enumerated() {
            let (stage, tap) = testCase
            if index > 0 {
                app.buttons["Next object case"].tap()
            }
            expected.append("ready \(stage)")
            waitForTrace(expected, in: app)
            let map = app.descendants(matching: .any).matching(
                NSPredicate(format: "label == %@", "fixture-object-map")
            ).firstMatch
            XCTAssertTrue(map.waitForExistence(timeout: 10), "Missing map for \(stage)")
            map.coordinate(withNormalizedOffset: CGVector(dx: 0.5, dy: 0.5)).tap()
            expected.append("tap \(stage) \(tap)")
            waitForTrace(expected, in: app)
        }
    }

    private func waitForTrace(_ events: [String], in app: XCUIApplication) {
        let expected = events.suffix(8).joined(separator: "\n")
        let trace = app.staticTexts["fixture-object-trace"]
        let matches = NSPredicate { object, _ in
            guard let element = object as? XCUIElement, element.exists else { return false }
            return element.label == expected
        }
        let expectation = XCTNSPredicateExpectation(predicate: matches, object: trace)
        let outcome = XCTWaiter.wait(for: [expectation], timeout: 10)
        let actual = trace.exists ? trace.label : app.debugDescription
        XCTAssertEqual(outcome, .completed, "Expected:\n\(expected)\nActual:\n\(actual)")
    }
}
