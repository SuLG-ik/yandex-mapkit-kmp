---
title: "YMKSearchPanoramasObjectMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchPanoramasObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPanoramasObjectMetadata.html"
---
# YMKSearchPanoramasObjectMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPanoramasObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchPanoramasObjectMetadata : NSObject <YMKBaseMetadata>
```

Snippet data to get panoramas info.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchPanoramasObjectMetadata *)panoramasObjectMetadataWithPanoramas:(nonnull NSArray<YMKSearchPanorama *> *)panoramas;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchPanorama *> *panoramas;
```

List of panoramas

## Class methods

### panoramasObjectMetadataWithPanoramas:

```objectivec
+ (nonnull YMKSearchPanoramasObjectMetadata *)panoramasObjectMetadataWithPanoramas:(nonnull NSArray<YMKSearchPanorama *> *)panoramas;
```

## Properties

### panoramas

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchPanorama *> *panoramas;
```

List of panoramas.
