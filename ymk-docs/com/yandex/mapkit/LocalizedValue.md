---
title: "LocalizedValue"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / LocalizedValue"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/LocalizedValue.html"
---
# LocalizedValue

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/LocalizedValue.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.LocalizedValue

`class LocalizedValue implements Serializable`

A value respecting the device locale.

## Summary

### Constructors

**Signature and Description**

```java
LocalizedValue(double value,
               @NonNull java.lang.String text)
```

```java
LocalizedValue()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `double` | `getValue()`<br>Value in SI units for distance, speed and duration. |
| `java.lang.String` | `getText()`<br>Localized text. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### LocalizedValue

```java
LocalizedValue(double value,
               @NonNull java.lang.String text)
```

### LocalizedValue

```java
LocalizedValue()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getValue

```java
double getValue()
```

Value in SI units for distance, speed and duration.

### getText

```java
@NonNull
java.lang.String getText()
```

Localized text.

For example: "15 ft" or "42 km".

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
