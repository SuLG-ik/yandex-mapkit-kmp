import XCTest

final class Nav3MapTests: XCTestCase {
    func testCancelledAndCommittedBackGesturesRestoreOnlyRetainedMapEntries() {
        continueAfterFailure = false
        let app = XCUIApplication()
        app.launchArguments.append("--navigation3")
        app.launch()
        let driver = Nav3Driver(app: app)

        driver.waitForMap("main-A", viewport: "default", selected: false)
        app.buttons["Nav move camera"].tap()
        driver.tapMap("main-A", viewport: "custom", selected: false)
        driver.waitForDetails("main-A")

        driver.waitForLabel("Nav gesture 0 idle progressed=false")
        driver.cancelBack()
        driver.waitForLabel("Nav gesture 1 idle progressed=true")
        driver.waitForDetails("main-A")
        driver.waitForLabel("Nav taps main-A")

        driver.back()
        driver.waitForLabel("Nav gesture 2 idle progressed=true")
        driver.waitForMap("main-A", viewport: "custom", selected: false)
        app.buttons["Nav push B"].tap()
        driver.waitForMap("main-B", viewport: "default", selected: false)
        app.buttons["Nav select marker"].tap()
        driver.tapMap("main-B", viewport: "default", selected: true)
        driver.waitForDetails("main-B")
        driver.back()
        driver.waitForMap("main-B", viewport: "default", selected: true)
        app.buttons["Nav move camera"].tap()
        driver.waitForMap("main-B", viewport: "custom", selected: true)
        driver.back()
        driver.waitForMap("main-A", viewport: "custom", selected: false)

        driver.tapMap("main-A", viewport: "custom", selected: false)
        driver.waitForDetails("main-A")
        driver.back()
        driver.waitForMap("main-A", viewport: "custom", selected: false)
        app.buttons["Nav push B"].tap()
        driver.waitForMap("main-B", viewport: "default", selected: false)

        app.buttons["Nav other tab"].tap()
        driver.waitForMap("other-B", viewport: "default", selected: false)
        app.buttons["Nav move camera"].tap()
        driver.waitForMap("other-B", viewport: "custom", selected: false)
        app.buttons["Nav select marker"].tap()
        driver.tapMap("other-B", viewport: "custom", selected: true)
        driver.waitForDetails("other-B")
        app.buttons["Nav main tab"].tap()
        driver.waitForMap("main-B", viewport: "default", selected: false)
        app.buttons["Nav other tab"].tap()
        driver.waitForDetails("other-B")
        driver.back()
        driver.tapMap("other-B", viewport: "custom", selected: true)
        driver.waitForDetails("other-B")

        app.buttons["Nav main tab"].tap()
        driver.waitForMap("main-B", viewport: "default", selected: false)
        driver.tapMap("main-B", viewport: "default", selected: false)
        driver.waitForDetails("main-B")
        driver.back()
        driver.waitForMap("main-B", viewport: "default", selected: false)
        driver.back()
        driver.tapMap("main-A", viewport: "custom", selected: false)
        driver.waitForDetails("main-A")
        driver.waitForLabel("Nav taps main-A main-B main-A other-B other-B main-B main-A")
    }
}

private struct Nav3Driver {
    let app: XCUIApplication

    func waitForMap(_ id: String, viewport: String, selected: Bool) {
        waitForLabel("Nav visible Map \(id)")
        waitForLabel("Nav ready \(id) \(viewport) selected=\(selected)")
    }

    func waitForDetails(_ id: String) {
        waitForLabel("Nav visible Details \(id)")
        waitForLabel("Details \(id)")
    }

    func waitForLabel(_ label: String) {
        let element = app.staticTexts.matching(NSPredicate(format: "label == %@", label)).firstMatch
        XCTAssertTrue(element.waitForExistence(timeout: 10), "Waiting for \(label). \(app.debugDescription)")
    }

    func tapMap(_ id: String, viewport: String, selected: Bool) {
        waitForMap(id, viewport: viewport, selected: selected)
        let element = app.descendants(matching: .any).matching(
            NSPredicate(format: "label BEGINSWITH %@", "nav-target \(id) \(viewport) selected=\(selected) ")
        ).firstMatch
        guard element.waitForExistence(timeout: 10) else {
            XCTFail("Missing native hit target for \(id). \(app.debugDescription)")
            return
        }
        let fields = element.label.split(separator: " ")
        guard fields.count == 6, let x = Double(fields[4]), let y = Double(fields[5]) else {
            XCTFail("Invalid native hit target: \(element.label)")
            return
        }
        element.coordinate(withNormalizedOffset: CGVector(dx: x, dy: y)).tap()
    }

    func back() {
        swipeBack(end: 0.83, velocity: .slow)
    }

    func cancelBack() {
        swipeBack(end: 0.14, velocity: XCUIGestureVelocity(40))
    }

    private func swipeBack(end: CGFloat, velocity: XCUIGestureVelocity) {
        let start = app.coordinate(withNormalizedOffset: CGVector(dx: 0.005, dy: 0.5))
        let destination = app.coordinate(withNormalizedOffset: CGVector(dx: end, dy: 0.5))
        start.press(forDuration: 0.05, thenDragTo: destination, withVelocity: velocity, thenHoldForDuration: 0.6)
    }
}
