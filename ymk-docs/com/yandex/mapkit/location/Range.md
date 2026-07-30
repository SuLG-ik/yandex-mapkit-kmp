---
title: "Range"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / Range"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/Range.html"
---
# Range

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/Range.html)

**Package** com.yandex.mapkit.location

java.lang.Object
↳ com.yandex.mapkit.location.Range

`class Range implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
Range()
```

Use constructor with parameters in your code.

```java
Range(double from,
      double to)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized double` | `getFrom()` |
| `synchronized double` | `getTo()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Range

```java
Range()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Range

```java
Range(double from,
      double to)
```

## Methods

### getFrom

```java
double getFrom()
```

### getTo

```java
double getTo()
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
