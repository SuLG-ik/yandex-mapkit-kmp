---
title: "Closed"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TransportThreadAlert_Closed"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportThreadAlert_Closed.html"
---
# Closed

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportThreadAlert_Closed.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.TransportThreadAlert.Closed

`static class Closed implements Serializable`

Thread is not operational on that day.

## Summary

### Constructors

**Signature and Description**

```java
Closed(boolean dummy)
```

```java
Closed()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `getDummy()`<br>Dummy field which is used here because IDL does not support structs without fields. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Closed

```java
Closed(boolean dummy)
```

### Closed

```java
Closed()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getDummy

```java
boolean getDummy()
```

Dummy field which is used here because IDL does not support structs without fields.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
