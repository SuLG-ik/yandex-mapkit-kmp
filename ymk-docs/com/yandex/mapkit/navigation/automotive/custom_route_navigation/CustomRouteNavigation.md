---
title: "CustomRouteNavigation"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.custom_route_navigation"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.custom_route_navigation / CustomRouteNavigation"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/custom_route_navigation/CustomRouteNavigation.html"
---
# CustomRouteNavigation

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/custom_route_navigation/CustomRouteNavigation.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.custom_route_navigation

`interface CustomRouteNavigation`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Navigation` | `getNavigation()`<br>This navigation is equal to standart automotive navigation BUT without alternatives without rerouting without working "requestRoutes" method traffic information will not be updated while driving along the route start guidance must be called only through the special method (startGuidance) of this class |
| `Camera` | `createCamera(@NonNull MapWindow mapWindow)`<br>This method allows to create camera which used in standart automotive navigation |
| `void` | `startGuidance(@Nullable DrivingRoute route)`<br>Start navigation with specified route. |

## Methods

### getNavigation

```java
@NonNull
Navigation getNavigation()
```

This navigation is equal to standart automotive navigation BUT without alternatives without rerouting without working "requestRoutes" method traffic information will not be updated while driving along the route start guidance must be called only through the special method (startGuidance) of this class

### createCamera

```java
@NonNull
Camera createCamera(@NonNull MapWindow mapWindow)
```

This method allows to create camera which used in standart automotive navigation

### startGuidance

```java
void startGuidance(@Nullable DrivingRoute route)
```

Start navigation with specified route.
