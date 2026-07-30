---
title: "TransitOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TransitOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransitOptions.html"
---
# TransitOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransitOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.TransitOptions

`class TransitOptions implements Serializable`

User-defined options, like time options and filter options.

## Summary

### Constructors

**Signature and Description**

```java
TransitOptions(int avoid,
               @NonNull TimeOptions timeOptions)
```

```java
TransitOptions()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getAvoid()`<br>Transport types that the router will avoid. |
| `TimeOptions` | `getTimeOptions()`<br>Desired departure/arrival time settings. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### TransitOptions

```java
TransitOptions(int avoid,
               @NonNull TimeOptions timeOptions)
```

### TransitOptions

```java
TransitOptions()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getAvoid

```java
int getAvoid()
```

Transport types that the router will avoid.

The value should be one of [mapkit.transport.masstransit.FilterVehicleTypes](FilterVehicleTypes.md), or their bitwise 'OR' combination.

### getTimeOptions

```java
@NonNull
TimeOptions getTimeOptions()
```

Desired departure/arrival time settings.

Empty [mapkit.transport.masstransit.TimeOptions](TimeOptions.md) for requests that are not time-dependent.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
