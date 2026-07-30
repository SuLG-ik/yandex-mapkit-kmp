---
title: "YMKSearchLink"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchLink"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchLink.html"
---
# YMKSearchLink

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchLink.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchLink : NSObject
```

Link structure. Combines actual link with attribution and type info.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchLink *)linkWithAref:(nullable NSString *)aref
                                   link:(nonnull YMKAttributionLink *)link
                                    tag:(nullable NSString *)tag;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *aref;
```

Attribution reference

```objectivec
@property (nonatomic, readonly, nonnull) YMKAttributionLink *link;
```

Actual link

```objectivec
@property (nonatomic, readonly, nullable) NSString *tag;
```

Link tag

## Class methods

### linkWithAref:link:tag:

```objectivec
+ (nonnull YMKSearchLink *)linkWithAref:(nullable NSString *)aref
                                   link:(nonnull YMKAttributionLink *)link
                                    tag:(nullable NSString *)tag;
```

## Properties

### aref

```objectivec
@property (nonatomic, readonly, nullable) NSString *aref;
```

Attribution reference.

Optional field, can be nil.

### link

```objectivec
@property (nonatomic, readonly, nonnull) YMKAttributionLink *link;
```

Actual link.

### tag

```objectivec
@property (nonatomic, readonly, nullable) NSString *tag;
```

Link tag. Possible values (non-exhaustive) 'self/social/attribution/showtimes/booking'.

Optional field, can be nil.
