---
title: "RouteJamsListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / RouteJamsListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteJamsListener.html"
---
# RouteJamsListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteJamsListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

`interface RouteJamsListener`

A listener to monitor changes to traffic jams on the route.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onJamsUpdated(@NonNull Route route)`<br>Triggered when traffic jams are updated. |
| `void` | `onJamsOutdated(@NonNull Route route)`<br>Triggered when traffic jams are outdated. |

## Methods

### onJamsUpdated

```java
@UiThread
void onJamsUpdated(@NonNull Route route)
```

Triggered when traffic jams are updated.

### onJamsOutdated

```java
@UiThread
void onJamsOutdated(@NonNull Route route)
```

Triggered when traffic jams are outdated.
