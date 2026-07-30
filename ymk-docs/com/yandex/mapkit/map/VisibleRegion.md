---
title: "VisibleRegion"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / VisibleRegion"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/VisibleRegion.html"
---
# VisibleRegion

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/VisibleRegion.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ com.yandex.mapkit.map.VisibleRegion

`class VisibleRegion implements Serializable`

Defines the visible region.

## Summary

### Constructors

**Signature and Description**

```java
VisibleRegion(@NonNull Point topLeft,
              @NonNull Point topRight,
              @NonNull Point bottomLeft,
              @NonNull Point bottomRight)
```

```java
VisibleRegion()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Point` | `getTopLeft()`<br>Top-left of the visible region. |
| `Point` | `getTopRight()`<br>Top-right of the visible region. |
| `Point` | `getBottomLeft()`<br>Bottom-left of the visible region. |
| `Point` | `getBottomRight()`<br>Bottom-right of the visible region. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### VisibleRegion

```java
VisibleRegion(@NonNull Point topLeft,
              @NonNull Point topRight,
              @NonNull Point bottomLeft,
              @NonNull Point bottomRight)
```

### VisibleRegion

```java
VisibleRegion()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getTopLeft

```java
@NonNull
Point getTopLeft()
```

Top-left of the visible region.

### getTopRight

```java
@NonNull
Point getTopRight()
```

Top-right of the visible region.

### getBottomLeft

```java
@NonNull
Point getBottomLeft()
```

Bottom-left of the visible region.

### getBottomRight

```java
@NonNull
Point getBottomRight()
```

Bottom-right of the visible region.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
