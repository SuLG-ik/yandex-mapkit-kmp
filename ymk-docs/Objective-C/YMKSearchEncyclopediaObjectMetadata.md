---
title: "YMKSearchEncyclopediaObjectMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchEncyclopediaObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchEncyclopediaObjectMetadata.html"
---
# YMKSearchEncyclopediaObjectMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchEncyclopediaObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchEncyclopediaObjectMetadata : NSObject <YMKBaseMetadata>
```

Snippet with encyclopedia data.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchEncyclopediaObjectMetadata *)encyclopediaObjectMetadataWithTitle:(nullable NSString *)title
                                                                         description:(nullable NSString *)description
                                                                         attribution:(nullable YMKAttribution *)attribution;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *title;
```

Encyclopedia article title

```objectivec
@property (nonatomic, readonly, nullable) NSString *description;
```

Encyclopedia article body

```objectivec
@property (nonatomic, readonly, nullable) YMKAttribution *attribution;
```

Attribution information

## Class methods

### encyclopediaObjectMetadataWithTitle:description:attribution:

```objectivec
+ (nonnull YMKSearchEncyclopediaObjectMetadata *)encyclopediaObjectMetadataWithTitle:(nullable NSString *)title
                                                                         description:(nullable NSString *)description
                                                                         attribution:(nullable YMKAttribution *)attribution;
```

## Properties

### title

```objectivec
@property (nonatomic, readonly, nullable) NSString *title;
```

Encyclopedia article title.

Optional field, can be nil.

### description

```objectivec
@property (nonatomic, readonly, nullable) NSString *description;
```

Encyclopedia article body.

Optional field, can be nil.

### attribution

```objectivec
@property (nonatomic, readonly, nullable) YMKAttribution *attribution;
```

Attribution information.

Optional field, can be nil.
