---
title: "YMKSearch"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearch"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearch.html"
---
# YMKSearch

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearch.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearch : NSObject
```

## Summary

### Instance methods

```swift
func createSearchLayer(with mapWindow: YMKMapWindow) -> YMKSearchLayer
```

Gets the search_layer object

```swift
func createSearchManager(with searchManagerType: YMKSearchManagerType) -> YMKSearchManager
```

Creates a manager that allows to search for various geographical objects using a variety of parameters

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### createSearchLayer(with:)

```swift
func createSearchLayer(with mapWindow: YMKMapWindow) -> YMKSearchLayer
```

Gets the search_layer object.

### createSearchManager(with:)

```swift
func createSearchManager(with searchManagerType: YMKSearchManagerType) -> YMKSearchManager
```

Creates a manager that allows to search for various geographical objects using a variety of parameters.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
