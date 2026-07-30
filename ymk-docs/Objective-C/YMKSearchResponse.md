---
title: "YMKSearchResponse"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchResponse"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchResponse.html"
---
# YMKSearchResponse

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchResponse.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchResponse : NSObject
```

Top level structure for search response.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchResponse *)responseWithMetadata:(nonnull YMKSearchMetadata *)metadata
                                         collection:(nonnull YMKGeoObjectCollection *)collection
                                          isOffline:( BOOL)isOffline;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKSearchMetadata *metadata;
```

Extended response information

```objectivec
@property (nonatomic, readonly, nonnull) YMKGeoObjectCollection *collection;
```

List of objects (organizations, toponyms) in search response

```objectivec
@property (nonatomic, readonly) BOOL isOffline;
```

Flag describing if this response was built offline

## Class methods

### responseWithMetadata:collection:isOffline:

```objectivec
+ (nonnull YMKSearchResponse *)responseWithMetadata:(nonnull YMKSearchMetadata *)metadata
                                         collection:(nonnull YMKGeoObjectCollection *)collection
                                          isOffline:( BOOL)isOffline;
```

## Properties

### metadata

```objectivec
@property (nonatomic, readonly, nonnull) YMKSearchMetadata *metadata;
```

Extended response information.

### collection

```objectivec
@property (nonatomic, readonly, nonnull) YMKGeoObjectCollection *collection;
```

List of objects (organizations, toponyms) in search response.

### isOffline

```objectivec
@property (nonatomic, readonly) BOOL isOffline;
```

Flag describing if this response was built offline.
