# Аудит покрытия Yandex MapKit

Полная сверка публичного API `ru.sulgik.mapkit:*` со справочником Yandex MapKit.
Дополняет [MAPKIT_BACKLOG.md](MAPKIT_BACKLOG.md): тот описывает дельту версий 4.24 → 4.42,
этот — покрытие всего API целиком.

## Как считалось

Источники:

- справочник MapKit из `ymk-docs/com` — 663 типа Android SDK, плюс `ymk-docs/Objective-C` для
  сверки iOS-сигнатур;
- публичный API враппера — klib-дампы `yandex-mapkit-kmp/api/*.klib.api`,
  `yandex-mapkit-kmp-compose/api/*.klib.api` и разбор `commonMain`;
- пометки `> [!WARNING] This feature is available in the Full MapKit SDK version` /
  `NaviKit SDK version` в шапке страницы — по ним типы разделены на доступные в lite-сборке
  и недоступные.

Проект собирается с `yandex-mapkit = 4.42.0-lite`, поэтому Full- и NaviKit-типы физически
недоступны и вынесены в отдельный раздел.

Сопоставление типов — по имени с поправкой на переименования (`logo.Alignment` → `LogoAlignment`
и т. п.), сопоставление членов — с нормализацией `getX()`/`setX()`/`isX()` → свойство `x`.

### Как перепроверить

Аудит воспроизводится скриптами, а не руками. Порядок:

1. Разобрать `ymk-docs/com/**/*.md`: YAML-шапка даёт `title`/`kind`/`package`; раздел
   `## Summary` → `### Methods` — таблицы `| тип | сигнатура<br>описание |`;
   `## Enum Constant Summary` — константы; `### Constuctors` (с опечаткой в оригинале) —
   блоки кода. Детальные секции под `## Methods` дают nullability возврата (`@NonNull` /
   `@Nullable`) и пометки `@Deprecated` — в сводной таблице их нет.
2. Разобрать `<module>/api/*.klib.api` и/или `src/commonMain/**/*.kt` — публичную поверхность
   враппера.
3. Нормализовать имена и вычесть множества; расхождения по nullability и `@Deprecated`
   проверять отдельными проходами.
4. Доступность считать по шапке страницы: `This feature is available in the Full MapKit SDK
   version` / `NaviKit SDK version` **до** первого `## Summary` — тогда пометка относится
   к типу целиком.

Две ловушки, на которых легко получить ложные срабатывания: у MapKit есть
`getIsUnderground()` и `getNativeName()` (первое нормализуется не в то свойство, второе —
служебное), а члены `MapObjectVisitor` во враппере живут параметрами конструктора, а не
методами.

Документация в `ymk-docs` снята под конкретный релиз и местами отстаёт от SDK: например,
`MapMode.HYBRID` в справочнике отсутствует, хотя в 4.42 константа есть на обеих платформах
и враппер с ней собирается. Если расхождение выглядит странно — сверяться со ссылкой `source`
в шапке страницы.

## Сводка

| Метрика | Значение |
|---|---|
| Типов в MapKit Android SDK | 663 |
| из них доступно в lite | 249 |
| только Full MapKit | 328 |
| только NaviKit | 86 |
| **Обёрнуто типов** | **82 из 249 lite (33 %)** |
| Членов у обёрнутых типов | 391, из них 14 помечены `@Deprecated` в самом MapKit |
| **Обёрнуто актуальных членов** | **305 из 377 (81 %)** |
| Всего членов в lite-API | ~1070 |
| **Итоговое покрытие lite-поверхности** | **~29 %** |

Nullability обёрнутых членов совпадает с MapKit **полностью** — автоматическая сверка
`@Nullable`/`@NonNull` в возвращаемых типах, свойствах и параметрах конструкторов не нашла
ни одного расхождения. Это сильная сторона текущего кода.

Устаревшее API MapKit во враппер осознанно не переносилось: из 20 методов
`MapObjectCollection`/`ClusterizedPlacemarkCollection`, помеченных в MapKit `@Deprecated`,
не обёрнут ни один — вместо них есть ровно то, на что MapKit и советует переходить
(`addPlacemark()` + `setGeometry()` + `setIcon()`, батч через `ClusterizedPlacemarkCollection`).
Ниже такие члены в пробелы не записаны.

### Покрытие по пакетам (только lite-доступные типы)

| Пакет | Обёрнуто / всего | Комментарий |
|---|---|---|
| `com.yandex.mapkit.logo` | 5 / 5 | закрыт полностью |
| `com.yandex.mapkit.indoor` | 3 / 3 | закрыт полностью |
| `com.yandex.mapkit.user_location` | 8 / 8 | закрыт полностью |
| `com.yandex.mapkit.mapview` | 1 / 1 | тип есть, нет `destroy()` и `isDebugModeEnabled` |
| `com.yandex.mapkit.map` | 40 / 61 | ядро; не хватает Icon/Model/Text/Animation, tile-слоёв, geo-object |
| `com.yandex.mapkit.geometry` | 12 / 18 | нет билдеров и хелперов |
| `com.yandex.mapkit.location` | 7 / 22 | нет `LocationSettings`, симулятора, ошибок |
| `com.yandex.mapkit` | 4 / 33 | нет `GeoObject` и всей его обвязки |
| `com.yandex.runtime.image` | 1 / 4 | нет `AnimatedImageProvider` |
| `com.yandex.mapkit.layers` | 1 / 13 | обёрнут только `ObjectEvent` |
| `com.yandex.mapkit.geometry.geo` | 0 / 6 | `Projection`, `PolylineUtils` |
| `com.yandex.mapkit.traffic` | 0 / 4 | пробки |
| `com.yandex.mapkit.offline_cache` | 0 / 14 | офлайн-кеш |
| `com.yandex.mapkit.storage` | 0 / 4 | управление диском |
| `com.yandex.mapkit.road_events` | 0 / 4 | дорожные события |
| `com.yandex.mapkit.tiles` | 0 / 2 | свои тайлы |
| `com.yandex.mapkit.navigation` | 0 / 5 | `JamStyle`, `RoutePosition` |
| `com.yandex.mapkit.images` | 0 / 2 | `ImageUrlProvider` |
| `com.yandex.mapkit.uri` | 0 / 2 | |
| `com.yandex.mapkit.personalized_poi` | 0 / 2 | |
| `com.yandex.mapkit.ui` | 0 / 1 | `Overlay` |
| `com.yandex.runtime` | 0 / 8 | иерархия `Error` |
| `com.yandex.runtime.network` | 0 / 7 | сетевые ошибки |
| `com.yandex.runtime.i18n` | 0 / 6 | локаль, единицы измерения |
| `com.yandex.runtime.logging` | 0 / 5 | логирование MapKit |
| `com.yandex.runtime.auth` | 0 / 3 | аккаунты |
| `com.yandex.runtime.view` | 0 / 3 | `Surface` |
| `com.yandex.runtime.ui_view` | 0 / 1 | `ViewProvider` |
| `com.yandex.runtime.config` | 0 / 1 | `ExperimentData` |
| `com.yandex.runtime.annotation` | 0 / 1 | внутренняя аннотация, не нужна |

Пакеты, недоступные в lite (покрытие 0 и не планируется, пока проект на lite):
`search` (93), `transport.masstransit` (89), `directions.driving` (66), `places.panorama` (31),
`navigation.automotive*` (62), `transport.bicycle` (20), `address_book` (6),
`road_events_layer` (6), `styling` (8), `search.search_layer` (8), `annotations` (4),
`places*` (5), `maps.recording` (3), `directions` (2), `transport` (2), `transport.time` (1),
`directions.carparks` (1), `navigation.balloons` (4), `navigation.guidance_camera` (3).

---

# Часть A. Дефекты в уже обёрнутом API

Это то, что «покрыто неправильно». Чинить до расширения покрытия.

**Статус: A1–A9 сделаны.** Правки лежат в ветке, `spotlessCheck`, `libraryApiCheck` и
`libraryTests` зелёные, klib-дампы перегенерированы, CHANGELOG обновлён.

## ✅ A1. КРИТИЧНО. iOS: `InputListener` перепутал колбэки местами

[InputListener.ios.kt](yandex-mapkit-kmp/src/iosMain/kotlin/ru/sulgik/mapkit/map/InputListener.ios.kt):

```kotlin
override fun onMapLongTapWithMap(map: NativeMap, point: NativePoint) {
    onMapTap(map.toCommon(), point.toCommon())      // ← вызывается onMapTap
}

override fun onMapTapWithMap(map: NativeMap, point: NativePoint) {
    onMapLongTap(map.toCommon(), point.toCommon())  // ← вызывается onMapLongTap
}
```

На iOS обычный тап приходит в `onMapLongTap`, долгий — в `onMapTap`. На Android
([InputListener.android.kt](yandex-mapkit-kmp/src/androidMain/kotlin/ru/sulgik/mapkit/map/InputListener.android.kt))
всё правильно. Любой кросс-платформенный код с тапами по карте на iOS работает наоборот.

**Что сделать:** поменять тела двух `override` местами; добавить тест-заглушку или хотя бы
проверку в sample.

## ✅ A2. `MapObjectVisitor.onCollectionVisitEnd` объявлен как `-> Boolean`

MapKit: `void onCollectionVisitEnd(MapObjectCollection)`. Враппер
([MapObjectVisitor.kt](yandex-mapkit-kmp/src/commonMain/kotlin/ru/sulgik/mapkit/map/MapObjectVisitor.kt))
требует от лямбды `Boolean`, который затем выбрасывается в обоих `actual`. Пользователь
вынужден писать бессмысленный `true`.

Для сравнения `onClusterizedCollectionVisitEnd` объявлен правильно — `-> Unit`.

**Что сделать:** сменить тип параметра на `(collection: MapObjectCollection) -> Unit`
в `expect` и в обоих `actual`. Это ломающее изменение API — в CHANGELOG.

## ✅ A3. `Location.relativeTimestamp` смоделирован как `Instant`

MapKit: «Relative timestamp, number of milliseconds passed on **steady clock**. Use for interval
calculation» — это показание монотонных часов, то есть длительность, а не момент времени.
Враппер оборачивает его в `kotlin.time.Instant`:

```kotlin
relativeTimestamp = Instant.fromEpochMilliseconds(relativeTimestamp)  // Android
relativeTimestamp = relativeTimestamp.toKotlinInstant()               // iOS
```

На Android это даёт дату вида «2 января 1970», на iOS — своё значение из `NSDate`. Значения
двух платформ не сопоставимы, а `Instant` подталкивает пользователя сравнивать их с реальным
временем.

**Что сделать:** сменить тип на `kotlin.time.Duration` (Android: `.milliseconds`,
iOS: `timeIntervalSinceReferenceDate.seconds` или что даёт нативный `NSDate`), либо оставить
как есть, но задокументировать KDoc-ом, что это монотонные часы. Ломающее изменение API.

## ✅ A4. `Map.mapObjects` отдаёт `MapObjectCollection` вместо `RootMapObjectCollection`

MapKit: `RootMapObjectCollection getMapObjects()`; `RootMapObjectCollection` расширяет
`MapObjectCollection` и добавляет `conflictResolutionMode: ConflictResolutionMode`
(управление приоритетом подписей при наложении). Враппер сужает тип, и настройка недоступна.
То же с `Map.addMapObjectLayer(layerId)`, который тоже возвращает `RootMapObjectCollection`
(и вовсе не обёрнут).

**Что сделать:** добавить `RootMapObjectCollection : MapObjectCollection` и enum
`ConflictResolutionMode` (`MINOR`, `EQUAL`, `MAJOR`, `IGNORE`), сменить тип `Map.mapObjects`.

## ✅ A5. `Cluster` лежит не в том пакете

MapKit: `com.yandex.mapkit.map.Cluster`. Враппер: `ru.sulgik.mapkit.geometry.Cluster`.
Это нарушает обещание «поменяй префикс импорта — и всё компилируется» из
[docs/wrapper/overview.md](docs/wrapper/overview.md). Соседние `ClusterListener`,
`ClusterTapListener`, `ClusterizedPlacemarkCollection` лежат правильно, в `map`.

**Что сделать:** перенести в `ru.sulgik.mapkit.map`, старый пакет не оставлять
(см. «Политика ломающих изменений»).

## ✅ A6. Расхождения в именах с MapKit

Каждое расхождение ломает миграцию «сменить префикс импорта». Ни одно не выглядит намеренным.

| Тип | MapKit (Android и iOS) | Враппер | Комментарий |
|---|---|---|---|
| `MapWindow` | `setMaxFps(int)` | `setMapFps(Int)` | на iOS тоже `setMaxFpsWithFps:` |
| `MapWindow` | `addSizeChangedListener` / `removeSizeChangedListener` | `addSizeChangeListener` / `removeSizeChangeListener` | потеряна буква `d` |
| `MapWindow` | `worldToScreen(Point)` | `convertWorldToScreen(Point)` | |
| `MapWindow` | `screenToWorld(ScreenPoint)` | `convertScreenToWorld(ScreenPoint)` | |
| `Map` | `cameraPosition(Geometry, …)` | `calculateCameraPosition(…)` | конфликта с `val cameraPosition` можно избежать перегрузкой |
| `Map` | `visibleRegion(CameraPosition)` | `calculateVisibleRegion(…)` | то же |
| `Map` | `getLogo()` | `fun getLogo(): Logo` | единственный геттер, оставшийся функцией; ожидается `val logo` |
| `Polygon` | `getInnerRings(): List<LinearRing>` | `val innerRing: List<LinearRing>` | и одноимённый параметр конструктора |
| `Alignment` | `horizontalAlignment` / `verticalAlignment` | `horizontal` / `vertical` | |
| `MapView` | `setNoninteractive(boolean)` | `setNonInteractive(Boolean)` | у MapKit строчная `i` |
| `PolylineMapObject` | `arrows()` | `val arrows` | допустимая котлинизация, но в compose-состоянии оставлено `arrows()` — расходятся между собой |

**Что сделать:** переименовать без переходных алиасов (см. «Политика ломающих изменений»);
`Map.getLogo()` заменить на `val logo`.

## ✅ A7. Файлы в неправильных исходниках и с опечатками

| Файл | Проблема |
|---|---|
| `iosMain/.../location/SubscriptionSettings.android.kt` | iOS-код с суффиксом `.android.kt` |
| `iosMain/.../location/UseInBackground.android.kt` | то же |
| `iosMain/.../map/MapWindow.kt` | нет суффикса платформы |
| `androidMain/.../geometry/PolylinePosition.andoird.kt` | опечатка в `android` |
| `logo/Alignment.{android,ios}.kt` | общий тип называется `LogoAlignment` |
| `logo/Padding.{android,ios}.kt` | общий тип — `LogoPadding` |
| `logo/HorizontalAlignment.{android,ios}.kt`, `VerticalAlignment.{android,ios}.kt` | общие типы — `Logo*Alignment` |

**Что сделать:** переименовать файлы (изменение только в именах файлов, API не трогается).

## ✅ A8. `location.FilteringMode` — мёртвый публичный тип

[FilteringMode.kt](yandex-mapkit-kmp/src/commonMain/kotlin/ru/sulgik/mapkit/location/FilteringMode.kt)
объявляет `public enum class FilteringMode { ON, OFF }`. У него нет:

- аналога в MapKit — ни `com.yandex.mapkit.location.FilteringMode`, ни `YMKLocationFilteringMode`
  в справочнике не существует;
- конвертеров `toNative()`/`toCommon()`;
- ни одной ссылки во всём репозитории, включая sample.

При этом тип попал в klib-дамп и опубликован. **Что сделать:** удалить (ломающее изменение,
но реальных пользователей у типа быть не может) либо, если он задумывался под
`LocationManager`-фильтрацию, дописать применение.

## ✅ A9. Накопленные `@Deprecated` пора удалить

Единственное задепрекейченное во враппере API — 10 свойств `PolylineMapObject`
(`strokeWidth`, `gradientLength`, `outlineWidth`, `outlineColor`, `isInnerOutlineEnabled`,
`turnRadius`, `dashLength`, `gapLength`, `dashOffset`, `arcApproximationStep`), объявленных
в трёх файлах — `commonMain`, `androidMain`, `iosMain`, — итого 30 объявлений с
`ReplaceWith("style.…")`.

MapKit пометил ровно эти же 20 методов (`getX`/`setX`) `@Deprecated` у себя, замена
`style: LineStyle` во враппере есть и работает. Держать их дальше незачем.

**Что сделать:** удалить все 30 объявлений вместе с их реализациями, прогнать
`updateKotlinAbi`.

## Политика ломающих изменений

Библиотека на `library_version=0.4.1`, следующий релиз — **1.0.0**. Накопленный `@Deprecated`
(A9) удаляется, не дожидаясь мажора. Переименования из A5–A6 и правки сигнатур из A2–A3
делаются **сразу и без переходных алиасов** — старые имена просто исчезают. Требование одно:
собрать все ломающие правки в 1.0.0 и описать их в CHANGELOG и в разделе миграции `docs/`.

После 1.0.0 такой возможности не будет — см. следующий раздел.

---

# Релиз 1.0.0

1.0.0 — это обещание совместимости. Всё, что ломает API, должно уехать **в него**, иначе ждать
2.0.0. Полнота покрытия для 1.0 не обязательна: 33 % lite-поверхности — нормально, если то,
что обёрнуто, обёрнуто правильно и не придётся переделывать. Ниже — что обязано попасть,
что можно спокойно добавлять в 1.x, и какие решения после 1.0.0 не переиграть.

## Блокеры 1.0.0 — ломающие правки

Из части A: **A1** (баг iOS), **A2**, **A3**, **A5**, **A6**, **A8**, **A9**.
A7 (имена файлов) API не трогает, но делать удобно тем же заходом.

Плюс то, что в плане стояло на поздних этапах, а на деле ломающее и потому обязано в 1.0.0:

1. **A4 — `Map.mapObjects: MapObjectCollection` → `RootMapObjectCollection`.** В плане это был
   этап 6; смена типа возвращаемого значения — ломающая, после 1.0 не сделать. Тянет за собой
   `RootMapObjectCollection` и enum `ConflictResolutionMode`. То же с
   `Map.addMapObjectLayer(layerId)`, который тоже возвращает `RootMapObjectCollection`.
2. **`Map.calculateCameraPosition` — привести сигнатуры к MapKit.** Сейчас
   `calculateCameraPosition(geometry, azimuth, tilt, screenRect)` требует все аргументы и не
   принимает `null`, у MapKit `azimuth`/`tilt`/`focusRect` необязательные. Замена сигнатуры —
   ломающая, вместе с переименованием в `cameraPosition` (A6) должна ехать в 1.0.0.
3. **`ImageProvider` — решить, что в общем интерфейсе.** Сейчас
   `public expect interface ImageProvider` пустой, у MapKit есть `id`, `image`, `isCacheable`.
   Интерфейс публичный и реализуемый снаружи — добавление любого члена после 1.0.0 сломает
   все пользовательские реализации. Решать **до** 1.0.0: либо добавить `id`/`isCacheable` в
   общий контракт, либо сознательно оставить маркером и записать это в документацию.
4. **`IndoorPlan` — то же самое.** Обычный `public interface` в `commonMain` с приватными
   реализациями на платформах; пользователь может его реализовать, добавление члена потом
   ломающее.
5. **Compose: `PolylineState.arrows()` → `val arrows`** — чтобы совпадало с `PolylineMapObject`
   враппера (A6). Ломающая.
6. **Compose: дозаполнить `MapConfig` и `UserLocationConfig`.** Это `data class`-ы; каждое
   новое поле после 1.0.0 — бинарно ломающее (меняются `copy$default` и `componentN`).
   Дешевле добавить всё нужное сразу: `mode`, `isHdModeEnabled`, `isIndoorEnabled`,
   `isAwesomeModelsEnabled`, `isTransparentBackgroundEnabled`, `isBuildingsAboveIndoorEnabled`,
   JSON-стиль, `cameraBounds`, `focusRect`, `pointOfView`, `gestureFocusPoint(Mode)`,
   `scaleFactor`.
7. **Решить судьбу `@YandexMapsComposeExperimentalApi`.** Под ним сейчас: перегрузка
   `YandexMap` с `YandexMapController`, весь `ComposeMapObjectRenderer` +
   `rememberComposeMapObjectRenderer` + `ComposeMapObjectRendererHost`, четыре перегрузки
   `Clustering`, `Placemark` с composable-контентом, `imageProvider {}`,
   `clusterImageProvider {}`, `ClusterImageProvider`, **вся `UserLocationConfig`**. Это
   заметная часть публичного compose-API. К 1.0.0 нужно явно сказать по каждому: стабилизируем
   (снимаем аннотацию и берём на себя совместимость) или оставляем экспериментальным.
   Отдельно неприятно, что `UserLocationConfig` экспериментальна целиком, а `YandexMap`
   с user location — нет.

## Что можно спокойно добавлять после 1.0.0

Аддитивно и мажора не требует: новые типы и подсистемы целиком (пробки, офлайн-кеш, storage,
слои и тайлы, geo-объекты, иконки/`Icon`/`Model`/`PlacemarkText`/`PlacemarkAnimation`,
`LocationSettings`, симулятор, `geometry.geo`, логирование, i18n), новые методы у существующих
`expect class`-ов (`Map.isTransparentBackgroundEnabled`, `MapObject.setVisible(…, Animation)`,
`MapView.destroy()`, `PlacemarkMapObject.setIconStyle`, `isValid`, `Geometry.fromXxx`), новые
composable и состояния.

То есть этапы 2–8 плана, кроме перечисленных выше пунктов, 1.0.0 не блокируют.

## Решения, которые после 1.0.0 не переиграть

### Value-типы — `data class`, а MapKit дописывает поля

`IconStyle`, `TextStyle`, `LineStyle`, `Location`, `CameraPosition`, `SubscriptionSettings`,
`LogoAlignment`, `MapConfig` и остальные — `data class`, конструкторы которых повторяют
структуры MapKit. MapKit эти структуры расширяет: в 4.42 приехало `IconStyle.opacity`.
Каждое такое поле — новый параметр конструктора, то есть изменение `copy$default`,
`componentN` и сигнатуры конструктора: **совместимость исходников сохраняется (параметр в
конец, с дефолтом), бинарная — нет.**

Значит, обещать в 1.x бинарную совместимость и одновременно следовать за MapKit нельзя.
Нужно выбрать и записать в README/`docs`:

- **(рекомендуется)** гарантировать совместимость **исходников** в пределах 1.x, бинарную — нет;
  явно предупредить, что при обновлении MapKit требуется пересборка зависимых модулей;
- либо отказаться от `data class` в пользу конструкторов с дефолтами + ручных `copy`
  (дорого, теряется `componentN` и удобство);
- либо замораживать поверхность и отставать от MapKit (не вариант для обёртки).

### Enum-константы

`MapMode`, `MapType`, `LocationPurpose`, `CameraUpdateReason` и прочие повторяют enum-ы MapKit,
а те растут: в 4.42 добавились `MapMode.HYBRID` и `LocationPurpose.STATIC_DISPLAY_LOCATION`.
Новая константа ломает исчерпывающий `when` в пользовательском коде на этапе компиляции.
Это неизбежно; надо один раз проговорить в документации, что enum-ы следуют за MapKit и
`when` по ним лучше писать с `else`.

### Листенеры — `expect abstract class` с абстрактными методами

Добавление метода в `InputListener`, `CameraListener` и прочие — ломающее для наследников.
Пока MapKit свои интерфейсы не расширял, но если это случится, в 1.x метод придётся давать
с реализацией по умолчанию (`open fun … {}`), а не абстрактным. Стоит решить заранее и
зафиксировать в `.claude/skills/ymk-wrapper-api`, чтобы не пришлось выбирать в спешке.

## Инфраструктура, которую 1.0.0 требует

### ✅ ABI Android-таргета не проверяется — закрыто

`checkKotlinAbi` работает по klib-дампам (`commonMain` + `iosMain`); Android-таргет
`com.android.kotlin.multiplatform.library` валидатором **не покрыт** — в `<module>/api` лежат
только `*.klib.api`. То есть Android-часть публичного API 1.0.0 ничем не защищена от случайной
поломки. Под обещание совместимости это надо закрыть: подключить дамп Android-поверхности
(binary-compatibility-validator для JVM/Android-таргета) и добавить его в `api-check` в CI.

Что именно сейчас не проверяется (Android-only публичное API):

- `ru.sulgik.mapkit.map.AndroidImageProvider`;
- `ImageProvider.Companion.fromBitmap` ×2, `.fromAsset` ×2, `.fromResource` ×2, `.fromFile` ×2;
- `Bitmap.toImageProvider()` ×2;
- `MapKit.Companion.initialize(Context)` — точка входа, которой нет в общем API;
- Android-актуалы `MapView`, `MapWindow` и все `toNative()`/`toCommon()` в `androidMain`.

**Сделано:** встроенный валидатор Kotlin 2.4.10 этот таргет не видит в принципе — для
`androidJvm` он ищет компиляцию `release`, а плагин `com.android.kotlin.multiplatform.library`
создаёт только `main`, поэтому JVM-дамп не генерируется ни через `updateKotlinAbi`, ни через
`updateLegacyAbi`. Вместо него в корневом `build.gradle.kts` добавлены задачи `dumpAndroidAbi`,
`checkAndroidAbi` и `updateAndroidAbi`: они прогоняют `javap -public` по классам Android-компиляции
и пишут `api/<module>.android.api`. Обе пары подключены к `libraryApiCheck` и `libraryApiDump`,
которые уже вызывает CI. Дамп чувствителен к версии JDK — генерировать той же, что в CI.

### ✅ `-moko` и `-moko-compose` без explicit API — закрыто

Оба модуля собираются с `-Xexplicit-api=strict` и попадают в Android-дамп.

### Отдельно: сборка iOS-фреймворка падает

`./gradlew :yandex-mapkit-kmp:linkPodDebugFrameworkIosArm64` роняет компилятор Kotlin/Native
(`NullPointerException` в `ObjCExportCodeGenerator.createFinalMethodAdapter`). Проверено на
чистом `main` (3e405c6) — воспроизводится там же, к правкам аудита отношения не имеет. CI это
не ловит: iOS-джоба выполняет только `libraryCompileIosArm64` и `libraryIosTests`, то есть klib,
а не линковку фреймворка. Требует отдельного разбора до релиза, иначе iOS-сэмпл не соберётся.

### Мелочи, которые дешевле поправить до 1.0.0

- `NativeConvertible<T>` объявлен дважды — отдельно в `androidMain` и `iosMain`, идентичным
  кодом, без `commonMain`-версии. Интерфейс не зависит от платформы и мог бы жить в
  `commonMain`; тогда общий код смог бы на него ссылаться. Сейчас — не может.
- Приватные реализации `IndoorPlan` на обеих платформах называются `DeletingIndoorLevel` —
  очевидная копипаста, к плану не относится, но глаза мозолит в двух файлах.

---

# Часть B. Пропущенные члены в уже обёрнутых типах

55 функциональных пробелов; расхождения в именах вынесены в A6, устаревшее в MapKit API
здесь не считается пробелом. Отсортировано по важности.

## `map.Map` — 12 членов

- `boolean isTransparentBackgroundEnabled()` / `void setTransparentBackgroundEnabled(boolean)`
  — прозрачный фон карты (4.41).
- `boolean isBuildingsAboveIndoorEnabled()` / `void setBuildingsAboveIndoorEnabled(boolean)`
  — здания поверх indoor-плана.
- `void addTapListener(WeakReference<GeoObjectTapListener>)` /
  `void removeTapListener(WeakReference<GeoObjectTapListener>)` — тап по объекту базовой карты
  (POI, дом, топоним). Требует `layers.GeoObjectTapListener`, `layers.GeoObjectTapEvent`,
  `mapkit.GeoObject` — см. часть C.
- `void selectGeoObject(GeoObjectSelectionMetadata)` / `void deselectGeoObject()` — подсветка
  выбранного объекта карты. Требует `map.GeoObjectSelectionMetadata`.
- `void setMapLoadedListener(WeakReference<MapLoadedListener>)` — событие «карта отрисована».
  Требует `map.MapLoadedListener` и `map.MapLoadStatistics`.
- `RootMapObjectCollection addMapObjectLayer(String layerId)` — своя коллекция объектов на
  указанном слое (используется вместе с `LayerIds`, который уже обёрнут).
- `Projection projection()` — проекция карты. Требует `geometry.geo.Projection`.
- `Layer addTileLayer(String, LayerOptions, CreateTileDataSource)` — свои тайловые слои.
  Требует весь `layers`-пакет.
- Перегрузки `cameraPosition(Geometry, ScreenRect?, Float? azimuth)` и
  `cameraPosition(Geometry, ScreenRect?, Float? azimuth, Float? tilt)`: у MapKit `azimuth` и
  `tilt` необязательные (`null` = оставить текущее), у враппера
  `calculateCameraPosition(geometry, azimuth, tilt, screenRect)` требует оба и не принимает
  `null`, а `screenRect` не может быть `null`.

## `MapKit` — 12 членов

- `void setAccount(Account?)` — аккаунт пользователя; требует `runtime.auth`.
- `void onTerminate()` — парный к `onStart`/`onStop`.
- `boolean isValid()`.
- `LocationSimulator createLocationSimulator()` / `createLocationSimulator(Polyline)` —
  симулятор геопозиции, крайне полезен для отладки и тестов.
- `DummyLocationManager createDummyLocationManager()`.
- `OffscreenMapWindow createOffscreenMapWindow(int, int)` /
  `createOffscreenMapWindow(int, int, float)` — рендер карты в буфер без вью.
- `TrafficLayer createTrafficLayer(MapWindow)` — пробки.
- `RoadEventsManager createRoadEventsManager()` — дорожные события.
- `OfflineCacheManager getOfflineCacheManager()` — офлайн-карты.
- `StorageManager getStorageManager()` — управление местом на диске.

`MapKitFactory` отдельным типом не обёрнут намеренно — его методы живут в
`MapKit.Companion` (`setApiKey`, `setLocale`, `setUserId`, `getInstance` и Android-only
`initialize`). Из фабрики не покрыт только `initializeBackgroundDownload`, и тот принимает
внутренний тип `offline_cache.internal.BackgroundDownloadInitializer` — обёртывать вместе с
офлайн-кешем или не обёртывать вовсе.

## `map.PlacemarkMapObject` — 10 членов

- `void setIconStyle(IconStyle)` — сменить только стиль, не трогая картинку.
- `Icon useIcon()` — обёртка над иконкой; требует `map.Icon`.
- `CompositeIcon useCompositeIcon()` — составные иконки; требует `map.CompositeIcon`.
- `Model useModel()` — 3D-модель плейсмарка; требует `map.Model`, `map.ModelStyle`.
- `PlacemarkAnimation useAnimation()` — анимация плейсмарка; требует `map.PlacemarkAnimation`.
- `PlacemarkText getText()` — доступ к тексту как к объекту; требует `map.PlacemarkText`.
- `void setScaleFunction(List<PointF>)` — кусочно-линейный масштаб от зума (у
  `PlacemarksStyler` этот метод обёрнут, у самого плейсмарка — нет).
- `setView(ViewProvider[, IconStyle][, Callback])` ×4 — иконка из нативной вью; требует
  `runtime.ui_view.ViewProvider`. В KMP это Android-специфично; в compose-модуле роль закрывает
  `imageProvider { }`, но у самого враппера аналога нет.

## `map.MapObject` — 2 перегрузки

- `void setVisible(boolean, Animation)` и `void setVisible(boolean, Animation, Callback)` —
  анимированное появление/скрытие объекта. Сейчас только `var isVisible`.

## `map.MapObjectCollection` и `map.ClusterizedPlacemarkCollection` — пробелов нет

Разбор показал, что все «недостающие» здесь методы в MapKit уже устарели:
`addEmptyPlacemark(Point)`, `addEmptyPlacemarks(List<Point>)`,
`addPlacemarks(List<Point>, ImageProvider, IconStyle)`, а также перегрузки
`addPlacemark(Point[, ImageProvider|ViewProvider|AnimatedImageProvider][, IconStyle])`
и `addPolyline()` без аргументов. Рекомендация MapKit — `addPlacemark()` + `setGeometry(point)`
+ `setIcon(image, style)`, а для больших объёмов — `ClusterizedPlacemarkCollection`; ровно это
во враппере и есть. Батчевые `addEmptyPlacemarks`/`addPlacemarks` на `ClusterizedPlacemarkCollection`
не устарели и обёрнуты.

**Действий не требуется.**

## `map.MapWindow` — 3 члена (помимо переименований из A6)

- `Overlay addRasterScreenOverlay()` — растровый оверлей поверх карты; требует `mapkit.ui.Overlay`.
- `void addSurface(Surface)` / `void removeSurface(Surface)` — рендер в дополнительный
  `Surface`; требует `runtime.view.Surface` (Android-специфично).

## `mapview.MapView` — 3 члена

- `void destroy()` — явное освобождение нативных ресурсов. Важно для compose-обвязки:
  сейчас `YandexMap` при уходе из композиции его не зовёт.
- `boolean isDebugModeEnabled()`.
- `setNoninteractive` — см. A6 (имя).

## `geometry.Geometry` — 6 фабрик

`fromPoint`, `fromPolyline`, `fromPolygon`, `fromMultiPolygon`, `fromBoundingBox`, `fromCircle`.
Во враппере их роль играют расширения `Point.toGeometry()` и т. д. — функционально эквивалентно,
но имена не совпадают с MapKit. Стоит добавить одноимённые фабрики в `companion object`.

## `map.ImageProvider` — 3 члена общего API

- `String getId()`, `Bitmap getImage()`, `boolean isCacheable()` — общий `expect interface
  ImageProvider` пустой, это чистый маркер. `id` можно вынести в общий API (строка), `image` —
  платформенный.
- Фабрики `fromBitmap`/`fromAsset`/`fromResource`/`fromFile` есть **только в androidMain**
  как расширения `ImageProvider.Companion`; на iOS только `fromUIImage`. Общего способа создать
  `ImageProvider` из ресурса нет — закрывается модулями `-moko` и `-compose`.

## `isValid` — 5 типов

`MapKit`, `Arrow`, `CameraBounds`, `Cluster`, `layers.ObjectEvent` — у остальных handle-типов
(`Map`, `MapWindow`, `MapObject`, `Logo`, `PlacemarksStyler`, `UserLocationLayer`,
`UserLocationView`) `isValid` обёрнут. Стоит довести до единообразия.

## `logo.Alignment`, `geometry.Polygon`

См. A6 — члены есть, отличаются имена.

---

# Часть C. Необёрнутые типы в уже затронутых пакетах

Полный перечень с членами — в приложении. Здесь — что это даёт и что тянет за собой.

## `com.yandex.mapkit.map` — 21 тип

**Иконки и содержимое плейсмарка** (нужны для части B по `PlacemarkMapObject`):
`Icon`, `CompositeIcon`, `PlacemarkPresentation`, `PlacemarkText`, `PlacemarkAnimation`,
`Model`, `ModelStyle` + вложенные `ModelStyle.RenderMode`, `ModelStyle.UnitType`.

**Geo-объекты базовой карты:** `GeoObjectSelectionMetadata`, `GeoObjectInspectionMetadata`
(+ `ObjectType`), `GeoObjectTags`.

**Загрузка карты:** `MapLoadedListener`, `MapLoadStatistics`.

**Тайловые слои:** `CreateTileDataSource`, `BaseDataSourceBuilder`, `TileDataSourceBuilder`.

**Коллекции:** `RootMapObjectCollection` (см. A4).

**Прочее:** `OffscreenMapWindow`, `VisibleRegionUtils` (утилиты `toPolygon`, `toBoundingBox`).

## `com.yandex.mapkit.layers` — 12 типов

`GeoObjectTapListener`, `GeoObjectTapEvent` — нужны для `Map.addTapListener`.
`Layer`, `LayerOptions`, `OverzoomMode`, `TileFormat`, `BaseDataSource`, `DataSource`,
`TileDataSource`, `DataSourceLayer`, `DataSourceListener`, `LayerLoadedListener` —
пользовательские слои и свои тайлы.

## `com.yandex.mapkit.location` — 15 типов

`LocationSettings` + `LocationSettingsFactory` — тонкая настройка провайдера (точность,
интервалы, heading, speed). `LocationSimulator`, `LocationSimulatorListener`,
`SimulationSettings` — симуляция маршрута. `LocationError`, `LocationUnavailableError` —
типизированные ошибки. `DummyLocationManager`, `DummyLocationQuality`,
`LocationManagerUtils`, `LocationViewSourceFactory`, `Range`, `TimeInterval`, `ViewArea`.

Отдельно: enum `Purpose` во враппере назван `LocationPurpose` — это осознанное переименование
(во избежание слишком общего имени), но его стоит зафиксировать в документации миграции.

## `com.yandex.mapkit.geometry` + `geometry.geo` — 12 типов

`PolylineBuilder` + `PolylineBuilderFactory`, `SubpolylineHelper`, `BoundingBoxHelper`,
`Direction`, `Span`; `Projection`, `Projections`, `XYPoint`, `PolylineIndex`, `PolylineUtils`,
`Priority`. `Projection` нужен для `Map.projection()`.

## `com.yandex.mapkit` — 29 типов

Ядро моделей данных, которое тянется за geo-object API: `GeoObject`, `GeoObjectCollection`
(+ `Item`), `BaseMetadata`, `Attribution` (+ `Author`, `Link`), `Image`, `ImageSize`,
`SpannableString` (+ `Span`), `LocalizedValue`, `Money`, `Time`, `Version`, `UserData`,
`RequestPoint` + `RequestPointType`, `ZoomRange`, `RawTile` + `TileId`, `Size2u`,
`ConflictResolutionMode` (нужен для A4), `MapKitFactory`.

## `com.yandex.runtime.image` — 3 типа

`AnimatedImageProvider`, `AnimatedImage`, `Frame` — анимированные иконки и паттерны полигонов
(`PolygonMapObject.setPattern(AnimatedImageProvider, float)` без них недоступен).

---

# Часть D. Полностью необёрнутые подсистемы (доступны в lite)

| Подсистема | Типы | Зачем |
|---|---|---|
| Пробки | `traffic`: `TrafficLayer`, `TrafficListener`, `TrafficLevel`, `TrafficColor` | слой пробок, самая частая просьба после базовой карты |
| Офлайн-кеш | `offline_cache`: 14 типов во главе с `OfflineCacheManager`, `Region`, `RegionState`, 8 листенеров | скачивание регионов |
| Хранилище | `storage`: `StorageManager`, `ClearListener`, `SizeListener`, `StorageErrorListener` | очистка кеша, лимиты |
| Дорожные события | `road_events`: `RoadEventsManager`, `EventInfoSession`, `EventInfoListener`, `EventTag` | ДТП, камеры (сам слой — Full) |
| Свои тайлы | `tiles`: `TileProvider`, `UrlProvider` + `layers` | свои растровые/векторные слои |
| Логирование | `runtime.logging`: `Logging`, `LoggingFactory`, `LogListener`, `LogMessage`, `LogLevel` | диагностика у пользователей SDK |
| Ошибки | `runtime`: `Error`, `LocalError`, `DiskFullError`, `DiskCorruptError`, `DiskWriteAccessError`, `KeyValuePair`, `TypeDictionary`, `DataProviderWithId`; `runtime.network`: `NetworkError`, `RemoteError`, `BadRequestError`, `ForbiddenError`, `NotFoundError`, `UnauthorizedError`, `RequestEntityTooLargeError` | сейчас у враппера нет ни одного типа ошибок MapKit |
| Локализация | `runtime.i18n`: `I18nManager`, `I18nManagerFactory`, `I18nPrefs`, `SystemOfMeasurement`, `TimeFormat`, `CanonicalUnit` | единицы измерения и формат времени |
| Аккаунты | `runtime.auth`: `Account`, `TokenListener`, `PasswordRequiredData` | нужно только для персонализации |
| Вью и оверлеи | `runtime.ui_view.ViewProvider`, `runtime.view.Surface`/`SurfaceFactory`/`BufferedRunnable`, `mapkit.ui.Overlay` | платформенные, обёртка нужна частично |
| Прочее | `uri`: `Uri`, `UriObjectMetadata`; `personalized_poi`; `runtime.config.ExperimentData`; `navigation`: `JamSegment`, `JamStyle`, `JamType`, `JamTypeColor`, `RoutePosition` | точечно |

---

# Часть E. Недоступно в lite-сборке

Эти 414 типов физически отсутствуют в `4.42.0-lite`. Обернуть их можно только вместе с
переходом на Full MapKit / NaviKit, что меняет лицензирование и размер артефакта.

- **Full MapKit (328 типов):** поиск и саджест (`search`, 93 типа), маршруты
  (`directions.driving` 66, `transport.masstransit` 89, `transport.bicycle` 20), панорамы
  (`places.panorama` 31), слой поиска (`search.search_layer` 8), слой дорожных событий
  (`road_events_layer` 6), аннотации (`annotations` 4), `places`, `places.mrc`, `directions`,
  `transport`, `transport.time`, `directions.carparks`.
- **NaviKit (86 типов):** `navigation.automotive*` (62), `styling` (8), `address_book` (6),
  `navigation.balloons` (4), `navigation.guidance_camera` (3), `maps.recording` (3).

Решение по ним — продуктовое, а не техническое. В README стоит явно написать, что враппер
рассчитан на lite-сборку.

---

# Часть F. Compose-модуль

Обёрнуто: `YandexMap` (3 перегрузки), `Placemark`, `TitledPlacemark`, `Polyline`, `Polygon`,
`Circle`, `Clustering` (6 перегрузок), user location, `MapEffect`, `MapControllerEffect`,
`imageProvider { }`, `clusterImageProvider { }`, `rememberMapKit`, `bindToLifecycleOwner`.

Не проброшено:

- **`MapConfig`** — есть `isNightModeEnabled`, `poiLimit`, четыре флага жестов, `isFastTapEnabled`,
  `mapType`, `use2dMode`, `logo`, `fps`. Нет: `mode: MapMode`, `isHdModeEnabled`,
  `isIndoorEnabled`, `isAwesomeModelsEnabled`, `isTransparentBackgroundEnabled` (A2 бэклога),
  `isBuildingsAboveIndoorEnabled`, JSON-стиль (`setMapStyle`/`resetMapStyles`),
  `cameraBounds` (min/max zoom, `latLngBounds`), `focusRect`, `pointOfView`,
  `gestureFocusPoint`/`gestureFocusPointMode`, `scaleFactor`.
- **Слушатели карты** — нет composable/`MapConfig`-хуков для `InputListener` (тап по карте),
  `GeoObjectTapListener`, `MapLoadedListener`, `IndoorStateListener`,
  `MapObjectCollectionListener`, `SizeChangedListener`. Всё это сейчас доступно только через
  `MapEffect`.
- **Объекты карты** — нет `MapObjectCollection` как вложенного composable (группировка,
  общий `zIndex`, `traverse`), нет доступа к `PlacemarksStyler`.
- **Состояния** — `PlacemarkState` не даёт `opacity`, `zIndex`, `isVisible`, `userData`;
  `CircleState`/`PolygonState` не дают ничего кроме `geometry`; `PolylineState` — единственное
  полноценное. Метод `PolylineState.arrows()` — функция, а во враппере `val arrows` (см. A6).
- **Жизненный цикл** — `MapView.destroy()` не вызывается при уходе `YandexMap` из композиции.
- **Пробки/слои** — как только появятся `TrafficLayer` и tile-слои, для них нужны composable.

---

# План работ

Порядок выбран так, чтобы каждый этап был самостоятельно полезен и не блокировался следующим.

### Этап 1 — В РЕЛИЗ 1.0.0. Всё ломающее, одним заходом — ✅ СДЕЛАНО

После 1.0.0 ничего из этого сделать нельзя до 2.0.0. Переходных алиасов не оставляем.

1. ✅ A1 — iOS `InputListener`, поменять тела колбэков. **Багфикс, срочно.**
2. ✅ A9 — удалить 30 объявлений `@Deprecated`-свойств `PolylineMapObject` в трёх исходниках.
3. ✅ A8 — удалить `location.FilteringMode`.
4. ✅ A7 — переименовать 7 файлов.
5. ✅ A6 — переименования (`setMaxFps`, `addSizeChangedListener`/`removeSizeChangedListener`,
   `worldToScreen`/`screenToWorld`, `setNoninteractive`, `innerRings`,
   `horizontalAlignment`/`verticalAlignment`, `val logo`, `cameraPosition`/`visibleRegion`).
   Заодно `PolylineState.arrows()` → `val arrows` из части F.
6. ✅ A2 — `MapObjectVisitor.onCollectionVisitEnd` → `Unit`.
7. ✅ A3 — `Location.relativeTimestamp` → `Duration`.
8. ✅ A5 — перенос `Cluster` в `ru.sulgik.mapkit.map`.
9. ✅ A4 — `RootMapObjectCollection` + `ConflictResolutionMode`, сменить тип `Map.mapObjects`.
   `MapObjectCollection` стал `open`, `NativeMapObjectCollection.toCommon()` диспетчеризует.
10. ✅ `Map.cameraPosition(…)` с необязательными `azimuth`/`tilt`/`focusRect` вместо нынешней
    сигнатуры с обязательными. Три перегрузки схлопнуты в одну функцию с дефолтами.
11. ✅ Состав `ImageProvider` и `IndoorPlan` зафиксирован. `ImageProvider` остаётся маркером:
    `id` и `isCacheable` есть только у Android-версии MapKit, на iOS SDK принимает голый `UIImage`,
    так что в общем контракте им взяться неоткуда — решение записано KDoc-ом на `expect` и на обоих
    `actual`. `IndoorPlan` переведён с общего `interface` на handle-тип (`expect class` +
    `internal constructor`), поэтому снаружи он больше не реализуется и расширять его можно
    свободно; заодно ушли приватные `DeletingIndoorLevel`.
12. ✅ Compose: `PolylineState.arrows()` → `val arrows`; `MapConfig` дозаполнен (плюс
    `MapCameraBoundsConfig` и два новых свойства `Map`); по `@YandexMapsComposeExperimentalApi`
    решение принято — user location (`UserLocationConfig` со вложенными типами и перегрузка
    `YandexMap` с `UserLocationState`) стабилизирован, compose-рендеринг иконок остаётся
    экспериментальным.
13. ✅ Инфраструктура: `dumpAndroidAbi`/`checkAndroidAbi`/`updateAndroidAbi` в корневом
    `build.gradle.kts` снимают `javap -public` с Android-компиляции в `api/<module>.android.api`
    и подключены к `libraryApiCheck`/`libraryApiDump`; explicit API включён в обоих `-moko`;
    `NativeConvertible` переехал в `commonMain`.
14. ✅ Политика совместимости (исходники — да, ABI — нет, рост enum-ов) записана в README,
    `docs/getting-started/contributing.md` и CLAUDE.md.
15. ✅ `isValid` у `MapKit`, `Arrow`, `CameraBounds`, `Cluster`, `ObjectEvent`.

Выхлоп: `updateKotlinAbi`, CHANGELOG, раздел «миграция» в docs.

### Этапы 2–8 — ✅ СДЕЛАНО

Изначально планировались после 1.0.0, реализованы до релиза. Всё аддитивно, мажора не требует.

Что сознательно не обёрнуто и почему:

- **API полной сборки.** `MapKit.setAccount`, `MapKit.createOffscreenMapWindow`,
  `MapKit.createRoadEventsManager`, поиск, маршрутизация, панорамы. В `4.42.0-lite` этих методов нет
  у самого `MapKit` (проверено по `javap` над AAR), поэтому `runtime.auth`, `map.OffscreenMapWindow`
  и `road_events` недостижимы и не обёрнуты.
- **`ViewProvider`** (`runtime.ui_view`) и завязанные на него `Icon.setView`,
  `PlacemarkMapObject.setView`, `Overlay.setView`, `MapWindow.addSurface`/`removeSurface`. Общей
  формы у `android.view.View` и `UIView` нет; в compose-модуле ту же задачу решает `imageProvider { }`.
- **`runtime.TypeDictionary`.** Контейнер метаданных `GeoObject` ключуется нативными классами.
  Вместо него у `GeoObject` типизированные аксессоры `selectionMetadata`, `inspectionMetadata`,
  `tags`.
- **`mapkit.Money`, `RequestPoint`, `RequestPointType`, `GeoObjectListener`, `GeoObjectSession`** —
  типы поисково-маршрутного API, в lite-биндингах отсутствуют.
- **`map.BaseDataSourceBuilder` и `mapkit.images`** (`ImageUrlProvider`, `ImageDataDescriptor`,
  `DefaultImageUrlProvider`). Типы в lite есть, но ни один публичный метод их не отдаёт: у `Map`
  только `addTileLayer` с `TileDataSourceBuilder`. Недостижимы, как и `OffscreenMapWindow`.
- **`mapkit.navigation`** (`JamSegment`, `JamStyle`, `JamType`, `JamTypeColor`, `RoutePosition`) —
  приходят только вместе с маршрутами, которых в lite нет.
- **`runtime.KeyValuePair`, `runtime.config.ExperimentData`, `runtime.annotation`,
  `runtime.view.*`** — служебные и платформенные типы рантайма, в публичном API враппера им нечего
  делать.
- **`offline_cache.DownloadNotificationsListener`** — работает только вместе с
  `MapKitFactory.initializeBackgroundDownload`, который принимает internal-тип.
- **`MapObjectCollection` как вложенный composable** и доступ к `PlacemarksStyler` из compose —
  это дизайн compose-API, а не покрытие MapKit; вынесено за рамки аудита.

### ✅ Этап 2. Дыры в ядре, ничего не тянущие за собой

16. `MapObject.setVisible(Boolean, Animation[, Callback])`.
17. `Map`: `isTransparentBackgroundEnabled`, `isBuildingsAboveIndoorEnabled`,
    перегрузки `cameraPosition` с необязательными azimuth/tilt.
18. `MapKit.onTerminate()`.
19. `MapView.destroy()` + вызов из compose при `onRemoved`.
20. `PlacemarkMapObject.setIconStyle`, `setScaleFunction`.
21. `Geometry.fromXxx` фабрики.

### ✅ Этап 3. Иконки и содержимое плейсмарка

22. `map.PlacemarkPresentation`, `Icon`, `CompositeIcon`, `PlacemarkText` +
    `PlacemarkMapObject.useIcon/useCompositeIcon/getText`.
23. `map.PlacemarkAnimation` + `useAnimation`.
24. `runtime.image.AnimatedImageProvider`, `AnimatedImage`, `Frame` +
    `PolygonMapObject.setPattern(AnimatedImageProvider, Float)`.
25. `map.Model`, `ModelStyle` (+ `RenderMode`, `UnitType`) + `useModel`.
26. Compose: параметры иконки/текста в `PlacemarkState`.

### ✅ Этап 4. Geo-объекты базовой карты

27. `mapkit.GeoObject` и минимальная обвязка: `GeoObjectCollection`, `Item`, `BaseMetadata`,
    `Attribution`, `Image`, `SpannableString`, `LocalizedValue`, `Time`, `UserData`.
28. `layers.GeoObjectTapEvent`, `layers.GeoObjectTapListener` + `Map.addTapListener`.
29. `map.GeoObjectSelectionMetadata` + `Map.selectGeoObject`/`deselectGeoObject`.
30. `map.MapLoadedListener`, `MapLoadStatistics` + `Map.setMapLoadedListener`.
31. Compose: `onGeoObjectTap`, `onMapLoaded` в `MapConfig` либо отдельными composable.

### ✅ Этап 5. Пробки и хранилище — самые запрашиваемые подсистемы

32. `traffic`: `TrafficLayer`, `TrafficListener`, `TrafficLevel`, `TrafficColor` +
    `MapKit.createTrafficLayer`. Compose: `TrafficLayer()` composable.
33. `storage`: `StorageManager` + листенеры, `MapKit.getStorageManager`.
34. `runtime`/`runtime.network`: иерархия `Error` — нужна всем листенерам этого этапа.
35. `offline_cache`: `OfflineCacheManager`, `Region`, `RegionState` + листенеры.

### ✅ Этап 6. Слои и тайлы

36. `layers`: `Layer`, `LayerOptions`, `OverzoomMode`, `TileFormat`, `BaseDataSource`,
    `DataSource`, `TileDataSource`, `DataSourceLayer`, `DataSourceListener`,
    `LayerLoadedListener`.
37. `map.CreateTileDataSource`, `BaseDataSourceBuilder`, `TileDataSourceBuilder`,
    `tiles.TileProvider`, `tiles.UrlProvider`, `mapkit.RawTile`, `TileId`, `ZoomRange`.
38. `Map.addTileLayer`, `Map.addMapObjectLayer`, `RootMapObjectCollection`,
    `ConflictResolutionMode` (A4).

### ✅ Этап 7. Геолокация целиком

39. `location.LocationSettings` + `LocationSettingsFactory`, `Range`, `TimeInterval`, `ViewArea`.
40. `location.LocationSimulator`, `SimulationSettings`, `LocationSimulatorListener` +
    `MapKit.createLocationSimulator`.
41. `location.LocationError`, `LocationUnavailableError`, `DummyLocationManager`,
    `DummyLocationQuality`, `LocationManagerUtils`, `LocationViewSourceFactory`.

### ✅ Этап 8. Долги и мелочи

42. `geometry`: `PolylineBuilder(+Factory)`, `SubpolylineHelper`, `BoundingBoxHelper`,
    `Direction`, `Span`; `geometry.geo`: `Projection`, `Projections`, `XYPoint`,
    `PolylineIndex`, `PolylineUtils`, `Priority` + `Map.projection()`.
43. `runtime.logging` — подписка на логи MapKit.
44. `runtime.i18n` — единицы измерения и формат времени.
45. `mapkit.ui.Overlay` + `MapWindow.addRasterScreenOverlay`.
46. ~~`MapKit.createOffscreenMapWindow` + `map.OffscreenMapWindow`~~ — в lite метода нет.
47. ~~`runtime.auth`~~ — в lite у `MapKit` нет `setAccount`, обёртка недостижима.

Сверх плана обёрнуты метаданные `GeoObject`, до которых план не дошёл: `uri.Uri`,
`uri.UriObjectMetadata` и `personalized_poi.PersonalizedPoiExtraMetadata` (+ `Entry`) —
они реализуют `BaseMetadata`, поэтому доступны через `GeoObject.uriMetadata` и
`GeoObject.personalizedPoiMetadata`.

Из части F (compose) сознательно не сделаны `MapObjectCollection` как вложенный composable и
доступ к `PlacemarksStyler`: это дизайн compose-API, а не покрытие MapKit. `opacity`, `zIndex`,
`isVisible` и `userData` у объектов карты — параметры самих composable, а не поля `*State`.

### Сквозные требования к каждому этапу

- `expect`/`actual` на обе платформы, конвертеры `toNative()`/`toCommon()` только в
  `androidMain`/`iosMain`;
- подписки — через `WeakRef`, `toNative()` листенера возвращает одну и ту же инстанцию;
- новый подтип `MapObject` — ветка в `when` внутри `MapObject.toCommon()` на обеих платформах;
- iOS-конвертеры enum — `else -> throw IllegalArgumentException(...)`;
- KDoc из официальной документации на `expect` и на обоих `actual`;
- новые типы в сигнатурах composable — в `compose_compiler_stability_config.conf`;
- `./gradlew updateKotlinAbi` на macOS, CHANGELOG, страница в `docs/` и `mkdocs.yml`.

---

# Приложение. Полный перечень необёрнутых lite-типов с членами

167 типов, доступных в `4.42.0-lite` и не представленных во враппере. Сигнатуры — Android;
iOS-аналоги ищутся по правилам из `.claude/skills/yml-docs`.

### `com.yandex.mapkit.map` — не обёрнуто типов: 21

**BaseDataSourceBuilder** _(Interface)_

- `void setImageUrlProvider(@NonNull ImageUrlProvider urlProvider)` — The class does not retain the object in the 'urlProvider' parameter.
- `boolean isValid()` — Tells if this BaseDataSourceBuilder is valid or not.

**CompositeIcon** _(Interface)_

- `void setIcon(@NonNull java.lang.String name, @NonNull ImageProvider image)` — Creates or resets a named layer with an icon and its style.
- `void setIcon(@NonNull java.lang.String name, @NonNull ImageProvider image, @Nullable IconStyle style)` — Creates or resets a named layer with an icon and its style.
- `void setIcon(@NonNull java.lang.String name, @NonNull ImageProvider image, @Nullable IconStyle style, @Nullable Callback onFinished)` — Creates or resets a named layer with an icon and its style.
- `void setIconStyle(@NonNull java.lang.String name, @NonNull IconStyle style)` — Changes the icon style for a specific layer.
- `Icon icon(@NonNull java.lang.String name)` — Returns named Icon object that can be used to set icon and its style.
- `void removeIcon(@NonNull java.lang.String name)` — Removes the named layer.
- `void removeAll()` — Removes all layers.

**CreateTileDataSource** _(Interface)_

- `void createTileDataSource(@NonNull TileDataSourceBuilder builder)` — User defined factory, which sets up TileDataSourceBuilder.

**GeoObjectInspectionMetadata** _(Class)_

- ctor `GeoObjectInspectionMetadata()`
- ctor `GeoObjectInspectionMetadata(@NonNull java.lang.String layerId, @NonNull ObjectType objectType)`
- `synchronized java.lang.String getLayerId()`
- `synchronized ObjectType getObjectType()`
- `static java.lang.String getNativeName()`

**GeoObjectSelectionMetadata** _(Class)_

- ctor `GeoObjectSelectionMetadata()`
- ctor `GeoObjectSelectionMetadata(@NonNull java.lang.String objectId, @NonNull java.lang.String dataSourceName, @NonNull java.lang.String layerId, @Nullable java.lang.Long groupId)`
- `synchronized java.lang.String getObjectId()` — Object ID.
- `synchronized java.lang.String getDataSourceName()` — Data source name.
- `synchronized java.lang.String getLayerId()` — Layer ID.
- `synchronized java.lang.Long getGroupId()` — Group ID.
- `static java.lang.String getNativeName()`

**GeoObjectTags** _(Class)_

- ctor `GeoObjectTags()`
- ctor `GeoObjectTags(@NonNull java.util.List<java.lang.String> tags)`
- `synchronized java.util.List<java.lang.String> getTags()`
- `static java.lang.String getNativeName()`

**Icon** _(Interface)_

- `void setImage(@NonNull ImageProvider image)` — Sets the image for the icon.
- `void setImage(@NonNull ImageProvider image, @Nullable IconStyle style)` — Sets the image for the icon.
- `void setImage(@NonNull ImageProvider image, @Nullable IconStyle style, @Nullable Callback onFinished)` — Sets the image for the icon.
- `void setView(@NonNull ViewProvider view)` — Sets the view for the icon.
- `void setView(@NonNull ViewProvider view, @Nullable IconStyle style)` — Sets the view for the icon.
- `void setView(@NonNull ViewProvider view, @Nullable IconStyle style, @Nullable Callback onFinished)` — Sets the view for the icon.
- `IconStyle getStyle()` — The style properties (scale, zIndex, etc.) of the icon placemark.
- `void setStyle(@NonNull IconStyle style)`

**MapLoadStatistics** _(Class)_

- ctor `MapLoadStatistics(long curZoomGeometryLoaded, long curZoomPlacemarksLoaded, long curZoomLabelsLoaded, long delayedGeometryLoaded, long curZoomModelsLoaded, long fullyLoaded, long fullyAppeared, int renderObjectCount, int tileMemoryUsage)`
- ctor `MapLoadStatistics()`
- `long getCurZoomGeometryLoaded()`
- `long getCurZoomPlacemarksLoaded()`
- `long getCurZoomLabelsLoaded()`
- `long getDelayedGeometryLoaded()` — The time it took to load delayed geometry.
- `long getCurZoomModelsLoaded()` — The time it took to load models.
- `long getFullyLoaded()` — The time it took to load all map objects.
- `long getFullyAppeared()` — The time it took for all map objects to appear.
- `int getRenderObjectCount()`
- `int getTileMemoryUsage()` — Tile memory usage in bytes

**MapLoadedListener** _(Interface)_

- `void onMapLoaded(@NonNull MapLoadStatistics statistics)` — Called after the map has finished loading all visible tiles.

**Model** _(Interface)_

- `ModelStyle getModelStyle()` — The style properties (scale, unitType, etc.) of the model placemark.
- `void setModelStyle(@NonNull ModelStyle modelStyle)`
- `void setData(@NonNull DataProviderWithId gltfDataProvider)` — Sets glTF data provider.
- `void setData(@NonNull DataProviderWithId gltfDataProvider, @Nullable Callback onFinished)` — Sets glTF data provider.

**ModelStyle** _(Class)_

- ctor `ModelStyle(float scale, @NonNull UnitType unitType, @NonNull RenderMode renderMode, @Nullable java.lang.String variantName)`
- ctor `ModelStyle()`
- `float getScale()` — Scale the model by this value.
- `ModelStyle setScale(float scale)` — See #getScale().
- `UnitType getUnitType()` — Unit type of the model.
- `ModelStyle setUnitType(@NonNull UnitType unitType)` — See #getUnitType().
- `RenderMode getRenderMode()` — Defines should it be rendered with buildings from ground layer.
- `ModelStyle setRenderMode(@NonNull RenderMode renderMode)` — See #getRenderMode().
- `java.lang.String getVariantName()` — Name of variant to render model with.
- `ModelStyle setVariantName(@Nullable java.lang.String variantName)` — See #getVariantName().

**ObjectType** _(Enum, вложенный)_

- `POINT`
- `POLYLINE`
- `POLYGON`
- `CIRCLE`

**OffscreenMapWindow** _(Interface)_

- `MapWindow getMapWindow()`
- `android.graphics.Bitmap captureScreenshot()`

**PlacemarkAnimation** _(Interface)_

- `void setIcon(@NonNull AnimatedImageProvider image, @NonNull IconStyle style)` — Sets the animated image and icon style.
- `void setIcon(@NonNull AnimatedImageProvider image, @NonNull IconStyle style, @NonNull Callback onFinished)` — Sets the animated image and icon style.
- `void setIconStyle(@NonNull IconStyle style)` — Changes the icon style.
- `void play()` — Starts animation.
- `void play(@NonNull Callback onFinished)` — Starts animation and handles the callback.
- `void resume()` — Resumes paused animation.
- `void stop()` — Stops animation.
- `void pause()` — Pauses animation.
- `boolean isReversed()` — If true, animation will be played in the reverse direction.
- `void setReversed(boolean reversed)`

**PlacemarkPresentation** _(Interface)_

- `void remove()` — Removes the presentation.
- `boolean isValid()` — Tells if this PlacemarkPresentation is valid or not.

**PlacemarkText** _(Interface)_

- `java.lang.String getText()` — UTF-8 encoded text to be displayed with the PlacemarkMapObject Empty string means no text
- `void setText(@NonNull java.lang.String text)`
- `TextStyle getStyle()` — The style properties (size, color, etc.) of the placemark text.
- `void setStyle(@NonNull TextStyle style)`
- `boolean isValid()` — Tells if this PlacemarkText is valid or not.

**RenderMode** _(Enum, вложенный)_

- `BUILDING` — Model should be rendered with buildings from ground layer.
- `USER_MODEL` — Model should be rendered within separate sublayer.

**RootMapObjectCollection** _(Interface)_

- `ConflictResolutionMode getConflictResolutionMode()`
- `void setConflictResolutionMode(@NonNull ConflictResolutionMode conflictResolutionMode)`

**TileDataSourceBuilder** _(Interface)_

- `void setTileUrlProvider(@NonNull UrlProvider urlProvider)` — The class does not retain the object in the 'urlProvider' parameter.
- `void setTileProvider(@NonNull TileProvider tileProvider)` — The class does not retain the object in the 'tileProvider' parameter.
- `void setProjection(@NonNull Projection projection)`
- `void setZoomRanges(@NonNull java.util.List<ZoomRange> zoomRanges)`
- `void setTileFormat(@NonNull TileFormat format)`

**UnitType** _(Enum, вложенный)_

- `UNIT` — The model is given in units.
- `NORMALIZED`
- `METER` — The model is given in meters.

**VisibleRegionUtils** _(Class)_

- ctor `VisibleRegionUtils()`
- `static native Geometry toPolygon(@NonNull VisibleRegion visibleRegion)` — Converts visible region to polygon geometry
- `static native BoundingBox getBounds(@NonNull VisibleRegion visibleRegion)`


### `com.yandex.mapkit.layers` — не обёрнуто типов: 12

**BaseDataSource** _(Interface)_

- `java.lang.String getId()` — Stores id of data source.
- `boolean isValid()` — Tells if this BaseDataSource is valid or not.

**DataSource** _(Interface)_

- `void setData(@NonNull byte[] data)` — Updates all data.

**DataSourceLayer** _(Interface)_

- `boolean isActive()` — Manages visibility of the layer.
- `void setActive(boolean active)`
- `void clear()` — Clears all cached tiles and starts new requests for tiles that are displayed.
- `boolean setStyle(int id, @NonNull java.lang.String style)` — Applies JSON style transformation to the layer.
- `void resetStyles()` — Resets all JSON style transformations applied to the layer.
- `void setLayerLoadedListener(@Nullable java.lang.ref.WeakReference<LayerLoadedListener> layerLoadedListener)` — Sets layer loaded listener.
- `void remove()` — Removes the data source layer from the parent layer.
- `void setDataSourceListener(@Nullable java.lang.ref.WeakReference<DataSourceListener> dataSourceListener)` — Sets data source listener.
- `boolean isValid()` — Tells if this DataSourceLayer is valid or not.

**DataSourceListener** _(Interface)_

- `void onDataSourceUpdated(@NonNull BaseDataSource dataSource)`

**GeoObjectTapEvent** _(Interface)_

- `GeoObject getGeoObject()`
- `boolean isValid()` — Tells if this GeoObjectTapEvent is valid or not.

**GeoObjectTapListener** _(Interface)_

- `boolean onObjectTap(@NonNull GeoObjectTapEvent event)` — Listener that retrieves brief geoObject info for the tapped object.

**Layer** _(Interface)_

- `void remove()` — Removes the layer from the map.
- `DataSourceLayer dataSourceLayer()`
- `boolean isValid()` — Tells if this Layer is valid or not.

**LayerLoadedListener** _(Interface)_

- `void onLayerLoaded()` — Called after the layer has finished loading all visible tiles.

**LayerOptions** _(Class)_

- ctor `LayerOptions(boolean active, boolean nightModeAvailable, boolean cacheable, boolean animateOnActivation, long tileAppearingAnimationDuration, @NonNull OverzoomMode overzoomMode, boolean transparent, boolean versionSupport)`
- ctor `LayerOptions()`
- `boolean getActive()` — Inactive layers are not displayed on the map and do not request any tiles from TileProvider.
- `LayerOptions setActive(boolean active)` — See #getActive().
- `boolean getNightModeAvailable()` — Indicates the availability of night mode for this layer (for example, night mode is disabled for the satellite
- `LayerOptions setNightModeAvailable(boolean nightModeAvailable)` — See #getNightModeAvailable().
- `boolean getCacheable()` — Determines whether tiles are cached on persistent storage or not.
- `LayerOptions setCacheable(boolean cacheable)` — See #getCacheable().
- `boolean getAnimateOnActivation()` — Indicates whether layer activation/deactivation should be animated.
- `LayerOptions setAnimateOnActivation(boolean animateOnActivation)` — See #getAnimateOnActivation().
- `long getTileAppearingAnimationDuration()` — Specifies duration of tile appearing animation.
- `LayerOptions setTileAppearingAnimationDuration(long tileAppearingAnimationDuration)` — See #getTileAppearingAnimationDuration().
- `OverzoomMode getOverzoomMode()` — Whether to render tiles from adjacent zoom levels in place of absent or translucent tiles.
- `LayerOptions setOverzoomMode(@NonNull OverzoomMode overzoomMode)` — See #getOverzoomMode().
- `boolean getTransparent()` — Set this flag if layer is transparent, that is parts of underlying layers can be seen through it.
- `LayerOptions setTransparent(boolean transparent)` — See #getTransparent().
- `boolean getVersionSupport()` — Determines if layer supports versioning
- `LayerOptions setVersionSupport(boolean versionSupport)` — See #getVersionSupport().

**OverzoomMode** _(Enum)_

- `DISABLED` — Overzoom is fully disabled.
- `ENABLED` — If a tile is absent or translucent, tiles from lower or higher zooms will be shown.
- `WITH_PREFETCH` — Same as Enabled, plus it fetches tiles well below absent or translucent tiles that don't have any overzoom tiles to replace them with.

**TileDataSource** _(Interface)_

- `void invalidate(@NonNull java.lang.String version)` — Invalidates data source and reloads all tiles.

**TileFormat** _(Enum)_

- `PNG`
- `JPG`
- `VECTOR2`
- `VECTOR3`
- `GEO_JSON`


### `com.yandex.mapkit.location` — не обёрнуто типов: 15

**DummyLocationManager** _(Interface)_

- `void setLocation(@NonNull Location location, @NonNull DummyLocationQuality quality)` — Sets a location and notifies all consumers of this location.

**DummyLocationQuality** _(Enum)_

- `HIGH`
- `LOW`

**LocationError** _(Class)_

- ctor `LocationError()`
- ctor `LocationError(@NonNull Range lateralErrorRange, @NonNull Range longitudinalErrorRange)`
- `synchronized Range getLateralErrorRange()` — The error of spreading locations across the route.
- `synchronized Range getLongitudinalErrorRange()` — The error of spreading locations along the route.
- `static java.lang.String getNativeName()`

**LocationManagerUtils** _(Class)_

- ctor `LocationManagerUtils()`
- `static native Location getLastKnownLocation()` — Last known location, if one was ever received.

**LocationSettings** _(Class)_

- ctor `LocationSettings(boolean provideAccuracy, @Nullable Range accuracy, @Nullable TimeInterval locationTimeInterval, boolean provideSpeed, double speed, boolean provideHeading, @Nullable Range headingError, @Nullable LocationError locationError, boolean provideWheelSpeed, @Nullable TimeInterval wheelSpeedTimeInterval)`
- ctor `LocationSettings()`
- `boolean getProvideAccuracy()` — Flag whether to provide accuracy value.
- `LocationSettings setProvideAccuracy(boolean provideAccuracy)` — See #getProvideAccuracy().
- `Range getAccuracy()` — Location accuracy range in meters.
- `LocationSettings setAccuracy(@Nullable Range accuracy)` — See #getAccuracy().
- `TimeInterval getLocationTimeInterval()` — Location time interval in milliseconds.
- `LocationSettings setLocationTimeInterval(@Nullable TimeInterval locationTimeInterval)` — See #getLocationTimeInterval().
- `boolean getProvideSpeed()` — Flag whether to provide speed value.
- `LocationSettings setProvideSpeed(boolean provideSpeed)` — See #getProvideSpeed().
- `double getSpeed()` — The speed in meters per second.
- `LocationSettings setSpeed(double speed)` — See #getSpeed().
- `boolean getProvideHeading()` — Flag whether to provide error of heading.
- `LocationSettings setProvideHeading(boolean provideHeading)` — See #getProvideHeading().
- `Range getHeadingError()` — The current heading error range in degrees relative to true heading, clockwise.
- `LocationSettings setHeadingError(@Nullable Range headingError)` — See #getHeadingError().
- `LocationError getLocationError()` — Optional field, can be null.
- `LocationSettings setLocationError(@Nullable LocationError locationError)` — See #getLocationError().
- `boolean getProvideWheelSpeed()` — Flag whether to provide wheel speed value.
- `LocationSettings setProvideWheelSpeed(boolean provideWheelSpeed)` — See #getProvideWheelSpeed().
- `TimeInterval getWheelSpeedTimeInterval()` — Time interval of getting the wheel speed in milliseconds.
- `LocationSettings setWheelSpeedTimeInterval(@Nullable TimeInterval wheelSpeedTimeInterval)` — See #getWheelSpeedTimeInterval().

**LocationSettingsFactory** _(Class)_

- ctor `LocationSettingsFactory()`
- `static native LocationSettings fineSettings()`
- `static native LocationSettings coarseSettings()`

**LocationSimulator** _(Interface)_

- `double getSpeed()`
- `void setSpeed(double speed)`
- `java.util.List<SimulationSettings> getSettings()`
- `void setSettings(@NonNull java.util.List<SimulationSettings> settings)`
- `void subscribeForSimulatorEvents(@NonNull java.lang.ref.WeakReference<LocationSimulatorListener> simulatorListener)` — Subscribes to simulation events.
- `void unsubscribeFromSimulatorEvents(@NonNull java.lang.ref.WeakReference<LocationSimulatorListener> simulatorListener)` — Unsubscribes from simulation events.
- `void startSimulation(@NonNull java.util.List<SimulationSettings> settings)` — Start simulation.
- `void stopSimulation()` — Stop simulation.
- `PolylinePosition polylinePosition()` — The position of the polyline.
- `boolean isActive()` — True if simulator is not suspended.

**LocationSimulatorListener** _(Interface)_

- `void onSimulationFinished()` — Simulation is finished.

**LocationUnavailableError** _(Interface)_


**LocationViewSourceFactory** _(Class)_

- ctor `LocationViewSourceFactory()`
- `static native LocationViewSource createLocationViewSource(@NonNull LocationManager locationManager)` — Location view source.

**Purpose** _(Enum)_

- `GENERAL` — This mode uses less resources and is the default.
- `AUTOMOTIVE_NAVIGATION` — This mode is used to configure LocationManager for automotive navigation.
- `PEDESTRIAN_NAVIGATION` — This mode is used to configure LocationManager for pedestrian navigation.
- `BICYCLE_NAVIGATION` — This mode is used to configure LocationManager for bicycle navigation.
- `SCOOTER_NAVIGATION` — This mode is used to configure LocationManager for scooter navigation.
- `STATIC_DISPLAY_LOCATION` — This mode is used to configure LocationManager for show current user location.

**Range** _(Class)_

- ctor `Range()`
- ctor `Range(double from, double to)`
- `synchronized double getFrom()`
- `synchronized double getTo()`
- `static java.lang.String getNativeName()`

**SimulationSettings** _(Class)_

- ctor `SimulationSettings()`
- ctor `SimulationSettings(@NonNull Polyline geometry, @NonNull LocationSettings locationSettings)`
- `synchronized Polyline getGeometry()`
- `synchronized LocationSettings getLocationSettings()`
- `static java.lang.String getNativeName()`

**TimeInterval** _(Class)_

- ctor `TimeInterval()`
- ctor `TimeInterval(long from, long to)`
- `synchronized long getFrom()` — Lower limit in milliseconds.
- `synchronized long getTo()` — Upper limit in milliseconds.
- `static java.lang.String getNativeName()`

**ViewArea** _(Class)_

- ctor `ViewArea(double lengthwise, double transverse)`
- ctor `ViewArea()`
- `double getLengthwise()` — The length of the view area in meters.
- `double getTransverse()` — The width of the view area from center in meters.


### `com.yandex.mapkit.geometry` — не обёрнуто типов: 6

**BoundingBoxHelper** _(Class)_

- ctor `BoundingBoxHelper()`
- `static native BoundingBox getBounds(@NonNull BoundingBox bbox)` — Gets bounds based on a bounding box.
- `static native BoundingBox getBounds(@NonNull Point point)` — Gets bounds based on a point.
- `static native BoundingBox getBounds(@NonNull Polyline polyline)` — Gets bounds based on a polyline.
- `static native BoundingBox getBounds(@NonNull LinearRing ring)` — Gets bounds based on a linear ring.
- `static native BoundingBox getBounds(@NonNull Polygon polygon)` — Gets bounds based on a polygon.
- `static native BoundingBox getBounds(@NonNull BoundingBox first, @NonNull BoundingBox second)` — Gets bounds based on two bounding boxes.

**Direction** _(Class)_

- ctor `Direction(double azimuth, double tilt)`
- ctor `Direction()`
- `double getAzimuth()` — Panorama azimuth.
- `double getTilt()` — Panorama tilt.

**PolylineBuilder** _(Interface)_

- `void append(@NonNull Polyline polyline)` — Appends a polyline.
- `void append(@NonNull Point point)` — Appends a point.
- `Polyline build()` — Builds a polyline.

**PolylineBuilderFactory** _(Class)_

- ctor `PolylineBuilderFactory()`
- `static native PolylineBuilder create()`

**Span** _(Class)_

- ctor `Span(double horizontalAngle, double verticalAngle)`
- ctor `Span()`
- `double getHorizontalAngle()` — The horizontal view angle.
- `double getVerticalAngle()` — The vertical view angle.

**SubpolylineHelper** _(Class)_

- ctor `SubpolylineHelper()`
- `static native Polyline subpolyline(@NonNull Polyline polyline, @NonNull Subpolyline subpolyline)` — Cuts subpolyline geometry from polyline.
- `static native double subpolylineLength(@NonNull Polyline polyline, @NonNull Subpolyline subpolyline)` — Calculates length of subpolyline geometry.


### `com.yandex.mapkit.geometry.geo` — не обёрнуто типов: 6

**PolylineIndex** _(Interface)_

- `PolylinePosition closestPolylinePosition(@NonNull Point point, @NonNull Priority priority, double maxLocationBias)` — Finds closest polyline position.
- `PolylinePosition closestPolylinePosition(@NonNull Point point, @NonNull PolylinePosition positionFrom, @NonNull PolylinePosition positionTo, double maxLocationBias)` — Finds the closest polyline position between the two positions.

**PolylineUtils** _(Class)_

- ctor `PolylineUtils()`
- `static native java.util.List<PolylinePosition> positionsOfFork(@NonNull Polyline firstPolyline, @NonNull PolylinePosition firstPolylinePosition, @NonNull Polyline secondPolyline, @NonNull PolylinePosition secondPolylinePosition)` — The position of the fork on the road.
- `static native PolylinePosition advancePolylinePosition(@NonNull Polyline polyline, @NonNull PolylinePosition position, double distance)` — Advance the polyline position by a specified distance in meters.
- `static native Point pointByPolylinePosition(@NonNull Polyline geometry, @NonNull PolylinePosition position)` — The point in the polyline.
- `static native double distanceBetweenPolylinePositions(@NonNull Polyline polyline, @NonNull PolylinePosition from, @NonNull PolylinePosition to)`
- `static native PolylineIndex createPolylineIndex(@NonNull Polyline polyline)` — Creates PolylineIndex for polyline.

**Priority** _(Enum)_

- `CLOSEST_TO_RAW_POINT`
- `CLOSEST_TO_START`

**Projection** _(Interface)_

- `XYPoint worldToXY(@NonNull Point geoPoint, int zoom)` — Converts the world coordinates to a flat world position.
- `Point xyToWorld(@NonNull XYPoint xyPoint, int zoom)` — Converts the flat world position to world coordinates.
- `boolean isValid()` — Tells if this Projection is valid or not.

**Projections** _(Class)_

- ctor `Projections()`
- `static native Projection getWgs84Mercator()`
- `static native Projection getSphericalMercator()`

**XYPoint** _(Class)_

- ctor `XYPoint(double x, double y)`
- ctor `XYPoint()`
- `double getX()` — The horizontal position of the point.
- `double getY()` — The vertical position of the point.


### `com.yandex.mapkit` — не обёрнуто типов: 29

**Attribution** _(Class)_

- ctor `Attribution()`
- ctor `Attribution(@Nullable Author author, @Nullable Link link, @Nullable Image avatarImage)`
- `synchronized Author getAuthor()` — Additional information about the author.
- `synchronized Link getLink()` — Link to a specific page on the author's site.
- `synchronized Image getAvatarImage()` — Optional field, can be null.
- `static java.lang.String getNativeName()`

**Author** _(Class, вложенный)_

- ctor `Author(@NonNull java.lang.String name, @Nullable java.lang.String uri, @Nullable java.lang.String email)`
- ctor `Author()`
- `java.lang.String getName()`
- `java.lang.String getUri()` — A reference to the author's site.
- `java.lang.String getEmail()` — Author's email.

**BaseMetadata** _(Interface)_


**ConflictResolutionMode** _(Enum)_

- `MINOR` — Feature can be hidden (if supported) due to conflict with higher feature but will not conflict with lower features.
- `EQUAL` — Feature can be hidden (if supported) due to conflict with higher feature and can displace lower features.
- `MAJOR` — Feature can NOT be hidden but can displace lower features.
- `IGNORE` — Feature doesn't participate in conflict resolution.

**GeoObject** _(Class)_

- ctor `GeoObject()`
- ctor `GeoObject(@Nullable java.lang.String name, @Nullable java.lang.String descriptionText, @NonNull java.util.List<Geometry> geometry, @Nullable BoundingBox boundingBox, @NonNull java.util.Map<java.lang.String, Attribution> attributionMap, @NonNull TypeDictionary<BaseMetadata> metadataContainer, @NonNull java.util.List<java.lang.String> aref)`
- `synchronized java.lang.String getName()` — Object name.
- `synchronized java.lang.String getDescriptionText()` — The description of the object.
- `synchronized java.util.List<Geometry> getGeometry()` — The object's geometry.
- `synchronized BoundingBox getBoundingBox()` — A rectangular box around the object.
- `synchronized java.util.Map<java.lang.String, Attribution> getAttributionMap()` — The attribution of information to a specific author.
- `synchronized TypeDictionary<BaseMetadata> getMetadataContainer()` — The object's metadata.
- `synchronized java.util.List<java.lang.String> getAref()` — The name of the internet resource.
- `static java.lang.String getNativeName()`

**GeoObjectCollection** _(Class)_

- ctor `GeoObjectCollection()`
- ctor `GeoObjectCollection(@Nullable BoundingBox boundingBox, @NonNull TypeDictionary<BaseMetadata> metadataContainer, @NonNull java.util.List<Item> children)`
- `synchronized BoundingBox getBoundingBox()` — The bounds around the collection of objects.
- `synchronized TypeDictionary<BaseMetadata> getMetadataContainer()` — The metadata for the objects.
- `synchronized java.util.List<Item> getChildren()`
- `static java.lang.String getNativeName()`

**GeoObjectListener** _(Interface)_

- `void onGeoObjectResult(@NonNull GeoObject obj)` — Called when a user is requesting detailed info for the specified object.
- `void onGeoObjectError(@NonNull Error error)` — Called when an error occurs.

**GeoObjectSession** _(Interface)_

- `void cancel()` — Cancels the current request.
- `void retry(@NonNull GeoObjectListener objListener)` — Retries the last request.

**Image** _(Class)_

- ctor `Image()`
- ctor `Image(@NonNull java.lang.String urlTemplate, @NonNull java.util.List<ImageSize> sizes, @NonNull java.util.List<java.lang.String> tags)`
- `synchronized java.lang.String getUrlTemplate()` — urlTemplate for the image.
- `synchronized java.util.List<ImageSize> getSizes()` — Image sizes.
- `synchronized java.util.List<java.lang.String> getTags()` — Image tags.
- `static java.lang.String getNativeName()`

**ImageSize** _(Class, вложенный)_

- ctor `ImageSize(@NonNull java.lang.String size, @Nullable java.lang.Integer width, @Nullable java.lang.Integer height)`
- ctor `ImageSize()`
- `java.lang.String getSize()`
- `java.lang.Integer getWidth()` — Optional field, can be null.
- `java.lang.Integer getHeight()` — Optional field, can be null.

**Item** _(Class, вложенный)_

- ctor `Item()`
- `static Item fromObj(@NonNull GeoObject obj)`
- `static Item fromCollection(@NonNull GeoObjectCollection collection)`
- `GeoObject getObj()`
- `GeoObjectCollection getCollection()`

**Link** _(Class, вложенный)_

- ctor `Link(@NonNull java.lang.String href)`
- ctor `Link()`
- `java.lang.String getHref()`

**LocalizedValue** _(Class)_

- ctor `LocalizedValue(double value, @NonNull java.lang.String text)`
- ctor `LocalizedValue()`
- `double getValue()` — Value in SI units for distance, speed and duration.
- `java.lang.String getText()` — Localized text.

**MapKitFactory** _(Class)_

- ctor `MapKitFactory()`
- `static synchronized void initialize(android.content.Context context)`
- `static synchronized void setApiKey(@NonNull java.lang.String apiKey)`
- `static synchronized void setLocale(@Nullable java.lang.String locale)`
- `static synchronized void setUserId(java.lang.String userId)`
- `static synchronized void initializeBackgroundDownload(android.content.Context context, com.yandex.mapkit.offline_cache.internal.BackgroundDownloadInitializer initializer)` — This method checks if background downloading is needed.
- `static native MapKit getInstance()`

**Money** _(Class)_

- ctor `Money(double value, @NonNull java.lang.String text, @NonNull java.lang.String currency)`
- ctor `Money()`
- `double getValue()`
- `java.lang.String getText()`
- `java.lang.String getCurrency()`

**RawTile** _(Class)_

- ctor `RawTile()`
- ctor `RawTile(@NonNull Version version, @NonNull java.util.Map<java.lang.String, java.lang.String> features, @NonNull java.lang.String etag, @NonNull UseCache useCache, @NonNull State state, @NonNull byte[] rawData)`
- `synchronized Version getVersion()`
- `synchronized java.util.Map<java.lang.String, java.lang.String> getFeatures()`
- `synchronized java.lang.String getEtag()`
- `synchronized UseCache getUseCache()`
- `synchronized State getState()`
- `synchronized byte[] getRawData()`
- `static java.lang.String getNativeName()`

**RequestPoint** _(Class)_

- ctor `RequestPoint()`
- ctor `RequestPoint(@NonNull Point point, @NonNull RequestPointType type, @Nullable java.lang.String pointContext, @Nullable java.lang.String drivingArrivalPointId, @Nullable java.lang.String indoorLevelId)`
- `synchronized Point getPoint()` — The request point.
- `synchronized RequestPointType getType()` — The type of request point specified.
- `synchronized java.lang.String getPointContext()` — Opaque string that describe entrances, driving arrival points and so on.
- `synchronized java.lang.String getDrivingArrivalPointId()` — Specifies what driving arrival point to use.
- `synchronized java.lang.String getIndoorLevelId()` — Indoor level (floor) id<br>Optional field, can be null.
- `static java.lang.String getNativeName()`

**RequestPointType** _(Enum)_

- `WAYPOINT` — The target waypoint.
- `VIAPOINT` — A point the route must pass through.

**Size2u** _(Class)_

- ctor `Size2u(int width, int height)`
- ctor `Size2u()`
- `int getWidth()`
- `int getHeight()`

**Span** _(Class, вложенный)_

- ctor `Span(int begin, int end)`
- ctor `Span()`
- `int getBegin()` — The index of the beginning symbol of the span.
- `int getEnd()` — The index of the ending symbol of the span.

**SpannableString** _(Class)_

- ctor `SpannableString()`
- ctor `SpannableString(@NonNull java.lang.String text, @NonNull java.util.List<Span> spans)`
- `synchronized java.lang.String getText()` — The text of the spannable string.
- `synchronized java.util.List<Span> getSpans()` — The spans in stored text.
- `static java.lang.String getNativeName()`

**State** _(Enum, вложенный)_

- `OK` — Tile is available.
- `NOT_MODIFIED` — Tile was not modified.
- `ERROR` — An error occurred when processing the tile.

**TileId** _(Class)_

- ctor `TileId(int x, int y, int z)`
- ctor `TileId()`
- `int getX()` — The number of the tile horizontally.
- `int getY()` — The number of the tile vertically.
- `int getZ()` — The number of columns and rows to split the map into.

**Time** _(Class)_

- ctor `Time(long value, int tzOffset, @NonNull java.lang.String text)`
- ctor `Time()`
- `long getValue()` — Time value.
- `int getTzOffset()` — Time offset to account for time zones.
- `java.lang.String getText()` — The description of the timer.

**Type** _(Enum, вложенный)_

- `SMOOTH` — Smooth interpolation between start and finish states.
- `LINEAR` — Movement with constant speed during animation time.

**UseCache** _(Enum, вложенный)_

- `YES`
- `NO`

**UserData** _(Class)_

- ctor `UserData()`
- ctor `UserData(@NonNull java.util.Map<java.lang.String, java.lang.String> data)`
- `synchronized java.util.Map<java.lang.String, java.lang.String> getData()` — A dictionary of data.
- `static java.lang.String getNativeName()`

**Version** _(Class)_

- ctor `Version(@NonNull java.lang.String str)`
- ctor `Version()`
- `java.lang.String getStr()` — Version string.

**ZoomRange** _(Class)_

- ctor `ZoomRange(int zMin, int zMax)`
- ctor `ZoomRange()`
- `int getZMin()` — Lower limit of zoom range, inclusive.
- `int getZMax()` — Upper limit of zoom range, exclusive.


### `com.yandex.mapkit.traffic` — не обёрнуто типов: 4

**TrafficColor** _(Enum)_

- `RED` — Red color.
- `YELLOW` — Yellow color.
- `GREEN` — Green color.

**TrafficLayer** _(Interface)_

- `boolean isTrafficVisible()` — Checks if traffic is visible.
- `void setTrafficVisible(boolean on)` — Sets traffic visibility.
- `boolean setTrafficStyle(@NonNull java.lang.String style)` — Applies JSON style transformations to the traffic layer.
- `boolean setTrafficStyle(int id, @NonNull java.lang.String style)` — Applies JSON style transformations to the traffic layer.
- `void resetTrafficStyles()` — Resets all JSON style transformations applied to the traffic layer.
- `void addTrafficListener(@NonNull java.lang.ref.WeakReference<TrafficListener> trafficListener)` — Adds a traffic listener.
- `void removeTrafficListener(@NonNull java.lang.ref.WeakReference<TrafficListener> trafficListener)` — Removes a traffic listener.
- `boolean isValid()` — Tells if this TrafficLayer is valid or not.

**TrafficLevel** _(Class)_

- ctor `TrafficLevel(@NonNull TrafficColor color, int level)`
- ctor `TrafficLevel()`
- `TrafficColor getColor()` — The color that represents traffic.
- `int getLevel()` — Traffic level.

**TrafficListener** _(Interface)_

- `void onTrafficChanged(@Nullable TrafficLevel trafficLevel)` — Triggered when traffic level changes.
- `void onTrafficLoading()` — Triggered when traffic information is loading.
- `void onTrafficExpired()` — Triggered when traffic information expires.


### `com.yandex.mapkit.offline_cache` — не обёрнуто типов: 14

**CachePathUnavailable** _(Interface)_


**ClearListener** _(Interface)_

- `void onClearCompleted()` — Cache was cleared.

**DataMoveListener** _(Interface)_

- `void onDataMoveProgress(int percent)` — Called when the operation makes progress.
- `void onDataMoveCompleted()` — Called when the request is completed.
- `void onDataMoveError(@NonNull Error error)` — Called when an error occurs.

**DownloadNotificationsListener** _(Interface)_

- `void startNotifications(@NonNull OfflineCacheManager offlineCacheManager)`

**ErrorListener** _(Interface)_

- `void onError(@NonNull Error error)`
- `void onRegionError(@NonNull Error error, int regionId)`

**OfflineCacheManager** _(Interface)_

- `java.util.List<Region> regions()` — Copying a list of regions from memory.
- `void allowUseCellularNetwork(boolean useCellular)` — Indicates whether to allow downloading using cellular networks (3G, LTE, and other).
- `void addRegionListUpdatesListener(@NonNull java.lang.ref.WeakReference<RegionListUpdatesListener> regionListUpdatesListener)` — Subscribe on update of region list<br>The class does not retain the object in the 'regionListUpdatesListener' 
- `void removeRegionListUpdatesListener(@NonNull java.lang.ref.WeakReference<RegionListUpdatesListener> regionListUpdatesListener)` — Unsubscribe from region list update
- `void addErrorListener(@NonNull java.lang.ref.WeakReference<ErrorListener> errorListener)` — Subscribe on errors<br>The class does not retain the object in the 'errorListener' parameter.
- `void removeErrorListener(@NonNull java.lang.ref.WeakReference<ErrorListener> errorListener)` — Unsubscribe from errors
- `void addRegionListener(@NonNull java.lang.ref.WeakReference<RegionListener> regionListener)` — Subscribe on status events<br>The class does not retain the object in the 'regionListener' parameter.
- `void removeRegionListener(@NonNull java.lang.ref.WeakReference<RegionListener> regionListener)` — Unsubscribe from status events
- `java.util.List<java.lang.String> getCities(int regionId)` — Returns a list of cities.
- `RegionState getState(int regionId)` — Current region state
- `java.lang.Long getDownloadedReleaseTime(int regionId)` — Release time of downloaded region files
- `float getProgress(int regionId)` — Current region progress [0,1].
- `void startDownload(int regionId)` — Start to download new offline cache for the region or update if region has been downloaded
- `void stopDownload(int regionId)` — Stop downloading of region
- `void pauseDownload(int regionId)` — Pause downloading of region
- `void drop(int regionId)` — Drop region data from the device.
- `boolean mayBeOutOfAvailableSpace(int regionId)` — Returns true if available disk space might not be enough for installation of the region data.
- `boolean isLegacyPath(int regionId)` — Returns true if region has files with legacy localized path.
- `void computeCacheSize(@NonNull SizeListener callback)` — Calculates the full cache size in bytes.
- `void requestPath(@NonNull PathGetterListener callback)` — Provides the data path for offline cache files.
- `void moveData(@NonNull java.lang.String newPath, @NonNull java.lang.ref.WeakReference<DataMoveListener> dataMoveListener)` — Moves offline caches to the specified folder.
- `void setCachePath(@NonNull java.lang.String path, @NonNull PathSetterListener pathSetterListener)` — Sets a new path for caches.
- `void enableAutoUpdate(boolean enable)` — Enables autoupdating downloaded caches when they become outdated.
- `void clear(@NonNull ClearListener callback)` — Erases all data for downloads and regions and wipes the cache.
- `void requestRegionsAtPoint(@NonNull Point point, @NonNull RegionsAtPointListener callback)` — Provides ids of regions containing specified point.
- `boolean isValid()` — Tells if this OfflineCacheManager is valid or not.

**PathGetterListener** _(Interface)_

- `void onPathReceived(@NonNull java.lang.String path)` — Path was received.

**PathSetterListener** _(Interface)_

- `void onPathSet()` — New cache path was set.
- `void onPathSetError(@NonNull Error error)` — Error occurred.

**Region** _(Class)_

- ctor `Region(int id, @NonNull java.lang.String name, @NonNull java.lang.String country, @NonNull Point center, @NonNull LocalizedValue size, long releaseTime, @Nullable java.lang.Integer parentId)`
- ctor `Region()`
- `int getId()` — Region ID.
- `java.lang.String getName()` — Name of the region.
- `java.lang.String getCountry()` — Country of the region.
- `Point getCenter()` — Center point.
- `LocalizedValue getSize()` — Region size
- `long getReleaseTime()` — Returns the region creation time.
- `java.lang.Integer getParentId()` — Region id of the parent region.

**RegionListUpdatesListener** _(Interface)_

- `void onListUpdated()`

**RegionListener** _(Interface)_

- `void onRegionStateChanged(int regionId)` — Region state was changed.
- `void onRegionProgress(int regionId)` — Progress of specific region download was updated.

**RegionState** _(Enum)_

- `AVAILABLE` — Available for download on the server.
- `DOWNLOADING` — Download in progress.
- `PAUSED` — Download is paused.
- `COMPLETED` — Cache data installation is finished.
- `OUTDATED` — The region was completed but there is a newer version on the server.
- `UNSUPPORTED` — The region was removed from regions list and will never be updated
- `NEED_UPDATE` — The region is significantly outdated or it contains invalid data.

**RegionsAtPointListener** _(Interface)_

- `void onRegions(@NonNull java.util.List<java.lang.Integer> regions)`
- `void onError(@NonNull Error error)`

**SizeListener** _(Interface)_

- `void onSizeComputed(@Nullable java.lang.Long size)` — Size was calculated.


### `com.yandex.mapkit.storage` — не обёрнуто типов: 4

**ClearListener** _(Interface)_

- `void onClearCompleted()` — Storage was cleared.

**SizeListener** _(Interface)_

- `void onSuccess(@Nullable java.lang.Long bytes)` — Storage size was computed/modify.
- `void onError(@NonNull Error error)` — There was an error during size operation.

**StorageErrorListener** _(Interface)_

- `void onStorageError(@NonNull LocalError error)` — Possible error types: - runtime.DiskCorruptError: Called if local storage is corrupted.

**StorageManager** _(Interface)_

- `void addStorageErrorListener(@NonNull java.lang.ref.WeakReference<StorageErrorListener> errorListener)` — Subscribes to storage events.
- `void removeStorageErrorListener(@NonNull java.lang.ref.WeakReference<StorageErrorListener> errorListener)` — Unsubscribes from storage events.
- `void computeSize(@NonNull SizeListener callback)` — Computes storage size in bytes.
- `void clear(@NonNull ClearListener callback)` — Removes all data.
- `void setMaxTileStorageSize(long limit, @NonNull SizeListener callback)` — Sets the maximum tile cache size to limit bytes.
- `void resetMaxTileStorageSize(@NonNull SizeListener callback)` — Resets the tile cache size limit.
- `void maxTileStorageSize(@NonNull SizeListener callback)` — Obtains the current storage size limit in bytes.
- `boolean isValid()` — Tells if this StorageManager is valid or not.


### `com.yandex.mapkit.tiles` — не обёрнуто типов: 2

**TileProvider** _(Interface)_

- `RawTile load(@NonNull TileId tileId, @NonNull Version version, @NonNull java.util.Map<java.lang.String, java.lang.String> features, @NonNull java.lang.String etag)` — Generates tile.

**UrlProvider** _(Interface)_

- `java.lang.String formatUrl(@NonNull TileId tileId, @NonNull Version version, @NonNull java.util.Map<java.lang.String, java.lang.String> features)` — Create s a URL based on the tile ID, version, and features.


### `com.yandex.mapkit.road_events` — не обёрнуто типов: 4

**EventInfoListener** _(Interface)_

- `void onEventInfoReceived(@NonNull GeoObject event)`
- `void onEventInfoError(@NonNull Error error)`

**EventInfoSession** _(Interface)_

- `void retry(@NonNull EventInfoListener eventInfoListener)` — One of the following errors can happen: runtime.network.NotFoundError, runtime.network.NetworkError, runtime.n
- `void cancel()`

**EventTag** _(Enum)_

- `OTHER`
- `FEEDBACK`
- `CHAT`
- `LOCAL_CHAT` — Same as Chat but limited by distance that you can see it from
- `DRAWBRIDGE` — Temporary issues
- `CLOSED`
- `RECONSTRUCTION`
- `ACCIDENT`
- `DANGER` — Potentially dangerous zones
- `SCHOOL`
- `OVERTAKING_DANGER`
- `PEDESTRIAN_DANGER`
- `CROSS_ROAD_DANGER`
- `POLICE` — Generalizing tag that has any traffic code control event.
- `LANE_CONTROL` — Traffic code control tags
- `ROAD_MARKING_CONTROL`
- `CROSS_ROAD_CONTROL`
- `NO_STOPPING_CONTROL`
- `MOBILE_CONTROL`
- `SPEED_CONTROL`
- `TRAFFIC_CONTROL`
- `POLICE_PATROL`

**RoadEventsManager** _(Interface)_

- `EventInfoSession requestEventInfo(@NonNull java.lang.String eventId, @NonNull EventInfoListener eventInfoListener)` — Begins asynchronous request for road event info.


### `com.yandex.mapkit.uri` — не обёрнуто типов: 2

**Uri** _(Class)_

- ctor `Uri(@NonNull java.lang.String value)`
- ctor `Uri()`
- `java.lang.String getValue()` — Gets URI.

**UriObjectMetadata** _(Class)_

- ctor `UriObjectMetadata()`
- ctor `UriObjectMetadata(@NonNull java.util.List<Uri> uris)`
- `synchronized java.util.List<Uri> getUris()` — Gets a list of URIs.
- `static java.lang.String getNativeName()`


### `com.yandex.mapkit.images` — не обёрнуто типов: 2

**ImageDataDescriptor** _(Class)_

- ctor `ImageDataDescriptor(@NonNull java.lang.String imageId, @Nullable java.lang.Integer primaryColor, @Nullable java.lang.Integer secondaryColor, @Nullable java.lang.Integer tertiaryColor)`
- ctor `ImageDataDescriptor()`
- `java.lang.String getImageId()`
- `java.lang.Integer getPrimaryColor()` — Optional field, can be null.
- `java.lang.Integer getSecondaryColor()` — Optional field, can be null.
- `java.lang.Integer getTertiaryColor()` — Optional field, can be null.

**ImageUrlProvider** _(Interface)_

- `java.lang.String formatUrl(@NonNull ImageDataDescriptor descriptor)` — Generates an URL that is used to load described image.


### `com.yandex.mapkit.personalized_poi` — не обёрнуто типов: 2

**PersonalizedPoiExtraMetadata** _(Class)_

- ctor `PersonalizedPoiExtraMetadata()`
- ctor `PersonalizedPoiExtraMetadata(@NonNull java.util.List<PersonalizedPoiExtraMetadataEntry> data)`
- `synchronized java.util.List<PersonalizedPoiExtraMetadataEntry> getData()`
- `static java.lang.String getNativeName()`

**PersonalizedPoiExtraMetadataEntry** _(Class)_

- ctor `PersonalizedPoiExtraMetadataEntry()`
- ctor `PersonalizedPoiExtraMetadataEntry(@Nullable java.lang.String key, @Nullable java.lang.String value)`
- `synchronized java.lang.String getKey()` — Optional field, can be null.
- `synchronized java.lang.String getValue()` — Optional field, can be null.
- `static java.lang.String getNativeName()`


### `com.yandex.mapkit.navigation` — не обёрнуто типов: 5

**JamSegment** _(Class)_

- ctor `JamSegment(@NonNull JamType jamType, double speed)`
- ctor `JamSegment()`
- `JamType getJamType()` — The type of the traffic jam.
- `double getSpeed()` — The speed at which traffic is moving.

**JamStyle** _(Class)_

- ctor `JamStyle()`
- ctor `JamStyle(@NonNull java.util.List<JamTypeColor> colors)`
- `synchronized java.util.List<JamTypeColor> getColors()` — Collection of colors for traffic intensity.
- `static java.lang.String getNativeName()`

**JamType** _(Enum)_

- `UNKNOWN` — Unknown intensity.
- `BLOCKED` — Route is blocked.
- `FREE` — Route is free.
- `LIGHT` — Light traffic on route.
- `HARD` — Heavy traffic on route.
- `VERY_HARD` — Very heavy traffic on route.

**JamTypeColor** _(Class)_

- ctor `JamTypeColor(@NonNull JamType jamType, int jamColor)`
- ctor `JamTypeColor()`
- `JamType getJamType()` — The type of the traffic jam.
- `int getJamColor()` — Traffic jam color.

**RoutePosition** _(Interface)_

- `boolean onRoute(@NonNull java.lang.String routeId)` — Check if this position on the same route as passed.
- `PolylinePosition positionOnRoute(@NonNull java.lang.String routeId)` — Return polyline position on route.
- `Point getPoint()` — As point on the map
- `RoutePosition advance(double distance)` — Create position shifted by distance.
- `java.lang.Double distanceTo(@NonNull RoutePosition to)` — Distance to another point on the route.
- `boolean precedes(@NonNull RoutePosition another)` — Determines if position precedes another position on the route.
- `boolean precedesOrEquals(@NonNull RoutePosition another)` — Determines if position precedes or equals another position on the route.
- `boolean equals(@NonNull RoutePosition another)` — Determines if position equals another position on the route.
- `double heading()` — Heading movement on the route at this position.
- `double distanceToFinish()` — Distance to the end of the route.
- `double timeToFinish()` — Time to the end of the route.


### `com.yandex.mapkit.ui` — не обёрнуто типов: 1

**Overlay** _(Interface)_

- `void setImage(@NonNull ImageProvider image, @NonNull ScreenRect rect)` — Sets image as content of overlay, resets view.
- `void setView(@NonNull ViewProvider view, @NonNull ScreenRect rect)` — Sets view as content of overlay, resets image.
- `void remove()` — Removes the overlay from the map.
- `boolean isValid()` — Tells if this Overlay is valid or not.


### `com.yandex.runtime` — не обёрнуто типов: 8

**DataProviderWithId** _(Interface)_

- `java.lang.String providerId()` — Use the same id for the identical data, to prevent repeated loading of the same data into RAM and VRAM.
- `byte[] load()` — Returns data.

**DiskCorruptError** _(Interface)_


**DiskFullError** _(Interface)_


**DiskWriteAccessError** _(Interface)_


**Error** _(Interface)_

- `boolean isValid()` — Tells if this Error is valid or not.

**KeyValuePair** _(Class)_

- ctor `KeyValuePair(@NonNull java.lang.String key, @NonNull java.lang.String value)`
- ctor `KeyValuePair()`
- `java.lang.String getKey()` — Data key.
- `java.lang.String getValue()` — Data value.

**LocalError** _(Interface)_


**TypeDictionary** _(Interface)_

- `U getItem(java.lang.Class cls)`
- `java.util.Map<java.lang.String, T> getAllItems()`


### `com.yandex.runtime.image` — не обёрнуто типов: 3

**AnimatedImage** _(Class)_

- ctor `AnimatedImage(int loopCount, java.util.List<Frame> frames)`
- ctor `AnimatedImage(int loopCount)`
- `void addFrame(ImageProvider image, long duration)`
- `java.util.List<Frame> getFrames()` — Returns a list of animation frames.
- `int getLoopCount()` — Returns the number of animation loops.

**AnimatedImageProvider** _(Class)_

- ctor `AnimatedImageProvider()`
- `abstract java.lang.String getId()` — Returns the unique identifier for the image.
- `abstract java.lang.Object getImage()` — Returns an animated image data buffer.
- `static AnimatedImageProvider fromByteArray(byte[] image)` — Returns an animated image provider based on the given data.
- `static AnimatedImageProvider fromResource(android.content.Context context, int resourceId)` — Returns an animated image provider based on a given resource.
- `static AnimatedImageProvider fromAsset(android.content.Context context, java.lang.String assetName)` — Returns an animated image provider based on a given asset (from the assets/ directory).
- `static AnimatedImageProvider fromFile(java.lang.String fileName)` — Returns an animated image provider based on an image file from the internal storage.
- `static AnimatedImageProvider fromAnimatedImage(AnimatedImage image)` — Returns an animated image provider.

**Frame** _(Class)_

- ctor `Frame(ImageProvider image, long duration)`
- `ImageProvider getImage()` — Returns a provider of the frame image.
- `long getDuration()` — Returns the number of milliseconds the image is displayed.


### `com.yandex.runtime.ui_view` — не обёрнуто типов: 1

**ViewProvider** _(Class)_

- ctor `ViewProvider(android.view.View view, boolean cacheable)`
- ctor `ViewProvider(android.view.View view)`
- `java.lang.String getId()` — Unique ID of the view provider.
- `boolean isCacheable()` — True if view provider is cacheable.
- `void snapshot()` — Takes a snapshot of the given view.


### `com.yandex.runtime.view` — не обёрнуто типов: 3

**BufferedRunnable** _(Class, вложенный)_

- ctor `BufferedRunnable()`
- `java.lang.Runnable add(@NonNull java.lang.Runnable runnable)`

**Surface** _(Interface)_

- `android.graphics.PointF getAnchorPoint()` — Anchor shifts the region of the frame that will be rendered on the surface.
- `void setAnchorPoint(@NonNull android.graphics.PointF anchorPoint)`

**SurfaceFactory** _(Class)_

- ctor `SurfaceFactory()`
- `static native Surface from(android.view.Surface surface)` — Creates a Surface object that wrap the given Android Surface object.


### `com.yandex.runtime.logging` — не обёрнуто типов: 5

**LogLevel** _(Enum, вложенный)_

- `ERROR`
- `WARNING`
- `INFO`
- `DEBUG`

**LogListener** _(Interface)_

- `void onMessageReceived(@NonNull LogMessage message)` — Called when a new log message is received.

**LogMessage** _(Class)_

- ctor `LogMessage(long time, @NonNull LogLevel level, @NonNull java.lang.String scope, @NonNull java.lang.String message, @NonNull java.lang.String verboseInfo)`
- ctor `LogMessage()`
- `long getTime()` — Absolute timestamp of the log message.
- `LogLevel getLevel()` — Severity level of the log message.
- `java.lang.String getScope()` — Scope or category of the log message.
- `java.lang.String getMessage()` — The log message content.
- `java.lang.String getVerboseInfo()` — Additional verbose information about the log message.

**Logging** _(Interface)_

- `void subscribe(@NonNull LogListener logListener)` — Subscribes a listener to receive log messages.
- `void unsubscribe(@NonNull LogListener logListener)` — Unsubscribes a listener from receiving log messages.
- `boolean isValid()` — Tells if this Logging is valid or not.

**LoggingFactory** _(Class)_

- ctor `LoggingFactory()`
- `static native Logging getLogging()` — Returns the Logging instance for subscribing to log messages.


### `com.yandex.runtime.i18n` — не обёрнуто типов: 6

**CanonicalUnit** _(Class)_

- ctor `CanonicalUnit(@NonNull java.lang.String unit, double value)`
- ctor `CanonicalUnit()`
- `java.lang.String getUnit()` — The unit of measurement.
- `double getValue()` — The numerical value.

**I18nManager** _(Interface)_

- `java.lang.String localizeDistance(int distance)` — Converts a distance value to the current locale.
- `java.lang.String localizeDuration(int duration)` — Converts a duration to the current locale.
- `java.lang.String localizeSpeed(double speed)` — Converts speed to the current locale.
- `java.lang.String localizeDataSize(long dataSize)` — Converts data size to the current locale.
- `CanonicalUnit canonicalSpeed(double speed)` — Represents the speed with the value and unit of measurement separated.
- `java.lang.String localizeCanonicalUnit(@NonNull CanonicalUnit canonicalUnit)` — Localizes a value represented by canonical units.
- `I18nPrefs getPrefs()` — Localization preferences.
- `void setPrefs(@NonNull I18nPrefs prefs)`
- `SystemOfMeasurement getSom()` — System of measurement used.
- `void setSom(@NonNull SystemOfMeasurement som)`
- `TimeFormat getTimeFormat()` — Preferred time format.
- `void setTimeFormat(@NonNull TimeFormat timeFormat)`
- `boolean isValid()` — Tells if this I18nManager is valid or not.

**I18nManagerFactory** _(Class)_

- ctor `I18nManagerFactory()`
- `static native java.lang.String getLocale()` — Returns the locale currently used by the runtime.
- `static native void setLocale(@Nullable java.lang.String locale)` — Sets the application's locale.
- `static native I18nManager getI18nManagerInstance()` — Gets the internationalization manager interface.

**I18nPrefs** _(Class)_

- ctor `I18nPrefs(@NonNull SystemOfMeasurement som, @NonNull TimeFormat timeFormat)`
- ctor `I18nPrefs()`
- `SystemOfMeasurement getSom()` — System of measurement (metric or imperial).
- `TimeFormat getTimeFormat()` — Time format (12- or 24-hour).

**SystemOfMeasurement** _(Enum)_

- `DEFAULT`
- `METRIC` — Metric system.
- `IMPERIAL` — Imperial system.

**TimeFormat** _(Enum)_

- `DEFAULT`
- `H24` — 24-hour time format.
- `H12` — 12-hour time format with AM/PM marker.


### `com.yandex.runtime.network` — не обёрнуто типов: 7

**BadRequestError** _(Interface)_


**ForbiddenError** _(Interface)_


**NetworkError** _(Interface)_


**NotFoundError** _(Interface)_


**RemoteError** _(Interface)_


**RequestEntityTooLargeError** _(Interface)_


**UnauthorizedError** _(Interface)_



### `com.yandex.runtime.auth` — не обёрнуто типов: 3

**Account** _(Interface)_

- `java.lang.String uid()` — Get the user's UID<br>This method may be called on any thread.
- `void requestToken(@NonNull TokenListener tokenListener)` — Makes a token request for the provider.
- `void invalidateToken(@NonNull java.lang.String token)` — Invalidates the OAuth token for an active account.
- `java.lang.String httpAuth(@NonNull java.lang.String token)` — Creates the HTTP authorization header for requests.

**PasswordRequiredData** _(Interface)_


**TokenListener** _(Interface)_

- `void onTokenReceived(@NonNull java.lang.String token)` — Token was received.
- `void onPasswordRequired(@NonNull PasswordRequiredData data)` — XToken is not valid anymore.
- `void onTokenRefreshFailed(@NonNull java.lang.String message)` — An error occurred during OAuth token refresh (it might be a network error or an invalid response from the auth


### `com.yandex.runtime.config` — не обёрнуто типов: 1

**ExperimentData** _(Class)_

- ctor `ExperimentData(int testId, int userGroup, int userBucket)`
- ctor `ExperimentData()`
- `int getTestId()`
- `int getUserGroup()`
- `int getUserBucket()`


### `com.yandex.runtime.annotation` — не обёрнуто типов: 1

**BridgedStruct** _(Class)_

