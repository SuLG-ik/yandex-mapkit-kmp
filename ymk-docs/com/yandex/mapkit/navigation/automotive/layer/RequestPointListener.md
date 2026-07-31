---
title: "RequestPointListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / RequestPointListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/RequestPointListener.html"
---
# RequestPointListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/RequestPointListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

`interface RequestPointListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onRequestPointsChanged()` |
| `void` | `onRequestPointTap(int requestPointIndex)` |

## Methods

### onRequestPointsChanged

```java
@UiThread
void onRequestPointsChanged()
```

### onRequestPointTap

```java
@UiThread
void onRequestPointTap(int requestPointIndex)
```
