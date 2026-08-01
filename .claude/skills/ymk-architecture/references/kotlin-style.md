# Kotlin style in yandex-mapkit-kmp

Every rule here is observable in the existing sources. When a new file disagrees with the codebase,
the codebase wins — consistency is the point.

## Explicit API

All four published modules build with `-Xexplicit-api=strict`, so the compiler rejects a public
declaration without an explicit modifier or an inferred return type. Write `public` even where it is
the default, and always spell the return type:

```kotlin
public fun Point.toNative(): NativePoint {
    return NativePoint(latitude.value, longitude.value)
}
```

Test sources obey it too — `commonTest` classes and test functions are `public`.

Other compiler flags in play: `-Xexpect-actual-classes` (the wrapper relies on `expect class`),
`-Xconsistent-data-class-copy-visibility` (core), `-Xexport-kdoc` (KDoc reaches the ObjC headers),
`progressiveMode = true`, and opt-ins for `ExperimentalForeignApi` / `BetaInteropApi` on iOS source
sets configured centrally in the module's `build.gradle.kts` — do not repeat those opt-ins per file
unless a file needs one the source set does not grant (`MapKit.ios.kt` opts in at file level).

## Function bodies

Blocks with `return`, not expression bodies:

```kotlin
public fun NativeMapKit.toCommon(): MapKit {
    return MapKit(this)
}
```

This holds even for one-liners. Property accessors are the exception and use the expression form:

```kotlin
public actual val version: String
    get() = nativeMapKit.version
```

## Naming

- Common types keep the MapKit name: `CameraPosition`, `PlacemarkMapObject`, `VisibleRegion`.
- Where MapKit's name is too generic for a flat Kotlin package, it gains its domain prefix:
  `logo.Alignment` → `LogoAlignment`, `logo.Padding` → `LogoPadding`, `logo.HorizontalAlignment` →
  `LogoHorizontalAlignment`.
- Enum constants are `UPPER_SNAKE_CASE` (`VECTOR_MAP`, `NO_ROTATION`, `BOTTOM_RIGHT`).
- Booleans exposed as properties read as predicates: `isVisible`, `isDraggable`, `isNightModeEnabled`,
  `isValid` — including where the native side spells it `visible` or `draggable`. The `actual`
  bridges the difference.
- Nested enums live inside the type they configure when MapKit does the same: `Animation.Type`,
  `TextStyle.Placement`.

## Value types

`data class` for multi-field values, with defaults where MapKit documents one:

```kotlin
public data class IconStyle(
    val anchor: PointF? = null,
    val rotationType: RotationType? = RotationType.NO_ROTATION,
    val zIndex: Float? = null,
    val flat: Boolean? = false,
    val isVisible: Boolean? = true,
    val scale: Float? = 1f,
    val tappableArea: Rect? = null,
)
```

`@JvmInline value class` for a single scalar that deserves a type — `Latitude`, `Longitude`, `Color`.
These wrap the raw value in `value` and add only what callers need (`Comparable` on coordinates,
`Color.fromArgb` / `toArgb` on colors).

Constants that back defaults are private and live next to the type: a `private companion object` for
a class member (`TextStyle.DEFAULT_COLOR`), or private file-level `val`/`const` at the bottom of the
file for Compose defaults (`DefaultStrokeColor`, `DefaultStrokeWidth` in `compose/Circle.kt`).

Secondary constructors are written as top-level functions with the type's name rather than real
constructors, so the primary constructor keeps the typed parameters:

```kotlin
public fun Point(latitude: Double, longitude: Double): Point {
    return Point(Latitude(latitude), Longitude(longitude))
}
```

`Geometry` shows the companion-factory variant (`Geometry.fromPoint(...)`) with matching extensions
(`Point.toGeometry()`), used when MapKit itself exposes a factory.

## Nullability

The common API is honest about optionality: native `NSNumber?` / boxed values become Kotlin nullable
types, and converters thread them through with `?.`:

```kotlin
accuracy = accuracy?.doubleValue,
onFinished = onFinished?.toNative(),
```

Never `!!` across the boundary. If a native call can genuinely fail to produce a value, the common
signature returns a nullable (`MapWindow.convertWorldToScreen(...): ScreenPoint?`).

## KDoc

Public wrapper API carries the official MapKit description, and the same KDoc is repeated on the
`actual` members:

```kotlin
/**
 * Notifies MapKit when the application resumes the foreground state.
 */
public fun onStart()
```

Compose API documents behaviour and pitfalls in its own words — see `CameraPositionState`,
`MapEffect`, `rememberYandexMapController`. Warnings about lifetime and single-ownership belong in
KDoc, not in comments.

## Comments

There are effectively no explanatory `//` comments in the sources. The few that exist are links to
upstream documentation in Gradle files. Do not add commentary to Kotlin code — rename, extract, or
write KDoc instead.

## Imports

- No wildcard imports.
- Alias imports last, one per native type, named `Native<CommonType>`.
- Import the converter extensions you use explicitly (`import ru.sulgik.mapkit.geometry.toCommon`) —
  they are top-level functions in the type's package, not members.
- When a file needs both the Compose and the MapKit `Color`, alias the foreign one at the bottom
  (`import androidx.compose.ui.graphics.Color as ComposeColor`) and keep the local one unaliased.

## Tests

`commonTest` uses `kotlin.test`, backtick test names, and a `public companion object` holding
fixtures:

```kotlin
public class ColorConvertionTest {

    @Test
    public fun `mapkit color to compose color should convert correct`() {
        assertEquals(DefaultMapkitColor.toComposeColor(), DefaultComposeColor)
    }
}
```

Compose UI-state tests use `runComposeUiTest` with `StateRestorationTester` to prove a `Saver`
survives configuration change — see `MapObjectStatesRestorationTest` for the intended shape when
adding a new state class. It needs a real frame, so it lives in `androidDeviceTest` and runs on an
emulator, not in the host test task.
