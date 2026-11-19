import CoreGraphics
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

    func testPanAndTwoFingerZoomSettleAndRespectGestureFlags() {
        let app = launchCameraFixture("Gestures")
        waitForEvent("gestures enabled", in: app)
        let map = app.descendants(matching: .any).matching(
            NSPredicate(format: "label == %@", "camera gesture map")
        ).firstMatch
        XCTAssertTrue(map.waitForExistence(timeout: 10), trace(in: app))
        let zoomTarget = app.descendants(matching: .any).matching(
            NSPredicate(format: "label == %@", "camera two-finger target")
        ).firstMatch
        XCTAssertTrue(zoomTarget.waitForExistence(timeout: 10), trace(in: app))
        XCTAssertTrue(
            map.frame.insetBy(dx: 10, dy: 10).contains(zoomTarget.frame),
            "Two-finger target \(zoomTarget.frame) must stay inside map \(map.frame)"
        )

        drag(on: map)
        waitForEvent("pan moved west", in: app)
        zoomTarget.twoFingerTap()
        waitForEvent("zoom moved out", in: app)

        app.buttons["Disable scroll"].tap()
        waitForEvent("scroll disabled", in: app)
        drag(on: map)
        app.buttons["Check blocked pan"].tap()
        waitForEvent("blocked pan held camera", in: app)
        zoomTarget.twoFingerTap()
        waitForEvent("zoom moved out with scroll disabled", in: app)

        app.buttons["Disable zoom"].tap()
        waitForEvent("zoom disabled", in: app)
        zoomTarget.twoFingerTap()
        app.buttons["Check blocked zoom"].tap()
        waitForEvent("blocked zoom held camera", in: app)
        drag(on: map)
        waitForEvent("pan moved west with zoom disabled", in: app)
        XCTAssertEqual(
            trace(in: app),
            """
            gestures enabled
            pan moved west
            zoom moved out
            scroll disabled
            blocked pan held camera
            zoom moved out with scroll disabled
            zoom disabled
            blocked zoom held camera
            pan moved west with zoom disabled
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
        waitForEvent("animation ready 2 on a new native map", in: app)
        app.buttons["Move the new map"].tap()
        waitForEvent("retired move deadline passed 1", in: app)
        XCTAssertEqual(
            trace(in: app),
            """
            animation ready 1
            first animation moving 1
            first animation cancelled 1
            replacement finished 1
            leaving while moving 1
            animation detached 1
            animation ready 2 on a new native map
            new animation finished 2
            retired move deadline passed 1
            """
        )
    }

    func testSimulatedPositionDrivesBothMountedMapsWithoutGps() {
        let app = launchCameraFixture("Location")
        waitForEvent("location applied 1", in: app, timeout: 15)
        expectLocationPin(true, in: app)
        app.buttons["Hide simulated location"].tap()
        waitForEvent("location hide requested 1", in: app)
        expectLocationPin(false, in: app)
        app.buttons["Remove location map"].tap()
        waitForEvent("location source released 1", in: app)
        app.buttons["Open location map"].tap()
        waitForEvent("location applied 2", in: app, timeout: 15)
        expectLocationPin(true, in: app)
        XCTAssertEqual(
            trace(in: app),
            """
            location applied 1
            location hide requested 1
            location source released 1
            location applied 2
            """
        )
    }

    private func expectLocationPin(_ visible: Bool, in app: XCUIApplication) {
        let map = app.descendants(matching: .any).matching(
            NSPredicate(format: "label == %@", "camera location map")
        ).firstMatch
        guard map.waitForExistence(timeout: 10), !map.frame.isEmpty else {
            XCTFail("Missing location map. Events: \(trace(in: app))")
            return
        }
        let deadline = Date().addingTimeInterval(10)
        var lastScreenshot: XCUIScreenshot?
        var lastPinSamples = 0
        repeat {
            let screenshot = map.screenshot()
            lastScreenshot = screenshot
            let extent = 512
            guard let image = screenshot.image.cgImage,
                  let pixels = CGContext(
                    data: nil,
                    width: extent,
                    height: extent,
                    bitsPerComponent: 8,
                    bytesPerRow: extent * 4,
                    space: CGColorSpaceCreateDeviceRGB(),
                    bitmapInfo: CGImageAlphaInfo.premultipliedLast.rawValue
                  ),
                  let bytes = pixels.data?.assumingMemoryBound(to: UInt8.self)
            else {
                XCTFail("Could not capture the location layer")
                return
            }
            pixels.interpolationQuality = .none
            pixels.draw(image, in: CGRect(x: 0, y: 0, width: CGFloat(extent), height: CGFloat(extent)))
            var pinSamples = 0
            for offset in stride(from: 0, to: extent * extent * 4, by: 4) {
                if bytes[offset] >= 175 && bytes[offset + 1] <= 90 && bytes[offset + 2] >= 125 {
                    pinSamples += 1
                    if pinSamples == 4 { break }
                }
            }
            lastPinSamples = pinSamples
            if (pinSamples >= 4) == visible { return }
            Thread.sleep(forTimeInterval: 0.1)
        } while Date() < deadline
        if let screenshot = lastScreenshot {
            let evidence = XCTAttachment(screenshot: screenshot)
            evidence.name = "Location map after waiting for pin to become \(visible ? "visible" : "hidden")"
            add(evidence)
        }
        XCTFail(
            "Location pin did not become \(visible ? "visible" : "hidden"). "
                + "Map frame: \(map.frame). Pin samples: \(lastPinSamples). Events: \(trace(in: app))"
        )
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

    private func waitForEvent(_ event: String, in app: XCUIApplication, timeout: TimeInterval = 10) {
        let element = app.staticTexts["fixture-trace"]
        let containsEvent = NSPredicate { object, _ in
            guard let trace = object as? XCUIElement, trace.exists else { return false }
            return trace.label.split(whereSeparator: \.isNewline).contains(Substring(event))
        }
        let expectation = XCTNSPredicateExpectation(predicate: containsEvent, object: element)
        let outcome = XCTWaiter.wait(for: [expectation], timeout: timeout)
        XCTAssertEqual(outcome, .completed, eventFailure(event, in: app))
    }

    private func eventFailure(_ event: String, in app: XCUIApplication) -> String {
        let camera = app.staticTexts["fixture-gesture-position"]
        let cameraState = camera.exists ? "\nLast stationary camera: \(camera.label)" : ""
        return "Waiting for \(event). Events: \(trace(in: app))\(cameraState)"
    }

    private func trace(in app: XCUIApplication) -> String {
        let element = app.staticTexts["fixture-trace"]
        return element.exists ? element.label : "<missing fixture-trace>\n\(app.debugDescription)"
    }
}
