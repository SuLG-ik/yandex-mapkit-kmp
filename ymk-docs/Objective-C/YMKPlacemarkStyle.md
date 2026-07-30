---
title: "YMKPlacemarkStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPlacemarkStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlacemarkStyle.html"
---
# YMKPlacemarkStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlacemarkStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKPlacemarkStyle : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)setArrowModel;
```

Set the placemark to be an 3D arrow

```objectivec
- (void)setGltfModelWithModel:(nonnull id<YRTDataProviderWithId>)model
                   modelStyle:(nonnull YMKModelStyle *)modelStyle;
```

The class maintains a strong reference to the object in the 'model' parameter until it (the class) is invalidated

```objectivec
- (void)setImageWithImage:(nonnull UIImage *)image;
```

```objectivec
- (void)setAnimatedImageWithIconImage:
    (nonnull id<YRTAnimatedImageProvider>)iconImage;
```

```objectivec
- (void)setIconAnchorWithIconAnchor:(CGPoint)iconAnchor;
```

Icon anchor, (0, 0) is top left and (1

```objectivec
- (void)setScaleFunctionWithPoints:(nonnull NSArray<NSValue *> *)points;
```

Piecewise linear scale function

```objectivec
- (void)setMinZoomVisibleWithMinZoom:(nullable NSNumber *)minZoom;
```

Minimal zoom for placemark to be visible

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setArrowModel

```objectivec
- (void)setArrowModel;
```

Set the placemark to be an 3D arrow. Usable only for user position placemark.

### setGltfModelWithModel:modelStyle:

```objectivec
- (void)setGltfModelWithModel:(nonnull id<YRTDataProviderWithId>)model
                   modelStyle:(nonnull YMKModelStyle *)modelStyle;
```

The class maintains a strong reference to the object in the 'model' parameter until it (the class) is invalidated.

### setImageWithImage:

```objectivec
- (void)setImageWithImage:(nonnull UIImage *)image;
```

### setAnimatedImageWithIconImage:

```objectivec
- (void)setAnimatedImageWithIconImage:
    (nonnull id<YRTAnimatedImageProvider>)iconImage;
```

### setIconAnchorWithIconAnchor:

```objectivec
- (void)setIconAnchorWithIconAnchor:(CGPoint)iconAnchor;
```

Icon anchor, (0, 0) is top left and (1.0, 1.0) is bottom right.

### setScaleFunctionWithPoints:

```objectivec
- (void)setScaleFunctionWithPoints:(nonnull NSArray<NSValue *> *)points;
```

Piecewise linear scale function. See Placemark's scale function.

### setMinZoomVisibleWithMinZoom:

```objectivec
- (void)setMinZoomVisibleWithMinZoom:(nullable NSNumber *)minZoom;
```

Minimal zoom for placemark to be visible.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
