---
title: "YMKMasstransitThreadStop"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitThreadStop"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitThreadStop.html"
---
# YMKMasstransitThreadStop

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitThreadStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitThreadStop : NSObject
```

Describes a YMKMasstransitStop on a YMKMasstransitThread.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitThreadStop *)threadStopWithStop:(nonnull YMKMasstransitStop *)stop
                                                position:(nonnull YMKPoint *)position;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitStop *stop;
```

Stop on a thread

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Coordinates of the thread stop

## Class methods

### threadStopWithStop:position:

```objectivec
+ (nonnull YMKMasstransitThreadStop *)threadStopWithStop:(nonnull YMKMasstransitStop *)stop
                                                position:(nonnull YMKPoint *)position;
```

## Properties

### stop

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitStop *stop;
```

Stop on a thread.

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Coordinates of the thread stop.
