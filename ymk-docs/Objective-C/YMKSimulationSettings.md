---
title: "YMKSimulationSettings"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSimulationSettings"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSimulationSettings.html"
---
# YMKSimulationSettings

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSimulationSettings.html)

```objectivec
@interface YMKSimulationSettings : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKSimulationSettings *)simulationSettingsWithGeometry:(nonnull YMKPolyline *)geometry
                                                 locationSettings:(nonnull YMKLocationSettings *)locationSettings;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolyline *geometry;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocationSettings *locationSettings;
```

## Class methods

### simulationSettingsWithGeometry:locationSettings:

```objectivec
+ (nonnull YMKSimulationSettings *)simulationSettingsWithGeometry:(nonnull YMKPolyline *)geometry
                                                 locationSettings:(nonnull YMKLocationSettings *)locationSettings;
```

## Properties

### geometry

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolyline *geometry;
```

### locationSettings

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocationSettings *locationSettings;
```
