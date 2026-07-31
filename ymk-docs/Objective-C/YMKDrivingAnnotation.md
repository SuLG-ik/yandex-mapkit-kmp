---
title: "YMKDrivingAnnotation"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingAnnotation"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingAnnotation.html"
---
# YMKDrivingAnnotation

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingAnnotation.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingAnnotation : NSObject
```

The annotation that is displayed on the map.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingAnnotation *)annotationWithAction:( YMKDrivingAction)action
                                               toponym:(nullable NSString *)toponym
                                       descriptionText:(nonnull NSString *)descriptionText
                                        actionMetadata:(nullable YMKDrivingActionMetadata *)actionMetadata
                                             landmarks:(nonnull NSArray<NSNumber *> *)landmarks
                                         toponymPhrase:(nonnull NSArray<YMKDrivingToponymPhrase *> *)toponymPhrase;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKDrivingAction action;
```

Driver action

```objectivec
@property (nonatomic, readonly, nullable) NSString *toponym;
```

The toponym of the location

```objectivec
@property (nonatomic, readonly, nonnull) NSString *descriptionText;
```

Description text to display

```objectivec
@property (nonatomic, readonly, nullable)
    YMKDrivingActionMetadata *actionMetadata;
```

Action metadata

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *landmarks;
```

Significant landmarks

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingToponymPhrase *> *toponymPhrase;
```

Toponym phrases with positions for pronunciation

## Class methods

### annotationWithAction:toponym:descriptionText:actionMetadata:landmarks:toponymPhrase:

```objectivec
+ (nonnull YMKDrivingAnnotation *)annotationWithAction:( YMKDrivingAction)action
                                               toponym:(nullable NSString *)toponym
                                       descriptionText:(nonnull NSString *)descriptionText
                                        actionMetadata:(nullable YMKDrivingActionMetadata *)actionMetadata
                                             landmarks:(nonnull NSArray<NSNumber *> *)landmarks
                                         toponymPhrase:(nonnull NSArray<YMKDrivingToponymPhrase *> *)toponymPhrase;
```

## Properties

### action

```objectivec
@property (nonatomic, readonly) YMKDrivingAction action;
```

Driver action.

### toponym

```objectivec
@property (nonatomic, readonly, nullable) NSString *toponym;
```

The toponym of the location.

Optional field, can be nil.

### descriptionText

```objectivec
@property (nonatomic, readonly, nonnull) NSString *descriptionText;
```

Description text to display.

### actionMetadata

```objectivec
@property (nonatomic, readonly, nullable)
    YMKDrivingActionMetadata *actionMetadata;
```

Action metadata.

Optional field, can be nil.

### landmarks

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *landmarks;
```

Significant landmarks.

### toponymPhrase

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingToponymPhrase *> *toponymPhrase;
```

Toponym phrases with positions for pronunciation.
