---
title: "IndoorData"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / IndoorSegment_IndoorData"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/IndoorSegment_IndoorData.html"
---
# IndoorData

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/IndoorSegment_IndoorData.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.IndoorSegment.IndoorData

`static class IndoorData implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
IndoorData()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static IndoorData` | `fromIndoorLevel(@NonNull IndoorLevel indoorLevel)` |
| `static IndoorData` | `fromConnector(@NonNull Connector connector)` |
| `IndoorLevel` | `getIndoorLevel()` |
| `Connector` | `getConnector()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### IndoorData

```java
IndoorData()
```

## Methods

### fromIndoorLevel

```java
@NonNull
IndoorData fromIndoorLevel(@NonNull IndoorLevel indoorLevel)
```

### fromConnector

```java
@NonNull
IndoorData fromConnector(@NonNull Connector connector)
```

### getIndoorLevel

```java
@Nullable
IndoorLevel getIndoorLevel()
```

### getConnector

```java
@Nullable
Connector getConnector()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
