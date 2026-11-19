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
            ("DensityOnly", .blue),
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
        let window = app.windows.firstMatch
        let status = app.staticTexts["icon-rendering-status"]
        let advance = app.buttons["Advance icon rendering"]
        var narrow: IconRow?
        var densityOnly: IconRow?

        for (name, ink) in cases {
            guard let image = awaitImage(
                name: name,
                ink: ink,
                viewport: viewport,
                window: window,
                status: status
            ) else { return }
            switch name {
            case "Narrow":
                narrow = image
            case "DensityOnly":
                guard let narrow else {
                    XCTFail("Missing narrow icon sample before the density change")
                    return
                }
                XCTAssertTrue((0.83...1.17).contains(image.widthFraction / narrow.widthFraction), "Density-only width: \(narrow) → \(image)")
                XCTAssertTrue((0.83...1.17).contains(image.heightFraction / narrow.heightFraction), "Density-only height: \(narrow) → \(image)")
                densityOnly = image
            case "Wide":
                guard let densityOnly else {
                    XCTFail("Missing density-only icon sample before resizing the content")
                    return
                }
                XCTAssertGreaterThanOrEqual(image.widthFraction, densityOnly.widthFraction * 1.65)
                XCTAssertTrue((0.83...1.17).contains(image.heightFraction / densityOnly.heightFraction), "Height after resize: \(densityOnly) → \(image)")
            default:
                break
            }
            if name != cases.last?.0 {
                guard advance.exists, advance.isHittable, window.frame.contains(advance.frame),
                      advance.frame.width >= 44, advance.frame.height >= 44 else {
                    XCTFail("The advance control must fit and be hittable. Control \(advance.frame), window \(window.frame)")
                    return
                }
                advance.coordinate(withNormalizedOffset: CGVector(dx: 0.5, dy: 0.5)).tap()
            }
        }
    }

    private func awaitImage(
        name: String,
        ink: Ink?,
        viewport: XCUIElement,
        window: XCUIElement,
        status: XCUIElement
    ) -> IconRow? {
        let deadline = Date().addingTimeInterval(15)
        var stage = "<unmounted>"
        var sample: IconRow?
        var matchingFrames = 0
        repeat {
            stage = status.exists ? status.label : "<missing status>"
            if stage == name && viewport.exists && window.exists {
                let windowFrame = window.frame
                let frame = viewport.frame
                guard windowFrame.contains(frame) else {
                    XCTFail("The map viewport must fit inside the window. Map \(frame), window \(windowFrame)")
                    return nil
                }
                sample = probe(
                    XCUIScreen.main.screenshot().image,
                    frame: frame,
                    screenWidthInPoints: windowFrame.width,
                    expected: ink
                )
                let raisesDensity = ["DensityOnly", "Wide", "Visible"].contains(name)
                if let sample, sample.matches(expected: ink, raisesDensity: raisesDensity) {
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
    case red, blue, green, magenta, yellow, cyan, orange

    var rgb: RGB {
        switch self {
        case .red: RGB(red: 255, green: 0, blue: 0)
        case .blue: RGB(red: 0, green: 0, blue: 255)
        case .green: RGB(red: 0, green: 255, blue: 0)
        case .magenta: RGB(red: 255, green: 0, blue: 255)
        case .yellow: RGB(red: 255, green: 255, blue: 0)
        case .cyan: RGB(red: 0, green: 255, blue: 255)
        case .orange: RGB(red: 255, green: 128, blue: 0)
        }
    }
}

private struct IconRow {
    let first: Double?
    let widthFraction: Double
    let heightFraction: Double
    let verticalCenter: Double?
    let densityMark: Bool
    let colors: Set<Ink>
    let background: RGB

    func matches(expected: Ink?, raisesDensity: Bool) -> Bool {
        guard background.isClose(to: RGB(red: 99, green: 125, blue: 143), tolerance: 32) else { return false }
        guard let expected else { return colors.isEmpty }
        guard let first, let verticalCenter else { return false }
        return colors == [expected] &&
            (0.012...0.085).contains(first) && (0.065...0.39).contains(widthFraction) &&
            abs(verticalCenter) <= 0.02 && (0.065...0.17).contains(heightFraction) &&
            densityMark == raisesDensity
    }
}

private func probe(
    _ screenshot: UIImage,
    frame: CGRect,
    screenWidthInPoints: CGFloat,
    expected: Ink?
) -> IconRow? {
    guard let image = screenshot.cgImage, let colorSpace = CGColorSpace(name: CGColorSpace.sRGB),
          screenshot.imageOrientation == .up, screenWidthInPoints.isFinite, screenWidthInPoints > 0 else {
        return nil
    }
    let scale = CGFloat(image.width) / screenWidthInPoints
    let width = Int((frame.width * scale).rounded())
    let height = Int((frame.height * scale).rounded())
    let left = (frame.minX * scale).rounded()
    let top = (frame.minY * scale).rounded()
    guard width >= 32, height >= 32, let row = readPixels(image, in: CGRect(
        x: left,
        y: top + CGFloat(height / 2),
        width: CGFloat(width),
        height: 1
    ), colorSpace: colorSpace), row.count == width else {
        return nil
    }

    var first: Int?
    var last = 0
    var count = 0
    var colors = Set<Ink>()
    for pixel in width / 4 ..< width * 9 / 10 {
        let color = row[pixel]
        guard let ink = Ink.allCases.first(where: { color.isClose(to: $0.rgb, tolerance: 54) }) else { continue }
        colors.insert(ink)
        if ink == expected {
            first = first ?? pixel
            last = pixel
            count += 1
        }
    }
    let vertical = first.flatMap { first in
        expected.flatMap {
            probeHeight(image, x: left + CGFloat((first + last) / 2), top: top, height: height, ink: $0, colorSpace: colorSpace)
        }
    }
    let densityMark: Bool
    if let first, let vertical {
        let x = left + CGFloat(first + (last - first) / 4)
        let y = top + CGFloat(vertical.first + (vertical.last - vertical.first) / 4)
        let pixel = readPixels(image, in: CGRect(x: x, y: y, width: 1, height: 1), colorSpace: colorSpace)?.first
        densityMark = pixel?.isClose(to: RGB(red: 128, green: 80, blue: 240), tolerance: 40) == true
    } else {
        densityMark = false
    }
    return IconRow(
        first: first.map { Double($0) / Double(width) - 0.5 },
        widthFraction: Double(count) / Double(width),
        heightFraction: Double(vertical?.count ?? 0) / Double(height),
        verticalCenter: vertical.map { Double($0.first + $0.last) / (2 * Double(height)) - 0.5 },
        densityMark: densityMark,
        colors: colors,
        background: row[Int((Double(width) * 0.508).rounded())]
    )
}

private struct VerticalBand {
    let first: Int
    let last: Int
    let count: Int
}

private func probeHeight(
    _ image: CGImage,
    x: CGFloat,
    top: CGFloat,
    height: Int,
    ink: Ink,
    colorSpace: CGColorSpace
) -> VerticalBand? {
    let frame = CGRect(x: x, y: top, width: 1, height: CGFloat(height))
    guard let pixels = readPixels(image, in: frame, colorSpace: colorSpace), pixels.count == height else {
        return nil
    }
    let hits = (height / 4 ..< height * 3 / 4).filter { pixels[$0].isClose(to: ink.rgb, tolerance: 54) }
    guard let first = hits.first, let last = hits.last else { return nil }
    return VerticalBand(first: first, last: last, count: hits.count)
}

private func readPixels(_ image: CGImage, in frame: CGRect, colorSpace: CGColorSpace) -> [RGB]? {
    guard let crop = image.cropping(to: frame) else { return nil }
    let width = crop.width
    let height = crop.height
    var pixels = [UInt8](repeating: 0, count: width * height * 4)
    let bitmapInfo = CGImageAlphaInfo.premultipliedLast.rawValue | CGBitmapInfo.byteOrder32Big.rawValue
    let drewPixels = pixels.withUnsafeMutableBytes { buffer -> Bool in
        guard let context = CGContext(
            data: buffer.baseAddress,
            width: width,
            height: height,
            bitsPerComponent: 8,
            bytesPerRow: width * 4,
            space: colorSpace,
            bitmapInfo: bitmapInfo
        ) else { return false }
        context.draw(crop, in: CGRect(x: 0, y: 0, width: CGFloat(width), height: CGFloat(height)))
        return true
    }
    guard drewPixels else { return nil }
    return stride(from: 0, to: pixels.count, by: 4).map {
        RGB(red: Int(pixels[$0]), green: Int(pixels[$0 + 1]), blue: Int(pixels[$0 + 2]))
    }
}
