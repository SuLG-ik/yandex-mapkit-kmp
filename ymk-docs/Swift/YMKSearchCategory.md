---
title: "YMKSearchCategory"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchCategory"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchCategory.html"
---
# YMKSearchCategory

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchCategory.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchCategory : NSObject
```

Single category (also known as rubric) description.

## Summary

### Class methods

```swift
 init(name: String, categoryClass: String?, tags: [String])
```

### Properties

```swift
var name: String { get }
```

Category name

```swift
var categoryClass: String? { get }
```

Category class

```swift
var tags: [String] { get }
```

Additional non-structured data for the category

## Class methods

### init(name:categoryClass:tags:)

```swift
 init(name: String, categoryClass: String?, tags: [String])
```

## Properties

### name

```swift
var name: String { get }
```

Category name.

### categoryClass

```swift
var categoryClass: String? { get }
```

Category class. Different categories can have the same class. For example, "Bar", "Cafe" and "Restaurant" categories inhabit "restaurants" category class.

Optional field, can be nil.

### tags

```swift
var tags: [String] { get }
```

Additional non-structured data for the category.
