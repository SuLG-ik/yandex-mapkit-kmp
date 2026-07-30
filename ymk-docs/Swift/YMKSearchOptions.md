---
title: "YMKSearchOptions"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchOptions.html"
---
# YMKSearchOptions

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchOptions : NSObject
```

Struct to fine-tune search request.

## Summary

### Class methods

```swift
 init(searchTypes: YMKSearchType,
   resultPageSize: NSNumber?,
         snippets: YMKSearchSnippet,
     userPosition: YMKPoint?,
           origin: String?,
         geometry: Bool,
 disableSpellingCorrection: Bool,
          filters: YMKSearchFilterCollection?)
```

### Instance methods

```swift
init()
```

### Properties

```swift
var searchTypes: YMKSearchType { get set }
```

The search type can be one of the YMKSearchType values or their bitwise 'OR' combination

```swift
@NSCopying var resultPageSize: NSNumber? { get set }
```

Maximum number of search results per page

```swift
var snippets: YMKSearchSnippet { get set }
```

Snippets that will be requested

```swift
var userPosition: YMKPoint? { get set }
```

The server uses the user position to calculate the distance from the user to search results

```swift
var origin: String? { get set }
```

String that sets an identifier for the request source

```swift
var geometry: Bool { get set }
```

Adds the geometry to the server response

```swift
var disableSpellingCorrection: Bool { get set }
```

Force disable correction of spelling mistakes

```swift
var filters: YMKSearchFilterCollection? { get set }
```

Filter set that will be requested

## Class methods

### init(searchTypes:resultPageSize:snippets:userPosition:origin:geometry:disableSpellingCorrection:filters:)

```swift
 init(searchTypes: YMKSearchType,
   resultPageSize: NSNumber?,
         snippets: YMKSearchSnippet,
     userPosition: YMKPoint?,
           origin: String?,
         geometry: Bool,
 disableSpellingCorrection: Bool,
          filters: YMKSearchFilterCollection?)
```

## Instance methods

### init()

```swift
init()
```

## Properties

### searchTypes

```swift
var searchTypes: YMKSearchType { get set }
```

The search type can be one of the YMKSearchType values or their bitwise 'OR' combination. If searchType is not initialized, it means to search in all the sources.

### resultPageSize

```swift
@NSCopying var resultPageSize: NSNumber? { get set }
```

Maximum number of search results per page.

Optional field, can be nil.

### snippets

```swift
var snippets: YMKSearchSnippet { get set }
```

Snippets that will be requested. The value should be one of YMKSearchSnippet, or their bitwise 'OR' combination.

### userPosition

```swift
var userPosition: YMKPoint? { get set }
```

The server uses the user position to calculate the distance from the user to search results.

Optional field, can be nil.

### origin

```swift
var origin: String? { get set }
```

String that sets an identifier for the request source.

Optional field, can be nil.

### geometry

```swift
var geometry: Bool { get set }
```

Adds the geometry to the server response.

### disableSpellingCorrection

```swift
var disableSpellingCorrection: Bool { get set }
```

Force disable correction of spelling mistakes.

### filters

```swift
var filters: YMKSearchFilterCollection? { get set }
```

Filter set that will be requested. Please note that the full set of filters that can be applied can only be obtained after the primary request. If you pass an invalid filter to the primary request (for example, "pharmacy with swimming pool"), the behavior is undefined. That is the search can either ignore an invalid filter or return an empty response.

Optional field, can be nil.
