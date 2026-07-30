---
title: "YMKAddressRecord"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKAddressRecord"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAddressRecord.html"
---
# YMKAddressRecord

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKAddressRecord.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKAddressRecord : NSObject
```

## Summary

### Class methods

```swift
 init(title: String,
 description: String?,
    comment: String?,
    address: String?,
   geometry: YMKGeometry?,
        uri: String?)
```

### Properties

```swift
var title: String { get }
```

```swift
var description: String? { get }
```

Optional field, can be nil

```swift
var comment: String? { get }
```

Optional field, can be nil

```swift
var address: String? { get }
```

Optional field, can be nil

```swift
var geometry: YMKGeometry? { get }
```

Optional field, can be nil

```swift
var uri: String? { get }
```

Optional field, can be nil

## Class methods

### init(title:description:comment:address:geometry:uri:)

```swift
 init(title: String,
 description: String?,
    comment: String?,
    address: String?,
   geometry: YMKGeometry?,
        uri: String?)
```

## Properties

### title

```swift
var title: String { get }
```

### description

```swift
var description: String? { get }
```

Optional field, can be nil.

### comment

```swift
var comment: String? { get }
```

Optional field, can be nil.

### address

```swift
var address: String? { get }
```

Optional field, can be nil.

### geometry

```swift
var geometry: YMKGeometry? { get }
```

Optional field, can be nil.

### uri

```swift
var uri: String? { get }
```

Optional field, can be nil.
