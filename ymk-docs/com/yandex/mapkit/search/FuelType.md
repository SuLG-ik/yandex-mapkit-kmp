---
title: "FuelType"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / FuelType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FuelType.html"
---
# FuelType

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FuelType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.FuelType

`class FuelType implements Serializable`

Fuel name and price.

## Summary

### Constructors

**Signature and Description**

```java
FuelType()
```

Use constructor with parameters in your code.

```java
FuelType(@Nullable java.lang.String name,
         @Nullable Money price)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getName()`<br>Fuel name. |
| `synchronized Money` | `getPrice()`<br>Fuel price. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### FuelType

```java
FuelType()
```

Use constructor with parameters in your code.

This one is for serialization only!

### FuelType

```java
FuelType(@Nullable java.lang.String name,
         @Nullable Money price)
```

## Methods

### getName

```java
@Nullable
java.lang.String getName()
```

Fuel name.

Optional field, can be null.

### getPrice

```java
@Nullable
Money getPrice()
```

Fuel price.

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
