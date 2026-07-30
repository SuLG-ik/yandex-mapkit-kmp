---
title: "YMKSearchAddressComponent"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchAddressComponent"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchAddressComponent.html"
---
# YMKSearchAddressComponent

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchAddressComponent.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchAddressComponent : NSObject
```

Single address component.

Component represents a single entry in the administrative hierarchy of the address.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchAddressComponent *)componentWithName:(nonnull NSString *)name
                                                   kinds:(nonnull NSArray<NSNumber *> *)kinds;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Component name

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *kinds;
```

Component kinds

## Class methods

### componentWithName:kinds:

```objectivec
+ (nonnull YMKSearchAddressComponent *)componentWithName:(nonnull NSString *)name
                                                   kinds:(nonnull NSArray<NSNumber *> *)kinds;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Component name.

### kinds

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *kinds;
```

Component kinds. May contain both general and specific kind, for example YMKSearchComponentKindStation and YMKSearchComponentKindMetroStation.
