---
title: "YMKGeoObjectCollectionItem"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKGeoObjectCollectionItem"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObjectCollectionItem.html"
---
# YMKGeoObjectCollectionItem

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObjectCollectionItem.html)

```objectivec
@interface YMKGeoObjectCollectionItem : NSObject
```

The geo objects in the collection.

## Summary

### Class methods

```objectivec
+ (nonnull YMKGeoObjectCollectionItem *)itemWithObj:(nonnull YMKGeoObject *)obj;
```

```objectivec
+ (nonnull YMKGeoObjectCollectionItem *)itemWithCollection:(nonnull YMKGeoObjectCollection *)collection;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKGeoObject *obj
```

```objectivec
@property (nonatomic, readonly, nullable) YMKGeoObjectCollection *collection
```

## Class methods

### itemWithObj:

```objectivec
+ (nonnull YMKGeoObjectCollectionItem *)itemWithObj:(nonnull YMKGeoObject *)obj;
```

### itemWithCollection:

```objectivec
+ (nonnull YMKGeoObjectCollectionItem *)itemWithCollection:(nonnull YMKGeoObjectCollection *)collection;
```

## Properties

### obj

```objectivec
@property (nonatomic, readonly, nullable) YMKGeoObject *obj
```

### collection

```objectivec
@property (nonatomic, readonly, nullable) YMKGeoObjectCollection *collection
```
