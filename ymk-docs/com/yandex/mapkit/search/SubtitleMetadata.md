---
title: "SubtitleMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SubtitleMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SubtitleMetadata.html"
---
# SubtitleMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SubtitleMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.SubtitleMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class SubtitleMetadata implements BaseMetadata, Serializable`

Subtitle snippet.

## Summary

### Constructors

**Signature and Description**

```java
SubtitleMetadata()
```

Use constructor with parameters in your code.

```java
SubtitleMetadata(@NonNull java.util.List<SubtitleItem> subtitleItems,
                 @NonNull java.util.List<SubtitleItem> serpSubtitleItems)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<SubtitleItem>` | `getSubtitleItems()`<br>List of subtitles. |
| `synchronized java.util.List<SubtitleItem>` | `getSerpSubtitleItems()`<br>List of subtitles to be displayed in SERP. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### SubtitleMetadata

```java
SubtitleMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### SubtitleMetadata

```java
SubtitleMetadata(@NonNull java.util.List<SubtitleItem> subtitleItems,
                 @NonNull java.util.List<SubtitleItem> serpSubtitleItems)
```

## Methods

### getSubtitleItems

```java
@NonNull
java.util.List<SubtitleItem> getSubtitleItems()
```

List of subtitles.

### getSerpSubtitleItems

```java
@NonNull
java.util.List<SubtitleItem> getSerpSubtitleItems()
```

List of subtitles to be displayed in SERP.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
