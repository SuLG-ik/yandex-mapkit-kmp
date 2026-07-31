---
title: "TileId"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / TileId"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/TileId.html"
---
# TileId

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/TileId.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.TileId

`class TileId implements Serializable`

The ID of a tile on the map.

## Summary

### Constructors

**Signature and Description**

```java
TileId(int x,
       int y,
       int z)
```

```java
TileId()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getX()`<br>The number of the tile horizontally. |
| `int` | `getY()`<br>The number of the tile vertically. |
| `int` | `getZ()`<br>The number of columns and rows to split the map into. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### TileId

```java
TileId(int x,
       int y,
       int z)
```

### TileId

```java
TileId()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getX

```java
int getX()
```

The number of the tile horizontally.

### getY

```java
int getY()
```

The number of the tile vertically.

### getZ

```java
int getZ()
```

The number of columns and rows to split the map into.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
