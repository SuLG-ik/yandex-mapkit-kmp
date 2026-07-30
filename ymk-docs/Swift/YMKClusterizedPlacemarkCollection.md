---
title: "YMKClusterizedPlacemarkCollection"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKClusterizedPlacemarkCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKClusterizedPlacemarkCollection.html"
---
# YMKClusterizedPlacemarkCollection

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKClusterizedPlacemarkCollection.html)

```swift
class YMKClusterizedPlacemarkCollection : YMKBaseMapObjectCollection
```

A collection that displays large groups of placemarks efficiently. Placemarks that are too close to each other with current zoom are rendered as a single cluster. Placemarks and clusters are not shown until clusterPlacemarks method is called explicitly.

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
func addEmptyPlacemarks(with points: [YMKPoint]) -> [YMKPlacemarkMapObject]
```

Creates new empty placemarks and adds them to the current collection

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
func clusterPlacemarks(withClusterRadius clusterRadius: Double, minZoom: UInt)
```

Updates clustered representations of placemark groups

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

Creates a new empty placemark and adds it to the current collection. Hint: to add a large amount of empty placemarks use addEmptyPlacemarks method.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point)

### addEmptyPlacemarks(with:)

```swift
func addEmptyPlacemarks(with points: [YMKPoint]) -> [YMKPlacemarkMapObject]
```

Creates new empty placemarks and adds them to the current collection.

Relevant for Android: this method provides better performance for adding a large number of empty placemarks than multiple calls of addEmptyPlacemark.

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
> Use addPlacemark() + setGeometry(point) + setIcon(image)

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

### clusterPlacemarks(withClusterRadius:minZoom:)

```swift
func clusterPlacemarks(withClusterRadius clusterRadius: Double, minZoom: UInt)
```

Updates clustered representations of placemark groups. This method must be called explicitly to render placemarks and clusters when collection is created and update them after collection change.

| Parameters |   |
| --- | --- |
| clusterRadius | Minimal distance in units between objects that remain separate. The size of the unit is equal to the size of a pixel when the camera position's tilt is equal to 0 and the scale factor is equal to 1. |
| minZoom | Minimal zoom level that displays clusters. All placemarks will be rendered separately at more detailed zoom levels. The value will be clipped between 0 and 19 (most detailed zoom). |
