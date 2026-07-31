---
title: "FuelMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / FuelMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FuelMetadata.html"
---
# FuelMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FuelMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.FuelMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class FuelMetadata implements BaseMetadata, Serializable`

Fuel snippet.

## Summary

### Constructors

**Signature and Description**

```java
FuelMetadata()
```

Use constructor with parameters in your code.

```java
FuelMetadata(@Nullable java.lang.Long timestamp,
             @NonNull java.util.List<FuelType> fuels,
             @Nullable Attribution attribution)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.Long` | `getTimestamp()`<br>Snippet update time as UNIX timestamp. |
| `synchronized java.util.List<FuelType>` | `getFuels()`<br>Fuel list. |
| `synchronized Attribution` | `getAttribution()`<br>Attribution information. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### FuelMetadata

```java
FuelMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### FuelMetadata

```java
FuelMetadata(@Nullable java.lang.Long timestamp,
             @NonNull java.util.List<FuelType> fuels,
             @Nullable Attribution attribution)
```

## Methods

### getTimestamp

```java
@Nullable
java.lang.Long getTimestamp()
```

Snippet update time as UNIX timestamp.

Optional field, can be null.

### getFuels

```java
@NonNull
java.util.List<FuelType> getFuels()
```

Fuel list.

### getAttribution

```java
@Nullable
Attribution getAttribution()
```

Attribution information.

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
