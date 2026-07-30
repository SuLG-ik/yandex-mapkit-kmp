---
title: "SectionPaymentOption"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / SectionPaymentOption"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/SectionPaymentOption.html"
---
# SectionPaymentOption

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/SectionPaymentOption.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.SectionPaymentOption

`class SectionPaymentOption implements Serializable`

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [AppliedFare](SectionPaymentOption_AppliedFare.md) |   |

## Summary

### Constructors

**Signature and Description**

```java
SectionPaymentOption(@Nullable Payment payment,
                     @NonNull AppliedFare appliedFare)
```

```java
SectionPaymentOption()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Payment` | `getPayment()`<br>Optional field, can be null. |
| `AppliedFare` | `getAppliedFare()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### SectionPaymentOption

```java
SectionPaymentOption(@Nullable Payment payment,
                     @NonNull AppliedFare appliedFare)
```

### SectionPaymentOption

```java
SectionPaymentOption()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPayment

```java
@Nullable
Payment getPayment()
```

Optional field, can be null.

### getAppliedFare

```java
@NonNull
AppliedFare getAppliedFare()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
