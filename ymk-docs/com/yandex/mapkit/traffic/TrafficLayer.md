---
title: "TrafficLayer"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.traffic"
section: "Android / Справочник / com.yandex.mapkit.traffic / TrafficLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/traffic/TrafficLayer.html"
---
# TrafficLayer

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/traffic/TrafficLayer.html)

**Package** com.yandex.mapkit.traffic

`interface TrafficLayer`

A layer with traffic information.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `isTrafficVisible()`<br>Checks if traffic is visible. |
| `void` | `setTrafficVisible(boolean on)`<br>Sets traffic visibility. |
| `boolean` | `setTrafficStyle(@NonNull java.lang.String style)`<br>Applies JSON style transformations to the traffic layer. |
| `boolean` | `setTrafficStyle(int id, @NonNull java.lang.String style)`<br>Applies JSON style transformations to the traffic layer. |
| `void` | `resetTrafficStyles()`<br>Resets all JSON style transformations applied to the traffic layer. |
| `void` | `addTrafficListener(@NonNull java.lang.ref.WeakReference<TrafficListener> trafficListener)`<br>Adds a traffic listener. |
| `void` | `removeTrafficListener(@NonNull java.lang.ref.WeakReference<TrafficListener> trafficListener)`<br>Removes a traffic listener. |
| `boolean` | `isValid()`<br>Tells if this **TrafficLayer** is valid or not. |

## Methods

### isTrafficVisible

```java
boolean isTrafficVisible()
```

Checks if traffic is visible.

### setTrafficVisible

```java
void setTrafficVisible(boolean on)
```

Sets traffic visibility.

### setTrafficStyle

```java
boolean setTrafficStyle(@NonNull java.lang.String style)
```

Applies JSON style transformations to the traffic layer.

Same as setTrafficStyle(0, style). Set to empty string to clear previous styling. Returns true if the style was successfully parsed; false otherwise. If the return value is false, the current traffic style remains unchanged.

### setTrafficStyle

```java
boolean setTrafficStyle(int id,
                        @NonNull java.lang.String style)
```

Applies JSON style transformations to the traffic layer.

Replaces previous styling with the specified ID (if such exists). Stylings are applied in an ascending order. Set to empty string to clear previous styling with the specified ID. Returns true if the style was successfully parsed; false otherwise. If the return value is false, the current traffic style remains unchanged.

### resetTrafficStyles

```java
void resetTrafficStyles()
```

Resets all JSON style transformations applied to the traffic layer.

### addTrafficListener

```java
void addTrafficListener(@NonNull java.lang.ref.WeakReference<TrafficListener> trafficListener)
```

Adds a traffic listener.

The class does not retain the object in the 'trafficListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeTrafficListener

```java
void removeTrafficListener(@NonNull java.lang.ref.WeakReference<TrafficListener> trafficListener)
```

Removes a traffic listener.

### isValid

```java
boolean isValid()
```

Tells if this **TrafficLayer** is valid or not.

Any other method (except for this one) called on an invalid **TrafficLayer** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
