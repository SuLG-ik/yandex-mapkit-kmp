---
title: "YMKMasstransitTransportContour"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTransportContour"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportContour.html"
---
# YMKMasstransitTransportContour

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportContour.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTransportContour : NSObject
```

Describes transport contours and it's properties

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTransportContour *)transportContourWithName:(nonnull NSString *)name
                                                               style:(nullable YMKMasstransitTransportContourStyle *)style;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Contour name

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTransportContourStyle *style;
```

Contour style; see YMKMasstransitTransportContourStyle

## Class methods

### transportContourWithName:style:

```objectivec
+ (nonnull YMKMasstransitTransportContour *)transportContourWithName:(nonnull NSString *)name
                                                               style:(nullable YMKMasstransitTransportContourStyle *)style;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Contour name

### style

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTransportContourStyle *style;
```

Contour style; see YMKMasstransitTransportContourStyle.

Optional field, can be nil.
