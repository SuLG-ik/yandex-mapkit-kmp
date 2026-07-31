---
title: "OrgOwnershipObjectMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / OrgOwnershipObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/OrgOwnershipObjectMetadata.html"
---
# OrgOwnershipObjectMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/OrgOwnershipObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.OrgOwnershipObjectMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class OrgOwnershipObjectMetadata implements BaseMetadata, Serializable`

## Summary

### Constructors

**Signature and Description**

```java
OrgOwnershipObjectMetadata()
```

Use constructor with parameters in your code.

```java
OrgOwnershipObjectMetadata(@Nullable java.lang.Boolean canBeClaimed)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.Boolean` | `getCanBeClaimed()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### OrgOwnershipObjectMetadata

```java
OrgOwnershipObjectMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### OrgOwnershipObjectMetadata

```java
OrgOwnershipObjectMetadata(@Nullable java.lang.Boolean canBeClaimed)
```

## Methods

### getCanBeClaimed

```java
@Nullable
java.lang.Boolean getCanBeClaimed()
```

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
