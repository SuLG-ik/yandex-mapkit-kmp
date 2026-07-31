---
title: "YMKMapObjectCollection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMapObjectCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapObjectCollection.html"
---
# YMKMapObjectCollection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapObjectCollection.html)

```objectivec
@interface YMKMapObjectCollection : YMKBaseMapObjectCollection
```

A collection of map objects that can hold any set of MapObject items, including nested collections.

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
- (nonnull NSArray<YMKPlacemarkMapObject *> *)addEmptyPlacemarksWithPoints:
    (nonnull NSArray<YMKPoint *> *)points;
```

Creates new empty placemarks and adds them to the current collection

```objectivec
- (nonnull YMKPolylineMapObject *)addPolylineWithPolyline:
    (nonnull YMKPolyline *)polyline;
```

Creates a new polyline and adds it to the current collection

```objectivec
- (nonnull YMKPolylineMapObject *)addPolyline;
```

Creates a new polyline with an empty geometry and adds it to the current collection

```objectivec
- (nonnull YMKPolygonMapObject *)addPolygonWithPolygon:
    (nonnull YMKPolygon *)polygon;
```

Creates a new polygon and adds it to the current collection

```objectivec
- (nonnull YMKCircleMapObject *)addCircleWithCircle:(nonnull YMKCircle *)circle;
```

Creates a new circle and adds it to the current collection

```objectivec
- (nonnull YMKMapObjectCollection *)addCollection;
```

Creates a new nested collection of map objects

```objectivec
- (nonnull YMKClusterizedPlacemarkCollection *)
    addClusterizedPlacemarkCollectionWithClusterListener:
        (nonnull id<YMKClusterListener>)clusterListener;
```

Creates a new nested collection of clusterized placemarks

```objectivec
- (nonnull YMKPlacemarksStyler *)placemarksStyler;
```

A styler for all placemarks in this collection, including placemarks in child collections

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

Creates a new empty placemark and adds it to the current collection.

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point)

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
> Use addPlacemark() + setGeometry(point) + setIcon(image, style)

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

> [!CAUTION] Внимание
> Use ClusterizedPlacemarkCollection

### addEmptyPlacemarksWithPoints:

```objectivec
- (nonnull NSArray<YMKPlacemarkMapObject *> *)addEmptyPlacemarksWithPoints:
    (nonnull NSArray<YMKPoint *> *)points;
```

Creates new empty placemarks and adds them to the current collection.

Relevant for Android: this method provides better performance for adding a large number of empty placemarks than multiple calls of addEmptyPlacemark.

> [!CAUTION] Внимание
> Use ClusterizedPlacemarkCollection

### addPolylineWithPolyline:

```objectivec
- (nonnull YMKPolylineMapObject *)addPolylineWithPolyline:
    (nonnull YMKPolyline *)polyline;
```

Creates a new polyline and adds it to the current collection.

### addPolyline

```objectivec
- (nonnull YMKPolylineMapObject *)addPolyline;
```

Creates a new polyline with an empty geometry and adds it to the current collection.

### addPolygonWithPolygon:

```objectivec
- (nonnull YMKPolygonMapObject *)addPolygonWithPolygon:
    (nonnull YMKPolygon *)polygon;
```

Creates a new polygon and adds it to the current collection.

### addCircleWithCircle:

```objectivec
- (nonnull YMKCircleMapObject *)addCircleWithCircle:(nonnull YMKCircle *)circle;
```

Creates a new circle and adds it to the current collection.

### addCollection

```objectivec
- (nonnull YMKMapObjectCollection *)addCollection;
```

Creates a new nested collection of map objects.

### addClusterizedPlacemarkCollectionWithClusterListener:

```objectivec
- (nonnull YMKClusterizedPlacemarkCollection *)
    addClusterizedPlacemarkCollectionWithClusterListener:
        (nonnull id<YMKClusterListener>)clusterListener;
```

Creates a new nested collection of clusterized placemarks.

The class does not retain the object in the 'clusterListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| clusterListener | Listener that controls cluster appearance once they are added to the map. |

### placemarksStyler

```objectivec
- (nonnull YMKPlacemarksStyler *)placemarksStyler;
```

A styler for all placemarks in this collection, including placemarks in child collections.
