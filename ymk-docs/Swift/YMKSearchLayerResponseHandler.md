---
title: "YMKSearchLayerResponseHandler"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKSearchLayerResponseHandler"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchLayerResponseHandler.html"
---
# YMKSearchLayerResponseHandler

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchLayerResponseHandler.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKSearchLayerResponseHandler : NSObjectProtocol
```

Interface for callbacks on search events.

## Summary

### Instance methods

```swift
func onSearchStart(with requestType: YMKSearchLayerRequestType)
```

Called when the search starts

```swift
func onSearchSuccess(with requestType: YMKSearchLayerRequestType)
```

Called after a succesful search

```swift
func onSearchErrorWithError(_ error: any Error,
                        requestType: YMKSearchLayerRequestType)
```

Called on any search error

```swift
func onPresentedResultsUpdate()
```

Called when presented results are updated and thus search results list can change

```swift
func onAllResultsClear()
```

Called before all results are cleared

## Instance methods

### onSearchStart(with:)

```swift
func onSearchStart(with requestType: YMKSearchLayerRequestType)
```

Called when the search starts.

| Parameters |   |
| --- | --- |
| requestType | Type of the started request. |

### onSearchSuccess(with:)

```swift
func onSearchSuccess(with requestType: YMKSearchLayerRequestType)
```

Called after a succesful search.

| Parameters |   |
| --- | --- |
| requestType | Type of the finished request. |

### onSearchErrorWithError(_:requestType:)

```swift
func onSearchErrorWithError(_ error: any Error,
                        requestType: YMKSearchLayerRequestType)
```

Called on any search error.

| Parameters |   |
| --- | --- |
| error | Error occured. |
| requestType | Type of the finished request. |

### onPresentedResultsUpdate()

```swift
func onPresentedResultsUpdate()
```

Called when presented results are updated and thus search results list can change.

### onAllResultsClear()

```swift
func onAllResultsClear()
```

Called before all results are cleared.
