---
title: "YMKPlacemarkAnimation"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPlacemarkAnimation"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlacemarkAnimation.html"
---
# YMKPlacemarkAnimation

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlacemarkAnimation.html)

```objectivec
@interface YMKPlacemarkAnimation : YMKPlacemarkPresentation
```

Provides an interface to load and control animation of placemark.

## Summary

### Instance methods

```objectivec
- (void)setIconWithImage:(nonnull id<YRTAnimatedImageProvider>)image
                   style:(nonnull YMKIconStyle *)style;
```

Sets the animated image and icon style

```objectivec
- (void)setIconWithImage:(nonnull id<YRTAnimatedImageProvider>)image
                   style:(nonnull YMKIconStyle *)style
                callback:(nonnull YMKCallback)callback;
```

Sets the animated image and icon style

```objectivec
- (void)setIconStyleWithStyle:(nonnull YMKIconStyle *)style;
```

Changes the icon style

```objectivec
- (void)play;
```

Starts animation

```objectivec
- (void)playWithCallback:(nonnull YMKCallback)callback;
```

Starts animation and handles the callback

```objectivec
- (void)resume;
```

Resumes paused animation

```objectivec
- (void)stop;
```

Stops animation

```objectivec
- (void)pause;
```

Pauses animation

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isReversed)
    BOOL reversed;
```

If true, animation will be played in the reverse direction

## Instance methods

### setIconWithImage:style:

```objectivec
- (void)setIconWithImage:(nonnull id<YRTAnimatedImageProvider>)image
                   style:(nonnull YMKIconStyle *)style;
```

Sets the animated image and icon style. The new animation will be in the paused state.

### setIconWithImage:style:callback:

```objectivec
- (void)setIconWithImage:(nonnull id<YRTAnimatedImageProvider>)image
                   style:(nonnull YMKIconStyle *)style
                callback:(nonnull YMKCallback)callback;
```

Sets the animated image and icon style. The new animation will be in the paused state.

| Parameters |   |
| --- | --- |
| onFinished | is called when the icon is loaded. |

### setIconStyleWithStyle:

```objectivec
- (void)setIconStyleWithStyle:(nonnull YMKIconStyle *)style;
```

Changes the icon style.

### play

```objectivec
- (void)play;
```

Starts animation. Removes the current play callback. Same as play(null).

### playWithCallback:

```objectivec
- (void)playWithCallback:(nonnull YMKCallback)callback;
```

Starts animation and handles the callback.

| Parameters |   |
| --- | --- |
| onFinished | is called when animation finishes and replaces the previous callback. |

### resume

```objectivec
- (void)resume;
```

Resumes paused animation. Callback (if any) is NOT removed.

### stop

```objectivec
- (void)stop;
```

Stops animation. Animation returns to the initial paused state.

### pause

```objectivec
- (void)pause;
```

Pauses animation.

## Properties

### reversed

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isReversed)
    BOOL reversed;
```

If true, animation will be played in the reverse direction. Default value is false.
