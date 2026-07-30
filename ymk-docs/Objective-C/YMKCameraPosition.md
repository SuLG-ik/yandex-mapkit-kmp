---
title: "YMKCameraPosition"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKCameraPosition"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCameraPosition.html"
---
# YMKCameraPosition

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCameraPosition.html)

```objectivec
@interface YMKCameraPosition : NSObject
```

The position of the camera.

## Summary

### Class methods

```objectivec
+ (nonnull YMKCameraPosition *)cameraPositionWithTarget:(nonnull YMKPoint *)target
                                                   zoom:( float)zoom
                                                azimuth:( float)azimuth
                                                   tilt:( float)tilt;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *target;
```

The point the camera is looking at

```objectivec
@property (nonatomic, readonly) float zoom;
```

Zoom level

```objectivec
@property (nonatomic, readonly) float azimuth;
```

Angle between north and the direction of interest on the map plane, in degrees in the range [0, 360)

```objectivec
@property (nonatomic, readonly) float tilt;
```

Camera tilt in degrees

## Class methods

### cameraPositionWithTarget:zoom:azimuth:tilt:

```objectivec
+ (nonnull YMKCameraPosition *)cameraPositionWithTarget:(nonnull YMKPoint *)target
                                                   zoom:( float)zoom
                                                azimuth:( float)azimuth
                                                   tilt:( float)tilt;
```

## Properties

### target

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *target;
```

The point the camera is looking at.

### zoom

```objectivec
@property (nonatomic, readonly) float zoom;
```

Zoom level. 0 corresponds to the whole world displayed in a single tile.

### azimuth

```objectivec
@property (nonatomic, readonly) float azimuth;
```

Angle between north and the direction of interest on the map plane, in degrees in the range [0, 360).

### tilt

```objectivec
@property (nonatomic, readonly) float tilt;
```

Camera tilt in degrees. 0 means vertical downward.
