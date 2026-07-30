---
name: ymk-compose-api
description: >-
  Recipe for the yandex-mapkit-kmp-compose module — adding or changing map composables, state
  holders with Savers, MapNode/MapApplier composition nodes, effects, config data classes and
  ImageProvider helpers, plus the @YandexMapComposable / @YandexMapsComposeExperimentalApi
  annotation rules and Compose stability config. Use it whenever the work touches Compose map API in
  this repo — "добавь composable для нового map object", "нужен rememberXxxState", "почему объект не
  обновляется при рекомпозиции", "добавь параметр в YandexMap/MapConfig", "Clustering",
  "imageProvider из compose-ресурса". Read it before writing Compose code here.
---

# Compose API in `yandex-mapkit-kmp-compose`

This module renders the map and lets users describe map contents declaratively. It does that with a
**second, separate composition** whose nodes are map objects rather than UI nodes — the same trick
`maps-compose` uses for Google Maps. Understanding that is the key to everything else: inside
`YandexMap { … }` you are not in the UI composition, so UI composables are unavailable and
`@YandexMapComposable` is what enforces it at compile time.

The `ymk-architecture` skill covers module-wide naming and style; `ymk-wrapper-api` covers the
underlying wrapper. This skill assumes both.

## The two public APIs

The module deliberately offers two ways to drive a map, and new features usually need a story for
both (see [docs/compose/overview.md](docs/compose/overview.md)):

- **States API** — `YandexMap(cameraPositionState, config, content)`, where `content` is a
  `@[Composable YandexMapComposable] () -> Unit` and map objects are declared as composables.
  Configuration flows through `MapConfig`; escape hatch is `MapEffect { map -> … }`.
- **Controller API** — `YandexMap(controller)` with `rememberYandexMapController()`; map access is
  imperative via `MapControllerEffect(controller) { mapWindow -> … }`. No Compose runtime involved.

Both funnel into `internal expect fun NativeYandexMap(modifier, onRelease, update)`, which wraps the
platform `MapView` (`AndroidView` on Android, `UIKitView` on iOS) and binds it to the lifecycle.

## How the map composition works

`launchMapComposition` (in `compose/composition/MapComposition.kt`) starts a `Composition` whose
applier is `MapApplier`, parented to the UI composition so recomposition propagates:

```kotlin
val composition = Composition(applier = MapApplier(mapWindow), parent = parentComposition)
composition.setContent {
    MapUpdater(mapUpdaterState)
    CompositionLocalProvider(
        LocalCameraPositionState provides mapUpdaterState.cameraPositionState,
        LocalMapObjectCollection provides mapWindow.map.mapObjects,
        LocalMap provides mapWindow.map,
    ) {
        content()
    }
}
```

`MapApplier` keeps a flat list of `MapNode`s and calls their lifecycle hooks:

| Hook | When | Typical work |
|---|---|---|
| `onAttached()` | node inserted | add listeners to the map object |
| `onRemoved()` | node leaves the composition | remove listeners, `mapObject.parent.remove(mapObject)` |
| `onCleared()` | whole composition disposed | drop references so nothing leaks |

Anything you add to the map must be removed in `onRemoved()`, otherwise objects survive their
composable and stack up on the map.

## Adding a new map object composable

Follow `Circle.kt` / `Placemark.kt` — the full annotated recipe is in
[references/map-object-recipe.md](references/map-object-recipe.md). The shape is always:

1. `public class XxxState(…)` — `@Immutable`, mutable fields via `mutableStateOf`, plus a
   `companion object { public val Saver: Saver<XxxState, Any> = listSaver(…) }`.
2. `public fun rememberXxxState(…, key: String? = null): XxxState` using `rememberSaveable` with that
   Saver, so the state survives configuration change.
3. `@[YandexMapComposable Composable] public fun Xxx(state, …, visible, zIndex, onTap)` — the public
   entry point, which just delegates.
4. `internal fun XxxImpl(…)` — does the real `MapObjectNode(factory = …, update = …)` call. The split
   exists so richer variants can reuse it: `TitledPlacemark` calls `PlacemarkImpl` with extra `init`
   and `update` blocks instead of duplicating the node wiring.
5. `internal class XxxNode(mapObject, tapListener) : MapObjectNode<XxxMapObject>(mapObject, tapListener)`
   — only override hooks if the object needs more than tap handling.
6. Private `DefaultXxx` constants at the bottom of the file.

Inside `MapObjectNode`, `factory` sets the initial native state and `update` re-applies exactly the
properties that changed:

```kotlin
update = {
    update(state.geometry) { this.mapObject.geometry = it }
    update(strokeColor) { mapObject.strokeColor = strokeColor.toMapkitColor() }
}
```

`update(value) { … }` runs the block only when `value` differs from the previous composition — that
is what keeps MapKit from re-uploading icons on every frame. Reading `state.geometry` inside the
`update` lambda is what subscribes the node to that snapshot state.

## Rules that keep this module honest

- **Annotate map composables with `@YandexMapComposable`.** It is a `ComposableTargetMarker`, so it
  makes "UI composable used inside the map composition" a compile error rather than a runtime crash.
  The combined form `@[YandexMapComposable Composable]` is the house spelling.
- **New or unstable API gets `@YandexMapsComposeExperimentalApi`** (`RequiresOptIn`, WARNING level).
  Everything composable-content-as-icon, clustering-by-content and user-location related is currently
  behind it — follow suit when behaviour differs across platforms or the design is still moving.
- **Public state classes are `@Immutable` and hold `mutableStateOf` fields**; internal updater states
  are `@Stable`. Setters that only the library may call are `internal set`
  (`CameraPositionState.isMoving`, `PlacemarkState.isDragging`).
- **One state instance drives one map.** `MapWindowOwner` enforces it with a reentrant lock and
  fails loudly (`"YandexMapController may only be associated with one MapView at a time"`). Any new
  state that owns a `MapWindow` should reuse `MapWindowOwner` rather than invent its own guard.
- **`CompositionLocal`s are `internal`** and error when unset:
  `compositionLocalOf<MapObjectCollection> { error("No MapObjectCollection provided") }`. Expose a
  public read-only accessor when users need it, as `currentCameraPositionState` does.
- **Colors cross via `compose.utils`**: `ComposeColor.toMapkitColor()` inbound,
  `Color.toComposeColor()` outbound. Public Compose API takes `androidx.compose.ui.graphics.Color`,
  never the MapKit `Color`.
- **Collections in public API are `ImmutableList`** (`Clustering(groups: ImmutableList<ClusterGroup>)`)
  so Compose can treat them as stable; provide a `List`-taking convenience overload if it helps
  callers, as `ClusterGroup(points: List<Point>, …)` does.
- **Wrapper types used as composable parameters must be listed in
  [compose_compiler_stability_config.conf](yandex-mapkit-kmp-compose/compose_compiler_stability_config.conf)**
  — the compiler cannot see stability across module boundaries. Adding a new wrapper type to a
  composable signature without adding it there silently makes every recomposition skip-less.

## Key-overload family

`MapEffect`, `MapControllerEffect`, `imageProvider` and `clusterImageProvider` each ship the same
overload ladder: `key1`, `key1+key2`, `key1+key2+key3`, `vararg keys`. It mirrors Compose's own
`LaunchedEffect`/`remember` API so users get familiar restart semantics. When you add a new effect or
provider, provide the whole ladder rather than a single `vararg` — `vararg` allocates and breaks the
common no-key case.

## Checklist

- [ ] Map-composition composables carry `@YandexMapComposable`; experimental ones also carry
      `@YandexMapsComposeExperimentalApi`.
- [ ] State class has a `Saver` and a `rememberXxxState(key: String? = null)` factory.
- [ ] Node removes everything it added in `onRemoved()` and drops references in `onCleared()`.
- [ ] `update(...)` blocks cover every mutable parameter, and nothing else.
- [ ] New wrapper types in composable signatures added to the stability config.
- [ ] `expect`/`actual` Compose functions repeat annotations on both sides.
- [ ] Docs updated: `docs/compose/overview.md`, `docs/compose/mapobjects.md` or
      `docs/compose/image-resources.md`.
- [ ] `./gradlew :yandex-mapkit-kmp-compose:compileDebugKotlinAndroid
      :yandex-mapkit-kmp-compose:compileKotlinIosSimulatorArm64` and, if states changed,
      `:yandex-mapkit-kmp-compose:allTests`.
