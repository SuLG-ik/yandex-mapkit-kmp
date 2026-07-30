---
title: "InputListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / InputListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/InputListener.html"
---
# InputListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/InputListener.html)

**Package** com.yandex.mapkit.map

`interface InputListener`

Listener for user interactions with the map.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onMapTap(@NonNull Map map, @NonNull Point point)`<br>Called when a tap occurred unless a tap was handled by geo objects or map objects. |
| `void` | `onMapLongTap(@NonNull Map map, @NonNull Point point)`<br>Called when a long tap occurred. |

## Methods

### onMapTap

```java
@UiThread
void onMapTap(@NonNull Map map,
              @NonNull Point point)
```

Called when a tap occurred unless a tap was handled by geo objects or map objects.

param@ position absolute screen coordinates

### onMapLongTap

```java
@UiThread
void onMapLongTap(@NonNull Map map,
                  @NonNull Point point)
```

Called when a long tap occurred.
