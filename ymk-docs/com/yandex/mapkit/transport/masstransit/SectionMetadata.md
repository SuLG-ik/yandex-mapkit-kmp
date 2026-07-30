---
title: "SectionMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / SectionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/SectionMetadata.html"
---
# SectionMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/SectionMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.SectionMetadata

`class SectionMetadata implements Serializable`

General information about a section of a route.

The [mapkit.transport.masstransit.SectionMetadata#data](SectionMetadata.md#data) field describes the type of section: wait, walk, transfer, or transport, and related data. Related data can be set for walk and transfer sections. This data is a vector of construction types of corresponding geometry segments.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [SectionData](SectionMetadata_SectionData.md) | A choice of information specific to the section type. |

## Summary

### Constructors

**Signature and Description**

```java
SectionMetadata()
```

Use constructor with parameters in your code.

```java
SectionMetadata(@NonNull Weight weight,
                @NonNull SectionData data,
                @Nullable TravelEstimation estimation,
                int legIndex,
                @NonNull java.util.List<SectionPaymentOption> paymentOptions)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Weight` | `getWeight()`<br>Contains the route traveling time, distance of the walking part, and the number of transfers. |
| `synchronized SectionData` | `getData()`<br>Contains information that is specific to a section type: wait, walk, transfer, or ride transport. |
| `synchronized TravelEstimation` | `getEstimation()`<br>Arrival and departure time estimations. |
| `synchronized int` | `getLegIndex()`<br>Part of the route polyline for the route leg. |
| `synchronized java.util.List<SectionPaymentOption>` | `getPaymentOptions()`<br>List of payment options with prices for the current section. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### SectionMetadata

```java
SectionMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### SectionMetadata

```java
SectionMetadata(@NonNull Weight weight,
                @NonNull SectionData data,
                @Nullable TravelEstimation estimation,
                int legIndex,
                @NonNull java.util.List<SectionPaymentOption> paymentOptions)
```

## Methods

### getWeight

```java
@NonNull
Weight getWeight()
```

Contains the route traveling time, distance of the walking part, and the number of transfers.

### getData

```java
@NonNull
SectionData getData()
```

Contains information that is specific to a section type: wait, walk, transfer, or ride transport.

### getEstimation

```java
@Nullable
TravelEstimation getEstimation()
```

Arrival and departure time estimations.

This field is set only for time-dependent routes.

Optional field, can be null.

### getLegIndex

```java
int getLegIndex()
```

Part of the route polyline for the route leg.

A leg is a part of the route between two consecutive waypoints.

### getPaymentOptions

```java
@NonNull
java.util.List<SectionPaymentOption> getPaymentOptions()
```

List of payment options with prices for the current section.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
