---
title: "RestrictedEntry"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / RestrictedEntry"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/RestrictedEntry.html"
---
# RestrictedEntry

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/RestrictedEntry.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

java.lang.Object
↳ com.yandex.mapkit.transport.bicycle.RestrictedEntry

`class RestrictedEntry implements Serializable`

Special point on the route (like gates).

## Summary

### Constructors

**Signature and Description**

```java
RestrictedEntry()
```

Use constructor with parameters in your code.

```java
RestrictedEntry(@NonNull PolylinePosition position)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized PolylinePosition` | `getPosition()`<br>Entry position on the route polyline. |
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
RestrictedEntry(@NonNull PolylinePosition position)
```

## Methods

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

Entry position on the route polyline.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
