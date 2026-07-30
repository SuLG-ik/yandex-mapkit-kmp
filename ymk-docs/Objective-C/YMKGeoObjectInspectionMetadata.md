---
title: "YMKGeoObjectInspectionMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKGeoObjectInspectionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObjectInspectionMetadata.html"
---
# YMKGeoObjectInspectionMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObjectInspectionMetadata.html)

```objectivec
@interface YMKGeoObjectInspectionMetadata : NSObject <YMKBaseMetadata>
```

Metadata type added to all objects returned by Map.visibleObjects

## Summary

### Class methods

```objectivec
+ (nonnull YMKGeoObjectInspectionMetadata *)geoObjectInspectionMetadataWithLayerId:(nonnull NSString *)layerId
                                                                        objectType:( YMKGeoObjectInspectionMetadataObjectType)objectType;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *layerId;
```

```objectivec
@property (nonatomic, readonly)
    YMKGeoObjectInspectionMetadataObjectType objectType;
```

## Class methods

### geoObjectInspectionMetadataWithLayerId:objectType:

```objectivec
+ (nonnull YMKGeoObjectInspectionMetadata *)geoObjectInspectionMetadataWithLayerId:(nonnull NSString *)layerId
                                                                        objectType:( YMKGeoObjectInspectionMetadataObjectType)objectType;
```

## Properties

### layerId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *layerId;
```

### objectType

```objectivec
@property (nonatomic, readonly)
    YMKGeoObjectInspectionMetadataObjectType objectType;
```
