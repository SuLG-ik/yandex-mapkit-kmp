---
title: "YMKSearchDeleteAllPersonalSuggestSession"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchDeleteAllPersonalSuggestSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchDeleteAllPersonalSuggestSession.html"
---
# YMKSearchDeleteAllPersonalSuggestSession

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchDeleteAllPersonalSuggestSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchDeleteAllPersonalSuggestSession : NSObject
```

Interface to handle remove all user personalized suggest request. Allows request cancellation and retry.

## Summary

### Instance methods

```swift
func cancel()
```

Cancels the current request

```swift
func retry(personalSuggestHandler: @escaping YMKSearchDeleteAllPersonalSuggestSessionPersonalSuggestHandler)
```

Retries the last request

## Instance methods

### cancel()

```swift
func cancel()
```

Cancels the current request.

### retry(personalSuggestHandler:)

```swift
func retry(personalSuggestHandler: @escaping YMKSearchDeleteAllPersonalSuggestSessionPersonalSuggestHandler)
```

Retries the last request. If there is an active request, it is cancelled.

| Parameters |   |
| --- | --- |
| personalSuggestListener | Listener to handle result. |
