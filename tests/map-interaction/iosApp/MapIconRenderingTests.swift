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
        var bitmapScale: BitmapScale?
        var narrow: IconRow?
        var densityOnly: IconRow?

        for (name, ink) in cases {
            guard let image = awaitImage(
                name: name,
                ink: ink,
                viewport: viewport,
                window: window,
                status: status,
                bitmapScale: bitmapScale
            ) else { return }
            switch name {
            case "Empty":
                bitmapScale = image.backdropScale
            case "Narrow":
                narrow = image
            case "DensityOnly":
                guard let narrow else {
                    XCTFail("Missing narrow icon sample before the density change")
                    return
                }
                XCTAssertEqual(
                    image.widthFraction / narrow.widthFraction,
                    1.5,
                    accuracy: 0.25,
                    "Density-only width: \(narrow) → \(image)"
                )
                XCTAssertEqual(
                    image.heightFraction / narrow.heightFraction,
                    1.5,
                    accuracy: 0.25,
                    "Density-only height: \(narrow) → \(image)"
                )
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
        status: XCUIElement,
        bitmapScale: BitmapScale?
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
                    expected: ink,
                    measureBackdrop: name == "Empty"
                )
                if let sample, sample.matches(name: name, expected: ink, bitmapScale: bitmapScale) {
                    matchingFrames += 1
                    if matchingFrames >= 3 { return sample }
                } else {
                    matchingFrames = 0
                }
            }
            Thread.sleep(forTimeInterval: 0.06)
        } while Date() < deadline
        XCTFail("Expected \(name) with \(String(describing: ink)). Last stage: \(stage). Native map sample: \(String(describing: sample)). Bitmap scale: \(String(describing: bitmapScale))")
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
    let leftOffsetPixels: Double?
    let widthPixels: Int
    let heightPixels: Int
    let verticalCenterOffsetPixels: Double?
    let viewportWidth: Int
    let viewportHeight: Int
    let densityMark: Bool
    let colors: Set<Ink>
    let background: RGB
    let backdropScale: BitmapScale?

    var widthFraction: Double { Double(widthPixels) / Double(viewportWidth) }
    var heightFraction: Double { Double(heightPixels) / Double(viewportHeight) }

    func matches(name: String, expected: Ink?, bitmapScale: BitmapScale?) -> Bool {
        guard background.isClose(to: backdropColor, tolerance: 32) else { return false }
        guard let expected else { return colors.isEmpty && (name != "Empty" || backdropScale != nil) }
        let raisesDensity = ["DensityOnly", "Wide", "Visible"].contains(name)
        guard colors == [expected], densityMark == raisesDensity,
              let leftOffsetPixels, let verticalCenterOffsetPixels else { return false }
        if name == "Bitmap" {
            guard let bitmapScale else { return false }
            return abs(leftOffsetPixels / bitmapScale.x - 8) <= 4 &&
                abs(Double(widthPixels) / bitmapScale.x - 24) <= 4 &&
                abs(Double(heightPixels) / bitmapScale.y - 24) <= 4 &&
                abs(verticalCenterOffsetPixels / bitmapScale.y) <= 4
        }
        return (0.012...0.085).contains(leftOffsetPixels / Double(viewportWidth)) &&
            (0.065...0.39).contains(widthFraction) &&
            abs(verticalCenterOffsetPixels) / Double(viewportHeight) <= 0.02 &&
            (0.065...0.17).contains(heightFraction)
    }
}

private let backdropColor = RGB(red: 99, green: 125, blue: 143)

private struct BitmapScale {
    let x: Double
    let y: Double
}

private func probe(
    _ screenshot: UIImage,
    frame: CGRect,
    screenWidthInPoints: CGFloat,
    expected: Ink?,
    measureBackdrop: Bool
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
    let backdropScale = measureBackdrop ? measureBitmapScale(
        image,
        row: row,
        x: left + CGFloat(width / 2),
        top: top,
        height: height,
        colorSpace: colorSpace
    ) : nil
    return IconRow(
        leftOffsetPixels: first.map { Double($0) - Double(width) / 2 },
        widthPixels: count,
        heightPixels: vertical?.count ?? 0,
        verticalCenterOffsetPixels: vertical.map { Double($0.first + $0.last) / 2 - Double(height) / 2 },
        viewportWidth: width,
        viewportHeight: height,
        densityMark: densityMark,
        colors: colors,
        background: row[width / 2 + 2],
        backdropScale: backdropScale
    )
}

private func measureBitmapScale(
    _ image: CGImage,
    row: [RGB],
    x: CGFloat,
    top: CGFloat,
    height: Int,
    colorSpace: CGColorSpace
) -> BitmapScale? {
    let frame = CGRect(x: x, y: top, width: 1, height: CGFloat(height))
    guard let column = readPixels(image, in: frame, colorSpace: colorSpace), column.count == height else { return nil }
    // The backing placemark is a known 48×48 bitmap in the same map renderer as the icon.
    let xScale = Double(centeredBackdropBand(in: row)) / 48
    let yScale = Double(centeredBackdropBand(in: column)) / 48
    guard (0.75...1.5).contains(xScale), (0.75...1.5).contains(yScale) else { return nil }
    return BitmapScale(x: xScale, y: yScale)
}

private func centeredBackdropBand(in pixels: [RGB]) -> Int {
    let center = pixels.count / 2
    guard pixels[center].isClose(to: backdropColor, tolerance: 18) else { return 0 }
    var first = center
    var last = center
    while first > 0 && pixels[first - 1].isClose(to: backdropColor, tolerance: 18) { first -= 1 }
    while last + 1 < pixels.count && pixels[last + 1].isClose(to: backdropColor, tolerance: 18) { last += 1 }
    return last - first + 1
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
