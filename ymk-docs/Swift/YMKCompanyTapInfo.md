---
title: "YMKCompanyTapInfo"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKCompanyTapInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCompanyTapInfo.html"
---
# YMKCompanyTapInfo

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCompanyTapInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKCompanyTapInfo : NSObject
```

## Summary

### Class methods

```swift
 init(permalink: String, screenPoint: YMKScreenPoint)
```

### Properties

```swift
var permalink: String { get }
```

Permalink of the company which icon or text was tapped

```swift
var screenPoint: YMKScreenPoint { get }
```

The screen position of the company tapped icon

## Class methods

### init(permalink:screenPoint:)

```swift
 init(permalink: String, screenPoint: YMKScreenPoint)
```

## Properties

### permalink

```swift
var permalink: String { get }
```

Permalink of the company which icon or text was tapped. The permalink may be used to show company info page

### screenPoint

```swift
var screenPoint: YMKScreenPoint { get }
```

The screen position of the company tapped icon. The screenPoint may be useful in positioning company info page
