---
title: "YMKBaseDataSource"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBaseDataSource"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBaseDataSource.html"
---
# YMKBaseDataSource

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBaseDataSource.html)

```swift
class YMKBaseDataSource : NSObject
```

## Summary

### Properties

```swift
var id: String { get }
```

Stores id of data source

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Properties

### id

```swift
var id: String { get }
```

Stores id of data source.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
