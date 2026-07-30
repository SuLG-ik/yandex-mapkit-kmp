---
title: "YRTAnimatedImage"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTAnimatedImage"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTAnimatedImage.html"
---
# YRTAnimatedImage

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTAnimatedImage.html)

```objectivec
@interface YRTAnimatedImage : NSObject
```

## Summary

### Instance methods

```objectivec
- (id)initWithLoopCount:(int)loopCount;
```

```objectivec
- (id)initWithLoopCount:(int)loopCount frames:(NSArray*)frames;
```

```objectivec
- (void)addFrameWithImage:(UIImage*)image duration:(NSTimeInterval)duration;
```

```objectivec
- (int)loopCount;
```

```objectivec
- (NSArray*)frames;
```

## Instance methods

### initWithLoopCount:

```objectivec
- (id)initWithLoopCount:(int)loopCount;
```

### initWithLoopCount:frames:

```objectivec
- (id)initWithLoopCount:(int)loopCount frames:(NSArray*)frames;
```

### addFrameWithImage:duration:

```objectivec
- (void)addFrameWithImage:(UIImage*)image duration:(NSTimeInterval)duration;
```

### loopCount

```objectivec
- (int)loopCount;
```

### frames

```objectivec
- (NSArray*)frames;
```
