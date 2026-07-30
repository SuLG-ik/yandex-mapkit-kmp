---
title: "YMKMapObjectCollection"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMapObjectCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapObjectCollection.html"
---
# YMKMapObjectCollection

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapObjectCollection.html)

```swift
class YMKMapObjectCollection : YMKBaseMapObjectCollection
```

A collection of map objects that can hold any set of MapObject items, including nested collections.

## Summary

### Instance methods

```swift
func addPlacemark() -> YMKPlacemarkMapObject
```

Creates a new empty placemark and adds it to the current collection

```swift
func addPlacemark(placemarkCreatedCallback: @escaping YMKPlacemarkCreatedCallback) -> YMKPlacemarkMapObject
```

Creates a new empty placemark and adds it to the current collection

```swift
func addEmptyPlacemark(with point: YMKPoint) -> YMKPlacemarkMapObject
```

Creates a new empty placemark and adds it to the current collection

```swift
func addPlacemark(with point: YMKPoint) -> YMKPlacemarkMapObject
```

Creates a new placemark with the default icon and style, and adds it to the current collection

```swift
func addPlacemark(with point: YMKPoint, image: UIImage) -> YMKPlacemarkMapObject
```

Creates a new placemark with the default style and adds it to the current collection

```swift
func addPlacemark(with point: YMKPoint,
                       image: UIImage,
                       style: YMKIconStyle) -> YMKPlacemarkMapObject
```

Creates a new placemark and adds it to the current collection

```swift
func addPlacemark(with point: YMKPoint,
                        view: YRTViewProvider) -> YMKPlacemarkMapObject
```

Creates a new view placemark with default style and adds it to the current collection

```swift
func addPlacemark(with point: YMKPoint,
                        view: YRTViewProvider,
                       style: YMKIconStyle) -> YMKPlacemarkMapObject
```

Creates a new view placemark and adds it to the current collection

```swift
func addPlacemark(with point: YMKPoint,
               animatedImage: any YRTAnimatedImageProvider,
                       style: YMKIconStyle) -> YMKPlacemarkMapObject
```

Creates a new placemark with animated icon and adds it to the current collection

```swift
func addPlacemarks(with points: [YMKPoint],
                         image: UIImage,
                         style: YMKIconStyle) -> [YMKPlacemarkMapObject]
```

Creates new placemarks and adds them to the current collection

```swift
func addEmptyPlacemarks(with points: [YMKPoint]) -> [YMKPlacemarkMapObject]
```

Creates new empty placemarks and adds them to the current collection

```swift
func addPolyline(with polyline: YMKPolyline) -> YMKPolylineMapObject
```

Creates a new polyline and adds it to the current collection

```swift
func addPolyline() -> YMKPolylineMapObject
```

Creates a new polyline with an empty geometry and adds it to the current collection

```swift
func addPolygon(with polygon: YMKPolygon) -> YMKPolygonMapObject
```

Creates a new polygon and adds it to the current collection

```swift
func addCircle(with circle: YMKCircle) -> YMKCircleMapObject
```

Creates a new circle and adds it to the current collection

```swift
func add() -> YMKMapObjectCollection
```

Creates a new nested collection of map objects

```swift
func addClusterizedPlacemarkCollection(with clusterListener: any YMKClusterListener) -> YMKClusterizedPlacemarkCollection
```

Creates a new nested collection of clusterized placemarks

```swift
func placemarksStyler() -> YMKPlacemarksStyler
```

A styler for all placemarks in this collection, including placemarks in child collections

## Instance methods

### addPlacemark()

```swift
func addPlacemark() -> YMKPlacemarkMapObject
```

Creates a new empty placemark and adds it to the current collection.

### addPlacemark(placemarkCreatedCallback:)

```swift
func addPlacemark(placemarkCreatedCallback: @escaping YMKPlacemarkCreatedCallback) -> YMKPlacemarkMapObject
```

Creates a new empty placemark and adds it to the current collection. Callback can be used to setup placemark style and position Callback will be called before MapObjectCollectionListener#onMapObjectAdded

### addEmptyPlacemark(with:)

```swift
func addEmptyPlacemark(with point: YMKPoint) -> YMKPlacemarkMapObject
```

Creates a new empty placemark and adds it to the current collection.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point)

### addPlacemark(with:)

```swift
func addPlacemark(with point: YMKPoint) -> YMKPlacemarkMapObject
```

Creates a new placemark with the default icon and style, and adds it to the current collection.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setIcon(your_own_blue_dot_icon). Default icon (also known as blue dot) is no longer provided.

### addPlacemark(with:image:)

```swift
func addPlacemark(with point: YMKPoint, image: UIImage) -> YMKPlacemarkMapObject
```

Creates a new placemark with the default style and adds it to the current collection.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setIcon(image, style)

### addPlacemark(with:image:style:)

```swift
func addPlacemark(with point: YMKPoint,
                       image: UIImage,
                       style: YMKIconStyle) -> YMKPlacemarkMapObject
```

Creates a new placemark and adds it to the current collection. Hint: to add a large amount of placemarks use addPlacemarks method.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setIcon(image, style)

### addPlacemark(with:view:)

```swift
func addPlacemark(with point: YMKPoint,
                        view: YRTViewProvider) -> YMKPlacemarkMapObject
```

Creates a new view placemark with default style and adds it to the current collection.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setView(view)

### addPlacemark(with:view:style:)

```swift
func addPlacemark(with point: YMKPoint,
                        view: YRTViewProvider,
                       style: YMKIconStyle) -> YMKPlacemarkMapObject
```

Creates a new view placemark and adds it to the current collection.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setView(view, style)

### addPlacemark(with:animatedImage:style:)

```swift
func addPlacemark(with point: YMKPoint,
               animatedImage: any YRTAnimatedImageProvider,
                       style: YMKIconStyle) -> YMKPlacemarkMapObject
```

Creates a new placemark with animated icon and adds it to the current collection.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + useAnimation() + setIcon(animatedImage, style)

### addPlacemarks(with:image:style:)

```swift
func addPlacemarks(with points: [YMKPoint],
                         image: UIImage,
                         style: YMKIconStyle) -> [YMKPlacemarkMapObject]
```

Creates new placemarks and adds them to the current collection. Relevant for Android: this method provides better performance for adding a large number of placemarks than multiple calls of addPlacemark.

> [!CAUTION] Внимание
> Use ClusterizedPlacemarkCollection

### addEmptyPlacemarks(with:)

```swift
func addEmptyPlacemarks(with points: [YMKPoint]) -> [YMKPlacemarkMapObject]
```

Creates new empty placemarks and adds them to the current collection.

Relevant for Android: this method provides better performance for adding a large number of empty placemarks than multiple calls of addEmptyPlacemark.

> [!CAUTION] Внимание
> Use ClusterizedPlacemarkCollection

### addPolyline(with:)

```swift
func addPolyline(with polyline: YMKPolyline) -> YMKPolylineMapObject
```

Creates a new polyline and adds it to the current collection.

### addPolyline()

```swift
func addPolyline() -> YMKPolylineMapObject
```

Creates a new polyline with an empty geometry and adds it to the current collection.

### addPolygon(with:)

```swift
func addPolygon(with polygon: YMKPolygon) -> YMKPolygonMapObject
```

Creates a new polygon and adds it to the current collection.

### addCircle(with:)

```swift
func addCircle(with circle: YMKCircle) -> YMKCircleMapObject
```

Creates a new circle and adds it to the current collection.

### add()

```swift
func add() -> YMKMapObjectCollection
```

Creates a new nested collection of map objects.

### addClusterizedPlacemarkCollection(with:)

```swift
func addClusterizedPlacemarkCollection(with clusterListener: any YMKClusterListener) -> YMKClusterizedPlacemarkCollection
```

Creates a new nested collection of clusterized placemarks.

The class does not retain the object in the 'clusterListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| clusterListener | Listener that controls cluster appearance once they are added to the map. |

### placemarksStyler()

```swift
func placemarksStyler() -> YMKPlacemarksStyler
```

A styler for all placemarks in this collection, including placemarks in child collections.
