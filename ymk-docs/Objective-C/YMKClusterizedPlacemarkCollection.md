---
title: "YMKClusterizedPlacemarkCollection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKClusterizedPlacemarkCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKClusterizedPlacemarkCollection.html"
---
# YMKClusterizedPlacemarkCollection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKClusterizedPlacemarkCollection.html)

```objectivec
@interface YMKClusterizedPlacemarkCollection : YMKBaseMapObjectCollection
```

A collection that displays large groups of placemarks efficiently. Placemarks that are too close to each other with current zoom are rendered as a single cluster. Placemarks and clusters are not shown until clusterPlacemarks method is called explicitly.

## Summary

### Instance methods

```objectivec
- (nonnull YMKPlacemarkMapObject *)addPlacemark;
```

Creates a new empty placemark and adds it to the current collection

```objectivec
- (nonnull YMKPlacemarkMapObject *)addPlacemarkWithPlacemarkCreatedCallback:
    (nonnull YMKPlacemarkCreatedCallback)placemarkCreatedCallback;
```

Creates a new empty placemark and adds it to the current collection

```objectivec
- (nonnull YMKPlacemarkMapObject *)addEmptyPlacemarkWithPoint:
    (nonnull YMKPoint *)point;
```

Creates a new empty placemark and adds it to the current collection

```objectivec
- (nonnull NSArray<YMKPlacemarkMapObject *> *)addEmptyPlacemarksWithPoints:
    (nonnull NSArray<YMKPoint *> *)points;
```

Creates new empty placemarks and adds them to the current collection

```objectivec
- (nonnull YMKPlacemarkMapObject *)addPlacemarkWithPoint:
    (nonnull YMKPoint *)point;
```

Creates a new placemark with the default icon and style, and adds it to the current collection

```objectivec
- (nonnull YMKPlacemarkMapObject *)
    addPlacemarkWithPoint:(nonnull YMKPoint *)point
                    image:(nonnull UIImage *)image;
```

Creates a new placemark with the default style and adds it to the current collection

```objectivec
- (nonnull YMKPlacemarkMapObject *)
    addPlacemarkWithPoint:(nonnull YMKPoint *)point
                    image:(nonnull UIImage *)image
                    style:(nonnull YMKIconStyle *)style;
```

Creates a new placemark and adds it to the current collection

```objectivec
- (nonnull YMKPlacemarkMapObject *)
    addPlacemarkWithPoint:(nonnull YMKPoint *)point
                     view:(nonnull YRTViewProvider *)view;
```

Creates a new view placemark with default style and adds it to the current collection

```objectivec
- (nonnull YMKPlacemarkMapObject *)
    addPlacemarkWithPoint:(nonnull YMKPoint *)point
                     view:(nonnull YRTViewProvider *)view
                    style:(nonnull YMKIconStyle *)style;
```

Creates a new view placemark and adds it to the current collection

```objectivec
- (nonnull YMKPlacemarkMapObject *)
    addPlacemarkWithPoint:(nonnull YMKPoint *)point
            animatedImage:(nonnull id<YRTAnimatedImageProvider>)animatedImage
                    style:(nonnull YMKIconStyle *)style;
```

Creates a new placemark with animated icon and adds it to the current collection

```objectivec
- (nonnull NSArray<YMKPlacemarkMapObject *> *)
    addPlacemarksWithPoints:(nonnull NSArray<YMKPoint *> *)points
                      image:(nonnull UIImage *)image
                      style:(nonnull YMKIconStyle *)style;
```

Creates new placemarks and adds them to the current collection

```objectivec
- (void)clusterPlacemarksWithClusterRadius:(double)clusterRadius
                                   minZoom:(NSUInteger)minZoom;
```

Updates clustered representations of placemark groups

## Instance methods

### addPlacemark

```objectivec
- (nonnull YMKPlacemarkMapObject *)addPlacemark;
```

Creates a new empty placemark and adds it to the current collection.

### addPlacemarkWithPlacemarkCreatedCallback:

```objectivec
- (nonnull YMKPlacemarkMapObject *)addPlacemarkWithPlacemarkCreatedCallback:
    (nonnull YMKPlacemarkCreatedCallback)placemarkCreatedCallback;
```

Creates a new empty placemark and adds it to the current collection. Callback can be used to setup placemark style and position Callback will be called before MapObjectCollectionListener#onMapObjectAdded

### addEmptyPlacemarkWithPoint:

```objectivec
- (nonnull YMKPlacemarkMapObject *)addEmptyPlacemarkWithPoint:
    (nonnull YMKPoint *)point;
```

Creates a new empty placemark and adds it to the current collection. Hint: to add a large amount of empty placemarks use addEmptyPlacemarks method.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point)

### addEmptyPlacemarksWithPoints:

```objectivec
- (nonnull NSArray<YMKPlacemarkMapObject *> *)addEmptyPlacemarksWithPoints:
    (nonnull NSArray<YMKPoint *> *)points;
```

Creates new empty placemarks and adds them to the current collection.

Relevant for Android: this method provides better performance for adding a large number of empty placemarks than multiple calls of addEmptyPlacemark.

### addPlacemarkWithPoint:

```objectivec
- (nonnull YMKPlacemarkMapObject *)addPlacemarkWithPoint:
    (nonnull YMKPoint *)point;
```

Creates a new placemark with the default icon and style, and adds it to the current collection.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setIcon(your_own_blue_dot_icon). Default icon (also known as blue dot) is no longer provided.

### addPlacemarkWithPoint:image:

```objectivec
- (nonnull YMKPlacemarkMapObject *)
    addPlacemarkWithPoint:(nonnull YMKPoint *)point
                    image:(nonnull UIImage *)image;
```

Creates a new placemark with the default style and adds it to the current collection.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setIcon(image)

### addPlacemarkWithPoint:image:style:

```objectivec
- (nonnull YMKPlacemarkMapObject *)
    addPlacemarkWithPoint:(nonnull YMKPoint *)point
                    image:(nonnull UIImage *)image
                    style:(nonnull YMKIconStyle *)style;
```

Creates a new placemark and adds it to the current collection. Hint: to add a large amount of placemarks use addPlacemarks method.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setIcon(image, style)

### addPlacemarkWithPoint:view:

```objectivec
- (nonnull YMKPlacemarkMapObject *)
    addPlacemarkWithPoint:(nonnull YMKPoint *)point
                     view:(nonnull YRTViewProvider *)view;
```

Creates a new view placemark with default style and adds it to the current collection.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setView(view)

### addPlacemarkWithPoint:view:style:

```objectivec
- (nonnull YMKPlacemarkMapObject *)
    addPlacemarkWithPoint:(nonnull YMKPoint *)point
                     view:(nonnull YRTViewProvider *)view
                    style:(nonnull YMKIconStyle *)style;
```

Creates a new view placemark and adds it to the current collection.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setView(view, style)

### addPlacemarkWithPoint:animatedImage:style:

```objectivec
- (nonnull YMKPlacemarkMapObject *)
    addPlacemarkWithPoint:(nonnull YMKPoint *)point
            animatedImage:(nonnull id<YRTAnimatedImageProvider>)animatedImage
                    style:(nonnull YMKIconStyle *)style;
```

Creates a new placemark with animated icon and adds it to the current collection.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + useAnimation() + setIcon(animatedImage, style)

### addPlacemarksWithPoints:image:style:

```objectivec
- (nonnull NSArray<YMKPlacemarkMapObject *> *)
    addPlacemarksWithPoints:(nonnull NSArray<YMKPoint *> *)points
                      image:(nonnull UIImage *)image
                      style:(nonnull YMKIconStyle *)style;
```

Creates new placemarks and adds them to the current collection. Relevant for Android: this method provides better performance for adding a large number of placemarks than multiple calls of addPlacemark.

### clusterPlacemarksWithClusterRadius:minZoom:

```objectivec
- (void)clusterPlacemarksWithClusterRadius:(double)clusterRadius
                                   minZoom:(NSUInteger)minZoom;
```

Updates clustered representations of placemark groups. This method must be called explicitly to render placemarks and clusters when collection is created and update them after collection change.

| Parameters |   |
| --- | --- |
| clusterRadius | Minimal distance in units between objects that remain separate. The size of the unit is equal to the size of a pixel when the camera position's tilt is equal to 0 and the scale factor is equal to 1. |
| minZoom | Minimal zoom level that displays clusters. All placemarks will be rendered separately at more detailed zoom levels. The value will be clipped between 0 and 19 (most detailed zoom). |
