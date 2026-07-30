---
title: "CurrencyExchangeMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / CurrencyExchangeMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/CurrencyExchangeMetadata.html"
---
# CurrencyExchangeMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/CurrencyExchangeMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.CurrencyExchangeMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class CurrencyExchangeMetadata implements BaseMetadata, Serializable`

Currency exchange snippet.

## Summary

### Constructors

**Signature and Description**

```java
CurrencyExchangeMetadata()
```

Use constructor with parameters in your code.

```java
CurrencyExchangeMetadata(@NonNull java.util.List<CurrencyExchangeType> currencies)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<CurrencyExchangeType>` | `getCurrencies()`<br>Available currency exchange rates. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### CurrencyExchangeMetadata

```java
CurrencyExchangeMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### CurrencyExchangeMetadata

```java
CurrencyExchangeMetadata(@NonNull java.util.List<CurrencyExchangeType> currencies)
```

## Methods

### getCurrencies

```java
@NonNull
java.util.List<CurrencyExchangeType> getCurrencies()
```

Available currency exchange rates.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
