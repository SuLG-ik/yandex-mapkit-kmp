---
title: "NavigationLayerFactory"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer / NavigationLayerFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/NavigationLayerFactory.html"
---
# NavigationLayerFactory

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/NavigationLayerFactory.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.layer.NavigationLayerFactory

`class NavigationLayerFactory`

## Summary

### Constructors

**Signature and Description**

```java
NavigationLayerFactory()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native NavigationLayer` | `createNavigationLayer(@NonNull MapWindow mapWindow, @NonNull StyleProvider roadEventsLayerStyleProvider, @NonNull NavigationStyleProvider styleProvider, @NonNull Navigation navigation)`<br>Adds navigation layer on the map. |

## Constuctors

### NavigationLayerFactory

```java
NavigationLayerFactory()
```

## Methods

### createNavigationLayer

```java
@NonNull
NavigationLayer createNavigationLayer(@NonNull MapWindow mapWindow,
                                      @NonNull StyleProvider roadEventsLayerStyleProvider,
                                      @NonNull NavigationStyleProvider styleProvider,
                                      @NonNull Navigation navigation)
```

Adds navigation layer on the map.

The class maintains a strong reference to the object in the 'roadEventsLayerStyleProvider' parameter until it (the class) is invalidated.

The class maintains a strong reference to the object in the 'styleProvider' parameter until it (the class) is invalidated.
