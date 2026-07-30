---
title: "Span"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / SpannableString_Span"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/SpannableString_Span.html"
---
# Span

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/SpannableString_Span.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.SpannableString.Span

`static class Span implements Serializable`

A span of text in the SpannableString.

## Summary

### Constructors

**Signature and Description**

```java
Span(int begin,
     int end)
```

```java
Span()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getBegin()`<br>The index of the beginning symbol of the span. |
| `int` | `getEnd()`<br>The index of the ending symbol of the span. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Span

```java
Span(int begin,
     int end)
```

### Span

```java
Span()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getBegin

```java
int getBegin()
```

The index of the beginning symbol of the span.

### getEnd

```java
int getEnd()
```

The index of the ending symbol of the span.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
