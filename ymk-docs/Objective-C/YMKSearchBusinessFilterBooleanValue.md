---
title: "YMKSearchBusinessFilterBooleanValue"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchBusinessFilterBooleanValue"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessFilterBooleanValue.html"
---
# YMKSearchBusinessFilterBooleanValue

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessFilterBooleanValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchBusinessFilterBooleanValue : NSObject
```

Value for boolean filters.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchBusinessFilterBooleanValue *)booleanValueWithValue:( BOOL)value
                                                              selected:(nullable NSNumber *)selected;
```

### Properties

```objectivec
@property (nonatomic, readonly) BOOL value;
```

Filter value

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *selected;
```

Selected marker

## Class methods

### booleanValueWithValue:selected:

```objectivec
+ (nonnull YMKSearchBusinessFilterBooleanValue *)booleanValueWithValue:( BOOL)value
                                                              selected:(nullable NSNumber *)selected;
```

## Properties

### value

```objectivec
@property (nonatomic, readonly) BOOL value;
```

Filter value. Set in server reponse for selected filters.

### selected

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *selected;
```

Selected marker. Set in server response for selected filters.

Optional field, can be nil.
