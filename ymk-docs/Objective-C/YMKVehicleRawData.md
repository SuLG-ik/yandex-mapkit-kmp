---
title: "YMKVehicleRawData"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKVehicleRawData"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKVehicleRawData.html"
---
# YMKVehicleRawData

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKVehicleRawData.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKVehicleRawData : NSObject <YMKBaseMetadata>
```

Represents a mass transport unit on the map

## Summary

### Class methods

```objectivec
+ (nonnull YMKVehicleRawData *)vehicleRawDataWithId:(nonnull NSString *)id
                                           threadId:(nonnull NSString *)threadId
                                               line:(nonnull YMKMasstransitLine *)line;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Id of a vehicle

```objectivec
@property (nonatomic, readonly, nonnull) NSString *threadId;
```

Id of the line thread on which the vehicle is running

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitLine *line;
```

Stores the vehicle's public transport line info

## Class methods

### vehicleRawDataWithId:threadId:line:

```objectivec
+ (nonnull YMKVehicleRawData *)vehicleRawDataWithId:(nonnull NSString *)id
                                           threadId:(nonnull NSString *)threadId
                                               line:(nonnull YMKMasstransitLine *)line;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Id of a vehicle

### threadId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *threadId;
```

Id of the line thread on which the vehicle is running

### line

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitLine *line;
```

Stores the vehicle's public transport line info
