---
title: "YMKDummyLocationManager"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDummyLocationManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDummyLocationManager.html"
---
# YMKDummyLocationManager

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDummyLocationManager.html)

```swift
class YMKDummyLocationManager : YMKLocationManager
```

> [!NOTE] Примечание
> The main reason why we need this class is to allow the user to set this LocationManager to Guide via setLocationManager, just to correct any desirable location via Guide.

Provides the ability to set any location and notify all consumers of this location.

This is a very simple location manager that is responsible for passing any locations via setLocation method and notifying all consumers.

## Summary

### Instance methods

```swift
func setLocationWith(_ location: YMKLocation, quality: YMKDummyLocationQuality)
```

Sets a location and notifies all consumers of this location

## Instance methods

### setLocationWith(_:quality:)

```swift
func setLocationWith(_ location: YMKLocation, quality: YMKDummyLocationQuality)
```

Sets a location and notifies all consumers of this location.

| Parameters |   |
| --- | --- |
| location | Any desirable location that we would like to provide. |
