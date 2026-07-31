---
title: "YMKTrafficLevel"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTrafficLevel"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTrafficLevel.html"
---
# YMKTrafficLevel

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTrafficLevel.html)

```objectivec
@interface YMKTrafficLevel : NSObject
```

The level of traffic.

## Summary

### Class methods

```objectivec
+ (nonnull YMKTrafficLevel *)trafficLevelWithColor:( YMKTrafficColor)color
                                             level:( NSInteger)level;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKTrafficColor color;
```

The color that represents traffic

```objectivec
@property (nonatomic, readonly) NSInteger level;
```

Traffic level

## Class methods

### trafficLevelWithColor:level:

```objectivec
+ (nonnull YMKTrafficLevel *)trafficLevelWithColor:( YMKTrafficColor)color
                                             level:( NSInteger)level;
```

## Properties

### color

```objectivec
@property (nonatomic, readonly) YMKTrafficColor color;
```

The color that represents traffic.

### level

```objectivec
@property (nonatomic, readonly) NSInteger level;
```

Traffic level.
