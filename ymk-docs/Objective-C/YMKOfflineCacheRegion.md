---
title: "YMKOfflineCacheRegion"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKOfflineCacheRegion"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOfflineCacheRegion.html"
---
# YMKOfflineCacheRegion

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOfflineCacheRegion.html)

```objectivec
@interface YMKOfflineCacheRegion : NSObject
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

## Summary

### Class methods

```objectivec
+ (nonnull YMKOfflineCacheRegion *)regionWithId:( NSUInteger)id
                                           name:(nonnull NSString *)name
                                        country:(nonnull NSString *)country
                                         center:(nonnull YMKPoint *)center
                                           size:(nonnull YMKLocalizedValue *)size
                                    releaseTime:(nonnull NSDate *)releaseTime
                                       parentId:(nullable NSNumber *)parentId;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger id;
```

Region ID

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Name of the region

```objectivec
@property (nonatomic, readonly, nonnull) NSString *country;
```

Country of the region

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *center;
```

Center point

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *size;
```

Region size

```objectivec
@property (nonatomic, readonly, nonnull) NSDate *releaseTime;
```

Returns the region creation time

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *parentId;
```

Region id of the parent region

## Class methods

### regionWithId:name:country:center:size:releaseTime:parentId:

```objectivec
+ (nonnull YMKOfflineCacheRegion *)regionWithId:( NSUInteger)id
                                           name:(nonnull NSString *)name
                                        country:(nonnull NSString *)country
                                         center:(nonnull YMKPoint *)center
                                           size:(nonnull YMKLocalizedValue *)size
                                    releaseTime:(nonnull NSDate *)releaseTime
                                       parentId:(nullable NSNumber *)parentId;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly) NSUInteger id;
```

Region ID.

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Name of the region.

### country

```objectivec
@property (nonatomic, readonly, nonnull) NSString *country;
```

Country of the region.

### center

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *center;
```

Center point.

### size

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *size;
```

Region size

### releaseTime

```objectivec
@property (nonatomic, readonly, nonnull) NSDate *releaseTime;
```

Returns the region creation time.

### parentId

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *parentId;
```

Region id of the parent region.

Optional field, can be nil.
