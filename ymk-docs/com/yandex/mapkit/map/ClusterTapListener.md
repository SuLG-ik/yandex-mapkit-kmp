---
title: "ClusterTapListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / ClusterTapListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/ClusterTapListener.html"
---
# ClusterTapListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/ClusterTapListener.html)

**Package** com.yandex.mapkit.map

`interface ClusterTapListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `onClusterTap(@NonNull Cluster cluster)`<br>Called when cluster is tapped. |

## Methods

### onClusterTap

```java
@UiThread
boolean onClusterTap(@NonNull Cluster cluster)
```

Called when cluster is tapped.

Return true if the event was handled. Otherwise it will be passed to underlying objects.
