---
title: "Transfer"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Transfer"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Transfer.html"
---
# Transfer

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Transfer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Transfer

`class Transfer implements Serializable`

Represents a transfer to another mass transit line or to another stop.

For example, transfer from one underground line to another.

## Summary

### Constructors

**Signature and Description**

```java
Transfer()
```

Use constructor with parameters in your code.

```java
Transfer(@NonNull java.util.List<ConstructionSegment> constructions,
         @NonNull TransferStop transferStop)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<ConstructionSegment>` | `getConstructions()`<br>Compressed information about pedestrian constructions along the transfer path. |
| `synchronized TransferStop` | `getTransferStop()`<br>The stop you need to transfer to |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Transfer

```java
Transfer()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Transfer

```java
Transfer(@NonNull java.util.List<ConstructionSegment> constructions,
         @NonNull TransferStop transferStop)
```

## Methods

### getConstructions

```java
@NonNull
java.util.List<ConstructionSegment> getConstructions()
```

Compressed information about pedestrian constructions along the transfer path.

[mapkit.transport.masstransit.ConstructionSegment#subpolyline](ConstructionSegment.md#subpolyline) fields of all segments cover the entire geometry of corresponding section".

### getTransferStop

```java
@NonNull
TransferStop getTransferStop()
```

The stop you need to transfer to

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
