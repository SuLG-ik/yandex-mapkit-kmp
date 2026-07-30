---
title: "ReferenceType"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / ReferenceType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ReferenceType.html"
---
# ReferenceType

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ReferenceType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.ReferenceType

`class ReferenceType implements Serializable`

The type of reference.

## Summary

### Constructors

**Signature and Description**

```java
ReferenceType()
```

Use constructor with parameters in your code.

```java
ReferenceType(@NonNull java.lang.String id,
              @NonNull java.lang.String scope)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getId()`<br>Reference ID. |
| `synchronized java.lang.String` | `getScope()`<br>Reference scope. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ReferenceType

```java
ReferenceType()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ReferenceType

```java
ReferenceType(@NonNull java.lang.String id,
              @NonNull java.lang.String scope)
```

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

Reference ID.

### getScope

```java
@NonNull
java.lang.String getScope()
```

Reference scope.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
