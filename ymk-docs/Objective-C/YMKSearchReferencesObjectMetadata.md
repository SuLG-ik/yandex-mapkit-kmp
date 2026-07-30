---
title: "YMKSearchReferencesObjectMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchReferencesObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchReferencesObjectMetadata.html"
---
# YMKSearchReferencesObjectMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchReferencesObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchReferencesObjectMetadata : NSObject <YMKBaseMetadata>
```

Reference metadata information.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchReferencesObjectMetadata *)referencesObjectMetadataWithReferences:(nonnull NSArray<YMKSearchReferenceType *> *)references;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchReferenceType *> *references;
```

The list of references

## Class methods

### referencesObjectMetadataWithReferences:

```objectivec
+ (nonnull YMKSearchReferencesObjectMetadata *)referencesObjectMetadataWithReferences:(nonnull NSArray<YMKSearchReferenceType *> *)references;
```

## Properties

### references

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchReferenceType *> *references;
```

The list of references.
