---
title: "YMKPanoramaCompanyMarker"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaCompanyMarker"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaCompanyMarker.html"
---
# YMKPanoramaCompanyMarker

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaCompanyMarker.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaCompanyMarker : NSObject
```

Company marker struct

## Summary

### Class methods

```objectivec
+ (nonnull YMKPanoramaCompanyMarker *)companyMarkerWithAngularPosition:(nonnull YMKDirection *)angularPosition
                                                                 label:(nonnull NSString *)label
                                                                iconId:(nonnull NSString *)iconId
                                                             permalink:(nonnull NSString *)permalink;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *angularPosition;
```

Angular position, degrees

```objectivec
@property (nonatomic, readonly, nonnull) NSString *label;
```

Displayed label

```objectivec
@property (nonatomic, readonly, nonnull) NSString *iconId;
```

The company iconId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *permalink;
```

Permalink is passed as a parameter to the onCompanyTap method

## Class methods

### companyMarkerWithAngularPosition:label:iconId:permalink:

```objectivec
+ (nonnull YMKPanoramaCompanyMarker *)companyMarkerWithAngularPosition:(nonnull YMKDirection *)angularPosition
                                                                 label:(nonnull NSString *)label
                                                                iconId:(nonnull NSString *)iconId
                                                             permalink:(nonnull NSString *)permalink;
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

Displayed label. For example, a company name 'Sweet market'

### iconId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *iconId;
```

The company iconId. The iconId is passed as a parameter to the IconImageFactory and IconUrlProvider

### permalink

```objectivec
@property (nonatomic, readonly, nonnull) NSString *permalink;
```

Permalink is passed as a parameter to the onCompanyTap method.
