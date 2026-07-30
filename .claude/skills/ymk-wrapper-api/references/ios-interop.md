# iOS interop notes

The Objective-C SDK reaches Kotlin through the `YandexMapKit` CocoaPods package name, so every iOS
source imports `YandexMapKit.YMK*` under a `Native*` alias. What follows are the recurring frictions
and how this repo resolves them.

## Naming translation

| Objective-C | Kotlin/Native | In this repo |
|---|---|---|
| `YMKPoint` | class | `import YandexMapKit.YMKPoint as NativePoint` |
| `YMKMapInputListener` protocol | `YMKMapInputListenerProtocol` | alias `NativeInputListener` |
| `+[YMKPoint pointWithLatitude:longitude:]` | `NativePoint.pointWithLatitude(lat, lon)` | used instead of a constructor |
| `-[YMKMap setIconWithImage:style:]` | `setIconWithImage(image, style)` | the `With<FirstArg>` suffix is normal |
| `YMKMapTypeVectorMap` | enum entry `NativeMapType.YMKMapTypeVectorMap` | mapped in `when` |
| `isValid` | `isValid()` — a function, not a property | `public actual val isValid: Boolean get() = nativeX.isValid()` |

Protocols must be implemented by an `NSObject` subclass:

```kotlin
private val nativeListener = object : NativeClusterListener, NSObject() { … }
```

## Boxed numbers

Optional scalars arrive as `NSNumber?`. Unwrap with the typed accessor, box with the internal helpers
in `NSNumber.ios.kt`:

```kotlin
accuracy = accuracy?.doubleValue          // native → common
accuracy = accuracy?.toNSNumber()          // common → native
```

`toNSNumber()` exists for `Int`, `Long`, `Boolean`, `Float`, `Double` and is `internal` — add an
overload there rather than calling `NSNumber.numberWith*` at the call site.

## CoreGraphics structs

`CGPoint` / `CGRect` come back as `CValue<…>`, which cannot be read directly:

```kotlin
public fun PointF.toNative(): CValue<CGPoint> {
    return CGPointMake(x.toDouble(), y.toDouble())
}

public fun CGPoint.toCommon(): PointF {
    return PointF(x.toFloat(), y.toFloat())
}
```

When the SDK hands over an `NSValue` box, open it with `useContents`:

```kotlin
internal fun NSValue.toPointF(): PointF {
    return CGPointValue.useContents { toCommon() }
}
```

`useContents` runs its block inside the struct's scope — do not let the receiver escape it; convert
to a common type inside the block, as above.

## Time

The common API speaks `kotlin.time`. iOS speaks `NSDate` and seconds:

```kotlin
absoluteTimestamp = absoluteTimestamp.toNSDate()        // common → native
absoluteTimestamp = absoluteTimestamp.toKotlinInstant() // native → common
```

Android's `Animation` takes seconds as `Float`, so its converter does the arithmetic explicitly
(`duration.inWholeMilliseconds / 1000f`). Keep such unit conversion inside the converter — the common
type stays a `Duration`.

## Colors

`Color` is ARGB-packed in common code; iOS needs a `UIColor` with normalized components, so
`Color.ios.kt` does the shifting in both directions. Android's side is a plain `Int`, which is why
there is no `Color.android.kt`.

## Opt-ins

`ExperimentalForeignApi` and `BetaInteropApi` are opted in for every iOS source set in the module's
`build.gradle.kts`:

```kotlin
sourceSets.all {
    languageSettings.apply {
        progressiveMode = true
        if (name.lowercase().contains("ios")) {
            optIn("kotlinx.cinterop.ExperimentalForeignApi")
            optIn("kotlinx.cinterop.BetaInteropApi")
        }
    }
}
```

Only add a file-level `@file:OptIn(...)` when a file needs something beyond that (as `MapKit.ios.kt`
does) — repeating the source-set opt-ins per file is noise.

## Building without a Mac setup

`-PskipIosTarget=true` drops the iOS targets and the CocoaPods block, so Android-only work can build
and test. Anything touching `iosMain` still needs a real compile before it is called done:

```bash
./gradlew :yandex-mapkit-kmp:compileKotlinIosSimulatorArm64
```
