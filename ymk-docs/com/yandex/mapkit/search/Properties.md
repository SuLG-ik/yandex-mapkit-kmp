---
title: "Properties"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Properties"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Properties.html"
---
# Properties

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Properties.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Properties

`class Properties implements Serializable`

Generic key-value property storage.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [Item](Properties_Item.md) | Single property item. |

## Summary

### Constructors

**Signature and Description**

```java
Properties()
```

Use constructor with parameters in your code.

```java
Properties(@NonNull java.util.List<Item> items)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<Item>` | `getItems()`<br>Property list. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Properties

```java
Properties()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Properties

```java
Properties(@NonNull java.util.List<Item> items)
```

## Methods

### getItems

```java
@NonNull
java.util.List<Item> getItems()
```

Property list.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
