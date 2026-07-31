---
title: "Padding"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.logo"
section: "Android / Справочник / com.yandex.mapkit.logo / Padding"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/logo/Padding.html"
---
# Padding

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/logo/Padding.html)

**Package** com.yandex.mapkit.logo

java.lang.Object
↳ com.yandex.mapkit.logo.Padding

`class Padding implements Serializable`

Logo padding class.

## Summary

### Constructors

**Signature and Description**

```java
Padding(int horizontalPadding,
        int verticalPadding)
```

```java
Padding()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getHorizontalPadding()`<br>Defines horizontal padding. |
| `int` | `getVerticalPadding()`<br>Defines vertical padding. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Padding

```java
Padding(int horizontalPadding,
        int verticalPadding)
```

### Padding

```java
Padding()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getHorizontalPadding

```java
int getHorizontalPadding()
```

Defines horizontal padding.

### getVerticalPadding

```java
int getVerticalPadding()
```

Defines vertical padding.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
