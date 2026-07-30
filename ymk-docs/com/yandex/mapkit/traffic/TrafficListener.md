---
title: "TrafficListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.traffic"
section: "Android / Справочник / com.yandex.mapkit.traffic / TrafficListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/traffic/TrafficListener.html"
---
# TrafficListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/traffic/TrafficListener.html)

**Package** com.yandex.mapkit.traffic

`interface TrafficListener`

Listener to handle traffic information.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onTrafficChanged(@Nullable TrafficLevel trafficLevel)`<br>Triggered when traffic level changes. |
| `void` | `onTrafficLoading()`<br>Triggered when traffic information is loading. |
| `void` | `onTrafficExpired()`<br>Triggered when traffic information expires. |

## Methods

### onTrafficChanged

```java
@UiThread
void onTrafficChanged(@Nullable TrafficLevel trafficLevel)
```

Triggered when traffic level changes.

### onTrafficLoading

```java
@UiThread
void onTrafficLoading()
```

Triggered when traffic information is loading.

### onTrafficExpired

```java
@UiThread
void onTrafficExpired()
```

Triggered when traffic information expires.
