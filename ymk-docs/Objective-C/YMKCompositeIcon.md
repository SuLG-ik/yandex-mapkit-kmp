---
title: "YMKCompositeIcon"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKCompositeIcon"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCompositeIcon.html"
---
# YMKCompositeIcon

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCompositeIcon.html)

```objectivec
@interface YMKCompositeIcon : YMKPlacemarkPresentation
```

Combines multiple icons into one.

## Summary

### Instance methods

```objectivec
- (void)setIconWithName:(nonnull NSString *)name image:(nonnull UIImage *)image;
```

Creates or resets a named layer with an icon and its style

```objectivec
- (void)setIconWithName:(nonnull NSString *)name
                  image:(nonnull UIImage *)image
                  style:(nullable YMKIconStyle *)style;
```

Creates or resets a named layer with an icon and its style

```objectivec
- (void)setIconWithName:(nonnull NSString *)name
                  image:(nonnull UIImage *)image
                  style:(nullable YMKIconStyle *)style
               callback:(nullable YMKCallback)callback;
```

Creates or resets a named layer with an icon and its style

```objectivec
- (void)setIconStyleWithName:(nonnull NSString *)name
                       style:(nonnull YMKIconStyle *)style;
```

Changes the icon style for a specific layer

```objectivec
- (nonnull YMKIcon *)iconWithName:(nonnull NSString *)name;
```

Returns named Icon object that can be used to set icon and its style

```objectivec
- (void)removeIconWithName:(nonnull NSString *)name;
```

Removes the named layer

```objectivec
- (void)removeAll;
```

Removes all layers

## Instance methods

### setIconWithName:image:

```objectivec
- (void)setIconWithName:(nonnull NSString *)name image:(nonnull UIImage *)image;
```

Creates or resets a named layer with an icon and its style.

| Parameters |   |
| --- | --- |
| name | Unique identifier of the icon layer. Used to create or update. |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setIconWithName:image:style:

```objectivec
- (void)setIconWithName:(nonnull NSString *)name
                  image:(nonnull UIImage *)image
                  style:(nullable YMKIconStyle *)style;
```

Creates or resets a named layer with an icon and its style.

| Parameters |   |
| --- | --- |
| name | Unique identifier of the icon layer. Used to create or update. |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setIconWithName:image:style:callback:

```objectivec
- (void)setIconWithName:(nonnull NSString *)name
                  image:(nonnull UIImage *)image
                  style:(nullable YMKIconStyle *)style
               callback:(nullable YMKCallback)callback;
```

Creates or resets a named layer with an icon and its style.

| Parameters |   |
| --- | --- |
| name | Unique identifier of the icon layer. Used to create or update. |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setIconStyleWithName:style:

```objectivec
- (void)setIconStyleWithName:(nonnull NSString *)name
                       style:(nonnull YMKIconStyle *)style;
```

Changes the icon style for a specific layer.

### iconWithName:

```objectivec
- (nonnull YMKIcon *)iconWithName:(nonnull NSString *)name;
```

Returns named Icon object that can be used to set icon and its style. Creates an empty Icon if it didn't exist.

### removeIconWithName:

```objectivec
- (void)removeIconWithName:(nonnull NSString *)name;
```

Removes the named layer.

### removeAll

```objectivec
- (void)removeAll;
```

Removes all layers.
