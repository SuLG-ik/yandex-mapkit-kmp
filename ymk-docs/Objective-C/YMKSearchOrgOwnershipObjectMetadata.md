---
title: "YMKSearchOrgOwnershipObjectMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchOrgOwnershipObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchOrgOwnershipObjectMetadata.html"
---
# YMKSearchOrgOwnershipObjectMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchOrgOwnershipObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchOrgOwnershipObjectMetadata : NSObject <YMKBaseMetadata>
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchOrgOwnershipObjectMetadata *)orgOwnershipObjectMetadataWithCanBeClaimed:(nullable NSNumber *)canBeClaimed;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *canBeClaimed;
```

Optional field, can be nil

## Class methods

### orgOwnershipObjectMetadataWithCanBeClaimed:

```objectivec
+ (nonnull YMKSearchOrgOwnershipObjectMetadata *)orgOwnershipObjectMetadataWithCanBeClaimed:(nullable NSNumber *)canBeClaimed;
```

## Properties

### canBeClaimed

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *canBeClaimed;
```

Optional field, can be nil.
