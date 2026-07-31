---
title: "DataSource"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.layers"
section: "Android / Справочник / com.yandex.mapkit.layers / DataSource"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/DataSource.html"
---
# DataSource

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/DataSource.html)

**Package** com.yandex.mapkit.layers

## All Superinterfaces:

*[BaseDataSource](BaseDataSource.md)*

`interface DataSource extends BaseDataSource`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setData(@NonNull byte[] data)`<br>Updates all data. |

## Methods

### setData

```java
void setData(@NonNull byte[] data)
```

Updates all data.

This method works synchronously and blocks UI thread. It is intended for passing not more than 500kB of data; otherwise, it will affect the responsiveness of UI and map.
