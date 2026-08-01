# Объекты базовой карты

Всё, что рисует сам MapKit — POI, здания, топонимы, дороги, — это **объекты базовой карты**. Вы их не
создаёте; вы реагируете на нажатия по ним и читаете их метаданные.

## Реакция на нажатие

`GeoObjectTapListener` срабатывает раньше, чем `InputListener` карты. Вернуть `true` — поглотить
событие, `false` — пропустить его дальше, в `onMapTap`.

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

`event.isValid` говорит, пригодно ли событие: оно инвалидируется, как только колбэк вернул
управление, поэтому ничего из него нельзя сохранять на потом.

## Выделение объекта

MapKit умеет подсветить нажатый объект своим стилем выделения — так делает приложение Яндекс.Карт
при нажатии на POI. Для этого нужны `GeoObjectSelectionMetadata` объекта:

```kotlin
private val tapListener = GeoObjectTapListener { event ->
    val metadata = event.geoObject.selectionMetadata ?: return@GeoObjectTapListener false
    map.selectGeoObject(metadata)
    true
}
```

`map.deselectGeoObject()` снимает выделение.

Вернуть здесь `true` важно: если событие пойдёт дальше, нажатие дойдёт ещё и до `onMapTap` со всем,
что там происходит.

## Чтение метаданных

MapKit держит метаданные объекта в словаре с ключами-нативными классами, у которого нет общего
представления. Обёртка отдаёт те записи, которые прикрепляет lite SDK, каждую как nullable-свойство:

| Свойство | Тип | Что несёт |
|---|---|---|
| `selectionMetadata` | `GeoObjectSelectionMetadata` | `objectId`, `dataSourceName`, `layerId`, `groupId` — то, что нужно `selectGeoObject` |
| `inspectionMetadata` | `GeoObjectInspectionMetadata` | `layerId` и `ObjectType` — `POINT`, `POLYLINE`, `POLYGON`, `CIRCLE` |
| `tags` | `GeoObjectTags` | список тегов объекта, например вид POI |
| `uriMetadata` | `UriObjectMetadata` | `Uri`, которые идентифицируют объект в других сервисах Яндекса |
| `personalizedPoiMetadata` | `PersonalizedPoiExtraMetadata` | пары ключ/значение персонализированного POI |

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

## Сам объект

| Свойство | Тип |
|---|---|
| `name` | `String?` |
| `descriptionText` | `String?` |
| `geometry` | `List<Geometry>` |
| `boundingBox` | `BoundingBox?` |
| `aref` | `List<String>` |
| `attributionMap` | `Map<String, Attribution>` |

`geometry` — список, потому что один объект может состоять из нескольких фигур. В каждой `Geometry`
заполнено ровно одно из `point`, `polyline`, `polygon`, `multiPolygon`, `boundingBox`, `circle`.

```kotlin
val point = geoObject.geometry.firstNotNullOfOrNull { it.point }

if (point != null) {
    map.move(
        CameraPosition(point, zoom = 17f, azimuth = 0f, tilt = 0f),
        Animation(Animation.Type.SMOOTH, 300.milliseconds),
    )
}
```

`attributionMap` сопоставляет идентификатор атрибуции с `Attribution`, где лежат `author`, `link` и
`avatarImage` — то, что нужно показать рядом со сторонними данными.

## Приблизиться к нажатому объекту

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

## В Compose

`MapListeners` подключает тот же слушатель на время нахождения в композиции:

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

## Идентификаторы слоёв

`layerId` в метаданных — один из идентификаторов, которыми MapKit называет свои слои; они
перечислены в `LayerIds`:

```kotlin
LayerIds.mapLayerId
LayerIds.jamsLayerId
LayerIds.buildingsLayerId
LayerIds.transportLayerId
LayerIds.mapObjectsLayerId
LayerIds.userLocationLayerId
```

С ними же вы сравниваете идентификатор, когда добавляете собственный слой — см.
[Слои и тайлы](layers.md).
