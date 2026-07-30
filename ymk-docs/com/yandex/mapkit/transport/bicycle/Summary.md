---
title: "Summary"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / Summary"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/Summary.html"
---
# Summary

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/Summary.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

java.lang.Object
↳ com.yandex.mapkit.transport.bicycle.Summary

`class Summary implements Serializable`

Contains brief information associated with a route constructed by the mass transit router.

## Summary

### Constructors

**Signature and Description**

```java
Summary()
```

Use constructor with parameters in your code.

```java
Summary(@NonNull Weight weight,
        @Nullable Flags flags)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Weight` | `getWeight()`<br>Quantitative characteristics of the route. |
| `synchronized Flags` | `getFlags()`<br>Specific properties of the route. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Summary

```java
Summary()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Summary

```java
Summary(@NonNull Weight weight,
        @Nullable Flags flags)
```

## Methods

### getWeight

```java
@NonNull
Weight getWeight()
```

Quantitative characteristics of the route.

### getFlags

```java
@Nullable
Flags getFlags()
```

Specific properties of the route.

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
