---
title: "YRTSurface"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTSurface"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTSurface.html"
---
# YRTSurface

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTSurface.html)

```objectivec
@interface YRTSurface : NSObject
```

Here is android only implementation

## Summary

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) CGPoint anchorPoint;
```

Anchor shifts the region of the frame that will be rendered on the surface

## Properties

### anchorPoint

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) CGPoint anchorPoint;
```

Anchor shifts the region of the frame that will be rendered on the surface. Anchor coordinates are within [0; 1] bounds. Position of frame’s focusPoint will match specified anchorPoint in the surface: - (0, 0) - left bottom corner of the surface; - (1, 1) - right top corner of the surface; Default value is (0.5, 0.5)
