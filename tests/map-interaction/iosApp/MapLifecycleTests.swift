import XCTest

final class MapLifecycleTests: XCTestCase {
    func testOverlayAndHostTransitionsPreserveSavedViewportAndMapInput() {
        continueAfterFailure = false
        let app = XCUIApplication()
        app.launchArguments += ["--lifecycle-scenario"]
        app.launch()

        let initialTarget = target(in: app, id: 1, saved: false)
        initialTarget.tap()
        waitForEvent("tap 1", in: app)

        app.buttons["Cover map"].tap()
        XCTAssertTrue(app.buttons["Map overlay"].waitForExistence(timeout: 10))
        initialTarget.tap()
        waitForEvent("overlay 1", in: app)
        app.buttons["Uncover map"].tap()
        target(in: app, id: 1, saved: false).tap()
        waitForEvent("tap 1", count: 2, in: app)

        app.buttons["Save viewport"].tap()
        waitForEvent("ready 1 camera=true selected=true", in: app)
        XCUIDevice.shared.press(.home)
        let background = XCTNSPredicateExpectation(
            predicate: NSPredicate { _, _ in app.state != .runningForeground },
            object: app
        )
        XCTAssertEqual(XCTWaiter.wait(for: [background], timeout: 10), .completed)
        app.activate()
        XCTAssertTrue(app.wait(for: .runningForeground, timeout: 10))
        target(in: app, id: 1, saved: true).tap()
        waitForEvent("tap 1", count: 3, in: app)

        for id in 1...2 {
            app.buttons["Animate and close"].tap()
            waitForEvent("detach \(id)", in: app)
            app.buttons["Open lifecycle map"].tap()
            target(in: app, id: id + 1, saved: true).tap()
            waitForEvent("tap \(id + 1)", in: app)
        }

        app.buttons["Detach map host"].tap()
        XCTAssertTrue(app.buttons["Attach map host"].waitForExistence(timeout: 10))
        app.buttons["Attach map host"].tap()
        waitForEvent("detach 3", in: app)
        target(in: app, id: 4, saved: true).tap()
        waitForEvent("tap 4", in: app)

        XCTAssertEqual(
            trace(in: app),
            """
            attach 1
            ready 1 camera=false selected=false
            tap 1
            overlay 1
            tap 1
            ready 1 camera=true selected=true
            tap 1
            animate 1
            detach 1
            attach 2
            ready 2 camera=true selected=true
            tap 2
            animate 2
            detach 2
            attach 3
            ready 3 camera=true selected=true
            tap 3
            detach 3
            attach 4
            ready 4 camera=true selected=true
            tap 4
            """
        )
    }

    private func target(in app: XCUIApplication, id: Int, saved: Bool) -> XCUICoordinate {
        waitForEvent("ready \(id) camera=\(saved) selected=\(saved)", in: app)
        let target = app.descendants(matching: .any).matching(
            NSPredicate(format: "label BEGINSWITH %@", "lifecycle-target \(id) ")
        ).firstMatch
        if target.waitForExistence(timeout: 10) {
            let fields = target.label.split(separator: " ")
            if fields.count == 4, let x = Double(fields[2]), let y = Double(fields[3]) {
                let frame = target.frame
                return app.coordinate(withNormalizedOffset: .zero).withOffset(
                    CGVector(dx: frame.minX - app.frame.minX + frame.width * x,
                             dy: frame.minY - app.frame.minY + frame.height * y)
                )
            }
        }
        XCTFail("Missing projected target for attachment \(id). Events: \(trace(in: app))")
        return app.coordinate(withNormalizedOffset: .zero)
    }

    private func waitForEvent(_ event: String, count: Int = 1, in app: XCUIApplication) {
        let containsEvent = NSPredicate { _, _ in
            self.trace(in: app).split(whereSeparator: \.isNewline).filter { String($0) == event }.count >= count
        }
        let expectation = XCTNSPredicateExpectation(predicate: containsEvent, object: app)
        let result = XCTWaiter.wait(for: [expectation], timeout: 10)
        XCTAssertEqual(result, .completed, "Waiting for \(event) (\(count)). Events: \(trace(in: app))")
    }

    private func trace(in app: XCUIApplication) -> String {
        let element = app.staticTexts["lifecycle-trace"]
        return element.exists ? element.label : "<missing lifecycle-trace>"
    }
}
