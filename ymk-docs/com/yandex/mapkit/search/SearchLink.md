---
title: "SearchLink"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SearchLink"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchLink.html"
---
# SearchLink

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchLink.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.SearchLink

`class SearchLink implements Serializable`

Link structure.

Combines actual link with attribution and type info.

## Summary

### Constructors

**Signature and Description**

```java
SearchLink(@Nullable java.lang.String aref,
           @NonNull Link link,
           @Nullable java.lang.String tag)
```

```java
SearchLink()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getAref()`<br>Attribution reference. |
| `Link` | `getLink()`<br>Actual link. |
| `java.lang.String` | `getTag()`<br>Link tag. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### SearchLink

```java
SearchLink(@Nullable java.lang.String aref,
           @NonNull Link link,
           @Nullable java.lang.String tag)
```

### SearchLink

```java
SearchLink()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getAref

```java
@Nullable
java.lang.String getAref()
```

Attribution reference.

Optional field, can be null.

### getLink

```java
@NonNull
Link getLink()
```

Actual link.

### getTag

```java
@Nullable
java.lang.String getTag()
```

Link tag.

Possible values (non-exhaustive) 'self/social/attribution/showtimes/booking'.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
