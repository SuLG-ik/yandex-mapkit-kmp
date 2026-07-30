---
title: "YMKOverlay"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKOverlay"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOverlay.html"
---
# YMKOverlay

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKOverlay.html)

```objectivec
@interface YMKOverlay : NSObject
```

Allows to render overlay on the screen.

## Summary

### Instance methods

```objectivec
- (void)setImageWithImage:(nonnull UIImage *)image
                     rect:(nonnull YMKScreenRect *)rect;
```

Sets image as content of overlay, resets view

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view
                   rect:(nonnull YMKScreenRect *)rect;
```

Sets view as content of overlay, resets image

```objectivec
- (void)remove;
```

Removes the overlay from the map

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setImageWithImage:rect:

```objectivec
- (void)setImageWithImage:(nonnull UIImage *)image
                     rect:(nonnull YMKScreenRect *)rect;
```

Sets image as content of overlay, resets view. Window origin (0, 0) - top left corner.

### setViewWithView:rect:

```objectivec
- (void)setViewWithView:(nonnull YRTViewProvider *)view
                   rect:(nonnull YMKScreenRect *)rect;
```

Sets view as content of overlay, resets image. Window origin (0, 0) - top left corner.

### remove

```objectivec
- (void)remove;
```

Removes the overlay from the map.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
