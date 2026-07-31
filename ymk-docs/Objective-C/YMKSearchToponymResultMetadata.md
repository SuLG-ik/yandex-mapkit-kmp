---
title: "YMKSearchToponymResultMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchToponymResultMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchToponymResultMetadata.html"
---
# YMKSearchToponymResultMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchToponymResultMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchToponymResultMetadata : NSObject <YMKBaseMetadata>
```

Common info for response from toponym search.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchToponymResultMetadata *)toponymResultMetadataWithFound:( NSInteger)found
                                                              responseInfo:(nullable YMKSearchToponymResultMetadataResponseInfo *)responseInfo
                                                              reversePoint:(nullable YMKPoint *)reversePoint;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSInteger found;
```

Approximate number of found objects

```objectivec
@property (nonatomic, readonly, nullable)
    YMKSearchToponymResultMetadataResponseInfo *responseInfo;
```

Additional response info

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *reversePoint;
```

The search coordinates given via 'll' or parsed from 'text' (only in reverse mode)

## Class methods

### toponymResultMetadataWithFound:responseInfo:reversePoint:

```objectivec
+ (nonnull YMKSearchToponymResultMetadata *)toponymResultMetadataWithFound:( NSInteger)found
                                                              responseInfo:(nullable YMKSearchToponymResultMetadataResponseInfo *)responseInfo
                                                              reversePoint:(nullable YMKPoint *)reversePoint;
```

## Properties

### found

```objectivec
@property (nonatomic, readonly) NSInteger found;
```

Approximate number of found objects.

### responseInfo

```objectivec
@property (nonatomic, readonly, nullable)
    YMKSearchToponymResultMetadataResponseInfo *responseInfo;
```

Additional response info.

Optional field, can be nil.

### reversePoint

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *reversePoint;
```

The search coordinates given via 'll' or parsed from 'text' (only in reverse mode).

Optional field, can be nil.
