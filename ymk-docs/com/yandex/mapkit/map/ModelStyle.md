---
title: "ModelStyle"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / ModelStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/ModelStyle.html"
---
# ModelStyle

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/ModelStyle.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ com.yandex.mapkit.map.ModelStyle

`final class ModelStyle implements Serializable`

The style of the model.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [UnitType](ModelStyle_UnitType.md) |   |
| `static final` | [RenderMode](ModelStyle_RenderMode.md) |   |

## Summary

### Constructors

**Signature and Description**

```java
ModelStyle(float scale,
           @NonNull UnitType unitType,
           @NonNull RenderMode renderMode,
           @Nullable java.lang.String variantName)
```

```java
ModelStyle()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `float` | `getScale()`<br>Scale the model by this value. |
| `ModelStyle` | `setScale(float scale)`<br>See **#getScale()**. |
| `UnitType` | `getUnitType()`<br>Unit type of the model. |
| `ModelStyle` | `setUnitType(@NonNull UnitType unitType)`<br>See **#getUnitType()**. |
| `RenderMode` | `getRenderMode()`<br>Defines should it be rendered with buildings from ground layer. |
| `ModelStyle` | `setRenderMode(@NonNull RenderMode renderMode)`<br>See **#getRenderMode()**. |
| `java.lang.String` | `getVariantName()`<br>Name of variant to render model with. |
| `ModelStyle` | `setVariantName(@Nullable java.lang.String variantName)`<br>See **#getVariantName()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ModelStyle

```java
ModelStyle(float scale,
           @NonNull UnitType unitType,
           @NonNull RenderMode renderMode,
           @Nullable java.lang.String variantName)
```

### ModelStyle

```java
ModelStyle()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getScale

```java
float getScale()
```

Scale the model by this value.

### setScale

```java
ModelStyle setScale(float scale)
```

See **#getScale()**.

### getUnitType

```java
@NonNull
UnitType getUnitType()
```

Unit type of the model.

### setUnitType

```java
ModelStyle setUnitType(@NonNull UnitType unitType)
```

See **#getUnitType()**.

### getRenderMode

```java
@NonNull
RenderMode getRenderMode()
```

Defines should it be rendered with buildings from ground layer.

### setRenderMode

```java
ModelStyle setRenderMode(@NonNull RenderMode renderMode)
```

See **#getRenderMode()**.

### getVariantName

```java
@Nullable
java.lang.String getVariantName()
```

Name of variant to render model with.

See KHR_materials_variants gltf extension. This works only for glTF models.

Optional field, can be null.

### setVariantName

```java
ModelStyle setVariantName(@Nullable java.lang.String variantName)
```

See **#getVariantName()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
