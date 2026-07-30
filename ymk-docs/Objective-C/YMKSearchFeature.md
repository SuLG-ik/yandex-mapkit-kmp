---
title: "YMKSearchFeature"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchFeature"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFeature.html"
---
# YMKSearchFeature

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFeature.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchFeature : NSObject
```

Describes some common feature of organizations. Can be of three types:

- boolean (like on/off switch, as for free Wi-Fi availability).
- enumerated (can have multiple values at once, like cuisine types in a cafe).
- text (like enumerated but with any strings instead of predefined values).

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchFeature *)featureWithId:(nonnull NSString *)id
                                      value:(nonnull YMKSearchFeatureVariantValue *)value
                                       name:(nullable NSString *)name
                                       aref:(nullable NSString *)aref
                                  iconLight:(nullable YMKImage *)iconLight
                                   iconDark:(nullable YMKImage *)iconDark;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Machine readable feature identifier

```objectivec
@property (nonatomic, readonly, nonnull) YMKSearchFeatureVariantValue *value;
```

Feature value (depends on feature type)

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Human readable localized representation

```objectivec
@property (nonatomic, readonly, nullable) NSString *aref;
```

Reference to information source providing given feature (see YMKAttribution)

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *iconLight;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *iconDark;
```

Optional field, can be nil

## Class methods

### featureWithId:value:name:aref:iconLight:iconDark:

```objectivec
+ (nonnull YMKSearchFeature *)featureWithId:(nonnull NSString *)id
                                      value:(nonnull YMKSearchFeatureVariantValue *)value
                                       name:(nullable NSString *)name
                                       aref:(nullable NSString *)aref
                                  iconLight:(nullable YMKImage *)iconLight
                                   iconDark:(nullable YMKImage *)iconDark;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Machine readable feature identifier.

### value

```objectivec
@property (nonatomic, readonly, nonnull) YMKSearchFeatureVariantValue *value;
```

Feature value (depends on feature type).

### name

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Human readable localized representation.

Optional field, can be nil.

### aref

```objectivec
@property (nonatomic, readonly, nullable) NSString *aref;
```

Reference to information source providing given feature (see YMKAttribution)

Optional field, can be nil.

### iconLight

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *iconLight;
```

Optional field, can be nil.

### iconDark

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *iconDark;
```

Optional field, can be nil.
