---
title: "Model"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / Model"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/Model.html"
---
# Model

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/Model.html)

**Package** com.yandex.mapkit.map

## All Superinterfaces:

*[PlacemarkPresentation](PlacemarkPresentation.md)*

`interface Model extends PlacemarkPresentation`

describes model presentation of PlacemarkMapObject

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `ModelStyle` | `getModelStyle()`<br>The style properties (scale, unitType, etc.) of the model placemark. |
| `void` | `setModelStyle(@NonNull ModelStyle modelStyle)` |
| `void` | `setData(@NonNull DataProviderWithId gltfDataProvider)`<br>Sets glTF data provider. |
| `void` | `setData(@NonNull DataProviderWithId gltfDataProvider, @Nullable Callback onFinished)`<br>Sets glTF data provider. |

## Methods

### getModelStyle

```java
@NonNull
ModelStyle getModelStyle()
```

The style properties (scale, unitType, etc.) of the model placemark.

Note: The current style cannot be modified directly - you must reset it to apply changes.

### setModelStyle

```java
void setModelStyle(@NonNull ModelStyle modelStyle)
```

### setData

```java
void setData(@NonNull DataProviderWithId gltfDataProvider)
```

Sets glTF data provider.

The class maintains a strong reference to the object in the 'gltfDataProvider' parameter until it (the class) is invalidated.

| Parameters |   |
| --- | --- |
| `onFinished` | Called when the model is loaded. |

### setData

```java
void setData(@NonNull DataProviderWithId gltfDataProvider,
             @Nullable Callback onFinished)
```

Sets glTF data provider.

The class maintains a strong reference to the object in the 'gltfDataProvider' parameter until it (the class) is invalidated.

| Parameters |   |
| --- | --- |
| `onFinished` | Called when the model is loaded. |
