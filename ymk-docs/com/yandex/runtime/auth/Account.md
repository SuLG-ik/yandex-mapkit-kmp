---
title: "Account"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.runtime.auth"
section: "Android / Справочник / com.yandex.runtime.auth / Account"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/auth/Account.html"
---
# Account

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/auth/Account.html)

**Package** com.yandex.runtime.auth

`interface Account`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `uid()`<br>Get the user's UID<br>This method may be called on any thread. |
| `void` | `requestToken(@NonNull TokenListener tokenListener)`<br>Makes a token request for the provider. |
| `void` | `invalidateToken(@NonNull java.lang.String token)`<br>Invalidates the OAuth token for an active account. |
| `java.lang.String` | `httpAuth(@NonNull java.lang.String token)`<br>Creates the HTTP authorization header for requests. |

## Methods

### uid

```java
@AnyThread @NonNull
java.lang.String uid()
```

Get the user's UID

This method may be called on any thread.

Its implementation must be thread-safe.

### requestToken

```java
@AnyThread
void requestToken(@NonNull TokenListener tokenListener)
```

Makes a token request for the provider.

This method may be called often (per each request). For best perfomance your implementation should cache the token. See [runtime.auth.TokenListener](TokenListener.md) for additional information.

This method may be called on any thread. Its implementation must be thread-safe.

### invalidateToken

```java
@AnyThread
void invalidateToken(@NonNull java.lang.String token)
```

Invalidates the OAuth token for an active account.

The next token request occurs on a new OAuth token request from XToken.

This method may be called on any thread. Its implementation must be thread-safe.

### httpAuth

```java
@AnyThread @Nullable
java.lang.String httpAuth(@NonNull java.lang.String token)
```

Creates the HTTP authorization header for requests.

return null if default authorization needed ('OAuth token').

This method may be called on any thread. Its implementation must be thread-safe.
