---
title: "YMKSearchSuggestSession"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchSuggestSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSuggestSession.html"
---
# YMKSearchSuggestSession

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSuggestSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchSuggestSession : NSObject
```

## Summary

### Instance methods

```swift
func suggest(withText text: String,
                    window: YMKBoundingBox,
            suggestOptions: YMKSuggestOptions,
           responseHandler: @escaping YMKSearchSuggestSessionResponseHandler)
```

Begin a suggest request

```swift
func reset()
```

Cancels current suggest request and resets internal state

## Instance methods

### suggest(withText:window:suggestOptions:responseHandler:)

```swift
func suggest(withText text: String,
                    window: YMKBoundingBox,
            suggestOptions: YMKSuggestOptions,
           responseHandler: @escaping YMKSearchSuggestSessionResponseHandler)
```

Begin a suggest request. The current request is cancelled, if present.

| Parameters |   |
| --- | --- |
| text | Text to get suggestions for. |
| window | Current map window position. |
| suggestOptions | Various additional suggest parameters. See the YMKSuggestOptions definition for details. |
| suggestListener | Function called when the result is ready. |

### reset()

```swift
func reset()
```

Cancels current suggest request and resets internal state. Next queries via this suggest session will be seen as a new suggest session from backend point of view.
