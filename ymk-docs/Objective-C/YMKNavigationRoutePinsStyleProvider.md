---
title: "YMKNavigationRoutePinsStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKNavigationRoutePinsStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationRoutePinsStyleProvider.html"
---
# YMKNavigationRoutePinsStyleProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationRoutePinsStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKNavigationRoutePinsStyleProvider <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)provideTrafficLightStyleWithScaleFactor:(float)scaleFactor
                                    isNightMode:(BOOL)isNightMode
                            navigationLayerMode:
                                (YMKNavigationLayerMode)navigationLayerMode
                                          style:(nonnull YMKPlacemarkStyle *)
                                                    style;
```

```objectivec
- (void)provideCheckpointStyleWithScaleFactor:(float)scaleFactor
                                  isNightMode:(BOOL)isNightMode
                          navigationLayerMode:
                              (YMKNavigationLayerMode)navigationLayerMode
                                        style:
                                            (nonnull YMKPlacemarkStyle *)style;
```

```objectivec
- (void)provideRailwayCrossingStyleWithScaleFactor:(float)scaleFactor
                                       isNightMode:(BOOL)isNightMode
                               navigationLayerMode:
                                   (YMKNavigationLayerMode)navigationLayerMode
                                             style:(nonnull YMKPlacemarkStyle *)
                                                       style;
```

```objectivec
- (void)provideRoadInPoorConditionStyleWithScaleFactor:(float)scaleFactor
                                           isNightMode:(BOOL)isNightMode
                                   navigationLayerMode:(YMKNavigationLayerMode)
                                                           navigationLayerMode
                         roadInPoorConditionStartStyle:
                             (nonnull YMKPlacemarkStyle *)
                                 roadInPoorConditionStartStyle
                           roadInPoorConditionEndStyle:
                               (nonnull YMKPlacemarkStyle *)
                                   roadInPoorConditionEndStyle;
```

```objectivec
- (void)provideTollRoadStyleWithScaleFactor:(float)scaleFactor
                                isNightMode:(BOOL)isNightMode
                        navigationLayerMode:
                            (YMKNavigationLayerMode)navigationLayerMode
                         tollRoadStartStyle:
                             (nonnull YMKPlacemarkStyle *)tollRoadStartStyle
                           tollRoadEndStyle:
                               (nonnull YMKPlacemarkStyle *)tollRoadEndStyle;
```

```objectivec
- (void)provideRestrictedEntryStyleWithScaleFactor:(float)scaleFactor
                                       isNightMode:(BOOL)isNightMode
                               navigationLayerMode:
                                   (YMKNavigationLayerMode)navigationLayerMode
                                             style:(nonnull YMKPlacemarkStyle *)
                                                       style;
```

```objectivec
- (void)provideSpeedBumpStyleWithScaleFactor:(float)scaleFactor
                                 isNightMode:(BOOL)isNightMode
                         navigationLayerMode:
                             (YMKNavigationLayerMode)navigationLayerMode
                                       style:(nonnull YMKPlacemarkStyle *)style;
```

## Instance methods

### provideTrafficLightStyleWithScaleFactor:isNightMode:navigationLayerMode:style:

```objectivec
- (void)provideTrafficLightStyleWithScaleFactor:(float)scaleFactor
                                    isNightMode:(BOOL)isNightMode
                            navigationLayerMode:
                                (YMKNavigationLayerMode)navigationLayerMode
                                          style:(nonnull YMKPlacemarkStyle *)
                                                    style;
```

### provideCheckpointStyleWithScaleFactor:isNightMode:navigationLayerMode:style:

```objectivec
- (void)provideCheckpointStyleWithScaleFactor:(float)scaleFactor
                                  isNightMode:(BOOL)isNightMode
                          navigationLayerMode:
                              (YMKNavigationLayerMode)navigationLayerMode
                                        style:
                                            (nonnull YMKPlacemarkStyle *)style;
```

### provideRailwayCrossingStyleWithScaleFactor:isNightMode:navigationLayerMode:style:

```objectivec
- (void)provideRailwayCrossingStyleWithScaleFactor:(float)scaleFactor
                                       isNightMode:(BOOL)isNightMode
                               navigationLayerMode:
                                   (YMKNavigationLayerMode)navigationLayerMode
                                             style:(nonnull YMKPlacemarkStyle *)
                                                       style;
```

### provideRoadInPoorConditionStyleWithScaleFactor:isNightMode:navigationLayerMode:roadInPoorConditionStartStyle:roadInPoorConditionEndStyle:

```objectivec
- (void)provideRoadInPoorConditionStyleWithScaleFactor:(float)scaleFactor
                                           isNightMode:(BOOL)isNightMode
                                   navigationLayerMode:(YMKNavigationLayerMode)
                                                           navigationLayerMode
                         roadInPoorConditionStartStyle:
                             (nonnull YMKPlacemarkStyle *)
                                 roadInPoorConditionStartStyle
                           roadInPoorConditionEndStyle:
                               (nonnull YMKPlacemarkStyle *)
                                   roadInPoorConditionEndStyle;
```

### provideTollRoadStyleWithScaleFactor:isNightMode:navigationLayerMode:tollRoadStartStyle:tollRoadEndStyle:

```objectivec
- (void)provideTollRoadStyleWithScaleFactor:(float)scaleFactor
                                isNightMode:(BOOL)isNightMode
                        navigationLayerMode:
                            (YMKNavigationLayerMode)navigationLayerMode
                         tollRoadStartStyle:
                             (nonnull YMKPlacemarkStyle *)tollRoadStartStyle
                           tollRoadEndStyle:
                               (nonnull YMKPlacemarkStyle *)tollRoadEndStyle;
```

### provideRestrictedEntryStyleWithScaleFactor:isNightMode:navigationLayerMode:style:

```objectivec
- (void)provideRestrictedEntryStyleWithScaleFactor:(float)scaleFactor
                                       isNightMode:(BOOL)isNightMode
                               navigationLayerMode:
                                   (YMKNavigationLayerMode)navigationLayerMode
                                             style:(nonnull YMKPlacemarkStyle *)
                                                       style;
```

### provideSpeedBumpStyleWithScaleFactor:isNightMode:navigationLayerMode:style:

```objectivec
- (void)provideSpeedBumpStyleWithScaleFactor:(float)scaleFactor
                                 isNightMode:(BOOL)isNightMode
                         navigationLayerMode:
                             (YMKNavigationLayerMode)navigationLayerMode
                                       style:(nonnull YMKPlacemarkStyle *)style;
```
