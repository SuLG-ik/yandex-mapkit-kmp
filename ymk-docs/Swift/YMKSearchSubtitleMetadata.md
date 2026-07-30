---
title: "YMKSearchSubtitleMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchSubtitleMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSubtitleMetadata.html"
---
# YMKSearchSubtitleMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSubtitleMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchSubtitleMetadata : NSObject, YMKBaseMetadata
```

Subtitle snippet.

## Summary

### Class methods

```swift
 init(subtitleItems: [YMKSearchSubtitleItem],
  serpSubtitleItems: [YMKSearchSubtitleItem])
```

### Properties

```swift
var subtitleItems: [YMKSearchSubtitleItem] { get }
```

List of subtitles

```swift
var serpSubtitleItems: [YMKSearchSubtitleItem] { get }
```

List of subtitles to be displayed in SERP

## Class methods

### init(subtitleItems:serpSubtitleItems:)

```swift
 init(subtitleItems: [YMKSearchSubtitleItem],
  serpSubtitleItems: [YMKSearchSubtitleItem])
```

## Properties

### subtitleItems

```swift
var subtitleItems: [YMKSearchSubtitleItem] { get }
```

List of subtitles.

### serpSubtitleItems

```swift
var serpSubtitleItems: [YMKSearchSubtitleItem] { get }
```

List of subtitles to be displayed in SERP.
