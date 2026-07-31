---
title: "DataSourceLayer"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.layers"
section: "Android / Справочник / com.yandex.mapkit.layers / DataSourceLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/DataSourceLayer.html"
---
# DataSourceLayer

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/DataSourceLayer.html)

**Package** com.yandex.mapkit.layers

`interface DataSourceLayer`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `isActive()`<br>Manages visibility of the layer. |
| `void` | `setActive(boolean active)` |
| `void` | `clear()`<br>Clears all cached tiles and starts new requests for tiles that are displayed. |
| `boolean` | `setStyle(int id, @NonNull java.lang.String style)`<br>Applies JSON style transformation to the layer. |
| `void` | `resetStyles()`<br>Resets all JSON style transformations applied to the layer. |
| `void` | `setLayerLoadedListener(@Nullable java.lang.ref.WeakReference<LayerLoadedListener> layerLoadedListener)`<br>Sets layer loaded listener. |
| `void` | `remove()`<br>Removes the data source layer from the parent layer. |
| `void` | `setDataSourceListener(@Nullable java.lang.ref.WeakReference<DataSourceListener> dataSourceListener)`<br>Sets data source listener. |
| `boolean` | `isValid()`<br>Tells if this **DataSourceLayer** is valid or not. |

## Methods

### isActive

```java
boolean isActive()
```

Manages visibility of the layer.

### setActive

```java
void setActive(boolean active)
```

### clear

```java
void clear()
```

Clears all cached tiles and starts new requests for tiles that are displayed.

### setStyle

```java
boolean setStyle(int id,
                 @NonNull java.lang.String style)
```

Applies JSON style transformation to the layer.

Replaces previous styling with the specified ID (if such exists). Stylings are applied in an ascending order. Set to empty string to clear previous styling with the specified ID. Returns true if the style was successfully parsed and false otherwise. If the returned value is false, the current style remains unchanged.

### resetStyles

```java
void resetStyles()
```

Resets all JSON style transformations applied to the layer.

### setLayerLoadedListener

```java
void setLayerLoadedListener(@Nullable java.lang.ref.WeakReference<LayerLoadedListener> layerLoadedListener)
```

Sets layer loaded listener.

The class does not retain the object in the 'layerLoadedListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### remove

```java
void remove()
```

Removes the data source layer from the parent layer.

The object becomes invalid after that.

### setDataSourceListener

```java
void setDataSourceListener(@Nullable java.lang.ref.WeakReference<DataSourceListener> dataSourceListener)
```

Sets data source listener.

Use it to invalidate data source. Temporary solution until https://st.yandex-team.ru/MAPSMOBCORE-20531 is done

The class does not retain the object in the 'dataSourceListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### isValid

```java
boolean isValid()
```

Tells if this **DataSourceLayer** is valid or not.

Any other method (except for this one) called on an invalid **DataSourceLayer** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
