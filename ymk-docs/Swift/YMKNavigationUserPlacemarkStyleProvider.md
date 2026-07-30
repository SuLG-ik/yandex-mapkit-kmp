---
title: "YMKNavigationUserPlacemarkStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKNavigationUserPlacemarkStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationUserPlacemarkStyleProvider.html"
---
# YMKNavigationUserPlacemarkStyleProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationUserPlacemarkStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
protocol YMKNavigationUserPlacemarkStyleProvider : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func provideStyle(withScaleFactor scaleFactor: Float,
                                  isNightMode: Bool,
                          navigationLayerMode: YMKNavigationLayerMode,
                                        style: YMKPlacemarkStyle)
```

## Instance methods

### provideStyle(withScaleFactor:isNightMode:navigationLayerMode:style:)

```swift
func provideStyle(withScaleFactor scaleFactor: Float,
                                  isNightMode: Bool,
                          navigationLayerMode: YMKNavigationLayerMode,
                                        style: YMKPlacemarkStyle)
```
