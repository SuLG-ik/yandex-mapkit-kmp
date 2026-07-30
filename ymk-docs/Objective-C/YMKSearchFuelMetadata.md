---
title: "YMKSearchFuelMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchFuelMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFuelMetadata.html"
---
# YMKSearchFuelMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchFuelMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchFuelMetadata : NSObject <YMKBaseMetadata>
```

Fuel snippet.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchFuelMetadata *)fuelMetadataWithTimestamp:(nullable NSNumber *)timestamp
                                                       fuels:(nonnull NSArray<YMKSearchFuelType *> *)fuels
                                                 attribution:(nullable YMKAttribution *)attribution;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *timestamp;
```

Snippet update time as UNIX timestamp

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchFuelType *> *fuels;
```

Fuel list

```objectivec
@property (nonatomic, readonly, nullable) YMKAttribution *attribution;
```

Attribution information

## Class methods

### fuelMetadataWithTimestamp:fuels:attribution:

```objectivec
+ (nonnull YMKSearchFuelMetadata *)fuelMetadataWithTimestamp:(nullable NSNumber *)timestamp
                                                       fuels:(nonnull NSArray<YMKSearchFuelType *> *)fuels
                                                 attribution:(nullable YMKAttribution *)attribution;
```

## Properties

### timestamp

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *timestamp;
```

Snippet update time as UNIX timestamp.

Optional field, can be nil.

### fuels

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchFuelType *> *fuels;
```

Fuel list.

### attribution

```objectivec
@property (nonatomic, readonly, nullable) YMKAttribution *attribution;
```

Attribution information.

Optional field, can be nil.
