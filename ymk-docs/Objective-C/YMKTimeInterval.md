---
title: "YMKTimeInterval"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTimeInterval"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTimeInterval.html"
---
# YMKTimeInterval

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTimeInterval.html)

```objectivec
@interface YMKTimeInterval : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKTimeInterval *)timeIntervalWithFrom:( NSTimeInterval)from
                                               to:( NSTimeInterval)to;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSTimeInterval from;
```

Lower limit in milliseconds

```objectivec
@property (nonatomic, readonly) NSTimeInterval to;
```

Upper limit in milliseconds

## Class methods

### timeIntervalWithFrom:to:

```objectivec
+ (nonnull YMKTimeInterval *)timeIntervalWithFrom:( NSTimeInterval)from
                                               to:( NSTimeInterval)to;
```

## Properties

### from

```objectivec
@property (nonatomic, readonly) NSTimeInterval from;
```

Lower limit in milliseconds.

### to

```objectivec
@property (nonatomic, readonly) NSTimeInterval to;
```

Upper limit in milliseconds.
