---
title: "YMKAttributionAuthor"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKAttributionAuthor"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAttributionAuthor.html"
---
# YMKAttributionAuthor

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAttributionAuthor.html)

```swift
class YMKAttributionAuthor : NSObject
```

## Summary

### Class methods

```swift
 init(name: String, uri: String?, email: String?)
```

### Properties

```swift
var name: String { get }
```

```swift
var uri: String? { get }
```

A reference to the author's site

```swift
var email: String? { get }
```

Author's email

## Class methods

### init(name:uri:email:)

```swift
 init(name: String, uri: String?, email: String?)
```

## Properties

### name

```swift
var name: String { get }
```

### uri

```swift
var uri: String? { get }
```

A reference to the author's site.

Optional field, can be nil.

### email

```swift
var email: String? { get }
```

Author's email. Must contain at least one @ symbol.

Optional field, can be nil.
