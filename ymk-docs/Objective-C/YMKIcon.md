---
title: "YMKIcon"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKIcon"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKIcon.html"
---
# YMKIcon

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKIcon.html)

```objectivec
@interface YMKIcon : YMKPlacemarkPresentation
```

Provides an interface to set icon and its style for a placemark.

## Summary

### Instance methods

```objectivec
- (void)setImageWithImage:(nonnull UIImage *)image;
```

Sets the image for the icon

```objectivec
- (void)setImageWithImage:(nonnull UIImage *)image
                    style:(nullable YMKIconStyle *)style;
```

Sets the image for the icon

```objectivec
- (void)setImageWithImage:(nonnull UIImage *)image
                    style:(nullable YMKIconStyle *)style
                 callback:(nullable YMKCallback)callback;
```

Sets the image for the icon

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view;
```

Sets the view for the icon

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view
                  style:(nullable YMKIconStyle *)style;
```

Sets the view for the icon

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view
                  style:(nullable YMKIconStyle *)style
               callback:(nullable YMKCallback)callback;
```

Sets the view for the icon

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKIconStyle *style;
```

The style properties (scale, zIndex, etc

## Instance methods

### setImageWithImage:

```objectivec
- (void)setImageWithImage:(nonnull UIImage *)image;
```

Sets the image for the icon.

| Parameters |   |
| --- | --- |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setImageWithImage:style:

```objectivec
- (void)setImageWithImage:(nonnull UIImage *)image
                    style:(nullable YMKIconStyle *)style;
```

Sets the image for the icon.

| Parameters |   |
| --- | --- |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setImageWithImage:style:callback:

```objectivec
- (void)setImageWithImage:(nonnull UIImage *)image
                    style:(nullable YMKIconStyle *)style
                 callback:(nullable YMKCallback)callback;
```

Sets the image for the icon.

| Parameters |   |
| --- | --- |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setViewWithView:

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view;
```

Sets the view for the icon.

| Parameters |   |
| --- | --- |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setViewWithView:style:

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view
                  style:(nullable YMKIconStyle *)style;
```

Sets the view for the icon.

| Parameters |   |
| --- | --- |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setViewWithView:style:callback:

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view
                  style:(nullable YMKIconStyle *)style
               callback:(nullable YMKCallback)callback;
```

Sets the view for the icon.

| Parameters |   |
| --- | --- |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

## Properties

### style

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKIconStyle *style;
```

The style properties (scale, zIndex, etc.) of the icon placemark. Note: The current style cannot be modified directly - you must reset it to apply changes.
