---
title: "YMKMasstransitToponym"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitToponym"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitToponym.html"
---
# YMKMasstransitToponym

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitToponym.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitToponym : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitToponym *)toponymWithToponym:(nullable NSString *)toponym
                                    accusativeToponym:(nullable NSString *)accusativeToponym;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) NSString *toponym;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSString *accusativeToponym;
```

Toponym in accusative case with preposition

Optional field, can be nil

## Class methods

### toponymWithToponym:accusativeToponym:

```objectivec
+ (nonnull YMKMasstransitToponym *)toponymWithToponym:(nullable NSString *)toponym
                                    accusativeToponym:(nullable NSString *)accusativeToponym;
```

## Properties

### toponym

```objectivec
@property (nonatomic, readonly, nullable) NSString *toponym;
```

Optional field, can be nil.

### accusativeToponym

```objectivec
@property (nonatomic, readonly, nullable) NSString *accusativeToponym;
```

Toponym in accusative case with preposition

Optional field, can be nil.
