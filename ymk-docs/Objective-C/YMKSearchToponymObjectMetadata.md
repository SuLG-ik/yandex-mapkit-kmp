---
title: "YMKSearchToponymObjectMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchToponymObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchToponymObjectMetadata.html"
---
# YMKSearchToponymObjectMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchToponymObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchToponymObjectMetadata : NSObject <YMKBaseMetadata>
```

Additional data for toponym objects.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchToponymObjectMetadata *)toponymObjectMetadataWithAddress:(nonnull YMKSearchAddress *)address
                                                                   precision:(nullable NSNumber *)precision
                                                                  formerName:(nullable NSString *)formerName
                                                                balloonPoint:(nonnull YMKPoint *)balloonPoint
                                                                       geoId:( NSInteger)geoId
                                                                          id:(nullable NSString *)id;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKSearchAddress *address;
```

Structured toponym address

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *precision;
```

Toponym precision

```objectivec
@property (nonatomic, readonly, nullable) NSString *formerName;
```

Former name for toponym if any

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *balloonPoint;
```

Point where balloon for the toponym should be shown

```objectivec
@property (nonatomic, readonly) NSInteger geoId;
```

geobase id

```objectivec
@property (nonatomic, readonly, nullable) NSString *id;
```

Persistent toponym id (available for Yandex-owned regions)

## Class methods

### toponymObjectMetadataWithAddress:precision:formerName:balloonPoint:geoId:id:

```objectivec
+ (nonnull YMKSearchToponymObjectMetadata *)toponymObjectMetadataWithAddress:(nonnull YMKSearchAddress *)address
                                                                   precision:(nullable NSNumber *)precision
                                                                  formerName:(nullable NSString *)formerName
                                                                balloonPoint:(nonnull YMKPoint *)balloonPoint
                                                                       geoId:( NSInteger)geoId
                                                                          id:(nullable NSString *)id;
```

## Properties

### address

```objectivec
@property (nonatomic, readonly, nonnull) YMKSearchAddress *address;
```

Structured toponym address

### precision

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *precision;
```

Toponym precision.

Optional field, can be nil.

### formerName

```objectivec
@property (nonatomic, readonly, nullable) NSString *formerName;
```

Former name for toponym if any.

Optional field, can be nil.

### balloonPoint

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *balloonPoint;
```

Point where balloon for the toponym should be shown. Differs for direct and reverse search modes: Direct mode -- toponym center. Reverse mode -- toponym nearest point to the given coordinates.

### geoId

```objectivec
@property (nonatomic, readonly) NSInteger geoId;
```

geobase id

### id

```objectivec
@property (nonatomic, readonly, nullable) NSString *id;
```

Persistent toponym id (available for Yandex-owned regions).

Optional field, can be nil.
