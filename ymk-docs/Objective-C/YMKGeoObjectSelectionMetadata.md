---
title: "YMKGeoObjectSelectionMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKGeoObjectSelectionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObjectSelectionMetadata.html"
---
# YMKGeoObjectSelectionMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObjectSelectionMetadata.html)

```objectivec
@interface YMKGeoObjectSelectionMetadata : NSObject <YMKBaseMetadata>
```

Geo object metadata which is needed to select object.

## Summary

### Class methods

```objectivec
+ (nonnull YMKGeoObjectSelectionMetadata *)geoObjectSelectionMetadataWithObjectId:(nonnull NSString *)objectId
                                                                   dataSourceName:(nonnull NSString *)dataSourceName
                                                                          layerId:(nonnull NSString *)layerId
                                                                          groupId:(nullable NSNumber *)groupId;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *objectId;
```

Object ID

```objectivec
@property (nonatomic, readonly, nonnull) NSString *dataSourceName;
```

Data source name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *layerId;
```

Layer ID

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *groupId;
```

Group ID

## Class methods

### geoObjectSelectionMetadataWithObjectId:dataSourceName:layerId:groupId:

```objectivec
+ (nonnull YMKGeoObjectSelectionMetadata *)geoObjectSelectionMetadataWithObjectId:(nonnull NSString *)objectId
                                                                   dataSourceName:(nonnull NSString *)dataSourceName
                                                                          layerId:(nonnull NSString *)layerId
                                                                          groupId:(nullable NSNumber *)groupId;
```

## Properties

### objectId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *objectId;
```

Object ID.

### dataSourceName

```objectivec
@property (nonatomic, readonly, nonnull) NSString *dataSourceName;
```

Data source name.

### layerId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *layerId;
```

Layer ID.

### groupId

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *groupId;
```

Group ID.

Optional field, can be nil.
