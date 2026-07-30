---
title: "YMKTrafficLayer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTrafficLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTrafficLayer.html"
---
# YMKTrafficLayer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTrafficLayer.html)

```objectivec
@interface YMKTrafficLayer : NSObject
```

A layer with traffic information.

## Summary

### Instance methods

```objectivec
- (BOOL)isTrafficVisible;
```

Checks if traffic is visible

```objectivec
- (void)setTrafficVisibleWithOn:(BOOL)on;
```

Sets traffic visibility

```objectivec
- (BOOL)setTrafficStyleWithStyle:(nonnull NSString *)style;
```

Applies JSON style transformations to the traffic layer

```objectivec
- (BOOL)setTrafficStyleWithId:(NSInteger)id style:(nonnull NSString *)style;
```

Applies JSON style transformations to the traffic layer

```objectivec
- (void)resetTrafficStyles;
```

Resets all JSON style transformations applied to the traffic layer

```objectivec
- (void)addTrafficListenerWithTrafficListener:
    (nonnull id<YMKTrafficDelegate>)trafficListener;
```

Adds a traffic listener

```objectivec
- (void)removeTrafficListenerWithTrafficListener:
    (nonnull id<YMKTrafficDelegate>)trafficListener;
```

Removes a traffic listener

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### isTrafficVisible

```objectivec
- (BOOL)isTrafficVisible;
```

Checks if traffic is visible.

### setTrafficVisibleWithOn:

```objectivec
- (void)setTrafficVisibleWithOn:(BOOL)on;
```

Sets traffic visibility.

### setTrafficStyleWithStyle:

```objectivec
- (BOOL)setTrafficStyleWithStyle:(nonnull NSString *)style;
```

Applies JSON style transformations to the traffic layer. Same as setTrafficStyle(0, style). Set to empty string to clear previous styling. Returns true if the style was successfully parsed; false otherwise. If the return value is false, the current traffic style remains unchanged.

### setTrafficStyleWithId:style:

```objectivec
- (BOOL)setTrafficStyleWithId:(NSInteger)id style:(nonnull NSString *)style;
```

Applies JSON style transformations to the traffic layer. Replaces previous styling with the specified ID (if such exists). Stylings are applied in an ascending order. Set to empty string to clear previous styling with the specified ID. Returns true if the style was successfully parsed; false otherwise. If the return value is false, the current traffic style remains unchanged.

### resetTrafficStyles

```objectivec
- (void)resetTrafficStyles;
```

Resets all JSON style transformations applied to the traffic layer.

### addTrafficListenerWithTrafficListener:

```objectivec
- (void)addTrafficListenerWithTrafficListener:
    (nonnull id<YMKTrafficDelegate>)trafficListener;
```

Adds a traffic listener.

The class does not retain the object in the 'trafficListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeTrafficListenerWithTrafficListener:

```objectivec
- (void)removeTrafficListenerWithTrafficListener:
    (nonnull id<YMKTrafficDelegate>)trafficListener;
```

Removes a traffic listener.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
