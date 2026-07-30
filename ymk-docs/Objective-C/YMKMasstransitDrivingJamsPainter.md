---
title: "YMKMasstransitDrivingJamsPainter"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitDrivingJamsPainter"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitDrivingJamsPainter.html"
---
# YMKMasstransitDrivingJamsPainter

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitDrivingJamsPainter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitDrivingJamsPainter : NSObject
```

## Summary

### Class methods

```objectivec
+ (void)applyJamsStyleWithPolyline:(nonnull YMKPolylineMapObject *)polyline
                              jams:(nonnull NSArray<YMKJamSegment *> *)jams
                             style:(nonnull YMKJamStyle *)style;
```

@ internal

Draw driving "jams" with specified "style"

## Class methods

### applyJamsStyleWithPolyline:jams:style:

```objectivec
+ (void)applyJamsStyleWithPolyline:(nonnull YMKPolylineMapObject *)polyline
                              jams:(nonnull NSArray<YMKJamSegment *> *)jams
                             style:(nonnull YMKJamStyle *)style;
```

@ internal

Draw driving "jams" with specified "style"
