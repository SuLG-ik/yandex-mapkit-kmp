---
title: "YMKSearchBusinessPhotoObjectMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchBusinessPhotoObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessPhotoObjectMetadata.html"
---
# YMKSearchBusinessPhotoObjectMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessPhotoObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchBusinessPhotoObjectMetadata : NSObject <YMKBaseMetadata>
```

Snippet for company-related photos (becoming obsolete).

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchBusinessPhotoObjectMetadata *)businessPhotoObjectMetadataWithCount:( NSUInteger)count
                                                                                photos:(nonnull NSArray<YMKSearchBusinessPhotoObjectMetadataPhoto *> *)photos;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger count;
```

Number of photos for the organisation

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchBusinessPhotoObjectMetadataPhoto *> *photos;
```

List of photos for the company (usually first three)

## Class methods

### businessPhotoObjectMetadataWithCount:photos:

```objectivec
+ (nonnull YMKSearchBusinessPhotoObjectMetadata *)businessPhotoObjectMetadataWithCount:( NSUInteger)count
                                                                                photos:(nonnull NSArray<YMKSearchBusinessPhotoObjectMetadataPhoto *> *)photos;
```

## Properties

### count

```objectivec
@property (nonatomic, readonly) NSUInteger count;
```

Number of photos for the organisation. (see PhotosManager for details)

### photos

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchBusinessPhotoObjectMetadataPhoto *> *photos;
```

List of photos for the company (usually first three)
