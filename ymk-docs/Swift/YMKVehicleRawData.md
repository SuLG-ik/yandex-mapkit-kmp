---
title: "YMKVehicleRawData"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKVehicleRawData"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKVehicleRawData.html"
---
# YMKVehicleRawData

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKVehicleRawData.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKVehicleRawData : NSObject, YMKBaseMetadata
```

Represents a mass transport unit on the map

## Summary

### Class methods

```swift
 init(id: String, threadId: String, line: YMKMasstransitLine)
```

### Properties

```swift
var id: String { get }
```

Id of a vehicle

```swift
var threadId: String { get }
```

Id of the line thread on which the vehicle is running

```swift
var line: YMKMasstransitLine { get }
```

Stores the vehicle's public transport line info

## Class methods

### init(id:threadId:line:)

```swift
 init(id: String, threadId: String, line: YMKMasstransitLine)
```

## Properties

### id

```swift
var id: String { get }
```

Id of a vehicle

### threadId

```swift
var threadId: String { get }
```

Id of the line thread on which the vehicle is running

### line

```swift
var line: YMKMasstransitLine { get }
```

Stores the vehicle's public transport line info
