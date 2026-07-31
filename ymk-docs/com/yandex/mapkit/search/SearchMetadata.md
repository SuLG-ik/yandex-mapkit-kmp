---
title: "SearchMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SearchMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchMetadata.html"
---
# SearchMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.SearchMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class SearchMetadata implements BaseMetadata, Serializable`

Additional info for search response;

## Summary

### Constructors

**Signature and Description**

```java
SearchMetadata()
```

Use constructor with parameters in your code.

```java
SearchMetadata(int found,
               @NonNull DisplayType displayType,
               @Nullable BoundingBox boundingBox,
               @Nullable Sort sort,
               @Nullable GeoObject toponym,
               @Nullable ToponymResultMetadata toponymResultMetadata,
               @Nullable BusinessResultMetadata businessResultMetadata,
               @NonNull java.lang.String reqid,
               @NonNull java.lang.String context,
               @NonNull java.lang.String requestText,
               @Nullable java.lang.String correctedRequestText,
               @Nullable BoundingBox requestBoundingBox)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized int` | `getFound()`<br>Approximate number of found objects. |
| `synchronized DisplayType` | `getDisplayType()`<br>Display type. |
| `synchronized BoundingBox` | `getBoundingBox()`<br>Bounding box of the response as a whole. |
| `synchronized Sort` | `getSort()`<br>Server-chosen sorting. |
| `synchronized GeoObject` | `getToponym()`<br>Geocoder response to the toponym part of the query. |
| `synchronized ToponymResultMetadata` | `getToponymResultMetadata()`<br>Additional info for the response from toponym search. |
| `synchronized BusinessResultMetadata` | `getBusinessResultMetadata()`<br>Additional info for the response from organization search. |
| `synchronized java.lang.String` | `getReqid()`<br>Server-generated request ID. |
| `synchronized java.lang.String` | `getContext()`<br>Server-generated request context. |
| `synchronized java.lang.String` | `getRequestText()`<br>Initial request text. |
| `synchronized java.lang.String` | `getCorrectedRequestText()`<br>Initial request text with correction of spelling mistakes. |
| `synchronized BoundingBox` | `getRequestBoundingBox()`<br>Initial request bounding box. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### SearchMetadata

```java
SearchMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### SearchMetadata

```java
SearchMetadata(int found,
               @NonNull DisplayType displayType,
               @Nullable BoundingBox boundingBox,
               @Nullable Sort sort,
               @Nullable GeoObject toponym,
               @Nullable ToponymResultMetadata toponymResultMetadata,
               @Nullable BusinessResultMetadata businessResultMetadata,
               @NonNull java.lang.String reqid,
               @NonNull java.lang.String context,
               @NonNull java.lang.String requestText,
               @Nullable java.lang.String correctedRequestText,
               @Nullable BoundingBox requestBoundingBox)
```

## Methods

### getFound

```java
int getFound()
```

Approximate number of found objects.

### getDisplayType

```java
@NonNull
DisplayType getDisplayType()
```

Display type.

### getBoundingBox

```java
@Nullable
BoundingBox getBoundingBox()
```

Bounding box of the response as a whole.

Optional field, can be null.

### getSort

```java
@Nullable
Sort getSort()
```

Server-chosen sorting.

Optional field, can be null.

### getToponym

```java
@Nullable
GeoObject getToponym()
```

Geocoder response to the toponym part of the query.

Optional field, can be null.

### getToponymResultMetadata

```java
@Nullable
ToponymResultMetadata getToponymResultMetadata()
```

Additional info for the response from toponym search.

Optional field, can be null.

### getBusinessResultMetadata

```java
@Nullable
BusinessResultMetadata getBusinessResultMetadata()
```

Additional info for the response from organization search.

Optional field, can be null.

### getReqid

```java
@NonNull
java.lang.String getReqid()
```

Server-generated request ID.

### getContext

```java
@NonNull
java.lang.String getContext()
```

Server-generated request context.

### getRequestText

```java
@NonNull
java.lang.String getRequestText()
```

Initial request text.

### getCorrectedRequestText

```java
@Nullable
java.lang.String getCorrectedRequestText()
```

Initial request text with correction of spelling mistakes.

Optional field, can be null.

### getRequestBoundingBox

```java
@Nullable
BoundingBox getRequestBoundingBox()
```

Initial request bounding box.

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
