---
title: "Item"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Properties_Item"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Properties_Item.html"
---
# Item

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Properties_Item.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Properties.Item

`static class Item implements Serializable`

Single property item.

## Summary

### Constructors

**Signature and Description**

```java
Item(@NonNull java.lang.String key,
     @NonNull java.lang.String value)
```

```java
Item()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getKey()`<br>Item key. |
| `java.lang.String` | `getValue()`<br>Item value. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Item

```java
Item(@NonNull java.lang.String key,
     @NonNull java.lang.String value)
```

### Item

```java
Item()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getKey

```java
@NonNull
java.lang.String getKey()
```

Item key.

### getValue

```java
@NonNull
java.lang.String getValue()
```

Item value.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
