---
title: "YMKDrivingDirectionSignToponym"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingDirectionSignToponym"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSignToponym.html"
---
# YMKDrivingDirectionSignToponym

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSignToponym.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingDirectionSignToponym : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingDirectionSignToponym *)directionSignToponymWithText:(nonnull NSString *)text
                                                                   style:(nonnull YMKDrivingDirectionSignStyle *)style;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingDirectionSignStyle *style;
```

## Class methods

### directionSignToponymWithText:style:

```objectivec
+ (nonnull YMKDrivingDirectionSignToponym *)directionSignToponymWithText:(nonnull NSString *)text
                                                                   style:(nonnull YMKDrivingDirectionSignStyle *)style;
```

## Properties

### text

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

### style

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingDirectionSignStyle *style;
```
