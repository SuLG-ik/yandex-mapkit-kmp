---
title: "YMKIndoorStateListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKIndoorStateListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKIndoorStateListener.html"
---
# YMKIndoorStateListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKIndoorStateListener.html)

```objectivec
@protocol YMKIndoorStateListener <NSObject>
```

Allows to handle events related to Indoor state.

## Summary

### Instance methods

```objectivec
- (void)onActivePlanFocusedWithActivePlan:(nonnull YMKIndoorPlan *)activePlan;
```

Notifies when user view focuses on a new plan (plan is NonNull)

```objectivec
- (void)onActivePlanLeft;
```

Notifies when user view leaves focus on a current active plan

```objectivec
- (void)onActiveLevelChangedWithActiveLevelId:(nonnull NSString *)activeLevelId;
```

Notifies when the current active level is changed on the active plan

## Instance methods

### onActivePlanFocusedWithActivePlan:

```objectivec
- (void)onActivePlanFocusedWithActivePlan:(nonnull YMKIndoorPlan *)activePlan;
```

Notifies when user view focuses on a new plan (plan is NonNull).

| Parameters |   |
| --- | --- |
| activePlan | is valid until onActivePlanLeft call. |

### onActivePlanLeft

```objectivec
- (void)onActivePlanLeft;
```

Notifies when user view leaves focus on a current active plan.

### onActiveLevelChangedWithActiveLevelId:

```objectivec
- (void)onActiveLevelChangedWithActiveLevelId:(nonnull NSString *)activeLevelId;
```

Notifies when the current active level is changed on the active plan.
