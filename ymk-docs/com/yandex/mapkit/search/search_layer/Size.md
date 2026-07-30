---
title: "Size"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search.search_layer"
section: "Android / Справочник / com.yandex.mapkit.search.search_layer / Size"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/Size.html"
---
# Size

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/Size.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search.search_layer

java.lang.Object
↳ com.yandex.mapkit.search.search_layer.Size

`class Size implements Serializable`

Size of the icon

## Summary

### Constructors

**Signature and Description**

```java
Size(double width,
     double height)
```

```java
Size()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `double` | `getWidth()`<br>Width. |
| `double` | `getHeight()`<br>Height. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Size

```java
Size(double width,
     double height)
```

### Size

```java
Size()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getWidth

```java
double getWidth()
```

Width.

### getHeight

```java
double getHeight()
```

Height.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
