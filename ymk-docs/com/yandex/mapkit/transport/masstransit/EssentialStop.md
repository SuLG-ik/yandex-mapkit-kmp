---
title: "EssentialStop"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / EssentialStop"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/EssentialStop.html"
---
# EssentialStop

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/EssentialStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.EssentialStop

`class EssentialStop implements Serializable`

Essential stop on thread

## Summary

### Constructors

**Signature and Description**

```java
EssentialStop()
```

Use constructor with parameters in your code.

```java
EssentialStop(@NonNull Stop stop,
              @NonNull EssentialStopInfo info)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Stop` | `getStop()`<br>Stop on the thread |
| `synchronized EssentialStopInfo` | `getInfo()`<br>Info for stop [mapkit.transport.masstransit.EssentialStopInfo](EssentialStopInfo.md). |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### EssentialStop

```java
EssentialStop()
```

Use constructor with parameters in your code.

This one is for serialization only!

### EssentialStop

```java
EssentialStop(@NonNull Stop stop,
              @NonNull EssentialStopInfo info)
```

## Methods

### getStop

```java
@NonNull
Stop getStop()
```

Stop on the thread

### getInfo

```java
@NonNull
EssentialStopInfo getInfo()
```

Info for stop [mapkit.transport.masstransit.EssentialStopInfo](EssentialStopInfo.md).

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
