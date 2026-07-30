---
title: "YMKDummyLocationManager"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDummyLocationManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDummyLocationManager.html"
---
# YMKDummyLocationManager

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDummyLocationManager.html)

```objectivec
@interface YMKDummyLocationManager : YMKLocationManager
```

> [!NOTE] Примечание
> The main reason why we need this class is to allow the user to set this LocationManager to Guide via setLocationManager, just to correct any desirable location via Guide.

Provides the ability to set any location and notify all consumers of this location.

This is a very simple location manager that is responsible for passing any locations via setLocation method and notifying all consumers.

## Summary

### Instance methods

```objectivec
- (void)setLocationWithLocation:(nonnull YMKLocation *)location
                        quality:(YMKDummyLocationQuality)quality;
```

Sets a location and notifies all consumers of this location

## Instance methods

### setLocationWithLocation:quality:

```objectivec
- (void)setLocationWithLocation:(nonnull YMKLocation *)location
                        quality:(YMKDummyLocationQuality)quality;
```

Sets a location and notifies all consumers of this location.

| Parameters |   |
| --- | --- |
| location | Any desirable location that we would like to provide. |
