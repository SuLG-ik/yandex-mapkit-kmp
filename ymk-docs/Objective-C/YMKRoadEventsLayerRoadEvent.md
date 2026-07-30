---
title: "YMKRoadEventsLayerRoadEvent"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRoadEventsLayerRoadEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsLayerRoadEvent.html"
---
# YMKRoadEventsLayerRoadEvent

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsLayerRoadEvent.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKRoadEventsLayerRoadEvent : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKRoadEventsLayerRoadEvent *)roadEventsLayerRoadEventWithId:(nonnull NSString *)id
                                                               position:(nonnull YMKPoint *)position
                                                                   tags:(nonnull NSArray<NSNumber *> *)tags
                                                                caption:(nonnull NSString *)caption
                                                             isInFuture:( BOOL)isInFuture;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

The road event unique id

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Position of the road event on the globe

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *tags;
```

Set of road event tags

```objectivec
@property (nonatomic, readonly, nonnull) NSString *caption;
```

Text caption displayed under the road event icon

```objectivec
@property (nonatomic, readonly) BOOL isInFuture;
```

Some road events can be not active yet, but still must be displayed to notify users about future events, for example drawbridges or closures

## Class methods

### roadEventsLayerRoadEventWithId:position:tags:caption:isInFuture:

```objectivec
+ (nonnull YMKRoadEventsLayerRoadEvent *)roadEventsLayerRoadEventWithId:(nonnull NSString *)id
                                                               position:(nonnull YMKPoint *)position
                                                                   tags:(nonnull NSArray<NSNumber *> *)tags
                                                                caption:(nonnull NSString *)caption
                                                             isInFuture:( BOOL)isInFuture;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

The road event unique id.

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Position of the road event on the globe.

### tags

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *tags;
```

Set of road event tags.

### caption

```objectivec
@property (nonatomic, readonly, nonnull) NSString *caption;
```

Text caption displayed under the road event icon.

### isInFuture

```objectivec
@property (nonatomic, readonly) BOOL isInFuture;
```

Some road events can be not active yet, but still must be displayed to notify users about future events, for example drawbridges or closures. Usually such events have a greyscale icon and/or clock drawn in the icon's corner.
