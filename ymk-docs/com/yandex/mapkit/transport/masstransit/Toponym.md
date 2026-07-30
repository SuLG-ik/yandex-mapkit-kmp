---
title: "Toponym"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Toponym"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Toponym.html"
---
# Toponym

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Toponym.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Toponym

`class Toponym implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
Toponym(@Nullable java.lang.String toponym,
        @Nullable java.lang.String accusativeToponym)
```

```java
Toponym()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getToponym()`<br>Optional field, can be null. |
| `java.lang.String` | `getAccusativeToponym()`<br>Toponym in accusative case with preposition<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Toponym

```java
Toponym(@Nullable java.lang.String toponym,
        @Nullable java.lang.String accusativeToponym)
```

### Toponym

```java
Toponym()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getToponym

```java
@Nullable
java.lang.String getToponym()
```

Optional field, can be null.

### getAccusativeToponym

```java
@Nullable
java.lang.String getAccusativeToponym()
```

Toponym in accusative case with preposition

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
