---
title: "TokenListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.runtime.auth"
section: "Android / Справочник / com.yandex.runtime.auth / TokenListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/auth/TokenListener.html"
---
# TokenListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/auth/TokenListener.html)

**Package** com.yandex.runtime.auth

`interface TokenListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onTokenReceived(@NonNull java.lang.String token)`<br>Token was received. |
| `void` | `onPasswordRequired(@NonNull PasswordRequiredData data)`<br>XToken is not valid anymore. |
| `void` | `onTokenRefreshFailed(@NonNull java.lang.String message)`<br>An error occurred during OAuth token refresh (it might be a network error or an invalid response from the authentication server). |

## Methods

### onTokenReceived

```java
void onTokenReceived(@NonNull java.lang.String token)
```

Token was received.

### onPasswordRequired

```java
void onPasswordRequired(@NonNull PasswordRequiredData data)
```

XToken is not valid anymore.

Password must be re-entered.

The class maintains a strong reference to the object in the 'data' parameter until it (the class) is invalidated.

| Parameters |   |
| --- | --- |
| `data` | Contains platform-specific data for user input. |

### onTokenRefreshFailed

```java
void onTokenRefreshFailed(@NonNull java.lang.String message)
```

An error occurred during OAuth token refresh (it might be a network error or an invalid response from the authentication server).
