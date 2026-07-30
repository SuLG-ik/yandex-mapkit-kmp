---
title: "YMKDrivingToponymPhrase"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingToponymPhrase"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingToponymPhrase.html"
---
# YMKDrivingToponymPhrase

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingToponymPhrase.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingToponymPhrase : NSObject
```

The description of the object.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingToponymPhrase *)toponymPhraseWithText:(nonnull NSString *)text
                                           actionProximity:(nullable NSNumber *)actionProximity;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

The string containing the description

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *actionProximity;
```

Positions at which text should be pronounced

## Class methods

### toponymPhraseWithText:actionProximity:

```objectivec
+ (nonnull YMKDrivingToponymPhrase *)toponymPhraseWithText:(nonnull NSString *)text
                                           actionProximity:(nullable NSNumber *)actionProximity;
```

## Properties

### text

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

The string containing the description.

### actionProximity

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *actionProximity;
```

Positions at which text should be pronounced.

Optional field, can be nil.
