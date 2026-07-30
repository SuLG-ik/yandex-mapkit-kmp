---
title: "PlaceInfo"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / PlaceInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/PlaceInfo.html"
---
# PlaceInfo

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/PlaceInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.PlaceInfo

`class PlaceInfo implements Serializable`

Related place information.

## Summary

### Constructors

**Signature and Description**

```java
PlaceInfo()
```

Use constructor with parameters in your code.

```java
PlaceInfo(@NonNull java.lang.String name,
          @Nullable java.lang.String uri,
          @Nullable java.lang.String photoUrlTemplate,
          @Nullable java.lang.String logId,
          @Nullable Point point,
          @Nullable java.lang.String category,
          @Nullable java.lang.String shortName,
          @Nullable java.lang.Float rating,
          @Nullable WorkingHours workingHours,
          @Nullable java.lang.String address,
          @NonNull java.util.List<java.lang.String> tag)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getName()`<br>Place name. |
| `synchronized java.lang.String` | `getUri()`<br>Place URI. |
| `synchronized java.lang.String` | `getPhotoUrlTemplate()`<br>Url template for place photo. |
| `synchronized java.lang.String` | `getLogId()`<br>Server-generated log identifier. |
| `synchronized Point` | `getPoint()`<br>Place position. |
| `synchronized java.lang.String` | `getCategory()`<br>Place category as a string. |
| `synchronized java.lang.String` | `getShortName()`<br>Short name for a place. |
| `synchronized java.lang.Float` | `getRating()`<br>Place rating as number in 0 to 10 range. |
| `synchronized WorkingHours` | `getWorkingHours()`<br>Open hours for a place. |
| `synchronized java.lang.String` | `getAddress()`<br>Formatted address for an organization. |
| `synchronized java.util.List<java.lang.String>` | `getTag()`<br>Tags |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### PlaceInfo

```java
PlaceInfo()
```

Use constructor with parameters in your code.

This one is for serialization only!

### PlaceInfo

```java
PlaceInfo(@NonNull java.lang.String name,
          @Nullable java.lang.String uri,
          @Nullable java.lang.String photoUrlTemplate,
          @Nullable java.lang.String logId,
          @Nullable Point point,
          @Nullable java.lang.String category,
          @Nullable java.lang.String shortName,
          @Nullable java.lang.Float rating,
          @Nullable WorkingHours workingHours,
          @Nullable java.lang.String address,
          @NonNull java.util.List<java.lang.String> tag)
```

## Methods

### getName

```java
@NonNull
java.lang.String getName()
```

Place name.

### getUri

```java
@Nullable
java.lang.String getUri()
```

Place URI.

Optional field, can be null.

### getPhotoUrlTemplate

```java
@Nullable
java.lang.String getPhotoUrlTemplate()
```

Url template for place photo.

Optional field, can be null.

### getLogId

```java
@Nullable
java.lang.String getLogId()
```

Server-generated log identifier.

Optional field, can be null.

### getPoint

```java
@Nullable
Point getPoint()
```

Place position.

Optional field, can be null.

### getCategory

```java
@Nullable
java.lang.String getCategory()
```

Place category as a string.

Optional field, can be null.

### getShortName

```java
@Nullable
java.lang.String getShortName()
```

Short name for a place.

Optional field, can be null.

### getRating

```java
@Nullable
java.lang.Float getRating()
```

Place rating as number in 0 to 10 range.

Optional field, can be null.

### getWorkingHours

```java
@Nullable
WorkingHours getWorkingHours()
```

Open hours for a place.

Optional field, can be null.

### getAddress

```java
@Nullable
java.lang.String getAddress()
```

Formatted address for an organization.

Optional field, can be null.

### getTag

```java
@NonNull
java.util.List<java.lang.String> getTag()
```

Tags

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
