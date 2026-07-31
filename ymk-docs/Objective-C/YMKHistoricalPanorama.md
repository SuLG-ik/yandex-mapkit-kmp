---
title: "YMKHistoricalPanorama"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKHistoricalPanorama"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKHistoricalPanorama.html"
---
# YMKHistoricalPanorama

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKHistoricalPanorama.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKHistoricalPanorama : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKHistoricalPanorama *)historicalPanoramaWithName:(nonnull NSString *)name
                                                   panoramaId:(nonnull NSString *)panoramaId
                                                    timestamp:(nonnull NSDate *)timestamp;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSString *panoramaId;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSDate *timestamp;
```

## Class methods

### historicalPanoramaWithName:panoramaId:timestamp:

```objectivec
+ (nonnull YMKHistoricalPanorama *)historicalPanoramaWithName:(nonnull NSString *)name
                                                   panoramaId:(nonnull NSString *)panoramaId
                                                    timestamp:(nonnull NSDate *)timestamp;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

### panoramaId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *panoramaId;
```

### timestamp

```objectivec
@property (nonatomic, readonly, nonnull) NSDate *timestamp;
```
