---
title: "YMKSuggestType"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKSuggestType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSuggestType.html"
---
# YMKSuggestType

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSuggestType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
struct YMKSuggestType : OptionSet, @unchecked Sendable
```

Bitmask for requested suggest types.

## Summary

### Enum cases

```swift
static var geo: YMKSuggestType { get }
```

Toponyms

```swift
static var biz: YMKSuggestType { get }
```

Companies

```swift
static var transit: YMKSuggestType { get }
```

Mass transit routes

```swift
static var oneOrg: YMKSuggestType { get }
```

Organization that can be uniquely identified by search request

```swift
static var chain: YMKSuggestType { get }
```

Chains

```swift
static var rubric: YMKSuggestType { get }
```

Rubrics

```swift
static var textHint: YMKSuggestType { get }
```

Text hints

```swift
static var promoQuery: YMKSuggestType { get }
```

Promo queries

```swift
static var coords: YMKSuggestType { get }
```

Coordinates

## Enum cases

### geo

```swift
static var geo: YMKSuggestType { get }
```

Toponyms.

### biz

```swift
static var biz: YMKSuggestType { get }
```

Companies.

### transit

```swift
static var transit: YMKSuggestType { get }
```

Mass transit routes.

### oneOrg

```swift
static var oneOrg: YMKSuggestType { get }
```

Organization that can be uniquely identified by search request.

### chain

```swift
static var chain: YMKSuggestType { get }
```

Chains.

### rubric

```swift
static var rubric: YMKSuggestType { get }
```

Rubrics.

### textHint

```swift
static var textHint: YMKSuggestType { get }
```

Text hints.

### promoQuery

```swift
static var promoQuery: YMKSuggestType { get }
```

Promo queries.

### coords

```swift
static var coords: YMKSuggestType { get }
```

Coordinates.
