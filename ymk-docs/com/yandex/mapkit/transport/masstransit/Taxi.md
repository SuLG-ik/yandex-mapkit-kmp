---
title: "Taxi"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Taxi"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Taxi.html"
---
# Taxi

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Taxi.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Taxi

`class Taxi implements Serializable`

Represents a taxi part of route.

## Summary

### Constructors

**Signature and Description**

```java
Taxi()
```

Use constructor with parameters in your code.

```java
Taxi(@NonNull java.util.List<JamSegment> jamSegments)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<JamSegment>` | `getJamSegments()`<br>Traffic conditions on the given part of route. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Taxi

```java
Taxi()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Taxi

```java
Taxi(@NonNull java.util.List<JamSegment> jamSegments)
```

## Methods

### getJamSegments

```java
@NonNull
java.util.List<JamSegment> getJamSegments()
```

Traffic conditions on the given part of route.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
