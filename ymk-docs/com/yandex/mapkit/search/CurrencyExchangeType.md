---
title: "CurrencyExchangeType"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / CurrencyExchangeType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/CurrencyExchangeType.html"
---
# CurrencyExchangeType

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/CurrencyExchangeType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.CurrencyExchangeType

`class CurrencyExchangeType implements Serializable`

Single currency exchange prices.

## Summary

### Constructors

**Signature and Description**

```java
CurrencyExchangeType()
```

Use constructor with parameters in your code.

```java
CurrencyExchangeType(@Nullable java.lang.String name,
                     @Nullable Money buy,
                     @Nullable Money sell)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getName()`<br>ISO-4217 currency name, for example "USD" or "RUB" or "EUR". |
| `synchronized Money` | `getBuy()`<br>Buy rate. |
| `synchronized Money` | `getSell()`<br>Sell rate. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### CurrencyExchangeType

```java
CurrencyExchangeType()
```

Use constructor with parameters in your code.

This one is for serialization only!

### CurrencyExchangeType

```java
CurrencyExchangeType(@Nullable java.lang.String name,
                     @Nullable Money buy,
                     @Nullable Money sell)
```

## Methods

### getName

```java
@Nullable
java.lang.String getName()
```

ISO-4217 currency name, for example "USD" or "RUB" or "EUR".

Optional field, can be null.

### getBuy

```java
@Nullable
Money getBuy()
```

Buy rate.

Optional field, can be null.

### getSell

```java
@Nullable
Money getSell()
```

Sell rate.

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
