---
title: "YMKSearchLink"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchLink"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchLink.html"
---
# YMKSearchLink

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchLink.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchLink : NSObject
```

Link structure. Combines actual link with attribution and type info.

## Summary

### Class methods

```swift
 init(aref: String?, link: YMKAttributionLink, tag: String?)
```

### Properties

```swift
var aref: String? { get }
```

Attribution reference

```swift
var link: YMKAttributionLink { get }
```

Actual link

```swift
var tag: String? { get }
```

Link tag

## Class methods

### init(aref:link:tag:)

```swift
 init(aref: String?, link: YMKAttributionLink, tag: String?)
```

## Properties

### aref

```swift
var aref: String? { get }
```

Attribution reference.

Optional field, can be nil.

### link

```swift
var link: YMKAttributionLink { get }
```

Actual link.

### tag

```swift
var tag: String? { get }
```

Link tag. Possible values (non-exhaustive) 'self/social/attribution/showtimes/booking'.

Optional field, can be nil.
