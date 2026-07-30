---
title: "SectionData"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / SectionMetadata_SectionData"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/SectionMetadata_SectionData.html"
---
# SectionData

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/SectionMetadata_SectionData.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.SectionMetadata.SectionData

`static class SectionData implements Serializable`

A choice of information specific to the section type.

## Summary

### Constructors

**Signature and Description**

```java
SectionData()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static SectionData` | `fromWait(@NonNull Wait wait)` |
| `static SectionData` | `fromFitness(@NonNull Fitness fitness)` |
| `static SectionData` | `fromTransfer(@NonNull Transfer transfer)` |
| `static SectionData` | `fromTaxi(@NonNull Taxi taxi)` |
| `static SectionData` | `fromTransports(@NonNull java.util.List<Transport> transports)` |
| `Wait` | `getWait()` |
| `Fitness` | `getFitness()` |
| `Transfer` | `getTransfer()` |
| `Taxi` | `getTaxi()` |
| `java.util.List<Transport>` | `getTransports()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### SectionData

```java
SectionData()
```

## Methods

### fromWait

```java
@NonNull
SectionData fromWait(@NonNull Wait wait)
```

### fromFitness

```java
@NonNull
SectionData fromFitness(@NonNull Fitness fitness)
```

### fromTransfer

```java
@NonNull
SectionData fromTransfer(@NonNull Transfer transfer)
```

### fromTaxi

```java
@NonNull
SectionData fromTaxi(@NonNull Taxi taxi)
```

### fromTransports

```java
@NonNull
SectionData fromTransports(@NonNull java.util.List<Transport> transports)
```

### getWait

```java
@Nullable
Wait getWait()
```

### getFitness

```java
@Nullable
Fitness getFitness()
```

### getTransfer

```java
@Nullable
Transfer getTransfer()
```

### getTaxi

```java
@Nullable
Taxi getTaxi()
```

### getTransports

```java
@Nullable
java.util.List<Transport> getTransports()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
