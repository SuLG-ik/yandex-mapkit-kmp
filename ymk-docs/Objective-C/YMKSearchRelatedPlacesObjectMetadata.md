---
title: "YMKSearchRelatedPlacesObjectMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchRelatedPlacesObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchRelatedPlacesObjectMetadata.html"
---
# YMKSearchRelatedPlacesObjectMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchRelatedPlacesObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchRelatedPlacesObjectMetadata : NSObject <YMKBaseMetadata>
```

Snippet data to get related places info.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchRelatedPlacesObjectMetadata *)relatedPlacesObjectMetadataWithSimilarPlaces:(nonnull NSArray<YMKSearchPlaceInfo *> *)similarPlaces;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchPlaceInfo *> *similarPlaces;
```

List of similar places

## Class methods

### relatedPlacesObjectMetadataWithSimilarPlaces:

```objectivec
+ (nonnull YMKSearchRelatedPlacesObjectMetadata *)relatedPlacesObjectMetadataWithSimilarPlaces:(nonnull NSArray<YMKSearchPlaceInfo *> *)similarPlaces;
```

## Properties

### similarPlaces

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchPlaceInfo *> *similarPlaces;
```

List of similar places.
