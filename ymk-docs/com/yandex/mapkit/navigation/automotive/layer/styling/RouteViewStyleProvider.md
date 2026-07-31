---
title: "RouteViewStyleProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer.styling"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer.styling / RouteViewStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/RouteViewStyleProvider.html"
---
# RouteViewStyleProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/RouteViewStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer.styling

`interface RouteViewStyleProvider`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `provideJamStyle(@NonNull Flags flags, boolean isSelected, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull JamStyle jamStyle)` |
| `void` | `providePolylineStyle(@NonNull Flags flags, boolean isSelected, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull PolylineStyle polylineStyle)` |
| `void` | `provideManoeuvreStyle(@NonNull Flags flags, boolean isSelected, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull ArrowStyle arrowStyle)` |
| `void` | `provideRouteStyle(@NonNull Flags flags, boolean isSelected, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull RouteStyle routeStyle)` |

## Methods

### provideJamStyle

```java
@UiThread
void provideJamStyle(@NonNull Flags flags,
                     boolean isSelected,
                     boolean isNightMode,
                     @NonNull NavigationLayerMode navigationLayerMode,
                     @NonNull JamStyle jamStyle)
```

### providePolylineStyle

```java
@UiThread
void providePolylineStyle(@NonNull Flags flags,
                          boolean isSelected,
                          boolean isNightMode,
                          @NonNull NavigationLayerMode navigationLayerMode,
                          @NonNull PolylineStyle polylineStyle)
```

### provideManoeuvreStyle

```java
@UiThread
void provideManoeuvreStyle(@NonNull Flags flags,
                           boolean isSelected,
                           boolean isNightMode,
                           @NonNull NavigationLayerMode navigationLayerMode,
                           @NonNull ArrowStyle arrowStyle)
```

### provideRouteStyle

```java
@UiThread
void provideRouteStyle(@NonNull Flags flags,
                       boolean isSelected,
                       boolean isNightMode,
                       @NonNull NavigationLayerMode navigationLayerMode,
                       @NonNull RouteStyle routeStyle)
```
