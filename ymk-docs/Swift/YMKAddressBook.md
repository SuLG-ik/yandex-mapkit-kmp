---
title: "YMKAddressBook"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKAddressBook"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAddressBook.html"
---
# YMKAddressBook

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAddressBook.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKAddressBook : NSObject
```

## Summary

### Class methods

```swift
 init(home: YMKAddressRecord?,
      work: YMKAddressRecord?,
 favorites: [YMKAddressRecord],
 customCollections: [YMKAddressCollection])
```

### Properties

```swift
var home: YMKAddressRecord? { get }
```

Optional field, can be nil

```swift
var work: YMKAddressRecord? { get }
```

Optional field, can be nil

```swift
var favorites: [YMKAddressRecord] { get }
```

```swift
var customCollections: [YMKAddressCollection] { get }
```

## Class methods

### init(home:work:favorites:customCollections:)

```swift
 init(home: YMKAddressRecord?,
      work: YMKAddressRecord?,
 favorites: [YMKAddressRecord],
 customCollections: [YMKAddressCollection])
```

## Properties

### home

```swift
var home: YMKAddressRecord? { get }
```

Optional field, can be nil.

### work

```swift
var work: YMKAddressRecord? { get }
```

Optional field, can be nil.

### favorites

```swift
var favorites: [YMKAddressRecord] { get }
```

### customCollections

```swift
var customCollections: [YMKAddressCollection] { get }
```
