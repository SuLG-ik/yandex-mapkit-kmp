---
title: "ThreadStop"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / ThreadStop"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/ThreadStop.html"
---
# ThreadStop

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/ThreadStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.ThreadStop

`class ThreadStop implements Serializable`

Describes a [mapkit.transport.masstransit.Stop](Stop.md) on a [mapkit.transport.masstransit.Thread](Thread.md).

## Summary

### Constructors

**Signature and Description**

```java
ThreadStop()
```

Use constructor with parameters in your code.

```java
ThreadStop(@NonNull Stop stop,
           @NonNull Point position)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Stop` | `getStop()`<br>Stop on a thread. |
| `synchronized Point` | `getPosition()`<br>Coordinates of the thread stop. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ThreadStop

```java
ThreadStop()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ThreadStop

```java
ThreadStop(@NonNull Stop stop,
           @NonNull Point position)
```

## Methods

### getStop

```java
@NonNull
Stop getStop()
```

Stop on a thread.

### getPosition

```java
@NonNull
Point getPosition()
```

Coordinates of the thread stop.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
