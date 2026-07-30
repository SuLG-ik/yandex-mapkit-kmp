---
title: "YMKGeoObjectTapEvent"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKGeoObjectTapEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObjectTapEvent.html"
---
# YMKGeoObjectTapEvent

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObjectTapEvent.html)

```objectivec
@interface YMKGeoObjectTapEvent : NSObject
```

Information about the tapped object.

## Summary

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKGeoObject *geoObject;
```

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Properties

### geoObject

```objectivec
@property (nonatomic, readonly, nonnull) YMKGeoObject *geoObject;
```

**Returns**

GeoObject The object that was tapped.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
