---
title: "YMKSearchReferenceType"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchReferenceType"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchReferenceType.html"
---
# YMKSearchReferenceType

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchReferenceType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchReferenceType : NSObject
```

The type of reference.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchReferenceType *)referenceTypeWithId:(nonnull NSString *)id
                                                  scope:(nonnull NSString *)scope;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Reference ID

```objectivec
@property (nonatomic, readonly, nonnull) NSString *scope;
```

Reference scope

## Class methods

### referenceTypeWithId:scope:

```objectivec
+ (nonnull YMKSearchReferenceType *)referenceTypeWithId:(nonnull NSString *)id
                                                  scope:(nonnull NSString *)scope;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Reference ID.

### scope

```objectivec
@property (nonatomic, readonly, nonnull) NSString *scope;
```

Reference scope.
