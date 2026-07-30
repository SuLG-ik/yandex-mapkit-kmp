---
title: "YMKSearchBusinessRating1xObjectMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchBusinessRating1xObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessRating1xObjectMetadata.html"
---
# YMKSearchBusinessRating1xObjectMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessRating1xObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchBusinessRating1xObjectMetadata : NSObject, YMKBaseMetadata
```

Snippet for company ratings. Score from 0 to 5.

## Summary

### Class methods

```swift
 init(ratings: UInt, reviews: UInt, score: NSNumber?)
```

### Properties

```swift
var ratings: UInt { get }
```

Total number of ratings

```swift
var reviews: UInt { get }
```

Total number of reviews

```swift
var score: NSNumber? { get }
```

Average rating score for the company (0 to 5)

## Class methods

### init(ratings:reviews:score:)

```swift
 init(ratings: UInt, reviews: UInt, score: NSNumber?)
```

## Properties

### ratings

```swift
var ratings: UInt { get }
```

Total number of ratings.

### reviews

```swift
var reviews: UInt { get }
```

Total number of reviews.

### score

```swift
var score: NSNumber? { get }
```

Average rating score for the company (0 to 5).

Optional field, can be nil.
