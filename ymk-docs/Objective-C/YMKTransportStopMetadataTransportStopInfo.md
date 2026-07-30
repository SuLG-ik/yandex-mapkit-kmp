---
title: "YMKTransportStopMetadataTransportStopInfo"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTransportStopMetadataTransportStopInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTransportStopMetadataTransportStopInfo.html"
---
# YMKTransportStopMetadataTransportStopInfo

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTransportStopMetadataTransportStopInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKTransportStopMetadataTransportStopInfo : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKTransportStopMetadataTransportStopInfo *)transportStopInfoWithThreadIds:(nonnull NSArray<NSString *> *)threadIds
                                                                                stops:(nonnull NSArray<YMKRawTransportStop *> *)stops;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *threadIds;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKRawTransportStop *> *stops;
```

## Class methods

### transportStopInfoWithThreadIds:stops:

```objectivec
+ (nonnull YMKTransportStopMetadataTransportStopInfo *)transportStopInfoWithThreadIds:(nonnull NSArray<NSString *> *)threadIds
                                                                                stops:(nonnull NSArray<YMKRawTransportStop *> *)stops;
```

## Properties

### threadIds

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *threadIds;
```

### stops

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKRawTransportStop *> *stops;
```
