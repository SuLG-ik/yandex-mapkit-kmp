---
title: "YMKMasstransitTransport"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitTransport"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTransport.html"
---
# YMKMasstransitTransport

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTransport.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitTransport : NSObject
```

Contains information about the mass transit ride section of a YMKMasstransitRoute for a specific mass transit YMKMasstransitLine.

## Summary

### Class methods

```swift
 init(line: YMKMasstransitLine,
 transports: [YMKMasstransitTransportTransportThread],
 transportContours: [YMKMasstransitTransportContour])
```

### Properties

```swift
var line: YMKMasstransitLine { get }
```

Mass transit line

```swift
var transports: [YMKMasstransitTransportTransportThread] { get }
```

Collection of mass transit threads of the specified line suitable for the constructed route

```swift
var transportContours: [YMKMasstransitTransportContour] { get }
```

Describes YMKMasstransitTransportContour in borders of which this block is located

## Class methods

### init(line:transports:transportContours:)

```swift
 init(line: YMKMasstransitLine,
 transports: [YMKMasstransitTransportTransportThread],
 transportContours: [YMKMasstransitTransportContour])
```

## Properties

### line

```swift
var line: YMKMasstransitLine { get }
```

Mass transit line.

### transports

```swift
var transports: [YMKMasstransitTransportTransportThread] { get }
```

Collection of mass transit threads of the specified line suitable for the constructed route.

### transportContours

```swift
var transportContours: [YMKMasstransitTransportContour] { get }
```

Describes YMKMasstransitTransportContour in borders of which this block is located
