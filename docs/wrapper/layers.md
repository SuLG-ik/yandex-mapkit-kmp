# Layers and tiles

A layer is a horizontal slice of the map with its own place in the render order. MapKit's own layers
are named in `LayerIds`; you add your own next to them, either with tiles of your own or with a
separate collection of map objects.

## A custom tile layer

`Map.addTileLayer` takes an id, the layer options and a callback that configures the data source.
The callback runs once, when the layer is created.

```kotlin
val layer: Layer = map.addTileLayer(
    layerId = "weather",
    layerOptions = LayerOptions(
        transparent = true,
        nightModeAvailable = false,
        cacheable = true,
    ),
) { builder ->
    builder.setTileUrlProvider(
        UrlProvider { tileId, _, _ ->
            "https://tiles.example.com/${tileId.z}/${tileId.x}/${tileId.y}.png"
        },
    )
    builder.setProjection(Projections.wgs84Mercator)
    builder.setZoomRanges(listOf(ZoomRange(zMin = 0, zMax = 19)))
    builder.setTileFormat(TileFormat.PNG)
}
```

`layerId` also decides where the layer sits: MapKit orders layers by id against its own, so an id
compared against `LayerIds` is how you get above or below the traffic layer, the buildings or the
map objects.

### `LayerOptions`

| Option | Default | What it does |
|---|---|---|
| `active` | `true` | an inactive layer draws nothing and requests no tiles |
| `nightModeAvailable` | `false` | the layer has a night variant |
| `cacheable` | `true` | tiles are kept on disk |
| `animateOnActivation` | `true` | activation fades in |
| `tileAppearingAnimationDuration` | `150.milliseconds` | how long a tile fades in |
| `overzoomMode` | `DISABLED` | `ENABLED` / `WITH_PREFETCH` fill gaps from adjacent zoom levels |
| `transparent` | `false` | lower layers show through |
| `versionSupport` | `false` | the layer is versioned |

### Serving tiles yourself

`setTileProvider` replaces the URL with a function that returns the bytes, which is how you serve
tiles rendered on the device or read from a bundled file:

```kotlin
builder.setTileProvider(
    TileProvider { tileId, version, _, etag ->
        RawTile(
            version = version,
            features = emptyMap(),
            etag = etag,
            useCache = RawTile.UseCache.YES,
            state = RawTile.State.OK,
            rawData = render(tileId),
        )
    },
)
```

Return `RawTile.State.NOT_MODIFIED` when `etag` says the tile has not changed, and
`RawTile.State.ERROR` when it cannot be produced.

### Driving the layer afterwards

`Layer` itself only removes; everything else is on its `DataSourceLayer`:

```kotlin
val dataSource = layer.dataSourceLayer()

dataSource.isActive = false
dataSource.setStyle(id = 0, style = """[{"stylers": {"opacity": 0.5}}]""")
dataSource.resetStyles()
dataSource.clear()

layer.remove()
```

Two subscriptions report what the layer is doing. Both take a single listener, and `null` clears it:

```kotlin
private val layerLoadedListener = LayerLoadedListener { println("tiles on screen") }
private val dataSourceListener = DataSourceListener { println("data source updated") }

dataSource.setLayerLoadedListener(layerLoadedListener.asWeakRef())
dataSource.setDataSourceListener(dataSourceListener.asWeakRef())
```

### Projections

`Projections.wgs84Mercator` is what Yandex tiles use; `Projections.sphericalMercator` is the
web-mercator most third-party tile servers serve. `map.projection()` returns the projection of the
map itself, and converts between world coordinates and tile coordinates:

```kotlin
val xy: XYPoint = map.projection().worldToXY(Point(55.751225, 37.629540), zoom = 15)
val back: Point = map.projection().xyToWorld(xy, zoom = 15)
```

## A layer of map objects

`Map.addMapObjectLayer` gives back a `RootMapObjectCollection` that is not the map's default one and
sits at the layer id you name — the way to put a group of objects above or below something MapKit
draws.

```kotlin
val routeObjects = map.addMapObjectLayer("my-routes")
routeObjects.addPolyline(Polyline(points))
```

!!! warning "One collection per id, for the lifetime of the map"
    MapKit links a collection to a layer id and cannot unlink it, so asking twice for the same id
    throws. Create it once and keep it; to empty it, use `clear()`.

    The Compose `MapObjectLayer` handles this for you — it caches the collection per id and only
    clears it when the composable leaves.

## Traffic

```kotlin
class TrafficController(mapKit: MapKit, mapWindow: MapWindow) {

    private val layer = mapKit.createTrafficLayer(mapWindow)

    private val trafficListener = TrafficListener(
        onTrafficChanged = { level ->
            if (level != null) show(level.level, level.color)
        },
        onTrafficLoading = { showSpinner() },
        onTrafficExpired = { showStale() },
    )

    init {
        layer.isTrafficVisible = true
        layer.addTrafficListener(trafficListener.asWeakRef())
    }
}
```

`TrafficLevel` is a number 0..10 plus a `TrafficColor` (`GREEN`, `YELLOW`, `RED`). `onTrafficChanged`
is called with `null` while the level is unknown.

The layer takes JSON styles too:

```kotlin
layer.setTrafficStyle("""[{"stylers": {"opacity": 0.6}}]""")
layer.setTrafficStyle(id = 1, style = dimJams)
layer.resetTrafficStyles()
```

Both style setters return whether the style was accepted.

## In Compose

Both kinds of layer are composables that remove themselves when they leave the composition:

```kotlin
YandexMap(modifier = Modifier.fillMaxSize()) {
    TrafficLayer(onTrafficChanged = { level = it })

    TileLayer(
        layerId = "weather",
        options = LayerOptions(transparent = true),
        onLayerLoaded = { println("weather tiles are on screen") },
    ) { builder ->
        builder.setTileUrlProvider(
            UrlProvider { tileId, _, _ ->
                "https://tiles.example.com/${tileId.z}/${tileId.x}/${tileId.y}.png"
            },
        )
        builder.setProjection(Projections.wgs84Mercator)
        builder.setZoomRanges(listOf(ZoomRange(zMin = 0, zMax = 19)))
        builder.setTileFormat(TileFormat.PNG)
    }

    MapObjectLayer(layerId = "my-routes") {
        Polyline(state = rememberPolylineState(route))
    }
}
```

See [Compose overview](../compose/overview.md#custom-tile-layers) for the parameters.
