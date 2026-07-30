---
title: "YMKSearchPlaceInfo"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchPlaceInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPlaceInfo.html"
---
# YMKSearchPlaceInfo

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPlaceInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchPlaceInfo : NSObject
```

Related place information.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchPlaceInfo *)placeInfoWithName:(nonnull NSString *)name
                                              uri:(nullable NSString *)uri
                                 photoUrlTemplate:(nullable NSString *)photoUrlTemplate
                                            logId:(nullable NSString *)logId
                                            point:(nullable YMKPoint *)point
                                         category:(nullable NSString *)category
                                        shortName:(nullable NSString *)shortName
                                           rating:(nullable NSNumber *)rating
                                     workingHours:(nullable YMKSearchWorkingHours *)workingHours
                                          address:(nullable NSString *)address
                                              tag:(nonnull NSArray<NSString *> *)tag;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Place name

```objectivec
@property (nonatomic, readonly, nullable) NSString *uri;
```

Place URI

```objectivec
@property (nonatomic, readonly, nullable) NSString *photoUrlTemplate;
```

Url template for place photo

```objectivec
@property (nonatomic, readonly, nullable) NSString *logId;
```

Server-generated log identifier

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *point;
```

Place position

```objectivec
@property (nonatomic, readonly, nullable) NSString *category;
```

Place category as a string

```objectivec
@property (nonatomic, readonly, nullable) NSString *shortName;
```

Short name for a place

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *rating;
```

Place rating as number in 0 to 10 range

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchWorkingHours *workingHours;
```

Open hours for a place

```objectivec
@property (nonatomic, readonly, nullable) NSString *address;
```

Formatted address for an organization

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tag;
```

Tags

## Class methods

### placeInfoWithName:uri:photoUrlTemplate:logId:point:category:shortName:rating:workingHours:address:tag:

```objectivec
+ (nonnull YMKSearchPlaceInfo *)placeInfoWithName:(nonnull NSString *)name
                                              uri:(nullable NSString *)uri
                                 photoUrlTemplate:(nullable NSString *)photoUrlTemplate
                                            logId:(nullable NSString *)logId
                                            point:(nullable YMKPoint *)point
                                         category:(nullable NSString *)category
                                        shortName:(nullable NSString *)shortName
                                           rating:(nullable NSNumber *)rating
                                     workingHours:(nullable YMKSearchWorkingHours *)workingHours
                                          address:(nullable NSString *)address
                                              tag:(nonnull NSArray<NSString *> *)tag;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Place name.

### uri

```objectivec
@property (nonatomic, readonly, nullable) NSString *uri;
```

Place URI.

Optional field, can be nil.

### photoUrlTemplate

```objectivec
@property (nonatomic, readonly, nullable) NSString *photoUrlTemplate;
```

Url template for place photo.

Optional field, can be nil.

### logId

```objectivec
@property (nonatomic, readonly, nullable) NSString *logId;
```

Server-generated log identifier.

Optional field, can be nil.

### point

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *point;
```

Place position.

Optional field, can be nil.

### category

```objectivec
@property (nonatomic, readonly, nullable) NSString *category;
```

Place category as a string.

Optional field, can be nil.

### shortName

```objectivec
@property (nonatomic, readonly, nullable) NSString *shortName;
```

Short name for a place.

Optional field, can be nil.

### rating

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *rating;
```

Place rating as number in 0 to 10 range.

Optional field, can be nil.

### workingHours

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchWorkingHours *workingHours;
```

Open hours for a place.

Optional field, can be nil.

### address

```objectivec
@property (nonatomic, readonly, nullable) NSString *address;
```

Formatted address for an organization.

Optional field, can be nil.

### tag

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *tag;
```

Tags
