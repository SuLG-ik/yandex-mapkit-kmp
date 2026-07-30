---
title: "BaseDataSourceBuilder"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / BaseDataSourceBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/BaseDataSourceBuilder.html"
---
# BaseDataSourceBuilder

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/BaseDataSourceBuilder.html)

**Package** com.yandex.mapkit.map

## All known Subinterfaces:

*[TileDataSourceBuilder](TileDataSourceBuilder.md)*

`interface BaseDataSourceBuilder`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setImageUrlProvider(@NonNull ImageUrlProvider urlProvider)`<br>The class does not retain the object in the 'urlProvider' parameter. |
| `boolean` | `isValid()`<br>Tells if this **BaseDataSourceBuilder** is valid or not. |

## Methods

### setImageUrlProvider

```java
void setImageUrlProvider(@NonNull ImageUrlProvider urlProvider)
```

The class does not retain the object in the 'urlProvider' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### isValid

```java
boolean isValid()
```

Tells if this **BaseDataSourceBuilder** is valid or not.

Any other method (except for this one) called on an invalid **BaseDataSourceBuilder** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
