---
title: "ShowtimesObjectMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / ShowtimesObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ShowtimesObjectMetadata.html"
---
# ShowtimesObjectMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ShowtimesObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.ShowtimesObjectMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class ShowtimesObjectMetadata implements BaseMetadata, Serializable`

Event schedule snippet.

## Summary

### Constructors

**Signature and Description**

```java
ShowtimesObjectMetadata()
```

Use constructor with parameters in your code.

```java
ShowtimesObjectMetadata(@NonNull java.lang.String title,
                        @NonNull java.util.List<Showtime> showtimes)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getTitle()`<br>Event title. |
| `synchronized java.util.List<Showtime>` | `getShowtimes()`<br>List of showtimes. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ShowtimesObjectMetadata

```java
ShowtimesObjectMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ShowtimesObjectMetadata

```java
ShowtimesObjectMetadata(@NonNull java.lang.String title,
                        @NonNull java.util.List<Showtime> showtimes)
```

## Methods

### getTitle

```java
@NonNull
java.lang.String getTitle()
```

Event title.

### getShowtimes

```java
@NonNull
java.util.List<Showtime> getShowtimes()
```

List of showtimes.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
