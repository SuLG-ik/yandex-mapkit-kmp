---
title: "YMKRoadEventsLayerTextStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRoadEventsLayerTextStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsLayerTextStyle.html"
---
# YMKRoadEventsLayerTextStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsLayerTextStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKRoadEventsLayerTextStyle : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKRoadEventsLayerTextStyle *)textStyleWithFontSize:( float)fontSize
                                                         color:(nonnull UIColor *)color
                                                  outlineColor:(nullable UIColor *)outlineColor;
```

### Properties

```objectivec
@property (nonatomic, readonly) float fontSize;
```

Font size in device-independent pixels

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *color;
```

Text primary color

```objectivec
@property (nonatomic, readonly, nullable) UIColor *outlineColor;
```

Text outline color

## Class methods

### textStyleWithFontSize:color:outlineColor:

```objectivec
+ (nonnull YMKRoadEventsLayerTextStyle *)textStyleWithFontSize:( float)fontSize
                                                         color:(nonnull UIColor *)color
                                                  outlineColor:(nullable UIColor *)outlineColor;
```

## Properties

### fontSize

```objectivec
@property (nonatomic, readonly) float fontSize;
```

Font size in device-independent pixels.

### color

```objectivec
@property (nonatomic, readonly, nonnull) UIColor *color;
```

Text primary color.

### outlineColor

```objectivec
@property (nonatomic, readonly, nullable) UIColor *outlineColor;
```

Text outline color.

Optional field, can be nil.
