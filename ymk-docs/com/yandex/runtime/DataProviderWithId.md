---
title: "DataProviderWithId"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.runtime"
section: "Android / Справочник / com.yandex.runtime / DataProviderWithId"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/DataProviderWithId.html"
---
# DataProviderWithId

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/DataProviderWithId.html)

**Package** com.yandex.runtime

`interface DataProviderWithId`

Provides any data.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `providerId()`<br>Use the same id for the identical data, to prevent repeated loading of the same data into RAM and VRAM. |
| `byte[]` | `load()`<br>Returns data. |

## Methods

### providerId

```java
@AnyThread @NonNull
java.lang.String providerId()
```

Use the same id for the identical data, to prevent repeated loading of the same data into RAM and VRAM.

This method may be called on any thread. Its implementation must be thread-safe.

### load

```java
@WorkerThread @NonNull
byte[] load()
```

Returns data.

This method will be called on a background thread.
