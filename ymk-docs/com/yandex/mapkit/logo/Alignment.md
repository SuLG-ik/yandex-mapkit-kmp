---
title: "Alignment"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.logo"
section: "Android / Справочник / com.yandex.mapkit.logo / Alignment"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/logo/Alignment.html"
---
# Alignment

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/logo/Alignment.html)

**Package** com.yandex.mapkit.logo

java.lang.Object
↳ com.yandex.mapkit.logo.Alignment

`class Alignment implements Serializable`

Logo alignment class.

## Summary

### Constructors

**Signature and Description**

```java
Alignment(@NonNull HorizontalAlignment horizontalAlignment,
          @NonNull VerticalAlignment verticalAlignment)
```

```java
Alignment()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `HorizontalAlignment` | `getHorizontalAlignment()`<br>Defines horizontal alignment. |
| `VerticalAlignment` | `getVerticalAlignment()`<br>Defines vertical alignment. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Alignment

```java
Alignment(@NonNull HorizontalAlignment horizontalAlignment,
          @NonNull VerticalAlignment verticalAlignment)
```

### Alignment

```java
Alignment()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getHorizontalAlignment

```java
@NonNull
HorizontalAlignment getHorizontalAlignment()
```

Defines horizontal alignment.

### getVerticalAlignment

```java
@NonNull
VerticalAlignment getVerticalAlignment()
```

Defines vertical alignment.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
