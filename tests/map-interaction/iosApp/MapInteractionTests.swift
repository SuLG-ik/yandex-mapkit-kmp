import XCTest

final class MapInteractionTests: XCTestCase {
    func testMapAcceptsTouchAfterMountAndReopen() {
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
        let match = app.staticTexts.matching(NSPredicate(format: "label CONTAINS %@", event)).firstMatch
        XCTAssertTrue(match.waitForExistence(timeout: 10), "Waiting for \(event). Events: \(trace(in: app))")
    }

    private func trace(in app: XCUIApplication) -> String {
        let match = app.staticTexts.matching(NSPredicate(format: "label BEGINSWITH %@", "mount screen=1 map=1")).firstMatch
        return match.exists ? match.label : "<empty>"
    }
}
