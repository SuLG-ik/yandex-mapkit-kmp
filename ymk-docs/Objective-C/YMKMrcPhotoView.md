---
title: "YMKMrcPhotoView"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMrcPhotoView"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMrcPhotoView.html"
---
# YMKMrcPhotoView

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMrcPhotoView.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMrcPhotoView : UIView
```

## Summary

### Instance methods

```objectivec
- (id)initWithFrame:(CGRect)frame vulkanPreferred:(bool)vulkanPreferred;
```

```objectivec
- (id)initWithFrame:(CGRect)frame
    vulkanPreferred:(bool)vulkanPreferred
  lifecycleProvider:(id<YRTLifecycleProvider>)lifecycleProvider;
```

```objectivec
- (void)setNoninteractive:(bool)is;
```

### Properties

```objectivec
@property (strong, nonatomic, readonly) YMKMrcPhotoPlayer *player
```

## Instance methods

### initWithFrame:vulkanPreferred:

```objectivec
- (id)initWithFrame:(CGRect)frame vulkanPreferred:(bool)vulkanPreferred;
```

### initWithFrame:vulkanPreferred:lifecycleProvider:

```objectivec
- (id)initWithFrame:(CGRect)frame
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
@property (strong, nonatomic, readonly) YMKMrcPhotoPlayer *player
```
