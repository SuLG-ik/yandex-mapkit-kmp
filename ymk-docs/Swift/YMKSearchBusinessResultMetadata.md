---
title: "YMKSearchBusinessResultMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchBusinessResultMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessResultMetadata.html"
---
# YMKSearchBusinessResultMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessResultMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchBusinessResultMetadata : NSObject
```

Common info for business search response.

## Summary

### Class methods

```swift
 init(categories: [YMKSearchCategory],
          chains: [YMKSearchChain],
 businessFilters: [YMKSearchBusinessFilter],
 importantFilters: YMKSearchFilterSet?,
    filterGroups: [YMKSearchBusinessFilterGroup],
 pricesCurrencies: [String])
```

### Properties

```swift
var categories: [YMKSearchCategory] { get }
```

List of categories (also known as rubrics) present in response

```swift
var chains: [YMKSearchChain] { get }
```

List of chains present in response

```swift
var businessFilters: [YMKSearchBusinessFilter] { get }
```

List of applicable filters

```swift
var importantFilters: YMKSearchFilterSet? { get }
```

Collection of filters that probably are of utmost interest to the user

```swift
var filterGroups: [YMKSearchBusinessFilterGroup] { get }
```

Grouped BusinessFilter's by their meaning

```swift
var pricesCurrencies: [String] { get }
```

Relevant currency for the prices

## Class methods

### init(categories:chains:businessFilters:importantFilters:filterGroups:pricesCurrencies:)

```swift
 init(categories: [YMKSearchCategory],
          chains: [YMKSearchChain],
 businessFilters: [YMKSearchBusinessFilter],
 importantFilters: YMKSearchFilterSet?,
    filterGroups: [YMKSearchBusinessFilterGroup],
 pricesCurrencies: [String])
```

## Properties

### categories

```swift
var categories: [YMKSearchCategory] { get }
```

List of categories (also known as rubrics) present in response. Non-empty list means that the request was treated as a 'category request' by the server (for example requests like "where to eat", "cinema", and other).

### chains

```swift
var chains: [YMKSearchChain] { get }
```

List of chains present in response. Non-empty list means that the request was treaded as 'chain request' (for example "mcdonalds", "starbucks", and other).

### businessFilters

```swift
var businessFilters: [YMKSearchBusinessFilter] { get }
```

List of applicable filters.

### importantFilters

```swift
var importantFilters: YMKSearchFilterSet? { get }
```

Collection of filters that probably are of utmost interest to the user.

Optional field, can be nil.

### filterGroups

```swift
var filterGroups: [YMKSearchBusinessFilterGroup] { get }
```

Grouped BusinessFilter's by their meaning.

### pricesCurrencies

```swift
var pricesCurrencies: [String] { get }
```

Relevant currency for the prices
