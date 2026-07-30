---
title: "Error"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.runtime"
section: "Android / Справочник / com.yandex.runtime / Error"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/Error.html"
---
# Error

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/Error.html)

**Package** com.yandex.runtime

## All known Subinterfaces:

*[CacheUnavailableError](../mapkit/search/CacheUnavailableError.md)*, *[LocalError](LocalError.md)*, *[LocationUnavailableError](../mapkit/location/LocationUnavailableError.md)*, *[NetworkError](network/NetworkError.md)*, *[NotFoundError](../mapkit/places/panorama/NotFoundError.md)*, *[RemoteError](network/RemoteError.md)*, *[TooComplexAvoidedZonesError](../mapkit/directions/driving/TooComplexAvoidedZonesError.md)*

`interface Error`

An error has occurred.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `isValid()`<br>Tells if this **Error** is valid or not. |

## Methods

### isValid

```java
boolean isValid()
```

Tells if this **Error** is valid or not.

Any other method (except for this one) called on an invalid **Error** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
