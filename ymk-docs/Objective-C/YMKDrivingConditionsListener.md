---
title: "YMKDrivingConditionsListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKDrivingConditionsListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingConditionsListener.html"
---
# YMKDrivingConditionsListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingConditionsListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKDrivingConditionsListener <NSObject>
```

A listener to monitor route condition changes.

## Summary

### Instance methods

```objectivec
- (void)onConditionsUpdated;
```

Triggers when the conditions are updated

```objectivec
- (void)onConditionsOutdated;
```

Triggers when the conditions are outdated

## Instance methods

### onConditionsUpdated

```objectivec
- (void)onConditionsUpdated;
```

Triggers when the conditions are updated.

### onConditionsOutdated

```objectivec
- (void)onConditionsOutdated;
```

Triggers when the conditions are outdated.
