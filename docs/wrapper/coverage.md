# What is wrapped

The wrapper targets the **lite** build of MapKit (`4.42.0-lite`). Everything the lite SDK exposes on
both Android and iOS is available from common code; the sections below are a map of where to look.

## Map and map objects

`ru.sulgik.mapkit.map` mirrors `com.yandex.mapkit.map`: `Map`, `MapWindow`, `CameraPosition`,
`VisibleRegion`, the `MapObject` hierarchy (`PlacemarkMapObject`, `PolylineMapObject`,
`PolygonMapObject`, `CircleMapObject`, `MapObjectCollection`, `RootMapObjectCollection`,
`ClusterizedPlacemarkCollection`) and every listener MapKit calls back on.

A placemark can be driven either through the shortcut methods (`setIcon`, `setText`,
`setScaleFunction`) or through the presentation objects — `useIcon()`, `useCompositeIcon()`,
`useModel()`, `useAnimation()` and `text` return `Icon`, `CompositeIcon`, `Model`,
`PlacemarkAnimation` and `PlacemarkText`.

Animated icons and polygon patterns take an `AnimatedImageProvider`, which is built either from raw
data (`fromByteArray`, `fromFile`) or frame by frame with `AnimatedImage` and `Frame`.

## Base map objects

A tap on a POI, a building or a toponym arrives as a `layers.GeoObjectTapEvent` carrying a
`GeoObject`. Its metadata is read through the typed accessors `selectionMetadata`,
`inspectionMetadata` and `tags` — MapKit stores it in a dictionary keyed by native classes, which
has no common representation, so the wrapper exposes the entries instead of the container.
`uriMetadata` and `personalizedPoiMetadata` read the remaining metadata kinds the lite SDK
attaches. `Map.selectGeoObject` takes the selection metadata back.

`Map.setMapLoadedListener` reports `MapLoadStatistics` once the visible tiles are rendered.

## Layers and tiles

`Map.addTileLayer` creates a custom tile layer: the `TileDataSourceBuilder` handed to it takes a
`tiles.UrlProvider` or a `tiles.TileProvider`, a `geometry.geo.Projection`, the `ZoomRange` list and
the `TileFormat`. The resulting `layers.Layer` gives access to its `DataSourceLayer`, which manages
visibility, JSON styles and the `LayerLoadedListener` / `DataSourceListener` subscriptions.
`Map.addMapObjectLayer` does the same for a collection of map objects.

## Traffic, storage and offline maps

`MapKit.createTrafficLayer` returns a `traffic.TrafficLayer` with its `TrafficListener` and
`TrafficLevel`. `MapKit.storageManager` computes and caps the space MapKit occupies;
`MapKit.offlineCacheManager` downloads regions, reports their `RegionState` and progress, and moves
the cache to another folder.

## Geolocation

Besides `LocationManager` and `LocationListener`, the wrapper covers the simulation side:
`MapKit.createLocationSimulator` replays a `Polyline` with `SimulationSettings` and
`LocationSettings`, and `MapKit.createDummyLocationManager` pushes positions in by hand.
`lastKnownLocation()` returns the last position MapKit received.

MapKit derives `LocationSimulator` from `LocationManager`. Kotlin cannot express that inheritance
across the two platforms, so `LocationSimulator.asLocationManager()` returns the same object seen as
a `LocationManager`, which is where `subscribeForLocationUpdates`, `requestSingleUpdate`,
`unsubscribe`, `suspend` and `resume` live. The simulator is created **suspended** and
`startSimulation` does not resume it, so call `resume()` on the view to make `isActive` true and let
the simulated locations reach the subscribers:

=== "Kotlin"

    ```kotlin
    val simulator = mapKit.createLocationSimulator(route)
    simulator.asLocationManager().resume()
    simulator.startSimulation(settings)
    ```

The result is a plain `LocationManager`, so it can also be passed to `MapKit.setLocationManager()`
or turned into a `LocationViewSource` with `toLocationViewSource()`.

## Runtime

`runtime.Error` and its subtypes (`LocalError`, `DiskFullError`, `NetworkError`, `RemoteError`, …)
type the failures the listeners report. `runtime.logging.Logging` subscribes to the MapKit log
stream, and `runtime.i18n.I18nManager` formats distances, durations, speeds and data sizes for the
current locale.

## Compose

`yandex-mapkit-kmp-compose` renders the map objects (`Placemark`, `Polyline`, `Polygon`, `Circle`,
`Clustering`), groups them with `MapObjectCollection` or puts them on a layer of their own with
`MapObjectLayer`, and adds the map-wide layers — `TrafficLayer` and `TileLayer`. `MapConfig` covers
`Map` and `MapWindow`; `MapListeners` covers the map events.

Whatever a parameter cannot express lives on the state object: every `MapObjectState` animates
visibility with `setVisible(visible, animation)`, `PlacemarkState` reaches `useIcon()`,
`useCompositeIcon()`, `useModel()`, `useAnimation()`, `text` and `setScaleFunction()`,
`PolylineState` selects and hides subpolylines and colours segments through the palette,
`PolygonState` sets an animated pattern, and `MapObjectCollectionState` reaches the shared
`PlacemarksStyler` and `traverse`. Anything still missing is one `MapEffect` away.

## Not wrapped

- **Full-build API.** Search, routing, panoramas, road events and the personalization API
  (`MapKit.setAccount`, `MapKit.createOffscreenMapWindow`) do not exist in the lite build.
- **`BaseDataSourceBuilder` and `mapkit.images`.** The types exist in the lite build but nothing
  hands one out — `Map.addTileLayer` builds a `TileDataSourceBuilder` instead.
- **`ViewProvider`.** MapKit can render a native `View` / `UIView` into an icon. There is no common
  shape for it; the Compose module covers the same ground with `imageProvider { }`.
- **`ImageProvider.id` / `isCacheable`.** They exist on Android only — iOS MapKit takes a plain
  `UIImage` — so they stay parameters of the Android factories.
