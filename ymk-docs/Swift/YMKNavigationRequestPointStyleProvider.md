---
title: "YMKNavigationRequestPointStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKNavigationRequestPointStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationRequestPointStyleProvider.html"
---
# YMKNavigationRequestPointStyleProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationRequestPointStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
protocol YMKNavigationRequestPointStyleProvider : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func provideStyle(withRequestPointIndex requestPointIndex: Int,
                                      requestPointsNumber: Int,
                                         requestPointType: YMKRequestPointType,
                                              scaleFactor: Float,
                                               isSelected: Bool,
                                              isNightMode: Bool,
                                      navigationLayerMode: YMKNavigationLayerMode,
                                                    style: YMKPlacemarkStyle)
```

## Instance methods

### provideStyle(withRequestPointIndex:requestPointsNumber:requestPointType:scaleFactor:isSelected:isNightMode:navigationLayerMode:style:)

```swift
func provideStyle(withRequestPointIndex requestPointIndex: Int,
                                      requestPointsNumber: Int,
                                         requestPointType: YMKRequestPointType,
                                              scaleFactor: Float,
                                               isSelected: Bool,
                                              isNightMode: Bool,
                                      navigationLayerMode: YMKNavigationLayerMode,
                                                    style: YMKPlacemarkStyle)
```
