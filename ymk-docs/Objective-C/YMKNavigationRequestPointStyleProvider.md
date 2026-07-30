---
title: "YMKNavigationRequestPointStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKNavigationRequestPointStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationRequestPointStyleProvider.html"
---
# YMKNavigationRequestPointStyleProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationRequestPointStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKNavigationRequestPointStyleProvider <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)provideStyleWithRequestPointIndex:(NSInteger)requestPointIndex
                      requestPointsNumber:(NSInteger)requestPointsNumber
                         requestPointType:(YMKRequestPointType)requestPointType
                              scaleFactor:(float)scaleFactor
                               isSelected:(BOOL)isSelected
                              isNightMode:(BOOL)isNightMode
                      navigationLayerMode:
                          (YMKNavigationLayerMode)navigationLayerMode
                                    style:(nonnull YMKPlacemarkStyle *)style;
```

## Instance methods

### provideStyleWithRequestPointIndex:requestPointsNumber:requestPointType:scaleFactor:isSelected:isNightMode:navigationLayerMode:style:

```objectivec
- (void)provideStyleWithRequestPointIndex:(NSInteger)requestPointIndex
                      requestPointsNumber:(NSInteger)requestPointsNumber
                         requestPointType:(YMKRequestPointType)requestPointType
                              scaleFactor:(float)scaleFactor
                               isSelected:(BOOL)isSelected
                              isNightMode:(BOOL)isNightMode
                      navigationLayerMode:
                          (YMKNavigationLayerMode)navigationLayerMode
                                    style:(nonnull YMKPlacemarkStyle *)style;
```
