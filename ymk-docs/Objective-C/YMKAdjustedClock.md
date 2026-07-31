---
title: "YMKAdjustedClock"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKAdjustedClock"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAdjustedClock.html"
---
# YMKAdjustedClock

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAdjustedClock.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKAdjustedClock : NSObject
```

## Summary

### Instance methods

```objectivec
- (nonnull NSDate *)now;
```

This method returns the time that has been synchronized with Yandex servers

```objectivec
- (void)resume;
```

Notifies AdjustedClock when the application resumes the foreground state

```objectivec
- (void)pause;
```

Notifies AdjustedClock when the application pauses and goes to the background

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### now

```objectivec
- (nonnull NSDate *)now;
```

This method returns the time that has been synchronized with Yandex servers. Use it if you don't trust the time on the local device because the user could have set it incorrectly. If time synchronization has failed or not yet finished, the returned value equals the local device's time.

**Returns**

POSIX time. For more information, see

https://en.wikipedia.org/wiki/Unix_time.

### resume

```objectivec
- (void)resume;
```

Notifies AdjustedClock when the application resumes the foreground state.

### pause

```objectivec
- (void)pause;
```

Notifies AdjustedClock when the application pauses and goes to the background.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
