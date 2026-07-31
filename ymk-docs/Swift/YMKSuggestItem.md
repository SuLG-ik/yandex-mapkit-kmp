---
title: "YMKSuggestItem"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSuggestItem"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSuggestItem.html"
---
# YMKSuggestItem

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSuggestItem.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSuggestItem : NSObject
```

A single suggested item.

## Summary

### Class methods

```swift
 init(type: YMKSuggestItemType,
     title: YMKSpannableString,
  subtitle: YMKSpannableString?,
      tags: [String],
 searchText: String,
 displayText: String?,
       uri: String?,
      link: String?,
  distance: YMKLocalizedValue?,
 isPersonal: Bool,
    action: YMKSuggestItemAction,
     logId: String?,
 isOffline: Bool,
 isWordItem: Bool,
 properties: [YRTKeyValuePair],
    center: YMKPoint?,
 businessContext: NSNumber?)
```

### Properties

```swift
var type: YMKSuggestItemType { get }
```

Suggested object type

```swift
var title: YMKSpannableString { get }
```

Short object name

```swift
var subtitle: YMKSpannableString? { get }
```

If type is TOPONYM returns reversed toponym hierarchy, if type is BUSINESS returns business address

```swift
var tags: [String] { get }
```

Additional free-form data for suggest item

```swift
var searchText: String { get }
```

Text to search for

```swift
var displayText: String? { get }
```

Text to display if searchText is too technical to display

```swift
var uri: String? { get }
```

Element uri, if applicable

```swift
var link: String? { get }
```

Element link, if applicable

```swift
var distance: YMKLocalizedValue? { get }
```

Optional distance localized value

```swift
var isPersonal: Bool { get }
```

If the suggested item respects personalization

```swift
var action: YMKSuggestItemAction { get }
```

Action to perform on click/tap/enter

```swift
var logId: String? { get }
```

Id for request logging

```swift
var isOffline: Bool { get }
```

Item is from offline search

```swift
var isWordItem: Bool { get }
```

Item is a word suggest item

```swift
var properties: [YRTKeyValuePair] { get }
```

Additional item properties

```swift
var center: YMKPoint? { get }
```

Position of object

```swift
var businessContext: NSNumber? { get }
```

Detailed subtype of the Business type

Optional field, can be nil

## Class methods

### init(type:title:subtitle:tags:searchText:displayText:uri:link:distance:isPersonal:action:logId:isOffline:isWordItem:properties:center:businessContext:)

```swift
 init(type: YMKSuggestItemType,
     title: YMKSpannableString,
  subtitle: YMKSpannableString?,
      tags: [String],
 searchText: String,
 displayText: String?,
       uri: String?,
      link: String?,
  distance: YMKLocalizedValue?,
 isPersonal: Bool,
    action: YMKSuggestItemAction,
     logId: String?,
 isOffline: Bool,
 isWordItem: Bool,
 properties: [YRTKeyValuePair],
    center: YMKPoint?,
 businessContext: NSNumber?)
```

## Properties

### type

```swift
var type: YMKSuggestItemType { get }
```

Suggested object type.

### title

```swift
var title: YMKSpannableString { get }
```

Short object name.

### subtitle

```swift
var subtitle: YMKSpannableString? { get }
```

If type is TOPONYM returns reversed toponym hierarchy, if type is BUSINESS returns business address.

Optional field, can be nil.

### tags

```swift
var tags: [String] { get }
```

Additional free-form data for suggest item. If type is TOPONYM, returns toponym kind (house/street/locality/...). If type is BUSINESS, returns category class (drugstores/restaurants/...).

### searchText

```swift
var searchText: String { get }
```

Text to search for.

### displayText

```swift
var displayText: String? { get }
```

Text to display if searchText is too technical to display.

Optional field, can be nil.

### uri

```swift
var uri: String? { get }
```

Element uri, if applicable.

Optional field, can be nil.

### link

```swift
var link: String? { get }
```

Element link, if applicable.

Optional field, can be nil.

### distance

```swift
var distance: YMKLocalizedValue? { get }
```

Optional distance localized value.

Optional field, can be nil.

### isPersonal

```swift
var isPersonal: Bool { get }
```

If the suggested item respects personalization.

### action

```swift
var action: YMKSuggestItemAction { get }
```

Action to perform on click/tap/enter.

### logId

```swift
var logId: String? { get }
```

Id for request logging.

Optional field, can be nil.

### isOffline

```swift
var isOffline: Bool { get }
```

Item is from offline search.

### isWordItem

```swift
var isWordItem: Bool { get }
```

Item is a word suggest item.

### properties

```swift
var properties: [YRTKeyValuePair] { get }
```

Additional item properties.

### center

```swift
var center: YMKPoint? { get }
```

Position of object.

Optional field, can be nil.

### businessContext

```swift
var businessContext: NSNumber? { get }
```

Detailed subtype of the Business type

Optional field, can be nil.
