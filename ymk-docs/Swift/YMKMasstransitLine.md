---
title: "YMKMasstransitLine"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitLine"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitLine.html"
---
# YMKMasstransitLine

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitLine.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitLine : NSObject, YMKBaseMetadata
```

Describes a public transport line.

## Summary

### Class methods

```swift
 init(id: String,
    name: String,
 vehicleTypes: [String],
   style: YMKMasstransitLineStyle?,
 isNight: Bool,
     uri: String?,
 shortName: String?,
 transportSystemId: String?)
```

### Properties

```swift
var id: String { get }
```

Line ID

```swift
var name: String { get }
```

Line name

```swift
var vehicleTypes: [String] { get }
```

List of line types

```swift
var style: YMKMasstransitLineStyle? { get }
```

Line style; see YMKMasstransitLineStyle

```swift
var isNight: Bool { get }
```

True if the line operates only at night

```swift
var uri: String? { get }
```

URI for a line

```swift
var shortName: String? { get }
```

Subway short line name

```swift
var transportSystemId: String? { get }
```

Subway transport system ID

## Class methods

### init(id:name:vehicleTypes:style:isNight:uri:shortName:transportSystemId:)

```swift
 init(id: String,
    name: String,
 vehicleTypes: [String],
   style: YMKMasstransitLineStyle?,
 isNight: Bool,
     uri: String?,
 shortName: String?,
 transportSystemId: String?)
```

## Properties

### id

```swift
var id: String { get }
```

Line ID.

### name

```swift
var name: String { get }
```

Line name.

### vehicleTypes

```swift
var vehicleTypes: [String] { get }
```

List of line types. Starts from the most detailed, ends with the most general.

### style

```swift
var style: YMKMasstransitLineStyle? { get }
```

Line style; see YMKMasstransitLineStyle.

Optional field, can be nil.

### isNight

```swift
var isNight: Bool { get }
```

True if the line operates only at night.

### uri

```swift
var uri: String? { get }
```

URI for a line.

Optional field, can be nil.

### shortName

```swift
var shortName: String? { get }
```

Subway short line name.

Optional field, can be nil.

### transportSystemId

```swift
var transportSystemId: String? { get }
```

Subway transport system ID.

Optional field, can be nil.
