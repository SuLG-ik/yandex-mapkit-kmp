---
title: "YMKPanoramaArrowConnection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaArrowConnection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaArrowConnection.html"
---
# YMKPanoramaArrowConnection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaArrowConnection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaArrowConnection : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKPanoramaArrowConnection *)arrowConnectionWithAngularPosition:(nonnull YMKDirection *)angularPosition
                                                                     label:(nonnull NSString *)label
                                                                arrowStyle:( YMKPanoramaArrowConnectionStyle)arrowStyle
                                                                panoramaId:(nonnull NSString *)panoramaId;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *angularPosition;
```

Angular position, degrees

```objectivec
@property (nonatomic, readonly, nonnull) NSString *label;
```

label is shown near the arrow

```objectivec
@property (nonatomic, readonly) YMKPanoramaArrowConnectionStyle arrowStyle;
```

Arrow style

```objectivec
@property (nonatomic, readonly, nonnull) NSString *panoramaId;
```

panoramaId is passed as a parameter to the onPanoramaChangeIntent method

## Class methods

### arrowConnectionWithAngularPosition:label:arrowStyle:panoramaId:

```objectivec
+ (nonnull YMKPanoramaArrowConnection *)arrowConnectionWithAngularPosition:(nonnull YMKDirection *)angularPosition
                                                                     label:(nonnull NSString *)label
                                                                arrowStyle:( YMKPanoramaArrowConnectionStyle)arrowStyle
                                                                panoramaId:(nonnull NSString *)panoramaId;
```

## Properties

### angularPosition

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *angularPosition;
```

Angular position, degrees. (bearing, tilt) (0, 0) - (north, horizon)

### label

```objectivec
@property (nonatomic, readonly, nonnull) NSString *label;
```

label is shown near the arrow

### arrowStyle

```objectivec
@property (nonatomic, readonly) YMKPanoramaArrowConnectionStyle arrowStyle;
```

Arrow style.

### panoramaId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *panoramaId;
```

panoramaId is passed as a parameter to the onPanoramaChangeIntent method.
