---
title: "ToponymObjectMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / ToponymObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ToponymObjectMetadata.html"
---
# ToponymObjectMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ToponymObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.ToponymObjectMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class ToponymObjectMetadata implements BaseMetadata, Serializable`

Additional data for toponym objects.

## Summary

### Constructors

**Signature and Description**

```java
ToponymObjectMetadata()
```

Use constructor with parameters in your code.

```java
ToponymObjectMetadata(@NonNull Address address,
                      @Nullable Precision precision,
                      @Nullable java.lang.String formerName,
                      @NonNull Point balloonPoint,
                      int geoId,
                      @Nullable java.lang.String id)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Address` | `getAddress()`<br>Structured toponym address |
| `synchronized Precision` | `getPrecision()`<br>Toponym precision. |
| `synchronized java.lang.String` | `getFormerName()`<br>Former name for toponym if any. |
| `synchronized Point` | `getBalloonPoint()`<br>Point where balloon for the toponym should be shown. |
| `synchronized int` | `getGeoId()`<br>geobase id |
| `synchronized java.lang.String` | `getId()`<br>Persistent toponym id (available for Yandex-owned regions). |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ToponymObjectMetadata

```java
ToponymObjectMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ToponymObjectMetadata

```java
ToponymObjectMetadata(@NonNull Address address,
                      @Nullable Precision precision,
                      @Nullable java.lang.String formerName,
                      @NonNull Point balloonPoint,
                      int geoId,
                      @Nullable java.lang.String id)
```

## Methods

### getAddress

```java
@NonNull
Address getAddress()
```

Structured toponym address

### getPrecision

```java
@Nullable
Precision getPrecision()
```

Toponym precision.

Optional field, can be null.

### getFormerName

```java
@Nullable
java.lang.String getFormerName()
```

Former name for toponym if any.

Optional field, can be null.

### getBalloonPoint

```java
@NonNull
Point getBalloonPoint()
```

Point where balloon for the toponym should be shown.

Differs for direct and reverse search modes: Direct mode -- toponym center. Reverse mode -- toponym nearest point to the given coordinates.

### getGeoId

```java
int getGeoId()
```

geobase id

### getId

```java
@Nullable
java.lang.String getId()
```

Persistent toponym id (available for Yandex-owned regions).

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
