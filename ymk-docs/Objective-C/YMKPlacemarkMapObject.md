---
title: "YMKPlacemarkMapObject"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPlacemarkMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlacemarkMapObject.html"
---
# YMKPlacemarkMapObject

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlacemarkMapObject.html)

```objectivec
@interface YMKPlacemarkMapObject : YMKMapObject
```

Represents a geo-positioned object on the map.

## Summary

### Instance methods

```objectivec
- (void)setIconWithImage:(nonnull UIImage *)image;
```

Sets an icon with the default style for the placemark

```objectivec
- (void)setIconWithImage:(nonnull UIImage *)image
                   style:(nonnull YMKIconStyle *)style;
```

Sets an icon with the given style for the placemark

```objectivec
- (void)setIconWithImage:(nonnull UIImage *)image
                callback:(nonnull YMKCallback)callback;
```

Sets an icon with the default style for the placemark

```objectivec
- (void)setIconWithImage:(nonnull UIImage *)image
                   style:(nonnull YMKIconStyle *)style
                callback:(nonnull YMKCallback)callback;
```

Sets an icon with the given style for the placemark

```objectivec
- (void)setIconStyleWithStyle:(nonnull YMKIconStyle *)style;
```

Changes the icon style

```objectivec
- (nonnull YMKIcon *)useIcon;
```

Returns Icon object that can be used to set image or view and its style for the placemark

```objectivec
- (nonnull YMKCompositeIcon *)useCompositeIcon;
```

Returns CompositeIcon object that can be used to set icons and their styles for the placemark

```objectivec
- (nonnull YMKModel *)useModel;
```

Returns Model object that can be used to set model and its style for the placemark

```objectivec
- (nonnull YMKPlacemarkAnimation *)useAnimation;
```

Returns PlacemarkAnimation object that can be used to control animation of the placemark

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view;
```

Sets the view with the default style for the placemark

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view
                  style:(nonnull YMKIconStyle *)style;
```

Sets the view with the given style for the placemark

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view
               callback:(nonnull YMKCallback)callback;
```

Sets the view with the default style for the placemark

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view
                  style:(nonnull YMKIconStyle *)style
               callback:(nonnull YMKCallback)callback;
```

Sets the view with the given style for the placemark

```objectivec
- (void)setScaleFunctionWithPoints:(nonnull NSArray<NSValue *> *)points;
```

Sets piecewise linear scale, depending on the zoom

```objectivec
- (void)setTextWithText:(nonnull NSString *)text;
```

Sets the text for the placemark, current text style is used

```objectivec
- (void)setTextWithText:(nonnull NSString *)text
                  style:(nonnull YMKTextStyle *)style;
```

Sets the text with the given style for the placemark

```objectivec
- (void)setTextStyleWithStyle:(nonnull YMKTextStyle *)style;
```

Changes the text style

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKPoint *geometry;
```

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float direction;
```

Angle between the direction of an object and the direction to north

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float opacity;
```

Opacity multiplicator for the placemark content

```objectivec
@property (nonatomic, readonly, nonnull) YMKPlacemarkText *text;
```

PlacemarkText can be used to set text and its style for the placemark

## Instance methods

### setIconWithImage:

```objectivec
- (void)setIconWithImage:(nonnull UIImage *)image;
```

Sets an icon with the default style for the placemark. Switches off and resets model/composite icon/animation/view.

### setIconWithImage:style:

```objectivec
- (void)setIconWithImage:(nonnull UIImage *)image
                   style:(nonnull YMKIconStyle *)style;
```

Sets an icon with the given style for the placemark. Switches off and resets model/composite icon/animation/view.

### setIconWithImage:callback:

```objectivec
- (void)setIconWithImage:(nonnull UIImage *)image
                callback:(nonnull YMKCallback)callback;
```

Sets an icon with the default style for the placemark. Switches off and resets model/composite icon/animation/view. The callback is called immediately after the image finished loading. This means you can, for example, change the placemark visibility with a new icon.

| Parameters |   |
| --- | --- |
| onFinished | Called when the icon is loaded. |

### setIconWithImage:style:callback:

```objectivec
- (void)setIconWithImage:(nonnull UIImage *)image
                   style:(nonnull YMKIconStyle *)style
                callback:(nonnull YMKCallback)callback;
```

Sets an icon with the given style for the placemark. Switches off and resets model/composite icon/animation/view. The callback is called immediately after the image finished loading. This means you can, for example, change the placemark visibility with a new icon.

| Parameters |   |
| --- | --- |
| onFinished | Called when the icon is loaded. |

### setIconStyleWithStyle:

```objectivec
- (void)setIconStyleWithStyle:(nonnull YMKIconStyle *)style;
```

Changes the icon style. Valid only for the single icon, the view and the animated icon.

### useIcon

```objectivec
- (nonnull YMKIcon *)useIcon;
```

Returns Icon object that can be used to set image or view and its style for the placemark. Switches off and resets composite icon/model/animation/view.

### useCompositeIcon

```objectivec
- (nonnull YMKCompositeIcon *)useCompositeIcon;
```

Returns CompositeIcon object that can be used to set icons and their styles for the placemark. Switches off and resets icon/model/animation/view.

### useModel

```objectivec
- (nonnull YMKModel *)useModel;
```

Returns Model object that can be used to set model and its style for the placemark. Switches off and resets icon/composite icon/animation/view.

### useAnimation

```objectivec
- (nonnull YMKPlacemarkAnimation *)useAnimation;
```

Returns PlacemarkAnimation object that can be used to control animation of the placemark. Switches off and resets icon/composite icon/model/view.

### setViewWithView:

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view;
```

Sets the view with the default style for the placemark. Switches off and resets icon/composite icon/animation/model.

### setViewWithView:style:

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view
                  style:(nonnull YMKIconStyle *)style;
```

Sets the view with the given style for the placemark. Switches off and resets icon/composite icon/animation/view.

### setViewWithView:callback:

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view
               callback:(nonnull YMKCallback)callback;
```

Sets the view with the default style for the placemark. Switches off and resets icon/composite icon/animation/view. The callback will be called immediately after the view finished loading.

| Parameters |   |
| --- | --- |
| onFinished | Called when the icon is loaded. |

### setViewWithView:style:callback:

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view
                  style:(nonnull YMKIconStyle *)style
               callback:(nonnull YMKCallback)callback;
```

Sets the view with the given style for the placemark. Switches off and resets icon/composite icon/animation/view. The callback will be called immediately after the view finished loading.

| Parameters |   |
| --- | --- |
| onFinished | Called when the icon is loaded. |

### setScaleFunctionWithPoints:

```objectivec
- (void)setScaleFunctionWithPoints:(nonnull NSArray<NSValue *> *)points;
```

Sets piecewise linear scale, depending on the zoom. The 'points' must be sorted by x; x coordinates must be unique. If zoom < minZoom(points) or zoom > maxZoom(points), it is set within the defined bounds before applying the function. By default, the scale function is defined by a single point (1, 1). If points is null or points.empty(), it resets the function to the default. If points.size() == 1, the scale is constant and equals point.y.

### setTextWithText:

```objectivec
- (void)setTextWithText:(nonnull NSString *)text;
```

Sets the text for the placemark, current text style is used

| Parameters |   |
| --- | --- |
| text | is a string in UTF-8 encoding |

### setTextWithText:style:

```objectivec
- (void)setTextWithText:(nonnull NSString *)text
                  style:(nonnull YMKTextStyle *)style;
```

Sets the text with the given style for the placemark

| Parameters |   |
| --- | --- |
| text | is a string in UTF-8 encoding |

### setTextStyleWithStyle:

```objectivec
- (void)setTextStyleWithStyle:(nonnull YMKTextStyle *)style;
```

Changes the text style.

## Properties

### geometry

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKPoint *geometry;
```

### direction

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float direction;
```

Angle between the direction of an object and the direction to north. Measured in degrees. Default: 0.f.

### opacity

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float opacity;
```

Opacity multiplicator for the placemark content. Values below 0 will be set to 0. Default: 1.

### text

```objectivec
@property (nonatomic, readonly, nonnull) YMKPlacemarkText *text;
```

PlacemarkText can be used to set text and its style for the placemark. It's optional parameter and can be used in addition to placemark objects
