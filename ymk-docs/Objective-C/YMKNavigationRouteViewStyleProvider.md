---
title: "YMKNavigationRouteViewStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKNavigationRouteViewStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationRouteViewStyleProvider.html"
---
# YMKNavigationRouteViewStyleProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationRouteViewStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKNavigationRouteViewStyleProvider <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)provideJamStyleWithFlags:(nonnull YMKDrivingFlags *)flags
                      isSelected:(BOOL)isSelected
                     isNightMode:(BOOL)isNightMode
             navigationLayerMode:(YMKNavigationLayerMode)navigationLayerMode
                        jamStyle:(nonnull YMKNavigationJamStyle *)jamStyle;
```

```objectivec
- (void)providePolylineStyleWithFlags:(nonnull YMKDrivingFlags *)flags
                           isSelected:(BOOL)isSelected
                          isNightMode:(BOOL)isNightMode
                  navigationLayerMode:
                      (YMKNavigationLayerMode)navigationLayerMode
                        polylineStyle:(nonnull YMKPolylineStyle *)polylineStyle;
```

```objectivec
- (void)provideManoeuvreStyleWithFlags:(nonnull YMKDrivingFlags *)flags
                            isSelected:(BOOL)isSelected
                           isNightMode:(BOOL)isNightMode
                   navigationLayerMode:
                       (YMKNavigationLayerMode)navigationLayerMode
                            arrowStyle:(nonnull YMKArrowStyle *)arrowStyle;
```

```objectivec
- (void)provideRouteStyleWithFlags:(nonnull YMKDrivingFlags *)flags
                        isSelected:(BOOL)isSelected
                       isNightMode:(BOOL)isNightMode
               navigationLayerMode:(YMKNavigationLayerMode)navigationLayerMode
                        routeStyle:
                            (nonnull YMKNavigationRouteStyle *)routeStyle;
```

## Instance methods

### provideJamStyleWithFlags:isSelected:isNightMode:navigationLayerMode:jamStyle:

```objectivec
- (void)provideJamStyleWithFlags:(nonnull YMKDrivingFlags *)flags
                      isSelected:(BOOL)isSelected
                     isNightMode:(BOOL)isNightMode
             navigationLayerMode:(YMKNavigationLayerMode)navigationLayerMode
                        jamStyle:(nonnull YMKNavigationJamStyle *)jamStyle;
```

### providePolylineStyleWithFlags:isSelected:isNightMode:navigationLayerMode:polylineStyle:

```objectivec
- (void)providePolylineStyleWithFlags:(nonnull YMKDrivingFlags *)flags
                           isSelected:(BOOL)isSelected
                          isNightMode:(BOOL)isNightMode
                  navigationLayerMode:
                      (YMKNavigationLayerMode)navigationLayerMode
                        polylineStyle:(nonnull YMKPolylineStyle *)polylineStyle;
```

### provideManoeuvreStyleWithFlags:isSelected:isNightMode:navigationLayerMode:arrowStyle:

```objectivec
- (void)provideManoeuvreStyleWithFlags:(nonnull YMKDrivingFlags *)flags
                            isSelected:(BOOL)isSelected
                           isNightMode:(BOOL)isNightMode
                   navigationLayerMode:
                       (YMKNavigationLayerMode)navigationLayerMode
                            arrowStyle:(nonnull YMKArrowStyle *)arrowStyle;
```

### provideRouteStyleWithFlags:isSelected:isNightMode:navigationLayerMode:routeStyle:

```objectivec
- (void)provideRouteStyleWithFlags:(nonnull YMKDrivingFlags *)flags
                        isSelected:(BOOL)isSelected
                       isNightMode:(BOOL)isNightMode
               navigationLayerMode:(YMKNavigationLayerMode)navigationLayerMode
                        routeStyle:
                            (nonnull YMKNavigationRouteStyle *)routeStyle;
```
