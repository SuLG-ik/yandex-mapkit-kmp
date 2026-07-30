---
title: "YMKMasstransitEssentialStop"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitEssentialStop"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitEssentialStop.html"
---
# YMKMasstransitEssentialStop

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitEssentialStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitEssentialStop : NSObject
```

Essential stop on thread

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitEssentialStop *)essentialStopWithStop:(nonnull YMKMasstransitStop *)stop
                                                          info:(nonnull YMKMasstransitEssentialStopInfo *)info;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitStop *stop;
```

Stop on the thread

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitEssentialStopInfo *info;
```

Info for stop YMKMasstransitEssentialStopInfo

## Class methods

### essentialStopWithStop:info:

```objectivec
+ (nonnull YMKMasstransitEssentialStop *)essentialStopWithStop:(nonnull YMKMasstransitStop *)stop
                                                          info:(nonnull YMKMasstransitEssentialStopInfo *)info;
```

## Properties

### stop

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitStop *stop;
```

Stop on the thread

### info

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitEssentialStopInfo *info;
```

Info for stop YMKMasstransitEssentialStopInfo.
