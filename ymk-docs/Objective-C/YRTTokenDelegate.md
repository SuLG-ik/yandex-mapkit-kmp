---
title: "YRTTokenDelegate"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTTokenDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTTokenDelegate.html"
---
# YRTTokenDelegate

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTTokenDelegate.html)

```objectivec
@interface YRTTokenDelegate : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)onTokenReceivedWithToken:(nonnull NSString *)token;
```

Token was received

```objectivec
- (void)onPasswordRequiredWithData:(nonnull id<YRTPasswordRequiredData>)data;
```

XToken is not valid anymore

```objectivec
- (void)onTokenRefreshFailedWithMessage:(nonnull NSString *)message;
```

An error occurred during OAuth token refresh (it might be a network error or an invalid response from the authentication server)

## Instance methods

### onTokenReceivedWithToken:

```objectivec
- (void)onTokenReceivedWithToken:(nonnull NSString *)token;
```

Token was received.

### onPasswordRequiredWithData:

```objectivec
- (void)onPasswordRequiredWithData:(nonnull id<YRTPasswordRequiredData>)data;
```

XToken is not valid anymore. Password must be re-entered.

The class maintains a strong reference to the object in the 'data' parameter until it (the class) is invalidated.

| Parameters |   |
| --- | --- |
| data | Contains platform-specific data for user input. |

### onTokenRefreshFailedWithMessage:

```objectivec
- (void)onTokenRefreshFailedWithMessage:(nonnull NSString *)message;
```

An error occurred during OAuth token refresh (it might be a network error or an invalid response from the authentication server).
