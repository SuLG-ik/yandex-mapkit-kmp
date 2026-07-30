---
title: "CanonicalUnit"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.runtime.i18n"
section: "Android / Справочник / com.yandex.runtime.i18n / CanonicalUnit"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/i18n/CanonicalUnit.html"
---
# CanonicalUnit

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/i18n/CanonicalUnit.html)

**Package** com.yandex.runtime.i18n

java.lang.Object
↳ com.yandex.runtime.i18n.CanonicalUnit

`class CanonicalUnit implements Serializable`

Represents a unit with the value and measurement separated.

## Summary

### Constructors

**Signature and Description**

```java
CanonicalUnit(@NonNull java.lang.String unit,
              double value)
```

```java
CanonicalUnit()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getUnit()`<br>The unit of measurement. |
| `double` | `getValue()`<br>The numerical value. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### CanonicalUnit

```java
CanonicalUnit(@NonNull java.lang.String unit,
              double value)
```

### CanonicalUnit

```java
CanonicalUnit()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getUnit

```java
@NonNull
java.lang.String getUnit()
```

The unit of measurement.

### getValue

```java
double getValue()
```

The numerical value.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
