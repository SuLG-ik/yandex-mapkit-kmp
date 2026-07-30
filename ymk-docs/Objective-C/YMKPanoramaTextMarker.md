---
title: "YMKPanoramaTextMarker"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaTextMarker"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaTextMarker.html"
---
# YMKPanoramaTextMarker

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaTextMarker.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaTextMarker : NSObject
```

Text marker struct

## Summary

### Class methods

```objectivec
+ (nonnull YMKPanoramaTextMarker *)textMarkerWithAngularPosition:(nonnull YMKDirection *)angularPosition
                                                      shortLabel:(nonnull NSString *)shortLabel
                                                       fullLabel:(nonnull NSString *)fullLabel;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *angularPosition;
```

Angular position, degrees

```objectivec
@property (nonatomic, readonly, nonnull) NSString *shortLabel;
```

The text displayed in short mode

```objectivec
@property (nonatomic, readonly, nonnull) NSString *fullLabel;
```

The text displayed in full mode

## Class methods

### textMarkerWithAngularPosition:shortLabel:fullLabel:

```objectivec
+ (nonnull YMKPanoramaTextMarker *)textMarkerWithAngularPosition:(nonnull YMKDirection *)angularPosition
                                                      shortLabel:(nonnull NSString *)shortLabel
                                                       fullLabel:(nonnull NSString *)fullLabel;
```

## Properties

### angularPosition

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *angularPosition;
```

Angular position, degrees. (bearing, tilt) (0, 0) - (north, horizon)

### shortLabel

```objectivec
@property (nonatomic, readonly, nonnull) NSString *shortLabel;
```

The text displayed in short mode. For example, a house name '14b'

### fullLabel

```objectivec
@property (nonatomic, readonly, nonnull) NSString *fullLabel;
```

The text displayed in full mode. For example, street name + house name 'Lesnaya ul. 14b'
