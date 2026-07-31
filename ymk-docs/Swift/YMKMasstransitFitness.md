---
title: "YMKMasstransitFitness"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitFitness"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitFitness.html"
---
# YMKMasstransitFitness

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitFitness.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitFitness : NSObject
```

Represent a section where we have to move by ourself (like pedestrian, or by bicycle and scooter)

## Summary

### Class methods

```swift
 init(type: YMKMasstransitFitnessType,
 constructions: [YMKMasstransitConstructionSegment],
 restrictedEntries: [YMKRestrictedEntry],
 viaPoints: [YMKPolylinePosition],
 annotations: [YMKMasstransitAnnotation],
 trafficTypes: [YMKMasstransitTrafficTypeSegment],
 elevationData: YMKMasstransitElevationData?,
 indoorSegments: [YMKMasstransitIndoorSegment])
```

### Properties

```swift
var type: YMKMasstransitFitnessType { get }
```

```swift
var constructions: [YMKMasstransitConstructionSegment] { get }
```

Compressed information about constructions along the path

```swift
var restrictedEntries: [YMKRestrictedEntry] { get }
```

List of restricted entries with their coordinates along the path

```swift
var viaPoints: [YMKPolylinePosition] { get }
```

List of via points on the path

```swift
var annotations: [YMKMasstransitAnnotation] { get }
```

List of annotations on the path

```swift
var trafficTypes: [YMKMasstransitTrafficTypeSegment] { get }
```

List of traffic types on path

```swift
var elevationData: YMKMasstransitElevationData? { get }
```

Information on elevation gain and loss in a fitness section

Optional field, can be nil

```swift
var indoorSegments: [YMKMasstransitIndoorSegment] { get }
```

List of indoor segments (levels or connectors) on path

## Class methods

### init(type:constructions:restrictedEntries:viaPoints:annotations:trafficTypes:elevationData:indoorSegments:)

```swift
 init(type: YMKMasstransitFitnessType,
 constructions: [YMKMasstransitConstructionSegment],
 restrictedEntries: [YMKRestrictedEntry],
 viaPoints: [YMKPolylinePosition],
 annotations: [YMKMasstransitAnnotation],
 trafficTypes: [YMKMasstransitTrafficTypeSegment],
 elevationData: YMKMasstransitElevationData?,
 indoorSegments: [YMKMasstransitIndoorSegment])
```

## Properties

### type

```swift
var type: YMKMasstransitFitnessType { get }
```

### constructions

```swift
var constructions: [YMKMasstransitConstructionSegment] { get }
```

Compressed information about constructions along the path. YMKMasstransitConstructionSegment::subpolyline fields of all segments cover the entire geometry of corresponding section".

### restrictedEntries

```swift
var restrictedEntries: [YMKRestrictedEntry] { get }
```

List of restricted entries with their coordinates along the path.

### viaPoints

```swift
var viaPoints: [YMKPolylinePosition] { get }
```

List of via points on the path. A via point is described by the index of the point in the route geometry polyline.

### annotations

```swift
var annotations: [YMKMasstransitAnnotation] { get }
```

List of annotations on the path.

### trafficTypes

```swift
var trafficTypes: [YMKMasstransitTrafficTypeSegment] { get }
```

List of traffic types on path

### elevationData

```swift
var elevationData: YMKMasstransitElevationData? { get }
```

Information on elevation gain and loss in a fitness section

Optional field, can be nil.

### indoorSegments

```swift
var indoorSegments: [YMKMasstransitIndoorSegment] { get }
```

List of indoor segments (levels or connectors) on path. Compressed information about levels along the path. YMKMasstransitIndoorSegment::subpolyline fields of all indoor segments cover only the indoor geometry, it does not cover outdoor parts.
