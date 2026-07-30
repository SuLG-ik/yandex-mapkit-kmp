---
title: "YRTCanonicalUnit"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTCanonicalUnit"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTCanonicalUnit.html"
---
# YRTCanonicalUnit

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTCanonicalUnit.html)

```objectivec
@interface YRTCanonicalUnit : NSObject
```

Represents a unit with the value and measurement separated.

## Summary

### Class methods

```objectivec
+ (nonnull YRTCanonicalUnit *)canonicalUnitWithUnit:(nonnull NSString *)unit
                                              value:( double)value;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *unit;
```

The unit of measurement

```objectivec
@property (nonatomic, readonly) double value;
```

The numerical value

## Class methods

### canonicalUnitWithUnit:value:

```objectivec
+ (nonnull YRTCanonicalUnit *)canonicalUnitWithUnit:(nonnull NSString *)unit
                                              value:( double)value;
```

## Properties

### unit

```objectivec
@property (nonatomic, readonly, nonnull) NSString *unit;
```

The unit of measurement.

### value

```objectivec
@property (nonatomic, readonly) double value;
```

The numerical value.
