---
title: "State"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / State"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/State.html"
---
# State

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/State.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.State

`class State implements Serializable`

Describes if an organization is open or closed now.

## Summary

### Constructors

**Signature and Description**

```java
State()
```

Use constructor with parameters in your code.

```java
State(@Nullable java.lang.Boolean isOpenNow,
      @Nullable java.lang.String text,
      @Nullable java.lang.String shortText,
      @NonNull java.util.List<java.lang.String> tags)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.Boolean` | `getIsOpenNow()`<br>Is open right now. |
| `synchronized java.lang.String` | `getText()`<br>Human-readable localized description of current state. |
| `synchronized java.lang.String` | `getShortText()`<br>Human-readable short localized description of current state. |
| `synchronized java.util.List<java.lang.String>` | `getTags()`<br>One of the following 3 tags: 'break', 'opening_soon', 'closing_soon'. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### State

```java
State()
```

Use constructor with parameters in your code.

This one is for serialization only!

### State

```java
State(@Nullable java.lang.Boolean isOpenNow,
      @Nullable java.lang.String text,
      @Nullable java.lang.String shortText,
      @NonNull java.util.List<java.lang.String> tags)
```

## Methods

### getIsOpenNow

```java
@Nullable
java.lang.Boolean getIsOpenNow()
```

Is open right now.

Optional field, can be null.

### getText

```java
@Nullable
java.lang.String getText()
```

Human-readable localized description of current state.

Optional field, can be null.

### getShortText

```java
@Nullable
java.lang.String getShortText()
```

Human-readable short localized description of current state.

Optional field, can be null.

### getTags

```java
@NonNull
java.util.List<java.lang.String> getTags()
```

One of the following 3 tags: 'break', 'opening_soon', 'closing_soon'.

Additional tag values may be added eventually.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
