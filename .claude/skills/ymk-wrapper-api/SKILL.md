---
name: ymk-wrapper-api
description: >-
  Recipe for adding or changing wrapped MapKit API in the yandex-mapkit-kmp core module — choosing
  between a value type, a handle type (expect class over a live native object) and a listener,
  writing the expect/actual pair, the toNative()/toCommon() converters for Android and iOS, and the
  enum, nullable and NSNumber edge cases. Use this whenever the task is to expose, wrap, extend or
  fix a MapKit type, property, method, listener or callback in common code — including asks like
  "оберни X из MapKit", "добавь метод в Map", "нужен листенер на Y", "поддержи новый тип geometry",
  "почему toCommon падает на iOS". Reach for it before writing any expect/actual or converter code.
---

# Wrapping MapKit API in `yandex-mapkit-kmp`

The wrapper's contract with its users: *common code sees a Kotlin-shaped MapKit; native types never
leak into `commonMain`.* Every decision below serves that contract, so when a case is not covered
here, pick whatever keeps native types out of common code and keeps the two converter names.

If you have not read the `ymk-architecture` skill yet, read it first — package layout, file naming
and the `Native*` alias rule are assumed here.

## Step 1 — pick the pattern

Ask what the thing *is* on the native side:

| Native shape | Pattern | Examples |
|---|---|---|
| Plain data, copied by value | **Value type** — `data class` / `value class` in common, converters per platform | `Point`, `CameraPosition`, `IconStyle`, `Location`, `Animation` |
| Live object with identity and mutable state | **Handle type** — `expect class` wrapping the native instance | `Map`, `MapWindow`, `PlacemarkMapObject`, `LocationManager`, `Logo` |
| Interface/protocol the SDK calls back into | **Listener** — `expect abstract class` + inline factory | `InputListener`, `CameraListener`, `ClusterListener`, `Callback` |
| Closed set of constants | **Enum** — `enum class` in common, `when` converters both ways | `MapType`, `RotationType`, `CameraUpdateReason` |

Mixed cases follow the dominant shape: `Cluster` holds native state, so it is a handle type even
though it lives in `geometry`.

Full annotated templates for each pattern, including the traps:
[references/type-patterns.md](references/type-patterns.md).

## Step 2 — write the common declaration

Value type — everything in `commonMain`, no mention of anything native:

```kotlin
package ru.sulgik.mapkit.map

public data class CameraPosition(
    val target: Point,
    val zoom: Float,
    val azimuth: Float,
    val tilt: Float,
)
```

Handle type — `expect class` listing only what the wrapper exposes, with KDoc from the MapKit docs.
Note what is *absent*: no constructor, no `toNative()`. Instances only ever come from `toCommon()`,
and the native type differs per platform, so it cannot appear in the `expect`:

```kotlin
public expect class MapWindow {

    /**
     * Gets the map interface.
     */
    public val map: Map

    public var focusPoint: ScreenPoint?

    public fun convertWorldToScreen(worldPoint: Point): ScreenPoint?

    public val isValid: Boolean
}
```

Default argument values belong on the `expect` side only — `actual` members repeat the parameter
without the default (`setText(text: String, style: TextStyle = TextStyle())` in common,
`setText(text: String, style: TextStyle)` in each actual).

## Step 3 — write the actuals

Android and iOS actuals are deliberately near-identical, differing only in the native call spelling
(`setIcon(...)` vs `setIconWithImage(...)`, `isVisible` vs `visible`). Keep member order the same in
both files so a diff between them shows only real platform differences.

```kotlin
public actual class MapWindow internal constructor(private val nativeMapWindow: NativeMapWindow) {

    public fun toNative(): NativeMapWindow {
        return nativeMapWindow
    }

    public actual val map: Map
        get() = nativeMapWindow.map.toCommon()
}

public fun NativeMapWindow.toCommon(): MapWindow {
    return MapWindow(this)
}
```

`internal constructor` is what stops users from fabricating a wrapper around a native object they
should not own; `toNative()` is public so platform code can drop back down to the SDK.

For a type hierarchy, the base `toCommon()` dispatches so callers get the most specific wrapper:

```kotlin
public fun NativeMapObject.toCommon(): MapObject {
    return when (this) {
        is NativeBaseMapObjectCollection -> toCommon()
        is NativeCircleMapObject -> toCommon()
        is NativePlacemarkMapObject -> toCommon()
        else -> MapObject(this)
    }
}
```

When you add a new `MapObject` subclass, add its branch here **and** in
`BaseMapObjectCollection.toCommon()` if it is a collection — otherwise map objects arriving from
listeners silently degrade to the base wrapper.

## Step 4 — converters

Value types get a symmetric pair of top-level extensions in each platform file:

```kotlin
public fun CameraPosition.toNative(): NativeCameraPosition {
    return NativeCameraPosition.cameraPositionWithTarget(target.toNative(), zoom, azimuth, tilt)
}

public fun NativeCameraPosition.toCommon(): CameraPosition {
    return CameraPosition(target.toCommon(), zoom, azimuth, tilt)
}
```

Rules that keep converters trustworthy:

- Convert every nested field through its own converter (`target.toNative()`), never by hand.
- Nullable native values map to nullable common values with `?.` — no `!!`, no silent defaults.
- Use named arguments when the constructor takes more than ~3 fields, so a reordering of the data
  class does not silently mis-map values.
- Round-trip must hold: `x.toNative().toCommon() == x` for value types. Anything that cannot
  round-trip (like `Geometry`, whose native form is a union) throws explicitly rather than guessing:
  `else -> throw IllegalStateException("Conversion common $this to native is not available")`.

Enums use exhaustive `when` in both directions. On iOS the Objective-C enum is not exhaustive from
Kotlin's point of view, so `toCommon()` needs the failing branch — copy the message shape used
elsewhere:

```kotlin
else -> throw IllegalArgumentException("Unknown NativeMapType ($this)")
```

## Step 5 — check yourself

- [ ] Common file has zero native imports; `toNative`/`toCommon` appear only under `androidMain` /
      `iosMain`.
- [ ] The file's native counterpart imported as `Native<CommonType>`, alias imports at the end of the
      import block.
- [ ] Android and iOS actuals expose the same members in the same order, both with KDoc.
- [ ] New handle type: `internal constructor`, member `toNative()`, top-level `toCommon()`, and a
      branch in any parent `toCommon()` dispatcher.
- [ ] New listener: `NativeConvertible` with a single `nativeListener` field (see below), plus the
      inline factory in common.
- [ ] New subscription method takes `WeakRef<Listener>` and forwards `listener.toNative()`.
- [ ] Explicit `public`, explicit return types, block bodies with `return`, no `//` comments.
- [ ] Docs under `docs/` and the README touched if the public surface changed.
- [ ] `./gradlew :yandex-mapkit-kmp:compileKotlinIosSimulatorArm64
      :yandex-mapkit-kmp:compileAndroidMain` (or `-PskipIosTarget=true` when no CocoaPods).

## The listener trap worth memorising

`toNative()` on a listener must return **the same instance every time**. The SDK's `removeXListener`
compares by identity, and MapKit holds listeners weakly — building a fresh adapter per call means
removal silently fails and the listener can be collected mid-flight. So the adapter is a field, and
the class implements `NativeConvertible<NativeX>` rather than declaring a bare `toNative()`:

```kotlin
public actual abstract class ClusterListener actual constructor() :
    NativeConvertible<NativeClusterListener> {

    private val nativeListener = NativeClusterListener { onClusterAdded(it.toCommon()) }

    override fun toNative(): NativeClusterListener {
        return nativeListener
    }

    public actual abstract fun onClusterAdded(cluster: Cluster)
}
```

On iOS the adapter additionally has to be an `NSObject` to satisfy the protocol:
`object : NativeClusterListener, NSObject() { … }`.

## Subscriptions take `WeakRef`, not the listener

Because MapKit stores listeners weakly, every subscription method in the common API takes
`WeakRef<Listener>` so the contract is visible at the call site:

```kotlin
public expect open class MapObject {
    public fun addTapListener(tapListener: WeakRef<MapObjectTapListener>)
    public fun removeTapListener(tapListener: WeakRef<MapObjectTapListener>)
}
```

The caller wraps with `asWeakRef()` and keeps the strong reference itself:

```kotlin
private val tapListener = MapObjectTapListener { _, _ -> true }

mapObject.addTapListener(tapListener.asWeakRef())
```

`NativeConvertible` is what lets the actuals unwrap it in one line — the conversion is already
written per platform, so a new subscription only forwards it:

```kotlin
public actual fun addTapListener(tapListener: WeakRef<MapObjectTapListener>) {
    nativeMapObject.addTapListener(tapListener.toNative())
}
```

`WeakRef<T>.toNative()` returns `WeakReference<Native>` on Android and a nullable `Native?` on iOS,
matching how each SDK expects to receive a weakly-held listener. When wrapping a **new** subscription
method, take `WeakRef<Listener>` — passing the listener directly is the old shape and reintroduces
the leak this API prevents.

Common code also gets a lambda-friendly factory so users are not forced to subclass:

```kotlin
public inline fun ClusterListener(crossinline onClusterAdded: (cluster: Cluster) -> Unit): ClusterListener {
    return object : ClusterListener() {
        override fun onClusterAdded(cluster: Cluster) {
            onClusterAdded.invoke(cluster)
        }
    }
}
```

iOS-specific mechanics — `NSNumber` boxing, `CValue`/`useContents`, `NSDate` ↔ `Instant`, protocol
naming (`YMKFooProtocol`), factory constructors (`fooWithBar(...)`):
[references/ios-interop.md](references/ios-interop.md).
