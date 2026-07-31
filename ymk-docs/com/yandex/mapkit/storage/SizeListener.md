---
title: "SizeListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.storage"
section: "Android / Справочник / com.yandex.mapkit.storage / SizeListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/storage/SizeListener.html"
---
# SizeListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/storage/SizeListener.html)

**Package** com.yandex.mapkit.storage

`static interface SizeListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onSuccess(@Nullable java.lang.Long bytes)`<br>Storage size was computed/modify. |
| `void` | `onError(@NonNull Error error)`<br>There was an error during size operation. |

## Methods

### onSuccess

```java
@UiThread
void onSuccess(@Nullable java.lang.Long bytes)
```

Storage size was computed/modify.

### onError

```java
@UiThread
void onError(@NonNull Error error)
```

There was an error during size operation.
