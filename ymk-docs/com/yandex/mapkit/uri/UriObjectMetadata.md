---
title: "UriObjectMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.uri"
section: "Android / Справочник / com.yandex.mapkit.uri / UriObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/uri/UriObjectMetadata.html"
---
# UriObjectMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/uri/UriObjectMetadata.html)

**Package** com.yandex.mapkit.uri

java.lang.Object
↳ com.yandex.mapkit.uri.UriObjectMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class UriObjectMetadata implements BaseMetadata, Serializable`

URI metadata.

## Summary

### Constructors

**Signature and Description**

```java
UriObjectMetadata()
```

Use constructor with parameters in your code.

```java
UriObjectMetadata(@NonNull java.util.List<Uri> uris)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<Uri>` | `getUris()`<br>Gets a list of URIs. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### UriObjectMetadata

```java
UriObjectMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### UriObjectMetadata

```java
UriObjectMetadata(@NonNull java.util.List<Uri> uris)
```

## Methods

### getUris

```java
@NonNull
java.util.List<Uri> getUris()
```

Gets a list of URIs.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
