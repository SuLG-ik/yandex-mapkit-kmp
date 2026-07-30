---
title: "YMKLocationManager"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLocationManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationManager.html"
---
# YMKLocationManager

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationManager.html)

```objectivec
@interface YMKLocationManager : NSObject
```

Handles location updates and changes.

## Summary

### Instance methods

```objectivec
- (void)subscribeForLocationUpdatesWithSubscriptionSettings:
            (nonnull YMKLocationSubscriptionSettings *)subscriptionSettings
                                           locationListener:
                                               (nonnull id<YMKLocationDelegate>)
                                                   locationListener;
```

Subscribe for location update events

```objectivec
- (void)requestSingleUpdateWithLocationListener:
    (nonnull id<YMKLocationDelegate>)locationListener;
```

Subscribe to a single location update

```objectivec
- (void)unsubscribeWithLocationListener:
    (nonnull id<YMKLocationDelegate>)locationListener;
```

Unsubscribe from location update events

```objectivec
- (void)suspend;
```

Stops updates for all subscriptions until resume() is called

```objectivec
- (void)resume;
```

Resumes updates stopped by a suspend() call

## Instance methods

### subscribeForLocationUpdatesWithSubscriptionSettings:locationListener:

```objectivec
- (void)subscribeForLocationUpdatesWithSubscriptionSettings:
            (nonnull YMKLocationSubscriptionSettings *)subscriptionSettings
                                           locationListener:
                                               (nonnull id<YMKLocationDelegate>)
                                                   locationListener;
```

Subscribe for location update events. If the listener was already subscribed to updates from the LocationManager, subscription settings will be updated.

The class does not retain the object in the 'locationListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| subscriptionSettings | Subscription settings. |
| locationListener | Location update listener. |

### requestSingleUpdateWithLocationListener:

```objectivec
- (void)requestSingleUpdateWithLocationListener:
    (nonnull id<YMKLocationDelegate>)locationListener;
```

Subscribe to a single location update. If the listener was already subscribed to location updates, the previous subscription will be removed.

The class does not retain the object in the 'locationListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| locationListener | Location update listener. |

### unsubscribeWithLocationListener:

```objectivec
- (void)unsubscribeWithLocationListener:
    (nonnull id<YMKLocationDelegate>)locationListener;
```

Unsubscribe from location update events. Can be called for either YMKLocationManager::subscribeForLocationUpdatesWithSubscriptionSettings:locationListener: or YMKLocationManager::requestSingleUpdateWithLocationListener:. For YMKLocationManager::requestSingleUpdateWithLocationListener:, if an event was already received, YMKLocationManager::unsubscribeWithLocationListener: does not have any effect. If the listener is already unsubscribed, the method call is ignored.

The class does not retain the object in the 'locationListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| locationListener | Listener passed to either YMKLocationManager::subscribeForLocationUpdatesWithSubscriptionSettings:locationListener: or YMKLocationManager::requestSingleUpdateWithLocationListener:. |

### suspend

```objectivec
- (void)suspend;
```

Stops updates for all subscriptions until resume() is called.

### resume

```objectivec
- (void)resume;
```

Resumes updates stopped by a suspend() call.
