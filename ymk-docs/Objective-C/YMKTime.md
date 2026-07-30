---
title: "YMKTime"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTime"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTime.html"
---
# YMKTime

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTime.html)

```objectivec
@interface YMKTime : NSObject
```

Time in I18nTime format.

## Summary

### Class methods

```objectivec
+ (nonnull YMKTime *)timeWithValue:( long long)value
                          tzOffset:( NSInteger)tzOffset
                              text:(nonnull NSString *)text;
```

### Properties

```objectivec
@property (nonatomic, readonly) long long value;
```

Time value

```objectivec
@property (nonatomic, readonly) NSInteger tzOffset;
```

Time offset to account for time zones

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

The description of the timer

## Class methods

### timeWithValue:tzOffset:text:

```objectivec
+ (nonnull YMKTime *)timeWithValue:( long long)value
                          tzOffset:( NSInteger)tzOffset
                              text:(nonnull NSString *)text;
```

## Properties

### value

```objectivec
@property (nonatomic, readonly) long long value;
```

Time value.

### tzOffset

```objectivec
@property (nonatomic, readonly) NSInteger tzOffset;
```

Time offset to account for time zones.

### text

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

The description of the timer.
