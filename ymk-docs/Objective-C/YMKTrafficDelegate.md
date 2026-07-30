---
title: "YMKTrafficDelegate"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKTrafficDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTrafficDelegate.html"
---
# YMKTrafficDelegate

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTrafficDelegate.html)

```objectivec
@protocol YMKTrafficDelegate <NSObject>
```

Listener to handle traffic information.

## Summary

### Instance methods

```objectivec
- (void)onTrafficChangedWithTrafficLevel:
    (nullable YMKTrafficLevel *)trafficLevel;
```

Triggered when traffic level changes

```objectivec
- (void)onTrafficLoading;
```

Triggered when traffic information is loading

```objectivec
- (void)onTrafficExpired;
```

Triggered when traffic information expires

## Instance methods

### onTrafficChangedWithTrafficLevel:

```objectivec
- (void)onTrafficChangedWithTrafficLevel:
    (nullable YMKTrafficLevel *)trafficLevel;
```

Triggered when traffic level changes.

### onTrafficLoading

```objectivec
- (void)onTrafficLoading;
```

Triggered when traffic information is loading.

### onTrafficExpired

```objectivec
- (void)onTrafficExpired;
```

Triggered when traffic information expires.
