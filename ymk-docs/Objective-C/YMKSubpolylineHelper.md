---
title: "YMKSubpolylineHelper"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSubpolylineHelper"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSubpolylineHelper.html"
---
# YMKSubpolylineHelper

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSubpolylineHelper.html)

```objectivec
@interface YMKSubpolylineHelper : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKPolyline *)subpolylineWithPolyline:(nonnull YMKPolyline *)polyline
                                     subpolyline:
                                         (nonnull YMKSubpolyline *)subpolyline;
```

Cuts subpolyline geometry from polyline

```objectivec
+ (double)subpolylineLengthWithPolyline:(nonnull YMKPolyline *)polyline
                            subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

Calculates length of subpolyline geometry

## Class methods

### subpolylineWithPolyline:subpolyline:

```objectivec
+ (nonnull YMKPolyline *)subpolylineWithPolyline:(nonnull YMKPolyline *)polyline
                                     subpolyline:
                                         (nonnull YMKSubpolyline *)subpolyline;
```

Cuts subpolyline geometry from polyline.

### subpolylineLengthWithPolyline:subpolyline:

```objectivec
+ (double)subpolylineLengthWithPolyline:(nonnull YMKPolyline *)polyline
                            subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

Calculates length of subpolyline geometry.
