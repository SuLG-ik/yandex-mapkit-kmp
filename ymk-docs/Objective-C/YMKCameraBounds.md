---
title: "YMKCameraBounds"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKCameraBounds"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCameraBounds.html"
---
# YMKCameraBounds

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCameraBounds.html)

```objectivec
@interface YMKCameraBounds : NSObject
```

The object that is used to interact with the map bounds.

## Summary

### Instance methods

```objectivec
- (float)getMinZoom;
```

Minimum available zoom level considering zoom level hint provided via #setMinZoomPreference

```objectivec
- (float)getMaxZoom;
```

Maximum available zoom level considering zoom level hint provided via #setMaxZoomPreference

```objectivec
- (void)setMinZoomPreferenceWithZoom:(float)zoom;
```

Set minimum available zoom level hint

```objectivec
- (void)setMaxZoomPreferenceWithZoom:(float)zoom;
```

Set maximum available zoom level hint

```objectivec
- (void)resetMinMaxZoomPreference;
```

Reset minimum and maximum available zoom level hints

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    YMKBoundingBox *latLngBounds;
```

Latitudes should be in range [-89

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### getMinZoom

```objectivec
- (float)getMinZoom;
```

Minimum available zoom level considering zoom level hint provided via #setMinZoomPreference.

### getMaxZoom

```objectivec
- (float)getMaxZoom;
```

Maximum available zoom level considering zoom level hint provided via #setMaxZoomPreference

### setMinZoomPreferenceWithZoom:

```objectivec
- (void)setMinZoomPreferenceWithZoom:(float)zoom;
```

Set minimum available zoom level hint.

### setMaxZoomPreferenceWithZoom:

```objectivec
- (void)setMaxZoomPreferenceWithZoom:(float)zoom;
```

Set maximum available zoom level hint.

### resetMinMaxZoomPreference

```objectivec
- (void)resetMinMaxZoomPreference;
```

Reset minimum and maximum available zoom level hints.

## Properties

### latLngBounds

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    YMKBoundingBox *latLngBounds;
```

Latitudes should be in range [-89.3, 89.3]. Longitudes should be in range [-180, 180).

Optional property, can be nil.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
