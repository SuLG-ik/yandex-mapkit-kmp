---
title: "Chain"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Chain"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Chain.html"
---
# Chain

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Chain.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Chain

`class Chain implements Serializable`

Single chain (group of companies) description.

## Summary

### Constructors

**Signature and Description**

```java
Chain(@NonNull java.lang.String id,
      @NonNull java.lang.String name)
```

```java
Chain()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getId()`<br>Chain identifier. |
| `java.lang.String` | `getName()`<br>Chain name. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Chain

```java
Chain(@NonNull java.lang.String id,
      @NonNull java.lang.String name)
```

### Chain

```java
Chain()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

Chain identifier.

### getName

```java
@NonNull
java.lang.String getName()
```

Chain name.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
