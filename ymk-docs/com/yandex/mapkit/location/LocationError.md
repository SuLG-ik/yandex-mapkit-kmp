---
title: "LocationError"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / LocationError"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationError.html"
---
# LocationError

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationError.html)

**Package** com.yandex.mapkit.location

java.lang.Object
↳ com.yandex.mapkit.location.LocationError

`class LocationError implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
LocationError()
```

Use constructor with parameters in your code.

```java
LocationError(@NonNull Range lateralErrorRange,
              @NonNull Range longitudinalErrorRange)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Range` | `getLateralErrorRange()`<br>The error of spreading locations across the route. |
| `synchronized Range` | `getLongitudinalErrorRange()`<br>The error of spreading locations along the route. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### LocationError

```java
LocationError()
```

Use constructor with parameters in your code.

This one is for serialization only!

### LocationError

```java
LocationError(@NonNull Range lateralErrorRange,
              @NonNull Range longitudinalErrorRange)
```

## Methods

### getLateralErrorRange

```java
@NonNull
Range getLateralErrorRange()
```

The error of spreading locations across the route.

### getLongitudinalErrorRange

```java
@NonNull
Range getLongitudinalErrorRange()
```

The error of spreading locations along the route.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
