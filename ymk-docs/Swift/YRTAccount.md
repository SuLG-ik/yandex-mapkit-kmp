---
title: "YRTAccount"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YRTAccount"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTAccount.html"
---
# YRTAccount

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTAccount.html)

```swift
protocol YRTAccount : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func uid() -> String
```

Get the user's UID

This method may be called on any thread

```swift
func requestToken(withTokenListener tokenListener: YRTTokenDelegate)
```

Makes a token request for the provider

```swift
func invalidateToken(_ token: String)
```

Invalidates the OAuth token for an active account

```swift
func httpAuth(withToken token: String) -> String?
```

Creates the HTTP authorization header for requests

## Instance methods

### uid()

```swift
func uid() -> String
```

Get the user's UID

This method may be called on any thread. Its implementation must be thread-safe.

### requestToken(withTokenListener:)

```swift
func requestToken(withTokenListener tokenListener: YRTTokenDelegate)
```

Makes a token request for the provider. This method may be called often (per each request). For best perfomance your implementation should cache the token. See YRTTokenDelegate for additional information.

This method may be called on any thread. Its implementation must be thread-safe.

### invalidateToken(_:)

```swift
func invalidateToken(_ token: String)
```

Invalidates the OAuth token for an active account. The next token request occurs on a new OAuth token request from XToken.

This method may be called on any thread. Its implementation must be thread-safe.

### httpAuth(withToken:)

```swift
func httpAuth(withToken token: String) -> String?
```

Creates the HTTP authorization header for requests. return null if default authorization needed ('OAuth token').

This method may be called on any thread. Its implementation must be thread-safe.
