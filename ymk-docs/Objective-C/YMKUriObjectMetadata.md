---
title: "YMKUriObjectMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKUriObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKUriObjectMetadata.html"
---
# YMKUriObjectMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKUriObjectMetadata.html)

```objectivec
@interface YMKUriObjectMetadata : NSObject <YMKBaseMetadata>
```

URI metadata.

## Summary

### Class methods

```objectivec
+ (nonnull YMKUriObjectMetadata *)uriObjectMetadataWithUris:(nonnull NSArray<YMKUri *> *)uris;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKUri *> *uris;
```

Gets a list of URIs

## Class methods

### uriObjectMetadataWithUris:

```objectivec
+ (nonnull YMKUriObjectMetadata *)uriObjectMetadataWithUris:(nonnull NSArray<YMKUri *> *)uris;
```

## Properties

### uris

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKUri *> *uris;
```

Gets a list of URIs.
