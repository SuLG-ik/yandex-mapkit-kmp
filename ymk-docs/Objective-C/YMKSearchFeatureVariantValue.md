---
title: "YMKSearchFeatureVariantValue"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchFeatureVariantValue"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFeatureVariantValue.html"
---
# YMKSearchFeatureVariantValue

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFeatureVariantValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchFeatureVariantValue : NSObject
```

A variant combining possible feature values.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchFeatureVariantValue *)variantValueWithBooleanValue:(nonnull YMKSearchFeatureBooleanValue *)booleanValue;
```

```objectivec
+ (nonnull YMKSearchFeatureVariantValue *)variantValueWithTextValue:(nonnull NSArray<NSString *> *)textValue;
```

```objectivec
+ (nonnull YMKSearchFeatureVariantValue *)variantValueWithEnumValue:(nonnull NSArray<YMKSearchFeatureEnumValue *> *)enumValue;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchFeatureBooleanValue *booleanValue
```

```objectivec
@property (nonatomic, readonly, nullable) NSArray<NSString *> *textValue
```

```objectivec
@property (nonatomic, readonly, nullable) NSArray<YMKSearchFeatureEnumValue *> *enumValue
```

## Class methods

### variantValueWithBooleanValue:

```objectivec
+ (nonnull YMKSearchFeatureVariantValue *)variantValueWithBooleanValue:(nonnull YMKSearchFeatureBooleanValue *)booleanValue;
```

### variantValueWithTextValue:

```objectivec
+ (nonnull YMKSearchFeatureVariantValue *)variantValueWithTextValue:(nonnull NSArray<NSString *> *)textValue;
```

### variantValueWithEnumValue:

```objectivec
+ (nonnull YMKSearchFeatureVariantValue *)variantValueWithEnumValue:(nonnull NSArray<YMKSearchFeatureEnumValue *> *)enumValue;
```

## Properties

### booleanValue

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchFeatureBooleanValue *booleanValue
```

### textValue

```objectivec
@property (nonatomic, readonly, nullable) NSArray<NSString *> *textValue
```

### enumValue

```objectivec
@property (nonatomic, readonly, nullable) NSArray<YMKSearchFeatureEnumValue *> *enumValue
```
