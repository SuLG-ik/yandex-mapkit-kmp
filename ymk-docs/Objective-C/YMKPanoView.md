---
title: "YMKPanoView"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoView"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoView.html"
---
# YMKPanoView

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoView.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoView : UIView
```

## Summary

### Instance methods

```objectivec
- (id)initWithCoder:(NSCoder *)aDecoder;
```

```objectivec
- (id)initWithFrame:(CGRect)frame vulkanPreferred:(bool)vulkanPreferred;
```

```objectivec
- (id)initWithFrame:(CGRect)frame scaleFactor:(float)scaleFactor vulkanPreferred:(bool)vulkanPreferred;
```

```objectivec
- (id)initWithFrame:(CGRect)frame
    vulkanPreferred:(bool)vulkanPreferred
  lifecycleProvider:(id<YRTLifecycleProvider>)lifecycleProvider;
```

```objectivec
- (id)initWithFrame:(CGRect)frame
        scaleFactor:(float)scaleFactor
    vulkanPreferred:(bool)vulkanPreferred
  lifecycleProvider:(id<YRTLifecycleProvider>)lifecycleProvider;
```

```objectivec
- (void)setNoninteractive:(bool)is;
```

### Properties

```objectivec
@property (strong, nonatomic, readonly) YMKPanoramaPlayer *player
```

## Instance methods

### initWithCoder:

```objectivec
- (id)initWithCoder:(NSCoder *)aDecoder;
```

### initWithFrame:vulkanPreferred:

```objectivec
- (id)initWithFrame:(CGRect)frame vulkanPreferred:(bool)vulkanPreferred;
```

### initWithFrame:scaleFactor:vulkanPreferred:

```objectivec
- (id)initWithFrame:(CGRect)frame scaleFactor:(float)scaleFactor vulkanPreferred:(bool)vulkanPreferred;
```

### initWithFrame:vulkanPreferred:lifecycleProvider:

```objectivec
- (id)initWithFrame:(CGRect)frame
    vulkanPreferred:(bool)vulkanPreferred
  lifecycleProvider:(id<YRTLifecycleProvider>)lifecycleProvider;
```

### initWithFrame:scaleFactor:vulkanPreferred:lifecycleProvider:

```objectivec
- (id)initWithFrame:(CGRect)frame
        scaleFactor:(float)scaleFactor
    vulkanPreferred:(bool)vulkanPreferred
  lifecycleProvider:(id<YRTLifecycleProvider>)lifecycleProvider;
```

### setNoninteractive:

```objectivec
- (void)setNoninteractive:(bool)is;
```

## Properties

### player

```objectivec
@property (strong, nonatomic, readonly) YMKPanoramaPlayer *player
```
