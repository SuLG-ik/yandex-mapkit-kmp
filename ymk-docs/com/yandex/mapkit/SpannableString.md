---
title: "SpannableString"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / SpannableString"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/SpannableString.html"
---
# SpannableString

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/SpannableString.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.SpannableString

`class SpannableString implements Serializable`

A string that supports spans in it.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [Span](SpannableString_Span.md) | A span of text in the SpannableString. |

## Summary

### Constructors

**Signature and Description**

```java
SpannableString()
```

Use constructor with parameters in your code.

```java
SpannableString(@NonNull java.lang.String text,
                @NonNull java.util.List<Span> spans)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getText()`<br>The text of the spannable string. |
| `synchronized java.util.List<Span>` | `getSpans()`<br>The spans in stored text. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### SpannableString

```java
SpannableString()
```

Use constructor with parameters in your code.

This one is for serialization only!

### SpannableString

```java
SpannableString(@NonNull java.lang.String text,
                @NonNull java.util.List<Span> spans)
```

## Methods

### getText

```java
@NonNull
java.lang.String getText()
```

The text of the spannable string.

### getSpans

```java
@NonNull
java.util.List<Span> getSpans()
```

The spans in stored text.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
