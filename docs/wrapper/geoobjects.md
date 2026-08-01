# Base map objects

Everything drawn by MapKit itself — POIs, buildings, toponyms, roads — is a **base map object**. You
do not create them; you react to taps on them and read their metadata.

## Reacting to a tap

`GeoObjectTapListener` fires before the map's `InputListener`. Returning `true` consumes the event,
`false` lets it fall through to `onMapTap`.

```kotlin
class GeoObjectController(private val map: Map) {

    private val tapListener = GeoObjectTapListener { event ->
        val geoObject = event.geoObject
        println("${geoObject.name}: ${geoObject.descriptionText}")
        false
    }

    init {
        map.addTapListener(tapListener.asWeakRef())
    }
}
```

`event.isValid` tells whether the event is still usable — it is invalidated once the callback
returns, so nothing about it should be kept beyond the call.

## Selecting an object

MapKit can highlight the tapped object with its own selection style, which is what the map
application does when you tap a POI. It needs the object's `GeoObjectSelectionMetadata`:

```kotlin
private val tapListener = GeoObjectTapListener { event ->
    val metadata = event.geoObject.selectionMetadata ?: return@GeoObjectTapListener false
    map.selectGeoObject(metadata)
    true
}
```

`map.deselectGeoObject()` clears it.

Returning `true` here matters: if the event keeps propagating, the tap also reaches `onMapTap` and
whatever it does.

## Reading the metadata

MapKit keeps object metadata in a dictionary keyed by native classes, which has no common
representation. The wrapper exposes the entries the lite SDK attaches, each as a nullable property:

| Property | Type | What it carries |
|---|---|---|
| `selectionMetadata` | `GeoObjectSelectionMetadata` | `objectId`, `dataSourceName`, `layerId`, `groupId` — what `selectGeoObject` needs |
| `inspectionMetadata` | `GeoObjectInspectionMetadata` | `layerId` and the `ObjectType` — `POINT`, `POLYLINE`, `POLYGON`, `CIRCLE` |
| `tags` | `GeoObjectTags` | the object's tag list, e.g. what kind of POI it is |
| `uriMetadata` | `UriObjectMetadata` | `Uri`s that identify the object elsewhere in Yandex services |
| `personalizedPoiMetadata` | `PersonalizedPoiExtraMetadata` | key/value entries of a personalized POI |

```kotlin
private val tapListener = GeoObjectTapListener { event ->
    val geoObject = event.geoObject

    val kind = geoObject.tags?.tags?.firstOrNull()
    val uri = geoObject.uriMetadata?.uris?.firstOrNull()?.value
    val type = geoObject.inspectionMetadata?.objectType

    println("$kind $type $uri")
    false
}
```

## The object itself

| Property | Type |
|---|---|
| `name` | `String?` |
| `descriptionText` | `String?` |
| `geometry` | `List<Geometry>` |
| `boundingBox` | `BoundingBox?` |
| `aref` | `List<String>` |
| `attributionMap` | `Map<String, Attribution>` |

`geometry` is a list because one object can consist of several shapes. Each `Geometry` holds exactly
one of `point`, `polyline`, `polygon`, `multiPolygon`, `boundingBox` or `circle`.

```kotlin
val point = geoObject.geometry.firstNotNullOfOrNull { it.point }

if (point != null) {
    map.move(
        CameraPosition(point, zoom = 17f, azimuth = 0f, tilt = 0f),
        Animation(Animation.Type.SMOOTH, 300.milliseconds),
    )
}
```

`attributionMap` maps an attribution id to an `Attribution` with its `author`, `link` and
`avatarImage` — what has to be shown next to third-party data.

## Zooming to what was tapped

```kotlin
private val tapListener = GeoObjectTapListener { event ->
    val box = event.geoObject.boundingBox ?: return@GeoObjectTapListener false
    map.move(
        map.cameraPosition(box.toGeometry()),
        Animation(Animation.Type.SMOOTH, 300.milliseconds),
    )
    true
}
```

## In Compose

`MapListeners` wires the same listener up for as long as it is in the composition:

```kotlin
YandexMap(modifier = Modifier.fillMaxSize()) {
    MapListeners(
        onGeoObjectTap = { event ->
            val metadata = event.geoObject.selectionMetadata ?: return@MapListeners false
            selection = metadata
            true
        },
    )
    MapEffect(selection) { map ->
        val metadata = selection
        if (metadata != null) map.selectGeoObject(metadata) else map.deselectGeoObject()
    }
}
```

## Layer ids

`layerId` in the metadata is one of the ids MapKit uses for its own layers, listed in `LayerIds`:

```kotlin
LayerIds.mapLayerId
LayerIds.jamsLayerId
LayerIds.buildingsLayerId
LayerIds.transportLayerId
LayerIds.mapObjectsLayerId
LayerIds.userLocationLayerId
```

They are also what you compare against when adding a layer of your own — see
[Layers and tiles](layers.md).
