---
title: "YMKRoadEventsLayerRoadEventStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRoadEventsLayerRoadEventStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsLayerRoadEventStyle.html"
---
# YMKRoadEventsLayerRoadEventStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsLayerRoadEventStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKRoadEventsLayerRoadEventStyle : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)setIconImage:(nonnull UIImage *)image;
```

Road event icon image

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) NSInteger zoomMin;
```

Road event is visible only if current camera zoom is greater or equal than this value

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) CGPoint iconAnchor;
```

Icon anchor, (0, 0) is top left and (1

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    NSArray<NSValue *> *zoomScaleFunction;
```

Piecewise linear scale function

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    YMKRoadEventsLayerTextStyle *captionStyle;
```

Style of caption displayed under the road event icon

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setIconImage:

```objectivec
- (void)setIconImage:(nonnull UIImage *)image;
```

Road event icon image.

## Properties

### zoomMin

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) NSInteger zoomMin;
```

Road event is visible only if current camera zoom is greater or equal than this value.

### iconAnchor

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) CGPoint iconAnchor;
```

Icon anchor, (0, 0) is top left and (1.0, 1.0) is bottom right.

### zoomScaleFunction

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    NSArray<NSValue *> *zoomScaleFunction;
```

Piecewise linear scale function. See Placemark's scale function.

### captionStyle

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    YMKRoadEventsLayerTextStyle *captionStyle;
```

Style of caption displayed under the road event icon.

Optional property, can be nil.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
