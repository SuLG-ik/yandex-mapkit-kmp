---
title: "YMKNavigationRoutePinsStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKNavigationRoutePinsStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationRoutePinsStyleProvider.html"
---
# YMKNavigationRoutePinsStyleProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationRoutePinsStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
protocol YMKNavigationRoutePinsStyleProvider : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func provideTrafficLightStyle(withScaleFactor scaleFactor: Float,
                                              isNightMode: Bool,
                                      navigationLayerMode: YMKNavigationLayerMode,
                                                    style: YMKPlacemarkStyle)
```

```swift
func provideCheckpointStyle(withScaleFactor scaleFactor: Float,
                                            isNightMode: Bool,
                                    navigationLayerMode: YMKNavigationLayerMode,
                                                  style: YMKPlacemarkStyle)
```

```swift
func provideRailwayCrossingStyle(withScaleFactor scaleFactor: Float,
                                                 isNightMode: Bool,
                                         navigationLayerMode: YMKNavigationLayerMode,
                                                       style: YMKPlacemarkStyle)
```

```swift
func provideRoadInPoorConditionStyle(withScaleFactor scaleFactor: Float,
                                                     isNightMode: Bool,
                                             navigationLayerMode: YMKNavigationLayerMode,
          roadInPoorConditionStart roadInPoorConditionStartStyle: YMKPlacemarkStyle,
              roadInPoorConditionEnd roadInPoorConditionEndStyle: YMKPlacemarkStyle)
```

```swift
func provideTollRoadStyle(withScaleFactor scaleFactor: Float,
                                          isNightMode: Bool,
                                  navigationLayerMode: YMKNavigationLayerMode,
                     tollRoadStart tollRoadStartStyle: YMKPlacemarkStyle,
                         tollRoadEnd tollRoadEndStyle: YMKPlacemarkStyle)
```

```swift
func provideRestrictedEntryStyle(withScaleFactor scaleFactor: Float,
                                                 isNightMode: Bool,
                                         navigationLayerMode: YMKNavigationLayerMode,
                                                       style: YMKPlacemarkStyle)
```

```swift
func provideSpeedBumpStyle(withScaleFactor scaleFactor: Float,
                                           isNightMode: Bool,
                                   navigationLayerMode: YMKNavigationLayerMode,
                                                 style: YMKPlacemarkStyle)
```

## Instance methods

### provideTrafficLightStyle(withScaleFactor:isNightMode:navigationLayerMode:style:)

```swift
func provideTrafficLightStyle(withScaleFactor scaleFactor: Float,
                                              isNightMode: Bool,
                                      navigationLayerMode: YMKNavigationLayerMode,
                                                    style: YMKPlacemarkStyle)
```

### provideCheckpointStyle(withScaleFactor:isNightMode:navigationLayerMode:style:)

```swift
func provideCheckpointStyle(withScaleFactor scaleFactor: Float,
                                            isNightMode: Bool,
                                    navigationLayerMode: YMKNavigationLayerMode,
                                                  style: YMKPlacemarkStyle)
```

### provideRailwayCrossingStyle(withScaleFactor:isNightMode:navigationLayerMode:style:)

```swift
func provideRailwayCrossingStyle(withScaleFactor scaleFactor: Float,
                                                 isNightMode: Bool,
                                         navigationLayerMode: YMKNavigationLayerMode,
                                                       style: YMKPlacemarkStyle)
```

### provideRoadInPoorConditionStyle(withScaleFactor:isNightMode:navigationLayerMode:roadInPoorConditionStart:roadInPoorConditionEnd:)

```swift
func provideRoadInPoorConditionStyle(withScaleFactor scaleFactor: Float,
                                                     isNightMode: Bool,
                                             navigationLayerMode: YMKNavigationLayerMode,
          roadInPoorConditionStart roadInPoorConditionStartStyle: YMKPlacemarkStyle,
              roadInPoorConditionEnd roadInPoorConditionEndStyle: YMKPlacemarkStyle)
```

### provideTollRoadStyle(withScaleFactor:isNightMode:navigationLayerMode:tollRoadStart:tollRoadEnd:)

```swift
func provideTollRoadStyle(withScaleFactor scaleFactor: Float,
                                          isNightMode: Bool,
                                  navigationLayerMode: YMKNavigationLayerMode,
                     tollRoadStart tollRoadStartStyle: YMKPlacemarkStyle,
                         tollRoadEnd tollRoadEndStyle: YMKPlacemarkStyle)
```

### provideRestrictedEntryStyle(withScaleFactor:isNightMode:navigationLayerMode:style:)

```swift
func provideRestrictedEntryStyle(withScaleFactor scaleFactor: Float,
                                                 isNightMode: Bool,
                                         navigationLayerMode: YMKNavigationLayerMode,
                                                       style: YMKPlacemarkStyle)
```

### provideSpeedBumpStyle(withScaleFactor:isNightMode:navigationLayerMode:style:)

```swift
func provideSpeedBumpStyle(withScaleFactor scaleFactor: Float,
                                           isNightMode: Bool,
                                   navigationLayerMode: YMKNavigationLayerMode,
                                                 style: YMKPlacemarkStyle)
```
