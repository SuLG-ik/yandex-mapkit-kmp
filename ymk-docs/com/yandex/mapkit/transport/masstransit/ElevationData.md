---
title: "ElevationData"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / ElevationData"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/ElevationData.html"
---
# ElevationData

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/ElevationData.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.ElevationData

`class ElevationData implements Serializable`

Information of elevation gain in loss in a fitness section

## Summary

### Constructors

**Signature and Description**

```java
ElevationData()
```

Use constructor with parameters in your code.

```java
ElevationData(@NonNull LocalizedValue totalAscent,
              @NonNull LocalizedValue totalDescent,
              @Nullable LocalizedValue steps,
              @NonNull LocalizedValue kilocalories,
              @NonNull java.util.List<InclineSection> inclineSections,
              @NonNull java.util.List<ElevationPoint> elevationSegments)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized LocalizedValue` | `getTotalAscent()`<br>Total ascent in meters |
| `synchronized LocalizedValue` | `getTotalDescent()`<br>Total descent in meters |
| `synchronized LocalizedValue` | `getSteps()`<br>The number of steps required to cover the distance for an average person<br>Optional field, can be null. |
| `synchronized LocalizedValue` | `getKilocalories()`<br>The number of kilocalories consumed by an average person to cover the distance |
| `synchronized java.util.List<InclineSection>` | `getInclineSections()`<br>List of sections with notable incline |
| `synchronized java.util.List<ElevationPoint>` | `getElevationSegments()`<br>List of elevation for each point of the section polyline |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ElevationData

```java
ElevationData()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ElevationData

```java
ElevationData(@NonNull LocalizedValue totalAscent,
              @NonNull LocalizedValue totalDescent,
              @Nullable LocalizedValue steps,
              @NonNull LocalizedValue kilocalories,
              @NonNull java.util.List<InclineSection> inclineSections,
              @NonNull java.util.List<ElevationPoint> elevationSegments)
```

## Methods

### getTotalAscent

```java
@NonNull
LocalizedValue getTotalAscent()
```

Total ascent in meters

### getTotalDescent

```java
@NonNull
LocalizedValue getTotalDescent()
```

Total descent in meters

### getSteps

```java
@Nullable
LocalizedValue getSteps()
```

The number of steps required to cover the distance for an average person

Optional field, can be null.

### getKilocalories

```java
@NonNull
LocalizedValue getKilocalories()
```

The number of kilocalories consumed by an average person to cover the distance

### getInclineSections

```java
@NonNull
java.util.List<InclineSection> getInclineSections()
```

List of sections with notable incline

### getElevationSegments

```java
@NonNull
java.util.List<ElevationPoint> getElevationSegments()
```

List of elevation for each point of the section polyline

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
