---
title: "YMKAnnotator"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKAnnotator"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAnnotator.html"
---
# YMKAnnotator

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAnnotator.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKAnnotator : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)setSpeakerWithSpeaker:(nullable id<YMKSpeaker>)speaker;
```

The class does not retain the object in the 'speaker' parameter

```objectivec
- (void)mute;
```

```objectivec
- (void)unmute;
```

```objectivec
- (void)addListenerWithAnnotatorListener:
    (nonnull id<YMKAnnotatorListener>)annotatorListener;
```

The class does not retain the object in the 'annotatorListener' parameter

```objectivec
- (void)removeListenerWithAnnotatorListener:
    (nonnull id<YMKAnnotatorListener>)annotatorListener;
```

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKAnnotatedEvents annotatedEvents;
```

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKAnnotatedRoadEvents annotatedRoadEvents;
```

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setSpeakerWithSpeaker:

```objectivec
- (void)setSpeakerWithSpeaker:(nullable id<YMKSpeaker>)speaker;
```

The class does not retain the object in the 'speaker' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### mute

```objectivec
- (void)mute;
```

### unmute

```objectivec
- (void)unmute;
```

### addListenerWithAnnotatorListener:

```objectivec
- (void)addListenerWithAnnotatorListener:
    (nonnull id<YMKAnnotatorListener>)annotatorListener;
```

The class does not retain the object in the 'annotatorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListenerWithAnnotatorListener:

```objectivec
- (void)removeListenerWithAnnotatorListener:
    (nonnull id<YMKAnnotatorListener>)annotatorListener;
```

## Properties

### annotatedEvents

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKAnnotatedEvents annotatedEvents;
```

### annotatedRoadEvents

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKAnnotatedRoadEvents annotatedRoadEvents;
```

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
