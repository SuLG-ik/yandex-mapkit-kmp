---
title: "Payment"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Payment"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Payment.html"
---
# Payment

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Payment.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Payment

`class Payment implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
Payment(@Nullable PaymentMedia paymentMedia,
        @NonNull Money price)
```

```java
Payment()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PaymentMedia` | `getPaymentMedia()`<br>Contains information about the payment media. |
| `Money` | `getPrice()`<br>Cost of travel in the vehicle. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Payment

```java
Payment(@Nullable PaymentMedia paymentMedia,
        @NonNull Money price)
```

### Payment

```java
Payment()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPaymentMedia

```java
@Nullable
PaymentMedia getPaymentMedia()
```

Contains information about the payment media.

Optional field, can be null.

### getPrice

```java
@NonNull
Money getPrice()
```

Cost of travel in the vehicle.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
