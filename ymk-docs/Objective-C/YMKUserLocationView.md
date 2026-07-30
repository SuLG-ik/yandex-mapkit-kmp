---
title: "YMKUserLocationView"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKUserLocationView"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKUserLocationView.html"
---
# YMKUserLocationView

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKUserLocationView.html)

```objectivec
@interface YMKUserLocationView : NSObject
```

Use this interface to specify the appearance of the user location icon elements.

## Summary

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPlacemarkMapObject *arrow;
```

Gets the location arrow map object

```objectivec
@property (nonatomic, readonly, nonnull) YMKPlacemarkMapObject *pin;
```

Gets the location pin map object

```objectivec
@property (nonatomic, readonly, nonnull) YMKCircleMapObject *accuracyCircle;
```

Gets the GPS accuracy circle map object

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Properties

### arrow

```objectivec
@property (nonatomic, readonly, nonnull) YMKPlacemarkMapObject *arrow;
```

Gets the location arrow map object.

### pin

```objectivec
@property (nonatomic, readonly, nonnull) YMKPlacemarkMapObject *pin;
```

Gets the location pin map object.

### accuracyCircle

```objectivec
@property (nonatomic, readonly, nonnull) YMKCircleMapObject *accuracyCircle;
```

Gets the GPS accuracy circle map object.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
