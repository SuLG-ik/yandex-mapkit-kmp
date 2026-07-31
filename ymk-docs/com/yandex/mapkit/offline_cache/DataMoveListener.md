---
title: "DataMoveListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.offline_cache"
section: "Android / Справочник / com.yandex.mapkit.offline_cache / DataMoveListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/DataMoveListener.html"
---
# DataMoveListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/DataMoveListener.html)

**Package** com.yandex.mapkit.offline_cache

`interface DataMoveListener`

Listener for the information about operations.

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onDataMoveProgress(int percent)`<br>Called when the operation makes progress. |
| `void` | `onDataMoveCompleted()`<br>Called when the request is completed. |
| `void` | `onDataMoveError(@NonNull Error error)`<br>Called when an error occurs. |

## Methods

### onDataMoveProgress

```java
@UiThread
void onDataMoveProgress(int percent)
```

Called when the operation makes progress.

Percent is the rate of completion in the range of 0 to 100.

### onDataMoveCompleted

```java
@UiThread
void onDataMoveCompleted()
```

Called when the request is completed.

### onDataMoveError

```java
@UiThread
void onDataMoveError(@NonNull Error error)
```

Called when an error occurs.
