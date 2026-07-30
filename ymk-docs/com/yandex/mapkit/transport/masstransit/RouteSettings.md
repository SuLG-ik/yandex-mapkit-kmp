---
title: "RouteSettings"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / RouteSettings"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteSettings.html"
---
# RouteSettings

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteSettings.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.RouteSettings

`class RouteSettings implements Serializable`

Route settings that were used by the mass transit router for a specific route.

## Summary

### Constructors

**Signature and Description**

```java
RouteSettings()
```

Use constructor with parameters in your code.

```java
RouteSettings(@NonNull java.util.List<java.lang.String> avoidTypes,
              @NonNull java.util.List<java.lang.String> acceptTypes)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<java.lang.String>` | `getAvoidTypes()`<br>Transport types that the router avoided. |
| `synchronized java.util.List<java.lang.String>` | `getAcceptTypes()`<br>Transport types that were allowed even if they are in the list of avoided types. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RouteSettings

```java
RouteSettings()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RouteSettings

```java
RouteSettings(@NonNull java.util.List<java.lang.String> avoidTypes,
              @NonNull java.util.List<java.lang.String> acceptTypes)
```

## Methods

### getAvoidTypes

```java
@NonNull
java.util.List<java.lang.String> getAvoidTypes()
```

Transport types that the router avoided.

### getAcceptTypes

```java
@NonNull
java.util.List<java.lang.String> getAcceptTypes()
```

Transport types that were allowed even if they are in the list of avoided types.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
