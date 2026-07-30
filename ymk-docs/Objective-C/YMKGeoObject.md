---
title: "YMKGeoObject"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKGeoObject"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObject.html"
---
# YMKGeoObject

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObject.html)

```objectivec
@interface YMKGeoObject : NSObject
```

Geo object. Can be displayed as a placemark, polyline, polygon, and other, depending on the geometry type.

## Summary

### Class methods

```objectivec
+ (nonnull YMKGeoObject *)geoObjectWithName:(nullable NSString *)name
                            descriptionText:(nullable NSString *)descriptionText
                                   geometry:(nonnull NSArray<YMKGeometry *> *)geometry
                                boundingBox:(nullable YMKBoundingBox *)boundingBox
                             attributionMap:(nonnull NSDictionary<NSString *, YMKAttribution *> *)attributionMap
                          metadataContainer:(nonnull YRTTypeDictionary<id<YMKBaseMetadata>> *)metadataContainer
                                       aref:(nonnull NSArray<NSString *> *)aref;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Object name

```objectivec
@property (nonatomic, readonly, nullable) NSString *descriptionText;
```

The description of the object

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKGeometry *> *geometry;
```

The object's geometry

```objectivec
@property (nonatomic, readonly, nullable) YMKBoundingBox *boundingBox;
```

A rectangular box around the object

```objectivec
@property (nonatomic, readonly, nonnull)
    NSDictionary<NSString *, YMKAttribution *> *attributionMap;
```

The attribution of information to a specific author

```objectivec
@property (nonatomic, readonly, nonnull)
    YRTTypeDictionary<id<YMKBaseMetadata>> *metadataContainer;
```

The object's metadata

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *aref;
```

The name of the internet resource

## Class methods

### geoObjectWithName:descriptionText:geometry:boundingBox:attributionMap:metadataContainer:aref:

```objectivec
+ (nonnull YMKGeoObject *)geoObjectWithName:(nullable NSString *)name
                            descriptionText:(nullable NSString *)descriptionText
                                   geometry:(nonnull NSArray<YMKGeometry *> *)geometry
                                boundingBox:(nullable YMKBoundingBox *)boundingBox
                             attributionMap:(nonnull NSDictionary<NSString *, YMKAttribution *> *)attributionMap
                          metadataContainer:(nonnull YRTTypeDictionary<id<YMKBaseMetadata>> *)metadataContainer
                                       aref:(nonnull NSArray<NSString *> *)aref;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Object name.

Optional field, can be nil.

### descriptionText

```objectivec
@property (nonatomic, readonly, nullable) NSString *descriptionText;
```

The description of the object.

Optional field, can be nil.

### geometry

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKGeometry *> *geometry;
```

The object's geometry.

### boundingBox

```objectivec
@property (nonatomic, readonly, nullable) YMKBoundingBox *boundingBox;
```

A rectangular box around the object.

Optional field, can be nil.

### attributionMap

```objectivec
@property (nonatomic, readonly, nonnull)
    NSDictionary<NSString *, YMKAttribution *> *attributionMap;
```

The attribution of information to a specific author.

### metadataContainer

```objectivec
@property (nonatomic, readonly, nonnull)
    YRTTypeDictionary<id<YMKBaseMetadata>> *metadataContainer;
```

The object's metadata.

### aref

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *aref;
```

The name of the internet resource.
