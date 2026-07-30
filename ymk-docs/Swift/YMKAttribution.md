---
title: "YMKAttribution"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKAttribution"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAttribution.html"
---
# YMKAttribution

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAttribution.html)

```swift
class YMKAttribution : NSObject
```

Details about the source of information.

## Summary

### Class methods

```swift
 init(author: YMKAttributionAuthor?,
        link: YMKAttributionLink?,
 avatarImage: YMKImage?)
```

### Properties

```swift
var author: YMKAttributionAuthor? { get }
```

Additional information about the author

```swift
var link: YMKAttributionLink? { get }
```

Link to a specific page on the author's site

```swift
var avatarImage: YMKImage? { get }
```

Optional field, can be nil

## Class methods

### init(author:link:avatarImage:)

```swift
 init(author: YMKAttributionAuthor?,
        link: YMKAttributionLink?,
 avatarImage: YMKImage?)
```

## Properties

### author

```swift
var author: YMKAttributionAuthor? { get }
```

Additional information about the author.

Optional field, can be nil.

### link

```swift
var link: YMKAttributionLink? { get }
```

Link to a specific page on the author's site. To link to the website as a whole, use author.uri.

Optional field, can be nil.

### avatarImage

```swift
var avatarImage: YMKImage? { get }
```

Optional field, can be nil.
