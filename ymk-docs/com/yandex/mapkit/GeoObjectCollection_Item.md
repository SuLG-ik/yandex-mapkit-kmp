---
title: "Item"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / GeoObjectCollection_Item"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/GeoObjectCollection_Item.html"
---
# Item

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/GeoObjectCollection_Item.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.GeoObjectCollection.Item

`static class Item implements Serializable`

The geo objects in the collection.

## Summary

### Constructors

**Signature and Description**

```java
Item()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static Item` | `fromObj(@NonNull GeoObject obj)` |
| `static Item` | `fromCollection(@NonNull GeoObjectCollection collection)` |
| `GeoObject` | `getObj()` |
| `GeoObjectCollection` | `getCollection()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Item

```java
Item()
```

## Methods

### fromObj

```java
@NonNull
Item fromObj(@NonNull GeoObject obj)
```

### fromCollection

```java
@NonNull
Item fromCollection(@NonNull GeoObjectCollection collection)
```

### getObj

```java
@Nullable
GeoObject getObj()
```

### getCollection

```java
@Nullable
GeoObjectCollection getCollection()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
