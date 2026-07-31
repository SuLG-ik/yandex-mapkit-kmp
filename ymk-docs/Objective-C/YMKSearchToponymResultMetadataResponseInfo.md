---
title: "YMKSearchToponymResultMetadataResponseInfo"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchToponymResultMetadataResponseInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchToponymResultMetadataResponseInfo.html"
---
# YMKSearchToponymResultMetadataResponseInfo

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchToponymResultMetadataResponseInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchToponymResultMetadataResponseInfo : NSObject
```

Additional response info.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchToponymResultMetadataResponseInfo *)responseInfoWithMode:( YMKSearchToponymResultMetadataSearchMode)mode
                                                                    accuracy:(nullable NSNumber *)accuracy;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKSearchToponymResultMetadataSearchMode mode;
```

Search mode

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *accuracy;
```

Search response accuracy

## Class methods

### responseInfoWithMode:accuracy:

```objectivec
+ (nonnull YMKSearchToponymResultMetadataResponseInfo *)responseInfoWithMode:( YMKSearchToponymResultMetadataSearchMode)mode
                                                                    accuracy:(nullable NSNumber *)accuracy;
```

## Properties

### mode

```objectivec
@property (nonatomic, readonly) YMKSearchToponymResultMetadataSearchMode mode;
```

Search mode.

### accuracy

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *accuracy;
```

Search response accuracy.

Optional field, can be nil.
