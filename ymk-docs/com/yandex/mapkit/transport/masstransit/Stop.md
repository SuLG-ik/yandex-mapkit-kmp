---
title: "Stop"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Stop"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Stop.html"
---
# Stop

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Stop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Stop

## All Superinterfaces:

*[BaseMetadata](../../BaseMetadata.md)*

`class Stop implements BaseMetadata, Serializable`

Describes a public transport stop.

## Summary

### Constructors

**Signature and Description**

```java
Stop()
```

Use constructor with parameters in your code.

```java
Stop(@NonNull java.lang.String id,
     @NonNull java.lang.String name,
     @Nullable java.lang.String additionalName,
     @Nullable StopFeatureMask features,
     @NonNull java.util.List<TransportContour> transportContours)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getId()`<br>Stop ID. |
| `synchronized java.lang.String` | `getName()`<br>Stop name. |
| `synchronized java.lang.String` | `getAdditionalName()`<br>Additional stop name. |
| `synchronized StopFeatureMask` | `getFeatures()`<br>Additional stop features. |
| `synchronized java.util.List<TransportContour>` | `getTransportContours()`<br>Describes transport contours represented at this Stop. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Stop

```java
Stop()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Stop

```java
Stop(@NonNull java.lang.String id,
     @NonNull java.lang.String name,
     @Nullable java.lang.String additionalName,
     @Nullable StopFeatureMask features,
     @NonNull java.util.List<TransportContour> transportContours)
```

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

Stop ID.

### getName

```java
@NonNull
java.lang.String getName()
```

Stop name.

### getAdditionalName

```java
@Nullable
java.lang.String getAdditionalName()
```

Additional stop name.

Can be a local number or specifying index. Similar to thread description, but for stops

Optional field, can be null.

### getFeatures

```java
@Nullable
StopFeatureMask getFeatures()
```

Additional stop features.

Optional field, can be null.

### getTransportContours

```java
@NonNull
java.util.List<TransportContour> getTransportContours()
```

Describes transport contours represented at this Stop.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
