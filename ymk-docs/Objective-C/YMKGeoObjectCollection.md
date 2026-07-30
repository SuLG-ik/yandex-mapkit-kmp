---
title: "YMKGeoObjectCollection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKGeoObjectCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObjectCollection.html"
---
# YMKGeoObjectCollection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObjectCollection.html)

```objectivec
@interface YMKGeoObjectCollection : NSObject
```

A collection of geo objects. Allows you to group geo objects for adding them to the map, setting options, etc. Collections are geo objects too.

## Summary

### Class methods

```objectivec
+ (nonnull YMKGeoObjectCollection *)geoObjectCollectionWithBoundingBox:(nullable YMKBoundingBox *)boundingBox
                                                     metadataContainer:(nonnull YRTTypeDictionary<id<YMKBaseMetadata>> *)metadataContainer
                                                              children:(nonnull NSArray<YMKGeoObjectCollectionItem *> *)children;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKBoundingBox *boundingBox;
```

The bounds around the collection of objects

```objectivec
@property (nonatomic, readonly, nonnull)
    YRTTypeDictionary<id<YMKBaseMetadata>> *metadataContainer;
```

The metadata for the objects

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKGeoObjectCollectionItem *> *children;
```

## Class methods

### geoObjectCollectionWithBoundingBox:metadataContainer:children:

```objectivec
+ (nonnull YMKGeoObjectCollection *)geoObjectCollectionWithBoundingBox:(nullable YMKBoundingBox *)boundingBox
                                                     metadataContainer:(nonnull YRTTypeDictionary<id<YMKBaseMetadata>> *)metadataContainer
                                                              children:(nonnull NSArray<YMKGeoObjectCollectionItem *> *)children;
```

## Properties

### boundingBox

```objectivec
@property (nonatomic, readonly, nullable) YMKBoundingBox *boundingBox;
```

The bounds around the collection of objects.

Optional field, can be nil.

### metadataContainer

```objectivec
@property (nonatomic, readonly, nonnull)
    YRTTypeDictionary<id<YMKBaseMetadata>> *metadataContainer;
```

The metadata for the objects.

### children

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKGeoObjectCollectionItem *> *children;
```
