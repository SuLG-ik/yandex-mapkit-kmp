---
title: "BaseDataSource"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.layers"
section: "Android / Справочник / com.yandex.mapkit.layers / BaseDataSource"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/BaseDataSource.html"
---
# BaseDataSource

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/BaseDataSource.html)

**Package** com.yandex.mapkit.layers

## All known Subinterfaces:

*[DataSource](DataSource.md)*, *[TileDataSource](TileDataSource.md)*

`interface BaseDataSource`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getId()`<br>Stores id of data source. |
| `boolean` | `isValid()`<br>Tells if this **BaseDataSource** is valid or not. |

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

Stores id of data source.

### isValid

```java
boolean isValid()
```

Tells if this **BaseDataSource** is valid or not.

Any other method (except for this one) called on an invalid **BaseDataSource** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
