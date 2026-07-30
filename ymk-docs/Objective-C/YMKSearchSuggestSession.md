---
title: "YMKSearchSuggestSession"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchSuggestSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSuggestSession.html"
---
# YMKSearchSuggestSession

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSuggestSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchSuggestSession : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)suggestWithText:(nonnull NSString *)text
                 window:(nonnull YMKBoundingBox *)window
         suggestOptions:(nonnull YMKSuggestOptions *)suggestOptions
        responseHandler:
            (nonnull YMKSearchSuggestSessionResponseHandler)responseHandler;
```

Begin a suggest request

```objectivec
- (void)reset;
```

Cancels current suggest request and resets internal state

## Instance methods

### suggestWithText:window:suggestOptions:responseHandler:

```objectivec
- (void)suggestWithText:(nonnull NSString *)text
                 window:(nonnull YMKBoundingBox *)window
         suggestOptions:(nonnull YMKSuggestOptions *)suggestOptions
        responseHandler:
            (nonnull YMKSearchSuggestSessionResponseHandler)responseHandler;
```

Begin a suggest request. The current request is cancelled, if present.

| Parameters |   |
| --- | --- |
| text | Text to get suggestions for. |
| window | Current map window position. |
| suggestOptions | Various additional suggest parameters. See the YMKSuggestOptions definition for details. |
| suggestListener | Function called when the result is ready. |

### reset

```objectivec
- (void)reset;
```

Cancels current suggest request and resets internal state. Next queries via this suggest session will be seen as a new suggest session from backend point of view.
