---
title: "YMKSearchBusinessPhotoObjectMetadataPhoto"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchBusinessPhotoObjectMetadataPhoto"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessPhotoObjectMetadataPhoto.html"
---
# YMKSearchBusinessPhotoObjectMetadataPhoto

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessPhotoObjectMetadataPhoto.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchBusinessPhotoObjectMetadataPhoto : NSObject
```

Information about single photos.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchBusinessPhotoObjectMetadataPhoto *)photoWithId:(nonnull NSString *)id
                                                             links:(nonnull NSArray<YMKSearchPhotoPhotoLink *> *)links;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

To get a valid download link use the value of id + /[size], where [size] is one of: 1

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchPhotoPhotoLink *> *links;
```

Photo links

## Class methods

### photoWithId:links:

```objectivec
+ (nonnull YMKSearchBusinessPhotoObjectMetadataPhoto *)photoWithId:(nonnull NSString *)id
                                                             links:(nonnull NSArray<YMKSearchPhotoPhotoLink *> *)links;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

To get a valid download link use the value of id + /[size], where [size] is one of: 1. XXXS 2. XXS 3. XS 4. S 5. M 6. L 7. XL 8. XXL 9. XXXL 10. orig

### links

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchPhotoPhotoLink *> *links;
```

Photo links.
