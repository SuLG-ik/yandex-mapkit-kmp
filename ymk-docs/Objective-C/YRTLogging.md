---
title: "YRTLogging"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTLogging"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTLogging.html"
---
# YRTLogging

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTLogging.html)

```objectivec
@interface YRTLogging : NSObject
```

Interface for subscribing to and unsubscribing from log messages.

## Summary

### Instance methods

```objectivec
- (void)subscribeWithLogListener:(nonnull id<YRTLogListener>)logListener;
```

Subscribes a listener to receive log messages

```objectivec
- (void)unsubscribeWithLogListener:(nonnull id<YRTLogListener>)logListener;
```

Unsubscribes a listener from receiving log messages

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### subscribeWithLogListener:

```objectivec
- (void)subscribeWithLogListener:(nonnull id<YRTLogListener>)logListener;
```

Subscribes a listener to receive log messages.

The class does not retain the object in the 'logListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| logListener | The listener to subscribe. |

### unsubscribeWithLogListener:

```objectivec
- (void)unsubscribeWithLogListener:(nonnull id<YRTLogListener>)logListener;
```

Unsubscribes a listener from receiving log messages.

The class does not retain the object in the 'logListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| logListener | The listener to unsubscribe. |

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
