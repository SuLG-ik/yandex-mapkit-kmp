---
title: "TileDataSource"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.layers"
section: "Android / Справочник / com.yandex.mapkit.layers / TileDataSource"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/TileDataSource.html"
---
# TileDataSource

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/TileDataSource.html)

**Package** com.yandex.mapkit.layers

## All Superinterfaces:

*[BaseDataSource](BaseDataSource.md)*

`interface TileDataSource extends BaseDataSource`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `invalidate(@NonNull java.lang.String version)`<br>Invalidates data source and reloads all tiles. |

## Methods

### invalidate

```java
void invalidate(@NonNull java.lang.String version)
```

Invalidates data source and reloads all tiles.

Must not be called if DataSource does not support versioning: LayerOptions.versionSupport = false;

This method may be called on any thread. Its implementation must be thread-safe.
