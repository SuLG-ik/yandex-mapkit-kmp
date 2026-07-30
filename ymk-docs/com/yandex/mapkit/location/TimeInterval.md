---
title: "TimeInterval"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / TimeInterval"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/TimeInterval.html"
---
# TimeInterval

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/TimeInterval.html)

**Package** com.yandex.mapkit.location

java.lang.Object
↳ com.yandex.mapkit.location.TimeInterval

`class TimeInterval implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
TimeInterval()
```

Use constructor with parameters in your code.

```java
TimeInterval(long from,
             long to)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized long` | `getFrom()`<br>Lower limit in milliseconds. |
| `synchronized long` | `getTo()`<br>Upper limit in milliseconds. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### TimeInterval

```java
TimeInterval()
```

Use constructor with parameters in your code.

This one is for serialization only!

### TimeInterval

```java
TimeInterval(long from,
             long to)
```

## Methods

### getFrom

```java
long getFrom()
```

Lower limit in milliseconds.

### getTo

```java
long getTo()
```

Upper limit in milliseconds.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
