---
title: "YMKMapView"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMapView"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapView.html"
---
# YMKMapView

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapView.html)

##@interface *[YMKMapView](YMKMapView.md)* : UIView

@property (nonatomic, readonly) *[YMKMapWindow](YMKMapWindow.md)* *mapWindow;

/// When YES, the underlying rendering surface will be non-opaque,

/// allowing views behind the map to show through transparent areas.

/// Must be set before the view is displayed. Default is NO.

@property (nonatomic, readonly) BOOL transparencySupport;

- (void)setNoninteractive:(bool)is;

- (id)initWithCoder:(NSCoder *)aDecoder;

- (id)initWithCoder:(NSCoder *)aDecoder transparencySupport:(BOOL)transparencySupport;

- (id)initWithFrame:(CGRect)frame;

- (id)initWithFrame:(CGRect)frame transparencySupport:(BOOL)transparencySupport;

/// :nodoc:

- (id)initWithFrame:(CGRect)frame vulkanPreferred:(BOOL)vulkanPreferred transparencySupport:(BOOL)transparencySupport;

/// :nodoc:

- (id)initWithFrame:(CGRect)frame

        scaleFactor:(float)scaleFactor

    vulkanPreferred:(BOOL)vulkanPreferred

  lifecycleProvider:(id<YRTLifecycleProvider>)lifecycleProvider

transparencySupport:(BOOL)transparencySupport;

/// :nodoc:

- (enum YRTGraphicsAPIType)getGraphicsAPI;

/// :nodoc:

- (void)handleTouchEvent:(YRTTouchEvent *)touchEvent;

@end##

## Summary

### Instance methods

```objectivec
- (void)setNoninteractive:(bool)is;
```

```objectivec
- (id)initWithCoder:(NSCoder *)aDecoder;
```

```objectivec
- (id)initWithCoder:(NSCoder *)aDecoder transparencySupport:(BOOL)transparencySupport;
```

```objectivec
- (id)initWithFrame:(CGRect)frame;
```

```objectivec
- (id)initWithFrame:(CGRect)frame transparencySupport:(BOOL)transparencySupport;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKMapWindow *mapWindow
```

```objectivec
@property (nonatomic, readonly) BOOL transparencySupport;
```

When YES, the underlying rendering surface will be non-opaque, allowing views behind the map to show through transparent areas

## Instance methods

### setNoninteractive:

```objectivec
- (void)setNoninteractive:(bool)is;
```

### initWithCoder:

```objectivec
- (id)initWithCoder:(NSCoder *)aDecoder;
```

### initWithCoder:transparencySupport:

```objectivec
- (id)initWithCoder:(NSCoder *)aDecoder transparencySupport:(BOOL)transparencySupport;
```

### initWithFrame:

```objectivec
- (id)initWithFrame:(CGRect)frame;
```

### initWithFrame:transparencySupport:

```objectivec
- (id)initWithFrame:(CGRect)frame transparencySupport:(BOOL)transparencySupport;
```

## Properties

### mapWindow

```objectivec
@property (nonatomic, readonly) YMKMapWindow *mapWindow
```

### transparencySupport

```objectivec
@property (nonatomic, readonly) BOOL transparencySupport;
```

When YES, the underlying rendering surface will be non-opaque, allowing views behind the map to show through transparent areas. Must be set before the view is displayed. Default is NO.
