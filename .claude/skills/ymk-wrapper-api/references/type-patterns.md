# The three wrapper patterns, end to end

Each section shows the complete set of files for one pattern, taken from working code in the repo.

## 1. Value type

Immutable data that crosses the boundary by copy. The common declaration knows nothing about
platforms.

**`commonMain/.../geometry/Point.kt`**

```kotlin
package ru.sulgik.mapkit.geometry

public data class Point(val latitude: Latitude, val longitude: Longitude)

public fun Point(latitude: Double, longitude: Double): Point {
    return Point(Latitude(latitude), Longitude(longitude))
}
```

**`androidMain/.../geometry/Point.android.kt`**

```kotlin
package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Point as NativePoint

public fun Point.toNative(): NativePoint {
    return NativePoint(latitude.value, longitude.value)
}

public fun NativePoint.toCommon(): Point {
    return Point(Latitude(latitude), Longitude(longitude))
}
```

**`iosMain/.../geometry/Point.ios.kt`** — same shape, native factory instead of a constructor:

```kotlin
import YandexMapKit.YMKPoint as NativePoint

public fun Point.toNative(): NativePoint {
    return NativePoint.pointWithLatitude(latitude.value, longitude.value)
}
```

Scalar wrappers use `@JvmInline value class` and expose the raw value as `value`:

```kotlin
@JvmInline
public value class Latitude(public val value: Double) : Comparable<Latitude> {
    override fun compareTo(other: Latitude): Int {
        return value.compareTo(other.value)
    }
}
```

`Color` is the variant where the raw value stays `internal` and access goes through
`Color.fromArgb(...)` / `toArgb()`, because the ARGB layout is an implementation detail the
platform converters translate (`UIColor` on iOS, plain `Int` on Android).

### Union-shaped values

`Geometry` models MapKit's tagged union as a data class of nullable fields with a private
constructor and named factories, plus `toGeometry()` extensions on each member type. Its `toNative()`
picks the first non-null branch and throws when none matches — a union with no arm set is a
programming error, not a default.

## 2. Handle type

Wraps a live native object. The class is `expect` so the wrapper type is one type in common code,
and each `actual` stores the native instance.

**`commonMain/.../map/PlacemarkMapObject.kt`**

```kotlin
public expect class PlacemarkMapObject : MapObject {

    public var geometry: Point

    public var direction: Float

    public fun setText(
        text: String,
        style: TextStyle = TextStyle(),
    )

    public fun setIcon(
        image: ImageProvider,
        style: IconStyle = IconStyle(),
        onFinished: Callback? = null,
    )
}
```

**`androidMain/.../map/PlacemarkMapObject.android.kt`**

```kotlin
public actual class PlacemarkMapObject internal constructor(private val nativePlacemarkMapObject: NativePlacemarkMapObject) :
    MapObject(nativePlacemarkMapObject) {

    override fun toNative(): NativePlacemarkMapObject {
        return nativePlacemarkMapObject
    }

    public actual var geometry: Point
        get() = nativePlacemarkMapObject.geometry.toCommon()
        set(value) {
            nativePlacemarkMapObject.geometry = value.toNative()
        }

    public actual fun setText(text: String, style: TextStyle) {
        nativePlacemarkMapObject.setText(text, style.toNative())
    }
}

public fun NativePlacemarkMapObject.toCommon(): PlacemarkMapObject {
    return PlacemarkMapObject(this)
}
```

Points to keep:

- The subclass passes its native object up to the base wrapper's constructor and **overrides
  `toNative()` with the narrower return type**, so callers of a `PlacemarkMapObject` get
  `NativePlacemarkMapObject` back, not `NativeMapObject`.
- `MapObject.toNative()` is declared `public open fun` in each actual — it is not part of the
  `expect` class, because its return type is platform-specific.
- Properties bridge naming differences at the actual level: Android `isVisible`, iOS `visible`, both
  exposed as `isVisible`.
- Optional native parameters get an `if`/`else` on Android when the SDK offers overloads instead of
  nullable arguments (`setIcon` with and without `onFinished`), while iOS passes `onFinished?.toNative()`.

### Types that must be created, not only wrapped

`MapObjectCollection.addPlacemark()` and friends return wrappers built from the native return value —
creation happens through the parent handle, never through a public wrapper constructor. If new API
needs a factory, put it on the owning handle type, mirroring MapKit.

## 3. Listener / callback

**`commonMain/.../map/InputListener.kt`**

```kotlin
public expect abstract class InputListener() {
    public abstract fun onMapTap(map: Map, point: Point)
    public abstract fun onMapLongTap(map: Map, point: Point)
}

public inline fun InputListener(
    crossinline onMapTap: (map: Map, point: Point) -> Unit,
    crossinline onMapLongTap: (map: Map, point: Point) -> Unit,
): InputListener {
    return object : InputListener() {
        override fun onMapTap(map: Map, point: Point) {
            onMapTap.invoke(map, point)
        }

        override fun onMapLongTap(map: Map, point: Point) {
            onMapLongTap.invoke(map, point)
        }
    }
}
```

The `expect abstract class X()` needs the explicit empty constructor, and every `actual` repeats it
as `actual constructor()`.

**`androidMain`** — the adapter is a stored field, the class implements `NativeConvertible`, and
native payloads are converted on the way in:

```kotlin
public actual abstract class InputListener actual constructor() :
    NativeConvertible<NativeInputListener> {

    private val nativeListener = object : NativeInputListener {
        override fun onMapTap(p0: NativeMap, p1: NativePoint) {
            onMapTap(p0.toCommon(), p1.toCommon())
        }

        override fun onMapLongTap(p0: NativeMap, p1: NativePoint) {
            onMapLongTap(p0.toCommon(), p1.toCommon())
        }
    }

    override fun toNative(): NativeInputListener {
        return nativeListener
    }

    public actual abstract fun onMapTap(map: Map, point: Point)

    public actual abstract fun onMapLongTap(map: Map, point: Point)
}
```

`NativeConvertible` is not decoration: it is what makes `WeakRef<InputListener>.toNative()` resolve,
and every subscription in the wrapper takes that `WeakRef` rather than the listener itself.

**`iosMain`** — same, but the adapter must extend `NSObject` to implement a `*Protocol`, and the
native method names carry their `WithX` suffixes:

```kotlin
private val nativeListener = object : NativeInputListener, NSObject() {
    override fun onMapTapWithMap(map: NativeMap, point: NativePoint) {
        onMapTap(map.toCommon(), point.toCommon())
    }
}
```

Take the mapping between native and common callback names seriously — `InputListener.ios.kt`
currently has `onMapTapWithMap` wired to `onMapLongTap` and vice versa, which is exactly the kind of
bug this shape invites. Read the native signature twice.

Single-method callbacks can collapse further when the native side is a functional type:
`Callback.ios.kt` returns a method reference (`return ::onTaskFinished`), and
`Callback.android.kt` uses a SAM conversion (`NativeCallback { onTaskFinished() }`).

Listeners with a return value keep it: `MapObjectTapListener.onMapObjectTap(...): Boolean` returns
straight through to the SDK, since MapKit uses it to mark the event consumed.

## 4. Enum

```kotlin
public enum class MapType {
    /**
     * Do not use any of the predefined maps.
     */
    NONE,
    /**
     * Raster map.
     */
    MAP,
}
```

Android converters map one-to-one and stay exhaustive in both directions. iOS `toCommon()` must add
`else -> throw IllegalArgumentException("Unknown NativeMapType ($this)")` because Kotlin sees the
Objective-C enum as open. Never map an unknown native constant onto an arbitrary common value —
throwing surfaces an SDK upgrade immediately instead of producing a wrong map.

Nested enums (`TextStyle.Placement`, `Animation.Type`) get their own converter pair alongside the
parent's, in the same file.
