---
title: "YMKPanoramaIconConnection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaIconConnection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaIconConnection.html"
---
# YMKPanoramaIconConnection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaIconConnection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaIconConnection : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKPanoramaIconConnection *)iconConnectionWithAngularPosition:(nonnull YMKDirection *)angularPosition
                                                                  iconId:(nonnull NSString *)iconId
                                                              panoramaId:(nonnull NSString *)panoramaId;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *angularPosition;
```

Angular position, degrees

```objectivec
@property (nonatomic, readonly, nonnull) NSString *iconId;
```

The connection iconId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *panoramaId;
```

panoramaId is passed as a parameter to the onPanoramaChangeIntent method

## Class methods

### iconConnectionWithAngularPosition:iconId:panoramaId:

```objectivec
+ (nonnull YMKPanoramaIconConnection *)iconConnectionWithAngularPosition:(nonnull YMKDirection *)angularPosition
                                                                  iconId:(nonnull NSString *)iconId
                                                              panoramaId:(nonnull NSString *)panoramaId;
```

## Properties

### angularPosition

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *angularPosition;
```

Angular position, degrees. (bearing, tilt) (0, 0) - (north, horizon)

### iconId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *iconId;
```

The connection iconId. The iconId is passed as a parameter to the IconImageFactory and IconUrlProvider once iconId is visible

### panoramaId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *panoramaId;
```

panoramaId is passed as a parameter to the onPanoramaChangeIntent method.
