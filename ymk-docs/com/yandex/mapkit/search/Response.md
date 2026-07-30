---
title: "Response"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Response"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Response.html"
---
# Response

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Response.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Response

`class Response implements Serializable`

Top level structure for search response.

## Summary

### Constructors

**Signature and Description**

```java
Response()
```

Use constructor with parameters in your code.

```java
Response(@NonNull SearchMetadata metadata,
         @NonNull GeoObjectCollection collection,
         boolean isOffline)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized SearchMetadata` | `getMetadata()`<br>Extended response information. |
| `synchronized GeoObjectCollection` | `getCollection()`<br>List of objects (organizations, toponyms) in search response. |
| `synchronized boolean` | `getIsOffline()`<br>Flag describing if this response was built offline. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Response

```java
Response()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Response

```java
Response(@NonNull SearchMetadata metadata,
         @NonNull GeoObjectCollection collection,
         boolean isOffline)
```

## Methods

### getMetadata

```java
@NonNull
SearchMetadata getMetadata()
```

Extended response information.

### getCollection

```java
@NonNull
GeoObjectCollection getCollection()
```

List of objects (organizations, toponyms) in search response.

### getIsOffline

```java
boolean getIsOffline()
```

Flag describing if this response was built offline.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
