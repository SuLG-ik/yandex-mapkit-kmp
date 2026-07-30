---
title: "YMKSuggestOptions"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSuggestOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSuggestOptions.html"
---
# YMKSuggestOptions

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSuggestOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSuggestOptions : NSObject
```

Struct to fine-tune suggest request.

## Summary

### Class methods

```swift
 init(suggestTypes: YMKSuggestType,
      userPosition: YMKPoint?,
      suggestWords: Bool,
      strictBounds: Bool)
```

### Instance methods

```swift
init()
```

### Properties

```swift
var suggestTypes: YMKSuggestType { get set }
```

The suggest type can be one of YMKSuggestType values or their bitwise 'OR' combination

```swift
var userPosition: YMKPoint? { get set }
```

The server uses the user position to calculate the distance from the user to suggest results

```swift
var suggestWords: Bool { get set }
```

Enable word-by-word suggestion items

```swift
var strictBounds: Bool { get set }
```

Strictly limit the output and keep only objects that fall within the window

## Class methods

### init(suggestTypes:userPosition:suggestWords:strictBounds:)

```swift
 init(suggestTypes: YMKSuggestType,
      userPosition: YMKPoint?,
      suggestWords: Bool,
      strictBounds: Bool)
```

## Instance methods

### init()

```swift
init()
```

## Properties

### suggestTypes

```swift
var suggestTypes: YMKSuggestType { get set }
```

The suggest type can be one of YMKSuggestType values or their bitwise 'OR' combination. If suggestType is not initialized, it means to use server-defined types.

### userPosition

```swift
var userPosition: YMKPoint? { get set }
```

The server uses the user position to calculate the distance from the user to suggest results.

Optional field, can be nil.

### suggestWords

```swift
var suggestWords: Bool { get set }
```

Enable word-by-word suggestion items.

### strictBounds

```swift
var strictBounds: Bool { get set }
```

Strictly limit the output and keep only objects that fall within the window. The window is advisory in nature and doesn't impose strict restrictions on search results, helping to select the most relevant hints.
