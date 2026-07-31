---
title: "YMKRoadEventsLayerStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKRoadEventsLayerStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsLayerStyleProvider.html"
---
# YMKRoadEventsLayerStyleProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsLayerStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKRoadEventsLayerStyleProvider <NSObject>
```

## Summary

### Instance methods

```objectivec
- (BOOL)
    provideStyleWithRoadEventStylingProperties:
        (nonnull YMKRoadEventsLayerRoadEventStylingProperties *)
            roadEventStylingProperties
                                   isNightMode:(BOOL)isNightMode
                                   scaleFactor:(float)scaleFactor
                                         style:
                                             (nonnull YMKRoadEventsLayerRoadEventStyle
                                                  *)style;
```

Provide style for given road event

## Instance methods

### provideStyleWithRoadEventStylingProperties:isNightMode:scaleFactor:style:

```objectivec
- (BOOL)
    provideStyleWithRoadEventStylingProperties:
        (nonnull YMKRoadEventsLayerRoadEventStylingProperties *)
            roadEventStylingProperties
                                   isNightMode:(BOOL)isNightMode
                                   scaleFactor:(float)scaleFactor
                                         style:
                                             (nonnull YMKRoadEventsLayerRoadEventStyle
                                                  *)style;
```

Provide style for given road event. Must produce same style for same input arguments.

| Parameters |   |
| --- | --- |
| scaleFactor | Scale factor of a map window displaying this road event. Road event icon image scale factor must match this value. |

**Returns**

`false` if road event must not be displayed at all.
