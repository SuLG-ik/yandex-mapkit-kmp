---
title: "YMKPlaces"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPlaces"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlaces.html"
---
# YMKPlaces

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlaces.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPlaces : NSObject
```

## Summary

### Instance methods

```objectivec
- (nonnull YMKPanoramaService *)createPanoramaService;
```

Creates a service that allows to find a panorama closest to the chosen point

```objectivec
- (nonnull YMKPanoramaLayer *)createPanoramaLayerWithMapWindow:
    (nonnull YMKMapWindow *)mapWindow;
```

Creates a layer representing where panoramas are available

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### createPanoramaService

```objectivec
- (nonnull YMKPanoramaService *)createPanoramaService;
```

Creates a service that allows to find a panorama closest to the chosen point.

### createPanoramaLayerWithMapWindow:

```objectivec
- (nonnull YMKPanoramaLayer *)createPanoramaLayerWithMapWindow:
    (nonnull YMKMapWindow *)mapWindow;
```

Creates a layer representing where panoramas are available.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
