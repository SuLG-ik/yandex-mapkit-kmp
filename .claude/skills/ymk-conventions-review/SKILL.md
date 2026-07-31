---
name: ymk-conventions-review
description: >-
  Convention audit for yandex-mapkit-kmp changes — checks a diff, a file or generated code against
  the repo's rules: expect/actual symmetry, toNative()/toCommon() placement and naming, Native*
  aliases, platform file suffixes, explicit API, KDoc and no-comment policy, listener identity,
  Compose node cleanup and stability config. Use it when reviewing or self-checking work in this
  repo — "проверь, что соответствует конвенциям", "отревьюй мой диф", "я дописал обёртку, всё ли по
  правилам", "почему листенер не отписывается", before opening a PR, and right after generating a
  batch of wrapper or Compose code.
---

# Convention review for yandex-mapkit-kmp

Run this over a change before it lands. The goal is not style policing for its own sake — every item
below has a failure mode attached, and most of them fail silently at runtime rather than at compile
time, which is exactly why a checklist earns its keep here.

Work through the sections that apply to the change. For each finding, state the file, the rule and
the concrete consequence. Fix mechanical issues directly; flag anything that changes public API
shape for the author to decide.

## Scope the review first

```bash
git diff --stat main...HEAD
git diff main...HEAD -- '*.kt'
```

If the change touches `commonMain`, both platform source sets must be in the diff too — a new
`expect` member with only one `actual` does not compile, but a new *optional* member or a converter
added on one platform only will happily ship half-done.

## 1. Boundary discipline

| Check | Command / how | Why it matters |
|---|---|---|
| No converters in common | `grep -rn "toNative\|toCommon" --include='*.kt' */src/commonMain` should only match imports of common-side helpers, never declarations | `commonMain` must not know a native type exists |
| No native imports in common | `grep -rn "^import com\.yandex\|^import YandexMapKit" --include='*.kt' */src/commonMain` → expect zero hits | same |
| Alias for the file's native type | native counterpart imported `as Native<CommonType>`, alias imports last | keeps Android/iOS actuals diffable line by line |
| Converter names | only `toNative` / `toCommon` — no `asNative`, `convert`, `fromNative` | the two-word vocabulary is the wrapper's readability contract |

Domain converters with other verbs (`toGeometry`, `toImageProvider`, `toMapkitColor`, `toArgb`) are
fine — they do not cross the native boundary.

## 2. File and package placement

```bash
find */src/androidMain */src/iosMain -name '*.kt' ! -name '*.android.kt' ! -name '*.ios.kt'
find . -path '*/iosMain/*' -name '*.android.kt' -o -path '*/androidMain/*' -name '*.ios.kt'
```

Expected survivors of the first command are only platform-only types with no common counterpart
(`AndroidImageProvider.kt`, `UIImageImageProvider.kt`) plus the known-bad `map/MapWindow.kt`.
Anything new showing up there is a mistake.

The second command should return only the two known-misplaced `location/*.android.kt` files in
`iosMain`. A new hit means a file was created in the wrong source set — it will compile (the suffix
is not semantic) and then confuse everyone forever.

Also verify the package mirrors MapKit (`ru.sulgik.mapkit.<mapkit package>`) and the file is named
after its single public type.

## 3. expect / actual symmetry

- Every `expect` member has an `actual` on both platforms, in the same order, with the same KDoc.
- Default parameter values only on the `expect` side.
- `expect abstract class X()` has `actual constructor()` in both actuals.
- Handle types: `internal constructor`, member `toNative()` returning the platform type, top-level
  `NativeX.toCommon()`.
- A new `MapObject` subtype is registered in the `when` inside `MapObject.toCommon()` (and
  `BaseMapObjectCollection.toCommon()` for collections) on **both** platforms. Miss this and objects
  coming back from listeners or `traverse` arrive as the base wrapper — no compile error, just a
  failed cast or missing API at runtime.

Quick way to compare the two actuals of a type:

```bash
diff <(grep -o 'actual [a-z]* [a-zA-Z]*' */src/androidMain/**/Foo.android.kt) \
     <(grep -o 'actual [a-z]* [a-zA-Z]*' */src/iosMain/**/Foo.ios.kt)
```

## 4. Listener identity

The single highest-value check in this repo:

- The listener class implements `NativeConvertible<NativeX>`, and `toNative()` returns a **stored
  field**, not a freshly built adapter.
- The iOS adapter extends `NSObject` alongside the `*Protocol`.
- Native callback names are wired to the matching common method — read them side by side. Precedent
  for why: `InputListener.ios.kt` currently maps `onMapTapWithMap` to `onMapLongTap` and vice versa.
- Common code offers an `inline` factory taking lambdas, so users are not forced to subclass.
- Subscription methods take `WeakRef<Listener>` and forward `listener.toNative()`; call sites wrap
  with `asWeakRef()` **and** keep the listener in a field of whatever owns the subscription
  (`MapObjectNode.nativeTapListener`, `MapUpdater.cameraListener`, `ClusterNode.clusterListener`).

Consequence of getting the first one wrong: `removeXListener` compares by identity, so removal
silently no-ops. Consequence of getting the last one wrong: nothing crashes and nothing logs — the
listener is collected and the subscription just never fires again.

## 5. Enum and nullability handling

- Both directions implemented, `when` exhaustive.
- iOS `toCommon()` ends with
  `else -> throw IllegalArgumentException("Unknown NativeX ($this)")` — never a fallback value.
- Nullable native values map to nullable common values with `?.`; no `!!`, no invented defaults.
- Round-trip sanity for value types: `x.toNative().toCommon() == x`.
- Named arguments used when a converter fills more than ~3 fields, so field reordering cannot
  silently swap values of the same type (`Float` zoom/azimuth/tilt is the classic trap here).

## 6. Style

- Explicit `public` and explicit return types in `yandex-mapkit-kmp` and
  `yandex-mapkit-kmp-compose` (not in the moko modules, which do not enable explicit API).
- Block bodies with `return`, expression bodies only for property getters.
- KDoc on new public API, repeated on the actuals.
- **No `//` comments.** `grep -rn '^\s*//' --include='*.kt' <changed files>` should be empty;
  existing hits are commented-out code in `LayerIds.ios.kt` and `MapObjectStatesRestorationTest.kt`.
- Trailing commas, no wildcard imports, private default constants next to their type.

## 7. Compose module extras

- Map-composition composables carry `@YandexMapComposable`; unstable API also carries
  `@YandexMapsComposeExperimentalApi`, and `expect`/`actual` pairs repeat both.
- State classes are `@Immutable` with a `Saver` and a `rememberXxxState(key: String? = null)`.
- Every node undoes in `onRemoved()` what it did in `onAttached()`/`factory`, and clears references in
  `onCleared()`. A missed removal leaves objects on the map after the composable leaves.
- `update(value) { … }` exists for each mutable parameter and nothing more — a missing `update` means
  the parameter silently stops working after the first composition.
- New wrapper types used in composable signatures are added to
  `compose_compiler_stability_config.conf`, otherwise recomposition never skips.
- Public Compose API takes `androidx.compose.ui.graphics.Color` and converts with
  `toMapkitColor()`; collections are `ImmutableList`.

## 8. Surrounding artefacts

- Public API change → matching page under `docs/` updated (and `mkdocs.yml` `nav` for a new page).
- New module → `settings.gradle.kts`, `dokkaModules`, README table.
- MapKit version bump → `libs.versions.toml` and the README sentence naming the version.

## 9. Compile

Nothing counts as reviewed until it builds on both platforms:

```bash
./gradlew :yandex-mapkit-kmp:compileAndroidMain :yandex-mapkit-kmp:compileKotlinIosSimulatorArm64
```

```bash
./gradlew :yandex-mapkit-kmp-compose:compileAndroidMain :yandex-mapkit-kmp-compose:compileKotlinIosSimulatorArm64
```

Without CocoaPods available, `-PskipIosTarget=true` builds Android only — say so explicitly in the
review instead of implying iOS was verified.

## Reporting

Group findings by severity and be concrete about the consequence:

```
Blocking
- map/FooMapObject.android.kt:41 — toCommon() dispatch in MapObject.toCommon() not extended;
  foo objects from traverse() arrive as MapObject and the cast in Clustering fails at runtime.

Should fix
- map/FooListener.ios.kt:12 — toNative() builds a new adapter per call; removeFooListener will
  never remove it.

Nit
- map/Foo.kt:7 — expression body; the codebase uses block bodies with return.
```

Known pre-existing deviations (misnamed files, `LocationManager.ios.kt`'s public constructor, the
swapped `InputListener` callbacks) are not the author's fault — mention them only if the change
touches those files.
