---
title: "SearchResultItem"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search.search_layer"
section: "Android / Справочник / com.yandex.mapkit.search.search_layer / SearchResultItem"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/SearchResultItem.html"
---
# SearchResultItem

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/SearchResultItem.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search.search_layer

`interface SearchResultItem`

Wrapper of the GeoObject in response, which makes it easy to get the certain fields from GeoObject

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getId()`<br>Id (constructed inside) |
| `java.lang.String` | `getName()`<br>Name (from GeoObject) |
| `java.lang.String` | `getCategoryClass()`<br>CategoryClass (optional, first if there are several)<br>Optional property, can be null. |
| `GeoObject` | `getGeoObject()`<br>Wrapped GeoObject itself |
| `Point` | `getPoint()`<br>Point from the GeoObject |
| `boolean` | `hasDetails()`<br>Does the GeoObject contain details for subtitle |
| `java.util.List<SubtitleItem>` | `details()`<br>Details for the subtitle |
| `boolean` | `isCollection()`<br>Is it a collection GeoObject |
| `boolean` | `isClosed()`<br>Is the organization closed now |
| `boolean` | `isOffline()`<br>Is the GeoObject found in offline search |

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

Id (constructed inside)

### getName

```java
@NonNull
java.lang.String getName()
```

Name (from GeoObject)

### getCategoryClass

```java
@Nullable
java.lang.String getCategoryClass()
```

CategoryClass (optional, first if there are several)

Optional property, can be null.

### getGeoObject

```java
@NonNull
GeoObject getGeoObject()
```

Wrapped GeoObject itself

### getPoint

```java
@NonNull
Point getPoint()
```

Point from the GeoObject

### hasDetails

```java
boolean hasDetails()
```

Does the GeoObject contain details for subtitle

### details

```java
@NonNull
java.util.List<SubtitleItem> details()
```

Details for the subtitle

### isCollection

```java
boolean isCollection()
```

Is it a collection GeoObject

### isClosed

```java
boolean isClosed()
```

Is the organization closed now

### isOffline

```java
boolean isOffline()
```

Is the GeoObject found in offline search
