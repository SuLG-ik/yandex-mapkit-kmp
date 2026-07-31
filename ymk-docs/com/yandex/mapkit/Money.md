---
title: "Money"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / Money"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Money.html"
---
# Money

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Money.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.Money

`class Money implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
Money(double value,
      @NonNull java.lang.String text,
      @NonNull java.lang.String currency)
```

```java
Money()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `double` | `getValue()` |
| `java.lang.String` | `getText()` |
| `java.lang.String` | `getCurrency()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Money

```java
Money(double value,
      @NonNull java.lang.String text,
      @NonNull java.lang.String currency)
```

### Money

```java
Money()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getValue

```java
double getValue()
```

### getText

```java
@NonNull
java.lang.String getText()
```

### getCurrency

```java
@NonNull
java.lang.String getCurrency()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
