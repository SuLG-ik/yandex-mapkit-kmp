---
title: "SuggestResponse"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SuggestResponse"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestResponse.html"
---
# SuggestResponse

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestResponse.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.SuggestResponse

`class SuggestResponse implements Serializable`

A suggest response

## Summary

### Constructors

**Signature and Description**

```java
SuggestResponse()
```

Use constructor with parameters in your code.

```java
SuggestResponse(@NonNull java.util.List<SuggestItem> items)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<SuggestItem>` | `getItems()`<br>Suggest items. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### SuggestResponse

```java
SuggestResponse()
```

Use constructor with parameters in your code.

This one is for serialization only!

### SuggestResponse

```java
SuggestResponse(@NonNull java.util.List<SuggestItem> items)
```

## Methods

### getItems

```java
@NonNull
java.util.List<SuggestItem> getItems()
```

Suggest items.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
