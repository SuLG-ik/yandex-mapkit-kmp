---
title: "YMKMasstransitLine"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitLine"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitLine.html"
---
# YMKMasstransitLine

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitLine.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitLine : NSObject <YMKBaseMetadata>
```

Describes a public transport line.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitLine *)lineWithId:(nonnull NSString *)id
                                      name:(nonnull NSString *)name
                              vehicleTypes:(nonnull NSArray<NSString *> *)vehicleTypes
                                     style:(nullable YMKMasstransitLineStyle *)style
                                   isNight:( BOOL)isNight
                                       uri:(nullable NSString *)uri
                                 shortName:(nullable NSString *)shortName
                         transportSystemId:(nullable NSString *)transportSystemId;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Line ID

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Line name

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *vehicleTypes;
```

List of line types

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitLineStyle *style;
```

Line style; see YMKMasstransitLineStyle

```objectivec
@property (nonatomic, readonly) BOOL isNight;
```

True if the line operates only at night

```objectivec
@property (nonatomic, readonly, nullable) NSString *uri;
```

URI for a line

```objectivec
@property (nonatomic, readonly, nullable) NSString *shortName;
```

Subway short line name

```objectivec
@property (nonatomic, readonly, nullable) NSString *transportSystemId;
```

Subway transport system ID

## Class methods

### lineWithId:name:vehicleTypes:style:isNight:uri:shortName:transportSystemId:

```objectivec
+ (nonnull YMKMasstransitLine *)lineWithId:(nonnull NSString *)id
                                      name:(nonnull NSString *)name
                              vehicleTypes:(nonnull NSArray<NSString *> *)vehicleTypes
                                     style:(nullable YMKMasstransitLineStyle *)style
                                   isNight:( BOOL)isNight
                                       uri:(nullable NSString *)uri
                                 shortName:(nullable NSString *)shortName
                         transportSystemId:(nullable NSString *)transportSystemId;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Line ID.

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Line name.

### vehicleTypes

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *vehicleTypes;
```

List of line types. Starts from the most detailed, ends with the most general.

### style

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitLineStyle *style;
```

Line style; see YMKMasstransitLineStyle.

Optional field, can be nil.

### isNight

```objectivec
@property (nonatomic, readonly) BOOL isNight;
```

True if the line operates only at night.

### uri

```objectivec
@property (nonatomic, readonly, nullable) NSString *uri;
```

URI for a line.

Optional field, can be nil.

### shortName

```objectivec
@property (nonatomic, readonly, nullable) NSString *shortName;
```

Subway short line name.

Optional field, can be nil.

### transportSystemId

```objectivec
@property (nonatomic, readonly, nullable) NSString *transportSystemId;
```

Subway transport system ID.

Optional field, can be nil.
