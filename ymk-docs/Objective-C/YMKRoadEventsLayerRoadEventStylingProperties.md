---
title: "YMKRoadEventsLayerRoadEventStylingProperties"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRoadEventsLayerRoadEventStylingProperties"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsLayerRoadEventStylingProperties.html"
---
# YMKRoadEventsLayerRoadEventStylingProperties

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsLayerRoadEventStylingProperties.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKRoadEventsLayerRoadEventStylingProperties : NSObject
```

Interface that has subset of fields of RoadEvent necessary for providing style.

## Summary

### Instance methods

```objectivec
- (BOOL)hasSignificanceGreaterOrEqualWithSignificance:
    (YMKRoadEventSignificance)significance;
```

Road events with a high significance can be visible on overview zooms, while events with low significance usually visible on detailed zooms only

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *tags;
```

Set of road event tags

```objectivec
@property (nonatomic, readonly, getter=isInFuture) BOOL inFuture;
```

Whether road event will become active in the future

```objectivec
@property (nonatomic, readonly, getter=isOnRoute) BOOL onRoute;
```

Road event placed on a route

```objectivec
@property (nonatomic, readonly, getter=isSelected) BOOL selected;
```

Road event was selected by RoadEventsLayer

```objectivec
@property (nonatomic, readonly, getter=isUserEvent) BOOL userEvent;
```

Currently logged in user is either an author of this road event or has commented it

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### hasSignificanceGreaterOrEqualWithSignificance:

```objectivec
- (BOOL)hasSignificanceGreaterOrEqualWithSignificance:
    (YMKRoadEventSignificance)significance;
```

Road events with a high significance can be visible on overview zooms, while events with low significance usually visible on detailed zooms only. Significance of a road event can depend on a road category this event is snapped to, number of comments of this event and other factors. Two road events with same significance but different tag sets can be visible on different zoom ranges.

## Properties

### tags

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *tags;
```

Set of road event tags.

### inFuture

```objectivec
@property (nonatomic, readonly, getter=isInFuture) BOOL inFuture;
```

Whether road event will become active in the future. See RoadEvent for details.

### onRoute

```objectivec
@property (nonatomic, readonly, getter=isOnRoute) BOOL onRoute;
```

Road event placed on a route. See RoadEventsLayer.setRoadEventsOnRoute.

### selected

```objectivec
@property (nonatomic, readonly, getter=isSelected) BOOL selected;
```

Road event was selected by RoadEventsLayer.selectRoadEvent.

### userEvent

```objectivec
@property (nonatomic, readonly, getter=isUserEvent) BOOL userEvent;
```

Currently logged in user is either an author of this road event or has commented it.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
