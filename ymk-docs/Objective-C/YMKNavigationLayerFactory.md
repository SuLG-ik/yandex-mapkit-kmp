---
title: "YMKNavigationLayerFactory"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigationLayerFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationLayerFactory.html"
---
# YMKNavigationLayerFactory

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationLayerFactory.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigationLayerFactory : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKNavigationLayer *)
    createNavigationLayerWithMapWindow:(nonnull YMKMapWindow *)mapWindow
          roadEventsLayerStyleProvider:
              (nonnull id<YMKRoadEventsLayerStyleProvider>)
                  roadEventsLayerStyleProvider
                         styleProvider:(nonnull id<YMKNavigationStyleProvider>)
                                           styleProvider
                            navigation:(nonnull YMKNavigation *)navigation;
```

Adds navigation layer on the map

## Class methods

### createNavigationLayerWithMapWindow:roadEventsLayerStyleProvider:styleProvider:navigation:

```objectivec
+ (nonnull YMKNavigationLayer *)
    createNavigationLayerWithMapWindow:(nonnull YMKMapWindow *)mapWindow
          roadEventsLayerStyleProvider:
              (nonnull id<YMKRoadEventsLayerStyleProvider>)
                  roadEventsLayerStyleProvider
                         styleProvider:(nonnull id<YMKNavigationStyleProvider>)
                                           styleProvider
                            navigation:(nonnull YMKNavigation *)navigation;
```

Adds navigation layer on the map.

The class maintains a strong reference to the object in the 'roadEventsLayerStyleProvider' parameter until it (the class) is invalidated.

The class maintains a strong reference to the object in the 'styleProvider' parameter until it (the class) is invalidated.
