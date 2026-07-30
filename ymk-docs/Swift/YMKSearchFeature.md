---
title: "YMKSearchFeature"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchFeature"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFeature.html"
---
# YMKSearchFeature

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFeature.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchFeature : NSObject
```

Describes some common feature of organizations. Can be of three types:

- boolean (like on/off switch, as for free Wi-Fi availability).
- enumerated (can have multiple values at once, like cuisine types in a cafe).
- text (like enumerated but with any strings instead of predefined values).

## Summary

### Class methods

```swift
 init(id: String,
   value: YMKSearchFeatureVariantValue,
    name: String?,
    aref: String?,
 iconLight: YMKImage?,
 iconDark: YMKImage?)
```

### Properties

```swift
var id: String { get }
```

Machine readable feature identifier

```swift
var value: YMKSearchFeatureVariantValue { get }
```

Feature value (depends on feature type)

```swift
var name: String? { get }
```

Human readable localized representation

```swift
var aref: String? { get }
```

Reference to information source providing given feature (see YMKAttribution)

Optional field, can be nil

```swift
var iconLight: YMKImage? { get }
```

Optional field, can be nil

```swift
var iconDark: YMKImage? { get }
```

Optional field, can be nil

## Class methods

### init(id:value:name:aref:iconLight:iconDark:)

```swift
 init(id: String,
   value: YMKSearchFeatureVariantValue,
    name: String?,
    aref: String?,
 iconLight: YMKImage?,
 iconDark: YMKImage?)
```

## Properties

### id

```swift
var id: String { get }
```

Machine readable feature identifier.

### value

```swift
var value: YMKSearchFeatureVariantValue { get }
```

Feature value (depends on feature type).

### name

```swift
var name: String? { get }
```

Human readable localized representation.

Optional field, can be nil.

### aref

```swift
var aref: String? { get }
```

Reference to information source providing given feature (see YMKAttribution)

Optional field, can be nil.

### iconLight

```swift
var iconLight: YMKImage? { get }
```

Optional field, can be nil.

### iconDark

```swift
var iconDark: YMKImage? { get }
```

Optional field, can be nil.
