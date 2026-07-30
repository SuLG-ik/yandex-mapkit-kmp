---
title: "EssentialStopInfo"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / EssentialStopInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/EssentialStopInfo.html"
---
# EssentialStopInfo

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/EssentialStopInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.EssentialStopInfo

`class EssentialStopInfo implements Serializable`

Info for essential stop

## Summary

### Constructors

**Signature and Description**

```java
EssentialStopInfo(boolean first_stop,
                  boolean intermediate_terminus,
                  boolean important,
                  boolean last_stop)
```

```java
EssentialStopInfo()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `getFirst_stop()`<br>First stop on thread |
| `boolean` | `getIntermediate_terminus()`<br>Intermediate terminus stop on thread |
| `boolean` | `getImportant()`<br>Important stop on thread |
| `boolean` | `getLast_stop()`<br>Last stop on thread |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### EssentialStopInfo

```java
EssentialStopInfo(boolean first_stop,
                  boolean intermediate_terminus,
                  boolean important,
                  boolean last_stop)
```

### EssentialStopInfo

```java
EssentialStopInfo()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getFirst_stop

```java
boolean getFirst_stop()
```

First stop on thread

### getIntermediate_terminus

```java
boolean getIntermediate_terminus()
```

Intermediate terminus stop on thread

### getImportant

```java
boolean getImportant()
```

Important stop on thread

### getLast_stop

```java
boolean getLast_stop()
```

Last stop on thread

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
