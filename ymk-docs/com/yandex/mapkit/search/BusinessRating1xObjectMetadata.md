---
title: "BusinessRating1xObjectMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / BusinessRating1xObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessRating1xObjectMetadata.html"
---
# BusinessRating1xObjectMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessRating1xObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.BusinessRating1xObjectMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class BusinessRating1xObjectMetadata implements BaseMetadata, Serializable`

Snippet for company ratings.

Score from 0 to 5.

## Summary

### Constructors

**Signature and Description**

```java
BusinessRating1xObjectMetadata()
```

Use constructor with parameters in your code.

```java
BusinessRating1xObjectMetadata(int ratings,
                               int reviews,
                               @Nullable java.lang.Float score)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized int` | `getRatings()`<br>Total number of ratings. |
| `synchronized int` | `getReviews()`<br>Total number of reviews. |
| `synchronized java.lang.Float` | `getScore()`<br>Average rating score for the company (0 to 5). |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### BusinessRating1xObjectMetadata

```java
BusinessRating1xObjectMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### BusinessRating1xObjectMetadata

```java
BusinessRating1xObjectMetadata(int ratings,
                               int reviews,
                               @Nullable java.lang.Float score)
```

## Methods

### getRatings

```java
int getRatings()
```

Total number of ratings.

### getReviews

```java
int getReviews()
```

Total number of reviews.

### getScore

```java
@Nullable
java.lang.Float getScore()
```

Average rating score for the company (0 to 5).

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
