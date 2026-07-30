---
title: "YMKBaseDataSourceBuilder"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBaseDataSourceBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBaseDataSourceBuilder.html"
---
# YMKBaseDataSourceBuilder

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBaseDataSourceBuilder.html)

```swift
class YMKBaseDataSourceBuilder : NSObject
```

## Summary

### Instance methods

```swift
func setImageUrlProviderWith(_ urlProvider: any YMKImagesImageUrlProvider)
```

The class does not retain the object in the 'urlProvider' parameter

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setImageUrlProviderWith(_:)

```swift
func setImageUrlProviderWith(_ urlProvider: any YMKImagesImageUrlProvider)
```

The class does not retain the object in the 'urlProvider' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
