---
title: "YMKCompanyTapInfo"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKCompanyTapInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCompanyTapInfo.html"
---
# YMKCompanyTapInfo

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCompanyTapInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKCompanyTapInfo : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKCompanyTapInfo *)companyTapInfoWithPermalink:(nonnull NSString *)permalink
                                               screenPoint:(nonnull YMKScreenPoint *)screenPoint;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *permalink;
```

Permalink of the company which icon or text was tapped

```objectivec
@property (nonatomic, readonly, nonnull) YMKScreenPoint *screenPoint;
```

The screen position of the company tapped icon

## Class methods

### companyTapInfoWithPermalink:screenPoint:

```objectivec
+ (nonnull YMKCompanyTapInfo *)companyTapInfoWithPermalink:(nonnull NSString *)permalink
                                               screenPoint:(nonnull YMKScreenPoint *)screenPoint;
```

## Properties

### permalink

```objectivec
@property (nonatomic, readonly, nonnull) NSString *permalink;
```

Permalink of the company which icon or text was tapped. The permalink may be used to show company info page

### screenPoint

```objectivec
@property (nonatomic, readonly, nonnull) YMKScreenPoint *screenPoint;
```

The screen position of the company tapped icon. The screenPoint may be useful in positioning company info page
