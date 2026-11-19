import UIKit
import XCTest

final class MapIconRenderingTests: XCTestCase {
    func testPlacemarkIconFollowsFramesRequestsAndDisposal() {
        verifyLiveIcon(argument: "--placemark-image-test")
    }

    func testClusterIconFollowsFramesRequestsAndDisposal() {
        verifyLiveIcon(argument: "--cluster-image-test")
    }

    private func verifyLiveIcon(argument: String) {
        continueAfterFailure = false
        let app = XCUIApplication()
        app.launchArguments.append(argument)
        app.launch()

        let cases: [(String, Ink?)] = [
            ("Empty", nil),
            ("Bitmap", .red),
            ("Narrow", .blue),
            ("Wide", .green),
            ("Hidden", nil),
            ("Visible", .green),
            ("Loading", .magenta),
            ("Failure", .yellow),
            ("Retrying", .magenta),
            ("Retried", .cyan),
            ("OlderPending", .magenta),
            ("Newer", .green),
            ("OlderCompleted", .green),
            ("RemovalPending", .magenta),
            ("Removed", nil),
            ("RemovedRequestCompleted", nil),
            ("Recreated", .blue),
        ]
        let viewport = app.descendants(matching: .any).matching(
            NSPredicate(format: "label == %@", "icon-rendering-map")
        ).firstMatch
        let status = app.staticTexts["icon-rendering-status"]
        let advance = app.buttons["Advance icon rendering"]
        var narrowWidth: Double?

        for (name, ink) in cases {
            guard let image = awaitImage(
                name: name,
                ink: ink,
                viewport: viewport,
                status: status
            ) else { return }
            if name == "Narrow" {
                narrowWidth = image.widthFraction
            }
            if name == "Wide", let narrowWidth {
                XCTAssertGreaterThanOrEqual(image.widthFraction, narrowWidth * 1.65)
                XCTAssertTrue((0.17...0.27).contains(image.widthFraction), "Icon width must remain in logical points")
            }
            if name != cases.last?.0 { advance.tap() }
        }
    }

    private func awaitImage(
        name: String,
        ink: Ink?,
        viewport: XCUIElement,
        status: XCUIElement
    ) -> IconRow? {
        let deadline = Date().addingTimeInterval(15)
        var stage = "<unmounted>"
        var sample: IconRow?
        var matchingFrames = 0
        repeat {
            stage = status.exists ? status.label : "<missing status>"
            if stage == name && viewport.exists {
                sample = probe(XCUIScreen.main.screenshot().image, frame: viewport.frame, expected: ink)
                if let sample, sample.matches(expected: ink) {
                    matchingFrames += 1
                    if matchingFrames >= 3 { return sample }
                } else {
                    matchingFrames = 0
                }
            }
            Thread.sleep(forTimeInterval: 0.06)
        } while Date() < deadline
        XCTFail("Expected \(name) with \(String(describing: ink)). Last stage: \(stage). Native map sample: \(String(describing: sample))")
        return nil
    }
}

private struct RGB {
    let red: Int
    let green: Int
    let blue: Int

    func isClose(to other: RGB, tolerance: Int) -> Bool {
        abs(red - other.red) <= tolerance && abs(green - other.green) <= tolerance && abs(blue - other.blue) <= tolerance
    }
}

private enum Ink: CaseIterable, Hashable {
    case red, blue, green, magenta, yellow, cyan

    var rgb: RGB {
        switch self {
        case .red: RGB(red: 255, green: 0, blue: 0)
        case .blue: RGB(red: 0, green: 0, blue: 255)
        case .green: RGB(red: 0, green: 255, blue: 0)
        case .magenta: RGB(red: 255, green: 0, blue: 255)
        case .yellow: RGB(red: 255, green: 255, blue: 0)
        case .cyan: RGB(red: 0, green: 255, blue: 255)
        }
    }
}

private struct IconRow {
    let first: Double?
    let widthFraction: Double
    let colors: Set<Ink>
    let background: RGB

    func matches(expected: Ink?) -> Bool {
        guard background.isClose(to: RGB(red: 99, green: 125, blue: 143), tolerance: 32) else { return false }
        guard let expected else { return colors.isEmpty }
        guard let first else { return false }
        return colors == [expected] && (0.012...0.075).contains(first) && (0.065...0.36).contains(widthFraction)
    }
}

private func probe(_ screenshot: UIImage, frame: CGRect, expected: Ink?) -> IconRow? {
    guard let image = screenshot.cgImage, let colorSpace = CGColorSpace(name: CGColorSpace.sRGB) else {
        return nil
    }
    let sx = CGFloat(image.width) / screenshot.size.width
    let sy = CGFloat(image.height) / screenshot.size.height
    let width = Int((frame.width * sx).rounded())
    guard width > 0, let line = image.cropping(to: CGRect(
        x: (frame.minX * sx).rounded(),
        y: (frame.midY * sy).rounded(),
        width: CGFloat(width),
        height: 1
    )), line.width == width else {
        return nil
    }

    var pixels = [UInt8](repeating: 0, count: width * 4)
    let bitmapInfo = CGImageAlphaInfo.premultipliedLast.rawValue | CGBitmapInfo.byteOrder32Big.rawValue
    let drewLine = pixels.withUnsafeMutableBytes { buffer -> Bool in
        guard let context = CGContext(
            data: buffer.baseAddress,
            width: width,
            height: 1,
            bitsPerComponent: 8,
            bytesPerRow: width * 4,
            space: colorSpace,
            bitmapInfo: bitmapInfo
        ) else { return false }
        context.draw(line, in: CGRect(x: 0, y: 0, width: CGFloat(width), height: 1))
        return true
    }
    guard drewLine else { return nil }

    func rgb(at index: Int) -> RGB {
        let address = index * 4
        return RGB(red: Int(pixels[address]), green: Int(pixels[address + 1]), blue: Int(pixels[address + 2]))
    }

    var first: Int?
    var count = 0
    var colors = Set<Ink>()
    for pixel in width / 4 ..< width * 9 / 10 {
        let color = rgb(at: pixel)
        guard let ink = Ink.allCases.first(where: { color.isClose(to: $0.rgb, tolerance: 54) }) else { continue }
        colors.insert(ink)
        if ink == expected {
            first = first ?? pixel
            count += 1
        }
    }
    return IconRow(
        first: first.map { Double($0) / Double(width) - 0.5 },
        widthFraction: Double(count) / Double(width),
        colors: colors,
        background: rgb(at: Int((Double(width) * 0.508).rounded()))
    )
}
