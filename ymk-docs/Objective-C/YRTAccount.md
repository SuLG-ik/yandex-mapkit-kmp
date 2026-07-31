---
title: "YRTAccount"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YRTAccount"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTAccount.html"
---
# YRTAccount

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTAccount.html)

```objectivec
@protocol YRTAccount <NSObject>
```

## Summary

### Instance methods

```objectivec
- (nonnull NSString *)uid;
```

Get the user's UID

This method may be called on any thread

```objectivec
- (void)requestTokenWithTokenListener:(nonnull YRTTokenDelegate *)tokenListener;
```

Makes a token request for the provider

```objectivec
- (void)invalidateToken:(nonnull NSString *)token;
```

Invalidates the OAuth token for an active account

```objectivec
- (nullable NSString *)httpAuthWithToken:(nonnull NSString *)token;
```

Creates the HTTP authorization header for requests

## Instance methods

### uid

```objectivec
- (nonnull NSString *)uid;
```

Get the user's UID

This method may be called on any thread. Its implementation must be thread-safe.

### requestTokenWithTokenListener:

```objectivec
- (void)requestTokenWithTokenListener:(nonnull YRTTokenDelegate *)tokenListener;
```

Makes a token request for the provider. This method may be called often (per each request). For best perfomance your implementation should cache the token. See YRTTokenDelegate for additional information.

This method may be called on any thread. Its implementation must be thread-safe.

### invalidateToken:

```objectivec
- (void)invalidateToken:(nonnull NSString *)token;
```

Invalidates the OAuth token for an active account. The next token request occurs on a new OAuth token request from XToken.

This method may be called on any thread. Its implementation must be thread-safe.

### httpAuthWithToken:

```objectivec
- (nullable NSString *)httpAuthWithToken:(nonnull NSString *)token;
```

Creates the HTTP authorization header for requests. return null if default authorization needed ('OAuth token').

This method may be called on any thread. Its implementation must be thread-safe.
