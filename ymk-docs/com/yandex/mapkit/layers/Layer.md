---
title: "Layer"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.layers"
section: "Android / Справочник / com.yandex.mapkit.layers / Layer"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/Layer.html"
---
# Layer

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/Layer.html)

**Package** com.yandex.mapkit.layers

`interface Layer`

Interface for working with the layer.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `remove()`<br>Removes the layer from the map. |
| `DataSourceLayer` | `dataSourceLayer()` |
| `boolean` | `isValid()`<br>Tells if this **Layer** is valid or not. |

## Methods

### remove

```java
void remove()
```

Removes the layer from the map.

The object becomes invalid after that.

### dataSourceLayer

```java
@NonNull
DataSourceLayer dataSourceLayer()
```

### isValid

```java
boolean isValid()
```

Tells if this **Layer** is valid or not.

Any other method (except for this one) called on an invalid **Layer** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
