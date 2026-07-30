---
title: "YMKNavigationWindshield"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigationWindshield"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationWindshield.html"
---
# YMKNavigationWindshield

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationWindshield.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigationWindshield : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)addListenerWithWindshieldListener:
    (nonnull id<YMKNavigationWindshieldListener>)windshieldListener;
```

The class does not retain the object in the 'windshieldListener' parameter

```objectivec
- (void)removeListenerWithWindshieldListener:
    (nonnull id<YMKNavigationWindshieldListener>)windshieldListener;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKNavigationUpcomingManoeuvre *> *manoeuvres;
```

Vector with next manoeuvres

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKNavigationUpcomingRoadEvent *> *roadEvents;
```

Vector with all road events between current position and the next manoeuvre

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKNavigationUpcomingLaneSign *> *laneSigns;
```

Vector with all lane signs between current position and the last manoeuvre from the manoeuvres vector

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKNavigationUpcomingDirectionSign *> *directionSigns;
```

Vector with all direction signs between current position and the last manoeuvre from the manoeuvres vector

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### addListenerWithWindshieldListener:

```objectivec
- (void)addListenerWithWindshieldListener:
    (nonnull id<YMKNavigationWindshieldListener>)windshieldListener;
```

The class does not retain the object in the 'windshieldListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListenerWithWindshieldListener:

```objectivec
- (void)removeListenerWithWindshieldListener:
    (nonnull id<YMKNavigationWindshieldListener>)windshieldListener;
```

## Properties

### manoeuvres

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKNavigationUpcomingManoeuvre *> *manoeuvres;
```

Vector with next manoeuvres. Contains several items only if they are close to each other.

### roadEvents

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKNavigationUpcomingRoadEvent *> *roadEvents;
```

Vector with all road events between current position and the next manoeuvre. Sorted by distance.

### laneSigns

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKNavigationUpcomingLaneSign *> *laneSigns;
```

Vector with all lane signs between current position and the last manoeuvre from the manoeuvres vector. Sorted by distance.

### directionSigns

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKNavigationUpcomingDirectionSign *> *directionSigns;
```

Vector with all direction signs between current position and the last manoeuvre from the manoeuvres vector. Sorted by distance.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
