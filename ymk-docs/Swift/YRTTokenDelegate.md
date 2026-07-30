---
title: "YRTTokenDelegate"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YRTTokenDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTTokenDelegate.html"
---
# YRTTokenDelegate

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTTokenDelegate.html)

```swift
class YRTTokenDelegate : NSObject
```

## Summary

### Instance methods

```swift
func onTokenReceived(withToken token: String)
```

Token was received

```swift
func onPasswordRequired(with data: any YRTPasswordRequiredData)
```

XToken is not valid anymore

```swift
func onTokenRefreshFailed(withMessage message: String)
```

An error occurred during OAuth token refresh (it might be a network error or an invalid response from the authentication server)

## Instance methods

### onTokenReceived(withToken:)

```swift
func onTokenReceived(withToken token: String)
```

Token was received.

### onPasswordRequired(with:)

```swift
func onPasswordRequired(with data: any YRTPasswordRequiredData)
```

XToken is not valid anymore. Password must be re-entered.

The class maintains a strong reference to the object in the 'data' parameter until it (the class) is invalidated.

| Parameters |   |
| --- | --- |
| data | Contains platform-specific data for user input. |

### onTokenRefreshFailed(withMessage:)

```swift
func onTokenRefreshFailed(withMessage message: String)
```

An error occurred during OAuth token refresh (it might be a network error or an invalid response from the authentication server).
