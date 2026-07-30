---
title: "YMKLocalizedValue"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLocalizedValue"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocalizedValue.html"
---
# YMKLocalizedValue

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocalizedValue.html)

```objectivec
@interface YMKLocalizedValue : NSObject
```

A value respecting the device locale.

## Summary

### Class methods

```objectivec
+ (nonnull YMKLocalizedValue *)localizedValueWithValue:( double)value
                                                  text:(nonnull NSString *)text;
```

### Properties

```objectivec
@property (nonatomic, readonly) double value;
```

Value in SI units for distance, speed and duration

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

Localized text

## Class methods

### localizedValueWithValue:text:

```objectivec
+ (nonnull YMKLocalizedValue *)localizedValueWithValue:( double)value
                                                  text:(nonnull NSString *)text;
```

## Properties

### value

```objectivec
@property (nonatomic, readonly) double value;
```

Value in SI units for distance, speed and duration.

### text

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

Localized text. For example: "15 ft" or "42 km".
