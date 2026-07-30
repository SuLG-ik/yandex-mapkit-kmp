---
title: "YMKAirshipTapInfo"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKAirshipTapInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAirshipTapInfo.html"
---
# YMKAirshipTapInfo

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAirshipTapInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKAirshipTapInfo : NSObject <YMKBaseMetadata>
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKAirshipTapInfo *)airshipTapInfoWithPanoramaId:(nonnull NSString *)panoramaId;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *panoramaId;
```

Panorama id of the tapped airship

## Class methods

### airshipTapInfoWithPanoramaId:

```objectivec
+ (nonnull YMKAirshipTapInfo *)airshipTapInfoWithPanoramaId:(nonnull NSString *)panoramaId;
```

## Properties

### panoramaId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *panoramaId;
```

Panorama id of the tapped airship. The id may be used to open panorama in the panorama player
