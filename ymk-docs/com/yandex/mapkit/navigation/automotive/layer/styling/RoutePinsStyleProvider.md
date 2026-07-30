---
title: "RoutePinsStyleProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer.styling"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer.styling / RoutePinsStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/RoutePinsStyleProvider.html"
---
# RoutePinsStyleProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/RoutePinsStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer.styling

`interface RoutePinsStyleProvider`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `provideTrafficLightStyle(float scaleFactor, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull PlacemarkStyle style)` |
| `void` | `provideCheckpointStyle(float scaleFactor, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull PlacemarkStyle style)` |
| `void` | `provideRailwayCrossingStyle(float scaleFactor, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull PlacemarkStyle style)` |
| `void` | `provideRoadInPoorConditionStyle(float scaleFactor, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull PlacemarkStyle roadInPoorConditionStartStyle, @NonNull PlacemarkStyle roadInPoorConditionEndStyle)` |
| `void` | `provideTollRoadStyle(float scaleFactor, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull PlacemarkStyle tollRoadStartStyle, @NonNull PlacemarkStyle tollRoadEndStyle)` |
| `void` | `provideRestrictedEntryStyle(float scaleFactor, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull PlacemarkStyle style)` |
| `void` | `provideSpeedBumpStyle(float scaleFactor, boolean isNightMode, @NonNull NavigationLayerMode navigationLayerMode, @NonNull PlacemarkStyle style)` |

## Methods

### provideTrafficLightStyle

```java
@UiThread
void provideTrafficLightStyle(float scaleFactor,
                              boolean isNightMode,
                              @NonNull NavigationLayerMode navigationLayerMode,
                              @NonNull PlacemarkStyle style)
```

### provideCheckpointStyle

```java
@UiThread
void provideCheckpointStyle(float scaleFactor,
                            boolean isNightMode,
                            @NonNull NavigationLayerMode navigationLayerMode,
                            @NonNull PlacemarkStyle style)
```

### provideRailwayCrossingStyle

```java
@UiThread
void provideRailwayCrossingStyle(float scaleFactor,
                                 boolean isNightMode,
                                 @NonNull NavigationLayerMode navigationLayerMode,
                                 @NonNull PlacemarkStyle style)
```

### provideRoadInPoorConditionStyle

```java
@UiThread
void provideRoadInPoorConditionStyle(float scaleFactor,
                                     boolean isNightMode,
                                     @NonNull NavigationLayerMode navigationLayerMode,
                                     @NonNull PlacemarkStyle roadInPoorConditionStartStyle,
                                     @NonNull PlacemarkStyle roadInPoorConditionEndStyle)
```

### provideTollRoadStyle

```java
@UiThread
void provideTollRoadStyle(float scaleFactor,
                          boolean isNightMode,
                          @NonNull NavigationLayerMode navigationLayerMode,
                          @NonNull PlacemarkStyle tollRoadStartStyle,
                          @NonNull PlacemarkStyle tollRoadEndStyle)
```

### provideRestrictedEntryStyle

```java
@UiThread
void provideRestrictedEntryStyle(float scaleFactor,
                                 boolean isNightMode,
                                 @NonNull NavigationLayerMode navigationLayerMode,
                                 @NonNull PlacemarkStyle style)
```

### provideSpeedBumpStyle

```java
@UiThread
void provideSpeedBumpStyle(float scaleFactor,
                           boolean isNightMode,
                           @NonNull NavigationLayerMode navigationLayerMode,
                           @NonNull PlacemarkStyle style)
```
