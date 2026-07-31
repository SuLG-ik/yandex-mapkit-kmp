---
title: "YMKSearchResultItem"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchResultItem"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchResultItem.html"
---
# YMKSearchResultItem

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchResultItem.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchResultItem : NSObject
```

Wrapper of the GeoObject in response, which makes it easy to get the certain fields from GeoObject

## Summary

### Instance methods

```objectivec
- (BOOL)hasDetails;
```

Does the GeoObject contain details for subtitle

```objectivec
- (nonnull NSArray<YMKSearchSubtitleItem *> *)details;
```

Details for the subtitle

```objectivec
- (BOOL)isCollection;
```

Is it a collection GeoObject

```objectivec
- (BOOL)isClosed;
```

Is the organization closed now

```objectivec
- (BOOL)isOffline;
```

Is the GeoObject found in offline search

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Id (constructed inside)

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Name (from GeoObject)

```objectivec
@property (nonatomic, readonly, nullable) NSString *categoryClass;
```

CategoryClass (optional, first if there are several)

Optional property, can be nil

```objectivec
@property (nonatomic, readonly, nonnull) YMKGeoObject *geoObject;
```

Wrapped GeoObject itself

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *point;
```

Point from the GeoObject

## Instance methods

### hasDetails

```objectivec
- (BOOL)hasDetails;
```

Does the GeoObject contain details for subtitle

### details

```objectivec
- (nonnull NSArray<YMKSearchSubtitleItem *> *)details;
```

Details for the subtitle

### isCollection

```objectivec
- (BOOL)isCollection;
```

Is it a collection GeoObject

### isClosed

```objectivec
- (BOOL)isClosed;
```

Is the organization closed now

### isOffline

```objectivec
- (BOOL)isOffline;
```

Is the GeoObject found in offline search

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Id (constructed inside)

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Name (from GeoObject)

### categoryClass

```objectivec
@property (nonatomic, readonly, nullable) NSString *categoryClass;
```

CategoryClass (optional, first if there are several)

Optional property, can be nil.

### geoObject

```objectivec
@property (nonatomic, readonly, nonnull) YMKGeoObject *geoObject;
```

Wrapped GeoObject itself

### point

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *point;
```

Point from the GeoObject
