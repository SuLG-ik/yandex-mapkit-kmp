# MapKit API backlog

Живой список API Yandex MapKit, который ещё не обёрнут в `yandex-mapkit-kmp`.

Актуально для **MapKit 4.42.0-lite**. Собрано диффом публичного API `com.yandex.android:maps.mobile`
между `4.24.0-lite` и `4.42.0-lite` и сверкой с ObjC-заголовками `YandexMapsMobile 4.42.0-lite`.

---

## Что уже закрыто в обновлении 4.24.0 → 4.42.0

| API | Где |
|---|---|
| Листенеры через слабые ссылки (`WeakRef<T>`) | `ru.sulgik.mapkit.WeakRef`, все методы подписки |
| `MapMode.HYBRID` | `ru.sulgik.mapkit.map.MapMode` |
| `LocationPurpose.STATIC_DISPLAY_LOCATION` | `ru.sulgik.mapkit.location.LocationPurpose` |
| `IconStyle.opacity` | `ru.sulgik.mapkit.map.IconStyle` |
| `setMapFps(Float)` → `setMapFps(Int)` | `ru.sulgik.mapkit.map.MapWindow` |
| Новый порядок аргументов `cameraPosition(geometry, focusRect, azimuth, tilt)` | `Map.calculateCameraPosition` |

---

## Не поддержано: добавлено в 4.25–4.42

### `Map`

- **Прозрачный фон карты** (4.41). `setTransparentBackgroundEnabled(Boolean)` /
  `isTransparentBackgroundEnabled`. Просится свойством `var isTransparentBackgroundEnabled: Boolean`
  рядом с `isHdModeEnabled`, плюс поле в `MapConfig` compose-модуля.
- **Здания поверх indoor-плана**. `setBuildingsAboveIndoorEnabled(Boolean)` /
  `isBuildingsAboveIndoorEnabled`. Свойство `var isBuildingsAboveIndoorEnabled: Boolean`; логически
  в пару к существующему `isIndoorEnabled`.
- **Перегрузки `cameraPosition` с необязательными azimuth/tilt**:
  `cameraPosition(Geometry, ScreenRect?, Float?)` и `cameraPosition(Geometry, ScreenRect?, Float?, Float?)`.
  Сейчас обёрнут только вариант с обязательными `azimuth` и `tilt`. Даёт «посчитай позицию, но
  азимут оставь текущим».

### `MapObject`

- **Анимированная смена видимости**: `setVisible(Boolean, Animation)` и
  `setVisible(Boolean, Animation, Callback)`. Сейчас есть только `var isVisible: Boolean` без
  анимации.

### `MapView`

- `destroy()` — явное освобождение ресурсов вью. Стоит проверить, нужно ли звать его из
  compose-обвязки при уходе `YandexMap` из композиции.

### `CompositeIcon`

Тип не обёрнут целиком, а в 4.42 у него появился короткий `setIcon(String, ImageProvider)` без
`IconStyle`. Нужен, если захочется составные иконки плейсмарков.

### `Model`

- `setData(DataProviderWithId)` — подача данных 3D-модели с идентификатором. Сам `Model` не обёрнут.

### `Size2u`

Новый тип `com.yandex.mapkit.Size2u` (пара `width`/`height` в беззнаковых). Пока не используется ни
одним обёрнутым API — обернуть вместе с тем, что его потребует.

### Логирование (4.38.1)

`Logging`, `LoggingFactory`, `LogListener`, `LogMessage` — подписка на внутренние логи MapKit.
Изолированная фича, обернуть несложно; полезно для диагностики у пользователей SDK.

### Аккаунты и авторизация (4.39.1)

`com.yandex.runtime.auth.Account`, `TokenListener`, `PasswordRequiredData`. Нужно, только если
появится задача про закладки Яндекс.Карт или персонализацию.

### Настройки геолокации

- `LocationSettingsFactory` — фабрика `LocationSettings`.
- `LocationSettings` получил fluent-сеттеры (`setAccuracy`, `setProvideHeading`, `setSpeed`, …).
- Сам `LocationSettings` во враппере не представлен: обёрнуты только `LocationManager`,
  `SubscriptionSettings`, `LocationPurpose`.

### `LocationSimulator`

Не обёрнут. В 4.42 у него сменился API: `startSimulation(SimulationAccuracy)` заменён на
`startSimulation(List<SimulationSettings>)`, а `setGeometry` / `getGeometry` /
`setLocationSpeedProviding` убраны. Тип `SimulationAccuracy` удалён из SDK.

---

## Не поддержано: было и до 4.25

Подсистемы MapKit, которых во враппере нет вообще. В 4.41 у всех них подписки переехали на
`WeakReference`, так что обёртки сразу надо писать под новую схему.

| Подсистема | Ключевые типы |
|---|---|
| Пробки | `TrafficLayer`, `TrafficListener`, `TrafficLevel` |
| Офлайн-кеш | `OfflineCacheManager`, `RegionListener`, `RegionListUpdatesListener`, `DataMoveListener` |
| Хранилище | `StorageManager`, `StorageErrorListener` |
| Слои данных | `DataSourceLayer`, `DataSourceListener`, `LayerLoadedListener` |
| Загрузка карты | `Map.setMapLoadedListener`, `MapLoadedListener` |
| Тап по гео-объектам | `Map.addTapListener(GeoObjectTapListener)` |

---

## Заметки по миграции

- `SimulationAccuracy` удалён из SDK — во враппере не использовался, миграция не требуется.
- `NativeObject.finalize()` и `NativeObject.Cleaner` убраны: MapKit перешёл на другой механизм
  освобождения нативной памяти. На враппер не влияет, но при отладке утечек искать надо не там.
- Структуры с данными на нативной стороне помечены аннотацией `BridgedStruct` (4.41) — чисто
  внутренняя деталь MapKit.
