---
title: "YMKPanoramaLayer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaLayer.html"
---
# YMKPanoramaLayer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaLayer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaLayer : NSObject
```

Panorama coverage layer

## Summary

### Instance methods

```objectivec
- (void)setStreetPanoramaVisibleWithOn:(BOOL)on;
```

Enables or disables the street coverage layer

```objectivec
- (void)setAirshipPanoramaVisibleWithOn:(BOOL)on;
```

Enables or disables the airship icons

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setStreetPanoramaVisibleWithOn:

```objectivec
- (void)setStreetPanoramaVisibleWithOn:(BOOL)on;
```

Enables or disables the street coverage layer.

### setAirshipPanoramaVisibleWithOn:

```objectivec
- (void)setAirshipPanoramaVisibleWithOn:(BOOL)on;
```

Enables or disables the airship icons.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
