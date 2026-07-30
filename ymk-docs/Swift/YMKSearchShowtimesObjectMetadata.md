---
title: "YMKSearchShowtimesObjectMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchShowtimesObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchShowtimesObjectMetadata.html"
---
# YMKSearchShowtimesObjectMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchShowtimesObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchShowtimesObjectMetadata : NSObject, YMKBaseMetadata
```

Event schedule snippet.

## Summary

### Class methods

```swift
 init(title: String, showtimes: [YMKSearchShowtime])
```

### Properties

```swift
var title: String { get }
```

Event title

```swift
var showtimes: [YMKSearchShowtime] { get }
```

List of showtimes

## Class methods

### init(title:showtimes:)

```swift
 init(title: String, showtimes: [YMKSearchShowtime])
```

## Properties

### title

```swift
var title: String { get }
```

Event title.

### showtimes

```swift
var showtimes: [YMKSearchShowtime] { get }
```

List of showtimes.
