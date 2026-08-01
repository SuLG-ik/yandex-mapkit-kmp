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
| `setMaxFps(Float)` → `setMaxFps(Int)` | `ru.sulgik.mapkit.map.MapWindow` |
| Новый порядок аргументов `cameraPosition(geometry, focusRect, azimuth, tilt)` | `Map.cameraPosition` |
| `RootMapObjectCollection`, `ConflictResolutionMode` | `ru.sulgik.mapkit.map`, `ru.sulgik.mapkit` |

---

## Не поддержано

Весь lite-доступный API MapKit 4.42 обёрнут — см. `docs/wrapper/coverage.md` и раздел
«Этапы 2–8» в `MAPKIT_COVERAGE_AUDIT.md`. Осталось только то, что сознательно оставлено за бортом:

| API | Почему |
|---|---|
| `MapKit.setAccount`, `runtime.auth.*` | в lite-сборке у `MapKit` нет `setAccount` |
| `MapKit.createOffscreenMapWindow`, `map.OffscreenMapWindow` | в lite-сборке метода нет |
| `MapKit.createRoadEventsManager`, `road_events.*` | доступно только в полной сборке |
| Поиск, маршрутизация, панорамы | доступно только в полной сборке |
| `runtime.ui_view.ViewProvider` и `setView`-перегрузки | нет общей формы у `View` и `UIView`; в compose роль закрывает `imageProvider { }` |
| `MapWindow.addSurface` / `removeSurface` | требует `runtime.view.Surface`, Android-специфично |
| `runtime.TypeDictionary` | ключуется нативными классами; у `GeoObject` есть типизированные аксессоры |
| `offline_cache.DownloadNotificationsListener` | работает только с `MapKitFactory.initializeBackgroundDownload`, который принимает internal-тип |

---

## Заметки по миграции

- `SimulationAccuracy` удалён из SDK — во враппере не использовался, миграция не требуется.
- `NativeObject.finalize()` и `NativeObject.Cleaner` убраны: MapKit перешёл на другой механизм
  освобождения нативной памяти. На враппер не влияет, но при отладке утечек искать надо не там.
- Структуры с данными на нативной стороне помечены аннотацией `BridgedStruct` (4.41) — чисто
  внутренняя деталь MapKit.
