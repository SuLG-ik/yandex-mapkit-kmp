---
title: "YMKMasstransitInclineSection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitInclineSection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitInclineSection.html"
---
# YMKMasstransitInclineSection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitInclineSection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitInclineSection : NSObject
```

represents a section of continuous non-trivial gradient

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitInclineSection *)inclineSectionWithType:( YMKMasstransitInclineType)type
                                                     subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKMasstransitInclineType type;
```

Vague characteristic of this gradient secion

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *subpolyline;
```

A subpolyline of the route where the section is located

## Class methods

### inclineSectionWithType:subpolyline:

```objectivec
+ (nonnull YMKMasstransitInclineSection *)inclineSectionWithType:( YMKMasstransitInclineType)type
                                                     subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

## Properties

### type

```objectivec
@property (nonatomic, readonly) YMKMasstransitInclineType type;
```

Vague characteristic of this gradient secion

### subpolyline

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *subpolyline;
```

A subpolyline of the route where the section is located
