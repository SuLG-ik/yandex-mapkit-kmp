---
title: "RoutePaymentOption"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / RoutePaymentOption"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RoutePaymentOption.html"
---
# RoutePaymentOption

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RoutePaymentOption.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.RoutePaymentOption

`class RoutePaymentOption implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
RoutePaymentOption()
```

Use constructor with parameters in your code.

```java
RoutePaymentOption(@NonNull java.util.List<Payment> payment,
                   @NonNull java.util.List<Money> totalPrice)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<Payment>` | `getPayment()` |
| `synchronized java.util.List<Money>` | `getTotalPrice()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RoutePaymentOption

```java
RoutePaymentOption()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RoutePaymentOption

```java
RoutePaymentOption(@NonNull java.util.List<Payment> payment,
                   @NonNull java.util.List<Money> totalPrice)
```

## Methods

### getPayment

```java
@NonNull
java.util.List<Payment> getPayment()
```

### getTotalPrice

```java
@NonNull
java.util.List<Money> getTotalPrice()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
