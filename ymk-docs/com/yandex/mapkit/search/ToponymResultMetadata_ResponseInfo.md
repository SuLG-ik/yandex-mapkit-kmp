---
title: "ResponseInfo"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / ToponymResultMetadata_ResponseInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ToponymResultMetadata_ResponseInfo.html"
---
# ResponseInfo

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ToponymResultMetadata_ResponseInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.ToponymResultMetadata.ResponseInfo

`static class ResponseInfo implements Serializable`

Additional response info.

## Summary

### Constructors

**Signature and Description**

```java
ResponseInfo(@NonNull SearchMode mode,
             @Nullable java.lang.Double accuracy)
```

```java
ResponseInfo()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `SearchMode` | `getMode()`<br>Search mode. |
| `java.lang.Double` | `getAccuracy()`<br>Search response accuracy. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ResponseInfo

```java
ResponseInfo(@NonNull SearchMode mode,
             @Nullable java.lang.Double accuracy)
```

### ResponseInfo

```java
ResponseInfo()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getMode

```java
@NonNull
SearchMode getMode()
```

Search mode.

### getAccuracy

```java
@Nullable
java.lang.Double getAccuracy()
```

Search response accuracy.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
