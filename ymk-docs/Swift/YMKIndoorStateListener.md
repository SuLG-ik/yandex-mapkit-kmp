---
title: "YMKIndoorStateListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKIndoorStateListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKIndoorStateListener.html"
---
# YMKIndoorStateListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKIndoorStateListener.html)

```swift
protocol YMKIndoorStateListener : NSObjectProtocol
```

Allows to handle events related to Indoor state.

## Summary

### Instance methods

```swift
func onActivePlanFocused(withActivePlan activePlan: YMKIndoorPlan)
```

Notifies when user view focuses on a new plan (plan is NonNull)

```swift
func onActivePlanLeft()
```

Notifies when user view leaves focus on a current active plan

```swift
func onActiveLevelChanged(withActiveLevelId activeLevelId: String)
```

Notifies when the current active level is changed on the active plan

## Instance methods

### onActivePlanFocused(withActivePlan:)

```swift
func onActivePlanFocused(withActivePlan activePlan: YMKIndoorPlan)
```

Notifies when user view focuses on a new plan (plan is NonNull).

| Parameters |   |
| --- | --- |
| activePlan | is valid until onActivePlanLeft call. |

### onActivePlanLeft()

```swift
func onActivePlanLeft()
```

Notifies when user view leaves focus on a current active plan.

### onActiveLevelChanged(withActiveLevelId:)

```swift
func onActiveLevelChanged(withActiveLevelId activeLevelId: String)
```

Notifies when the current active level is changed on the active plan.
