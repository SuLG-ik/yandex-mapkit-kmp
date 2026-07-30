---
title: "RawTile"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / RawTile"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/RawTile.html"
---
# RawTile

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/RawTile.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.RawTile

`class RawTile implements Serializable`

A raw tile that can be displayed on the map.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [State](RawTile_State.md) | Available tile states. |
| `static final` | [UseCache](RawTile_UseCache.md) |   |

## Summary

### Constructors

**Signature and Description**

```java
RawTile()
```

Use constructor with parameters in your code.

```java
RawTile(@NonNull Version version,
        @NonNull java.util.Map<java.lang.String, java.lang.String> features,
        @NonNull java.lang.String etag,
        @NonNull UseCache useCache,
        @NonNull State state,
        @NonNull byte[] rawData)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Version` | `getVersion()` |
| `synchronized java.util.Map<java.lang.String, java.lang.String>` | `getFeatures()` |
| `synchronized java.lang.String` | `getEtag()` |
| `synchronized UseCache` | `getUseCache()` |
| `synchronized State` | `getState()` |
| `synchronized byte[]` | `getRawData()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RawTile

```java
RawTile()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RawTile

```java
RawTile(@NonNull Version version,
        @NonNull java.util.Map<java.lang.String, java.lang.String> features,
        @NonNull java.lang.String etag,
        @NonNull UseCache useCache,
        @NonNull State state,
        @NonNull byte[] rawData)
```

## Methods

### getVersion

```java
@NonNull
Version getVersion()
```

### getFeatures

```java
@NonNull
java.util.Map<java.lang.String, java.lang.String> getFeatures()
```

### getEtag

```java
@NonNull
java.lang.String getEtag()
```

### getUseCache

```java
@NonNull
UseCache getUseCache()
```

### getState

```java
@NonNull
State getState()
```

### getRawData

```java
@NonNull
byte[] getRawData()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
