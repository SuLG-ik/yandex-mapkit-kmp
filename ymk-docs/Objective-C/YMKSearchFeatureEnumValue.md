---
title: "YMKSearchFeatureEnumValue"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchFeatureEnumValue"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFeatureEnumValue.html"
---
# YMKSearchFeatureEnumValue

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFeatureEnumValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchFeatureEnumValue : NSObject
```

Value for enumerated features.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchFeatureEnumValue *)enumValueWithId:(nonnull NSString *)id
                                                  name:(nonnull NSString *)name
                                      imageUrlTemplate:(nullable NSString *)imageUrlTemplate
                                                  tags:(nonnull NSArray<NSString *> *)tags;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Machine readable value identifier

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Human readable localized representation

```objectivec
@property (nonatomic, readonly, nullable) NSString *imageUrlTemplate;
```

urlTemplate for the image

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tags;
```

## Class methods

### enumValueWithId:name:imageUrlTemplate:tags:

```objectivec
+ (nonnull YMKSearchFeatureEnumValue *)enumValueWithId:(nonnull NSString *)id
                                                  name:(nonnull NSString *)name
                                      imageUrlTemplate:(nullable NSString *)imageUrlTemplate
                                                  tags:(nonnull NSArray<NSString *> *)tags;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Machine readable value identifier.

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Human readable localized representation.

### imageUrlTemplate

```objectivec
@property (nonatomic, readonly, nullable) NSString *imageUrlTemplate;
```

urlTemplate for the image. Available sizes are listed here: http://api.yandex.ru/fotki/doc/format-ref/f-img.xml

Optional field, can be nil.

### tags

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tags;
```
