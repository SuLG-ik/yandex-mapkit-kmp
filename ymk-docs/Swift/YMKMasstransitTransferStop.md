---
title: "YMKMasstransitTransferStop"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitTransferStop"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTransferStop.html"
---
# YMKMasstransitTransferStop

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTransferStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitTransferStop : NSObject
```

Represents a stop in path which is not a part of any transport trip but must be visited according travelling. For example, exit from subway may require transfer on other stop.

## Summary

### Class methods

```swift
 init(routeStop: YMKMasstransitRouteStop, transports: [YMKMasstransitTransport])
```

### Properties

```swift
var routeStop: YMKMasstransitRouteStop { get }
```

Stop information

```swift
var transports: [YMKMasstransitTransport] { get }
```

Transports at the stops

## Class methods

### init(routeStop:transports:)

```swift
 init(routeStop: YMKMasstransitRouteStop, transports: [YMKMasstransitTransport])
```

## Properties

### routeStop

```swift
var routeStop: YMKMasstransitRouteStop { get }
```

Stop information.

### transports

```swift
var transports: [YMKMasstransitTransport] { get }
```

Transports at the stops
