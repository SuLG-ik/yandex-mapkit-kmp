---
title: "YMKSearchBusinessFilterEnumValue"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchBusinessFilterEnumValue"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessFilterEnumValue.html"
---
# YMKSearchBusinessFilterEnumValue

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessFilterEnumValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchBusinessFilterEnumValue : NSObject
```

Value for enum filters.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchBusinessFilterEnumValue *)enumValueWithValue:(nonnull YMKSearchFeatureEnumValue *)value
                                                        selected:(nullable NSNumber *)selected
                                                        disabled:(nullable NSNumber *)disabled;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKSearchFeatureEnumValue *value;
```

Filter value

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *selected;
```

Selected marker

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *disabled;
```

Same as YMKSearchBusinessFilter::disabled, but for this specific enum value

## Class methods

### enumValueWithValue:selected:disabled:

```objectivec
+ (nonnull YMKSearchBusinessFilterEnumValue *)enumValueWithValue:(nonnull YMKSearchFeatureEnumValue *)value
                                                        selected:(nullable NSNumber *)selected
                                                        disabled:(nullable NSNumber *)disabled;
```

## Properties

### value

```objectivec
@property (nonatomic, readonly, nonnull) YMKSearchFeatureEnumValue *value;
```

Filter value. Set in server response for selected filters.

### selected

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *selected;
```

Selected marker. Set in server response for selected filters.

Optional field, can be nil.

### disabled

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *disabled;
```

Same as YMKSearchBusinessFilter::disabled, but for this specific enum value.

Optional field, can be nil.
