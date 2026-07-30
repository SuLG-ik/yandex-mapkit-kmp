# `com.yandex.mapkit.map`

Пакет справочника MapKit SDK для Android. Типов: **61**.

[← Ко всей документации](../../../../README.md) · [Все пакеты Android](../../../../INDEX-android.md)

## Interface (38)

| Тип | Описание |
| --- | --- |
| [Arrow](Arrow.md) | The arrow element. |
| [BaseDataSourceBuilder](BaseDataSourceBuilder.md) |   |
| [BaseMapObjectCollection](BaseMapObjectCollection.md) |   |
| [Callback](Callback.md) |   |
| [CameraBounds](CameraBounds.md) | The object that is used to interact with the map bounds. |
| [CameraCallback](CameraCallback.md) |   |
| [CameraListener](CameraListener.md) | Listens for updates to the camera position. |
| [CircleMapObject](CircleMapObject.md) |   |
| [Cluster](Cluster.md) |   |
| [ClusterizedPlacemarkCollection](ClusterizedPlacemarkCollection.md) |   |
| [ClusterListener](ClusterListener.md) |   |
| [ClusterTapListener](ClusterTapListener.md) |   |
| [CompositeIcon](CompositeIcon.md) |   |
| [CreateTileDataSource](CreateTileDataSource.md) |   |
| [Icon](Icon.md) |   |
| [InputListener](InputListener.md) | Listener for user interactions with the map. |
| [Map](Map.md) | The object that is used to interact with the map. |
| [MapLoadedListener](MapLoadedListener.md) | Listener interface for when the map has finished loading. |
| [MapObject](MapObject.md) |   |
| [MapObjectCollection](MapObjectCollection.md) |   |
| [MapObjectCollectionListener](MapObjectCollectionListener.md) | The map object collection can't be modified in callbacks. |
| [MapObjectDragListener](MapObjectDragListener.md) | This listener is notified when a map object is being dragged. |
| [MapObjectTapListener](MapObjectTapListener.md) | If an event is not handled by the source object then it's propagated to its parent. |
| [MapObjectVisitor](MapObjectVisitor.md) | Used to traverse over the children of the MapObjectCollection. |
| [MapWindow](MapWindow.md) | Handles the MapWindow element. |
| [Model](Model.md) |   |
| [OffscreenMapWindow](OffscreenMapWindow.md) | Wraps mapkit.map.MapWindow without its own view to render. |
| [PlacemarkAnimation](PlacemarkAnimation.md) |   |
| [PlacemarkCreatedCallback](PlacemarkCreatedCallback.md) |   |
| [PlacemarkMapObject](PlacemarkMapObject.md) |   |
| [PlacemarkPresentation](PlacemarkPresentation.md) |   |
| [PlacemarksStyler](PlacemarksStyler.md) | Represents a styler for all placemarks in the map object collection, including placemarks in child collections. |
| [PlacemarkText](PlacemarkText.md) | Provides an interface to set text and its style for a placemark. |
| [PolygonMapObject](PolygonMapObject.md) |   |
| [PolylineMapObject](PolylineMapObject.md) |   |
| [RootMapObjectCollection](RootMapObjectCollection.md) |   |
| [SizeChangedListener](SizeChangedListener.md) | Listener for MapWindow size changes. |
| [TileDataSourceBuilder](TileDataSourceBuilder.md) |   |

## Class (13)

| Тип | Описание |
| --- | --- |
| [CameraPosition](CameraPosition.md) | The position of the camera. |
| [GeoObjectInspectionMetadata](GeoObjectInspectionMetadata.md) |   |
| [GeoObjectSelectionMetadata](GeoObjectSelectionMetadata.md) |   |
| [GeoObjectTags](GeoObjectTags.md) |   |
| [IconStyle](IconStyle.md) | The style of created icons. |
| [LayerIds](LayerIds.md) |   |
| [LineStyle](LineStyle.md) | The style of the polyline. |
| [MapLoadStatistics](MapLoadStatistics.md) | The time it took to load map elements. |
| [ModelStyle](ModelStyle.md) | The style of the model. |
| [Rect](Rect.md) | The rectangle to display on the map. |
| [TextStyle](TextStyle.md) | The style of placemarks's text. |
| [VisibleRegion](VisibleRegion.md) | Defines the visible region. |
| [VisibleRegionUtils](VisibleRegionUtils.md) |   |

## Enum (10)

| Тип | Описание |
| --- | --- |
| [CameraUpdateReason](CameraUpdateReason.md) | The reason of the camera update. |
| [GestureFocusPointMode](GestureFocusPointMode.md) | Specifies the way provided zoom focus point affects gestures. |
| [MapMode](MapMode.md) | Supported map style modes |
| [MapType](MapType.md) | The type of map displayed. |
| [ObjectType](GeoObjectInspectionMetadata_ObjectType.md) |   |
| [Placement](TextStyle_Placement.md) | Text placement positions |
| [PointOfView](PointOfView.md) | The point of view. |
| [RenderMode](ModelStyle_RenderMode.md) |   |
| [RotationType](RotationType.md) | The way rotation is handled. |
| [UnitType](ModelStyle_UnitType.md) |   |
