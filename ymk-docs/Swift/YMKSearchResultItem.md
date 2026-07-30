---
title: "YMKSearchResultItem"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchResultItem"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchResultItem.html"
---
# YMKSearchResultItem

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchResultItem.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchResultItem : NSObject
```

Wrapper of the GeoObject in response, which makes it easy to get the certain fields from GeoObject

## Summary

### Instance methods

```swift
func hasDetails() -> Bool
```

Does the GeoObject contain details for subtitle

```swift
func details() -> [YMKSearchSubtitleItem]
```

Details for the subtitle

```swift
func isCollection() -> Bool
```

Is it a collection GeoObject

```swift
func isClosed() -> Bool
```

Is the organization closed now

```swift
func isOffline() -> Bool
```

Is the GeoObject found in offline search

### Properties

```swift
var id: String { get }
```

Id (constructed inside)

```swift
var name: String { get }
```

Name (from GeoObject)

```swift
var categoryClass: String? { get }
```

CategoryClass (optional, first if there are several)

Optional property, can be nil

```swift
var geoObject: YMKGeoObject { get }
```

Wrapped GeoObject itself

```swift
var point: YMKPoint { get }
```

Point from the GeoObject

## Instance methods

### hasDetails()

```swift
func hasDetails() -> Bool
```

Does the GeoObject contain details for subtitle

### details()

```swift
func details() -> [YMKSearchSubtitleItem]
```

Details for the subtitle

### isCollection()

```swift
func isCollection() -> Bool
```

Is it a collection GeoObject

### isClosed()

```swift
func isClosed() -> Bool
```

Is the organization closed now

### isOffline()

```swift
func isOffline() -> Bool
```

Is the GeoObject found in offline search

## Properties

### id

```swift
var id: String { get }
```

Id (constructed inside)

### name

```swift
var name: String { get }
```

Name (from GeoObject)

### categoryClass

```swift
var categoryClass: String? { get }
```

CategoryClass (optional, first if there are several)

Optional property, can be nil.

### geoObject

```swift
var geoObject: YMKGeoObject { get }
```

Wrapped GeoObject itself

### point

```swift
var point: YMKPoint { get }
```

Point from the GeoObject
