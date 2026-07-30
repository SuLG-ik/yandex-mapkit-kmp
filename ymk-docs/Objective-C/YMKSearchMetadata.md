---
title: "YMKSearchMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchMetadata.html"
---
# YMKSearchMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchMetadata : NSObject <YMKBaseMetadata>
```

Additional info for search response;

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchMetadata *)searchMetadataWithFound:( NSInteger)found
                                           displayType:( YMKSearchDisplayType)displayType
                                           boundingBox:(nullable YMKBoundingBox *)boundingBox
                                                  sort:(nullable YMKSearchSort *)sort
                                               toponym:(nullable YMKGeoObject *)toponym
                                 toponymResultMetadata:(nullable YMKSearchToponymResultMetadata *)toponymResultMetadata
                                businessResultMetadata:(nullable YMKSearchBusinessResultMetadata *)businessResultMetadata
                                                 reqid:(nonnull NSString *)reqid
                                               context:(nonnull NSString *)context
                                           requestText:(nonnull NSString *)requestText
                                  correctedRequestText:(nullable NSString *)correctedRequestText
                                    requestBoundingBox:(nullable YMKBoundingBox *)requestBoundingBox;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSInteger found;
```

Approximate number of found objects

```objectivec
@property (nonatomic, readonly) YMKSearchDisplayType displayType;
```

Display type

```objectivec
@property (nonatomic, readonly, nullable) YMKBoundingBox *boundingBox;
```

Bounding box of the response as a whole

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchSort *sort;
```

Server-chosen sorting

```objectivec
@property (nonatomic, readonly, nullable) YMKGeoObject *toponym;
```

Geocoder response to the toponym part of the query

```objectivec
@property (nonatomic, readonly, nullable)
    YMKSearchToponymResultMetadata *toponymResultMetadata;
```

Additional info for the response from toponym search

```objectivec
@property (nonatomic, readonly, nullable)
    YMKSearchBusinessResultMetadata *businessResultMetadata;
```

Additional info for the response from organization search

```objectivec
@property (nonatomic, readonly, nonnull) NSString *reqid;
```

Server-generated request ID

```objectivec
@property (nonatomic, readonly, nonnull) NSString *context;
```

Server-generated request context

```objectivec
@property (nonatomic, readonly, nonnull) NSString *requestText;
```

Initial request text

```objectivec
@property (nonatomic, readonly, nullable) NSString *correctedRequestText;
```

Initial request text with correction of spelling mistakes

```objectivec
@property (nonatomic, readonly, nullable) YMKBoundingBox *requestBoundingBox;
```

Initial request bounding box

## Class methods

### searchMetadataWithFound:displayType:boundingBox:sort:toponym:toponymResultMetadata:businessResultMetadata:reqid:context:requestText:correctedRequestText:requestBoundingBox:

```objectivec
+ (nonnull YMKSearchMetadata *)searchMetadataWithFound:( NSInteger)found
                                           displayType:( YMKSearchDisplayType)displayType
                                           boundingBox:(nullable YMKBoundingBox *)boundingBox
                                                  sort:(nullable YMKSearchSort *)sort
                                               toponym:(nullable YMKGeoObject *)toponym
                                 toponymResultMetadata:(nullable YMKSearchToponymResultMetadata *)toponymResultMetadata
                                businessResultMetadata:(nullable YMKSearchBusinessResultMetadata *)businessResultMetadata
                                                 reqid:(nonnull NSString *)reqid
                                               context:(nonnull NSString *)context
                                           requestText:(nonnull NSString *)requestText
                                  correctedRequestText:(nullable NSString *)correctedRequestText
                                    requestBoundingBox:(nullable YMKBoundingBox *)requestBoundingBox;
```

## Properties

### found

```objectivec
@property (nonatomic, readonly) NSInteger found;
```

Approximate number of found objects.

### displayType

```objectivec
@property (nonatomic, readonly) YMKSearchDisplayType displayType;
```

Display type.

### boundingBox

```objectivec
@property (nonatomic, readonly, nullable) YMKBoundingBox *boundingBox;
```

Bounding box of the response as a whole.

Optional field, can be nil.

### sort

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchSort *sort;
```

Server-chosen sorting.

Optional field, can be nil.

### toponym

```objectivec
@property (nonatomic, readonly, nullable) YMKGeoObject *toponym;
```

Geocoder response to the toponym part of the query.

Optional field, can be nil.

### toponymResultMetadata

```objectivec
@property (nonatomic, readonly, nullable)
    YMKSearchToponymResultMetadata *toponymResultMetadata;
```

Additional info for the response from toponym search.

Optional field, can be nil.

### businessResultMetadata

```objectivec
@property (nonatomic, readonly, nullable)
    YMKSearchBusinessResultMetadata *businessResultMetadata;
```

Additional info for the response from organization search.

Optional field, can be nil.

### reqid

```objectivec
@property (nonatomic, readonly, nonnull) NSString *reqid;
```

Server-generated request ID.

### context

```objectivec
@property (nonatomic, readonly, nonnull) NSString *context;
```

Server-generated request context.

### requestText

```objectivec
@property (nonatomic, readonly, nonnull) NSString *requestText;
```

Initial request text.

### correctedRequestText

```objectivec
@property (nonatomic, readonly, nullable) NSString *correctedRequestText;
```

Initial request text with correction of spelling mistakes.

Optional field, can be nil.

### requestBoundingBox

```objectivec
@property (nonatomic, readonly, nullable) YMKBoundingBox *requestBoundingBox;
```

Initial request bounding box.

Optional field, can be nil.
