---
title: "ClusterListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / ClusterListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/ClusterListener.html"
---
# ClusterListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/ClusterListener.html)

**Package** com.yandex.mapkit.map

`interface ClusterListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onClusterAdded(@NonNull Cluster cluster)`<br>This method is called when a new cluster is added to the collection and should customize cluster appearance based on its content. |

## Methods

### onClusterAdded

```java
@UiThread
void onClusterAdded(@NonNull Cluster cluster)
```

This method is called when a new cluster is added to the collection and should customize cluster appearance based on its content.
