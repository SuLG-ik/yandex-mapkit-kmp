---
title: "YMKLocationManager"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKLocationManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationManager.html"
---
# YMKLocationManager

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocationManager.html)

```swift
class YMKLocationManager : NSObject
```

Handles location updates and changes.

## Summary

### Instance methods

```swift
func subscribeForLocationUpdates(with subscriptionSettings: YMKLocationSubscriptionSettings,
                                          locationListener: any YMKLocationDelegate)
```

Subscribe for location update events

```swift
func requestSingleUpdate(withLocationListener locationListener: any YMKLocationDelegate)
```

Subscribe to a single location update

```swift
func unsubscribe(withLocationListener locationListener: any YMKLocationDelegate)
```

Unsubscribe from location update events

```swift
func suspend()
```

Stops updates for all subscriptions until resume() is called

```swift
func resume()
```

Resumes updates stopped by a suspend() call

## Instance methods

### subscribeForLocationUpdates(with:locationListener:)

```swift
func subscribeForLocationUpdates(with subscriptionSettings: YMKLocationSubscriptionSettings,
                                          locationListener: any YMKLocationDelegate)
```

Subscribe for location update events. If the listener was already subscribed to updates from the LocationManager, subscription settings will be updated.

The class does not retain the object in the 'locationListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| subscriptionSettings | Subscription settings. |
| locationListener | Location update listener. |

### requestSingleUpdate(withLocationListener:)

```swift
func requestSingleUpdate(withLocationListener locationListener: any YMKLocationDelegate)
```

Subscribe to a single location update. If the listener was already subscribed to location updates, the previous subscription will be removed.

The class does not retain the object in the 'locationListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| locationListener | Location update listener. |

### unsubscribe(withLocationListener:)

```swift
func unsubscribe(withLocationListener locationListener: any YMKLocationDelegate)
```

Unsubscribe from location update events. Can be called for either YMKLocationManager::subscribeForLocationUpdatesWithSubscriptionSettings:locationListener: or YMKLocationManager::requestSingleUpdateWithLocationListener:. For YMKLocationManager::requestSingleUpdateWithLocationListener:, if an event was already received, YMKLocationManager::unsubscribeWithLocationListener: does not have any effect. If the listener is already unsubscribed, the method call is ignored.

The class does not retain the object in the 'locationListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| locationListener | Listener passed to either YMKLocationManager::subscribeForLocationUpdatesWithSubscriptionSettings:locationListener: or YMKLocationManager::requestSingleUpdateWithLocationListener:. |

### suspend()

```swift
func suspend()
```

Stops updates for all subscriptions until resume() is called.

### resume()

```swift
func resume()
```

Resumes updates stopped by a suspend() call.
