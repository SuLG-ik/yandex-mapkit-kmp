---
title: "YMKSearchLayerRequestType"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKSearchLayerRequestType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchLayerRequestType.html"
---
# YMKSearchLayerRequestType

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchLayerRequestType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
enum YMKSearchLayerRequestType : UInt, @unchecked Sendable
```

Type of search layer's search requests.

## Summary

### Enum cases

```swift
case newQuery = 0
```

Primary request initiated via new query methods

```swift
case manualResubmit = 1
```

Manual resubmit on search layer

```swift
case fetchNextPage = 2
```

Request to fetch next page of results

```swift
case mapMoveByApp = 3
```

Request was initiated by map moved via API call

```swift
case mapMoveByGesture = 4
```

Request was initiated by map moved via user gesture

## Enum cases

### newQuery

```swift
case newQuery = 0
```

Primary request initiated via new query methods.

### manualResubmit

```swift
case manualResubmit = 1
```

Manual resubmit on search layer.

### fetchNextPage

```swift
case fetchNextPage = 2
```

Request to fetch next page of results.

### mapMoveByApp

```swift
case mapMoveByApp = 3
```

Request was initiated by map moved via API call.

### mapMoveByGesture

```swift
case mapMoveByGesture = 4
```

Request was initiated by map moved via user gesture.
