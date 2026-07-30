---
title: "YMKMasstransitStop"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitStop"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitStop.html"
---
# YMKMasstransitStop

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitStop : NSObject <YMKBaseMetadata>
```

Describes a public transport stop.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitStop *)stopWithId:(nonnull NSString *)id
                                      name:(nonnull NSString *)name
                            additionalName:(nullable NSString *)additionalName
                                  features:(nullable YMKMasstransitStopFeatureMask *)features
                         transportContours:(nonnull NSArray<YMKMasstransitTransportContour *> *)transportContours;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Stop ID

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Stop name

```objectivec
@property (nonatomic, readonly, nullable) NSString *additionalName;
```

Additional stop name

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitStopFeatureMask *features;
```

Additional stop features

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTransportContour *> *transportContours;
```

Describes transport contours represented at this Stop

## Class methods

### stopWithId:name:additionalName:features:transportContours:

```objectivec
+ (nonnull YMKMasstransitStop *)stopWithId:(nonnull NSString *)id
                                      name:(nonnull NSString *)name
                            additionalName:(nullable NSString *)additionalName
                                  features:(nullable YMKMasstransitStopFeatureMask *)features
                         transportContours:(nonnull NSArray<YMKMasstransitTransportContour *> *)transportContours;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Stop ID.

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Stop name.

### additionalName

```objectivec
@property (nonatomic, readonly, nullable) NSString *additionalName;
```

Additional stop name. Can be a local number or specifying index. Similar to thread description, but for stops

Optional field, can be nil.

### features

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitStopFeatureMask *features;
```

Additional stop features.

Optional field, can be nil.

### transportContours

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTransportContour *> *transportContours;
```

Describes transport contours represented at this Stop.
