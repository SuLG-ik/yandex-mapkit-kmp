---
title: "IndoorStateListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.indoor"
section: "Android / Справочник / com.yandex.mapkit.indoor / IndoorStateListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/indoor/IndoorStateListener.html"
---
# IndoorStateListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/indoor/IndoorStateListener.html)

**Package** com.yandex.mapkit.indoor

`interface IndoorStateListener`

Allows to handle events related to Indoor state.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onActivePlanFocused(@NonNull IndoorPlan activePlan)`<br>Notifies when user view focuses on a new plan (plan is NonNull). |
| `void` | `onActivePlanLeft()`<br>Notifies when user view leaves focus on a current active plan. |
| `void` | `onActiveLevelChanged(@NonNull java.lang.String activeLevelId)`<br>Notifies when the current active level is changed on the active plan. |

## Methods

### onActivePlanFocused

```java
@UiThread
void onActivePlanFocused(@NonNull IndoorPlan activePlan)
```

Notifies when user view focuses on a new plan (plan is NonNull).

| Parameters |   |
| --- | --- |
| `activePlan` | is valid until onActivePlanLeft call. |

### onActivePlanLeft

```java
@UiThread
void onActivePlanLeft()
```

Notifies when user view leaves focus on a current active plan.

### onActiveLevelChanged

```java
@UiThread
void onActiveLevelChanged(@NonNull java.lang.String activeLevelId)
```

Notifies when the current active level is changed on the active plan.
