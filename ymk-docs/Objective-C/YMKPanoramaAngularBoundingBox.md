---
title: "YMKPanoramaAngularBoundingBox"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaAngularBoundingBox"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaAngularBoundingBox.html"
---
# YMKPanoramaAngularBoundingBox

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaAngularBoundingBox.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaAngularBoundingBox : NSObject
```

Angular bbox. Direction + span will be limited between top and bottom It's recommended to have (right - left) = 360.

## Summary

### Class methods

```objectivec
+ (nonnull YMKPanoramaAngularBoundingBox *)angularBoundingBoxWithLeft:( float)left
                                                                  top:( float)top
                                                                right:( float)right
                                                               bottom:( float)bottom;
```

### Properties

```objectivec
@property (nonatomic, readonly) float left;
```

```objectivec
@property (nonatomic, readonly) float top;
```

```objectivec
@property (nonatomic, readonly) float right;
```

```objectivec
@property (nonatomic, readonly) float bottom;
```

## Class methods

### angularBoundingBoxWithLeft:top:right:bottom:

```objectivec
+ (nonnull YMKPanoramaAngularBoundingBox *)angularBoundingBoxWithLeft:( float)left
                                                                  top:( float)top
                                                                right:( float)right
                                                               bottom:( float)bottom;
```

## Properties

### left

```objectivec
@property (nonatomic, readonly) float left;
```

### top

```objectivec
@property (nonatomic, readonly) float top;
```

### right

```objectivec
@property (nonatomic, readonly) float right;
```

### bottom

```objectivec
@property (nonatomic, readonly) float bottom;
```
