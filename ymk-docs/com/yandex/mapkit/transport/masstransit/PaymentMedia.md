---
title: "PaymentMedia"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / PaymentMedia"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/PaymentMedia.html"
---
# PaymentMedia

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/PaymentMedia.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.PaymentMedia

`class PaymentMedia implements Serializable`

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [MediaType](PaymentMedia_MediaType.md) |   |

## Summary

### Constructors

**Signature and Description**

```java
PaymentMedia(@NonNull java.lang.String id,
             @Nullable java.lang.String name,
             @NonNull MediaType type)
```

```java
PaymentMedia()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getId()`<br>string which identifies the current media, can be used to select icons im maps application. |
| `java.lang.String` | `getName()`<br>Localized name of the media, which is used for payment. |
| `MediaType` | `getType()`<br>Type of media, which is used for payment. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### PaymentMedia

```java
PaymentMedia(@NonNull java.lang.String id,
             @Nullable java.lang.String name,
             @NonNull MediaType type)
```

### PaymentMedia

```java
PaymentMedia()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

string which identifies the current media, can be used to select icons im maps application.

### getName

```java
@Nullable
java.lang.String getName()
```

Localized name of the media, which is used for payment.

Optional field, can be null.

### getType

```java
@NonNull
MediaType getType()
```

Type of media, which is used for payment.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
