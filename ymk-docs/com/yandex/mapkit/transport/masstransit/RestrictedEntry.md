---
title: "RestrictedEntry"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / RestrictedEntry"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RestrictedEntry.html"
---
# RestrictedEntry

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RestrictedEntry.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.RestrictedEntry

`class RestrictedEntry implements Serializable`

Defines a point on a pedestrian path.

## Summary

### Constructors

**Signature and Description**

```java
RestrictedEntry()
```

Use constructor with parameters in your code.

```java
RestrictedEntry(int position)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized int` | `getPosition()`<br>Index of the point in the section geometry. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RestrictedEntry

```java
RestrictedEntry()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RestrictedEntry

```java
RestrictedEntry(int position)
```

## Methods

### getPosition

```java
int getPosition()
```

Index of the point in the section geometry.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
