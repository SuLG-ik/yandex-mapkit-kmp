---
title: "YMKPanoramaCompanyMarker"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoramaCompanyMarker"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaCompanyMarker.html"
---
# YMKPanoramaCompanyMarker

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaCompanyMarker.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoramaCompanyMarker : NSObject
```

Company marker struct

## Summary

### Class methods

```swift
 init(angularPosition: YMKDirection,
                label: String,
               iconId: String,
            permalink: String)
```

### Properties

```swift
var angularPosition: YMKDirection { get }
```

Angular position, degrees

```swift
var label: String { get }
```

Displayed label

```swift
var iconId: String { get }
```

The company iconId

```swift
var permalink: String { get }
```

Permalink is passed as a parameter to the onCompanyTap method

## Class methods

### init(angularPosition:label:iconId:permalink:)

```swift
 init(angularPosition: YMKDirection,
                label: String,
               iconId: String,
            permalink: String)
```

## Properties

### angularPosition

```swift
var angularPosition: YMKDirection { get }
```

Angular position, degrees. (bearing, tilt) (0, 0) - (north, horizon)

### label

```swift
var label: String { get }
```

Displayed label. For example, a company name 'Sweet market'

### iconId

```swift
var iconId: String { get }
```

The company iconId. The iconId is passed as a parameter to the IconImageFactory and IconUrlProvider

### permalink

```swift
var permalink: String { get }
```

Permalink is passed as a parameter to the onCompanyTap method.
