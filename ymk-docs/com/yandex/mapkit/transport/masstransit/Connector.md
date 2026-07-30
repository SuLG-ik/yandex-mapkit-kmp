---
title: "Connector"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Connector"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Connector.html"
---
# Connector

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Connector.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Connector

`class Connector implements Serializable`

Connectors connect two floors, indoor and outdoor, two indoor plans.

Connectors do not have single level id and name but still are considered a part of the indoor plan. Examples: stairs, elevators, escalators, travolators, transitions, route segment that goes from outdoor to indoor (through the entrance) and vica versa.

## Summary

### Constructors

**Signature and Description**

```java
Connector(@Nullable IndoorLevel from,
          @Nullable IndoorLevel to)
```

```java
Connector()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `IndoorLevel` | `getFrom()`<br>A level (floor) where the connector begins. |
| `IndoorLevel` | `getTo()`<br>A level (floor) where the connector ends. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Connector

```java
Connector(@Nullable IndoorLevel from,
          @Nullable IndoorLevel to)
```

### Connector

```java
Connector()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getFrom

```java
@Nullable
IndoorLevel getFrom()
```

A level (floor) where the connector begins.

Null means outdoor.

Optional field, can be null.

### getTo

```java
@Nullable
IndoorLevel getTo()
```

A level (floor) where the connector ends.

Null means outdoor.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
