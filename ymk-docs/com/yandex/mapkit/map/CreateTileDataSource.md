---
title: "CreateTileDataSource"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / CreateTileDataSource"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CreateTileDataSource.html"
---
# CreateTileDataSource

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CreateTileDataSource.html)

**Package** com.yandex.mapkit.map

`interface CreateTileDataSource`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `createTileDataSource(@NonNull TileDataSourceBuilder builder)`<br>User defined factory, which sets up TileDataSourceBuilder. |

## Methods

### createTileDataSource

```java
@UiThread
void createTileDataSource(@NonNull TileDataSourceBuilder builder)
```

User defined factory, which sets up TileDataSourceBuilder.

Will be called only once.
