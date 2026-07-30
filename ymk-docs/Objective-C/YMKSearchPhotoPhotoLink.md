---
title: "YMKSearchPhotoPhotoLink"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchPhotoPhotoLink"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPhotoPhotoLink.html"
---
# YMKSearchPhotoPhotoLink

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchPhotoPhotoLink.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchPhotoPhotoLink : NSObject
```

Photo link details.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchPhotoPhotoLink *)photoLinkWithType:(nullable NSString *)type
                                                   uri:(nonnull NSString *)uri;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *type;
```

Optional link type, for example "panorama"

```objectivec
@property (nonatomic, readonly, nonnull) NSString *uri;
```

Link URI

## Class methods

### photoLinkWithType:uri:

```objectivec
+ (nonnull YMKSearchPhotoPhotoLink *)photoLinkWithType:(nullable NSString *)type
                                                   uri:(nonnull NSString *)uri;
```

## Properties

### type

```objectivec
@property (nonatomic, readonly, nullable) NSString *type;
```

Optional link type, for example "panorama".

Optional field, can be nil.

### uri

```objectivec
@property (nonatomic, readonly, nonnull) NSString *uri;
```

Link URI.
