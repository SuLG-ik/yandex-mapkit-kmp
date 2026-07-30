---
title: "ToponymResultMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / ToponymResultMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ToponymResultMetadata.html"
---
# ToponymResultMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ToponymResultMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.ToponymResultMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class ToponymResultMetadata implements BaseMetadata, Serializable`

Common info for response from toponym search.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [SearchMode](ToponymResultMetadata_SearchMode.md) | Search mode. |
| `static` | [ResponseInfo](ToponymResultMetadata_ResponseInfo.md) | Additional response info. |

## Summary

### Constructors

**Signature and Description**

```java
ToponymResultMetadata()
```

Use constructor with parameters in your code.

```java
ToponymResultMetadata(int found,
                      @Nullable ResponseInfo responseInfo,
                      @Nullable Point reversePoint)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized int` | `getFound()`<br>Approximate number of found objects. |
| `synchronized ResponseInfo` | `getResponseInfo()`<br>Additional response info. |
| `synchronized Point` | `getReversePoint()`<br>The search coordinates given via 'll' or parsed from 'text' (only in reverse mode). |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ToponymResultMetadata

```java
ToponymResultMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ToponymResultMetadata

```java
ToponymResultMetadata(int found,
                      @Nullable ResponseInfo responseInfo,
                      @Nullable Point reversePoint)
```

## Methods

### getFound

```java
int getFound()
```

Approximate number of found objects.

### getResponseInfo

```java
@Nullable
ResponseInfo getResponseInfo()
```

Additional response info.

Optional field, can be null.

### getReversePoint

```java
@Nullable
Point getReversePoint()
```

The search coordinates given via 'll' or parsed from 'text' (only in reverse mode).

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
