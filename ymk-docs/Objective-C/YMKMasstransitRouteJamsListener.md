---
title: "YMKMasstransitRouteJamsListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKMasstransitRouteJamsListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouteJamsListener.html"
---
# YMKMasstransitRouteJamsListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouteJamsListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKMasstransitRouteJamsListener <NSObject>
```

A listener to monitor changes to traffic jams on the route.

## Summary

### Instance methods

```objectivec
- (void)onJamsUpdatedWithRoute:(nonnull YMKMasstransitRoute *)route;
```

Triggered when traffic jams are updated

```objectivec
- (void)onJamsOutdatedWithRoute:(nonnull YMKMasstransitRoute *)route;
```

Triggered when traffic jams are outdated

## Instance methods

### onJamsUpdatedWithRoute:

```objectivec
- (void)onJamsUpdatedWithRoute:(nonnull YMKMasstransitRoute *)route;
```

Triggered when traffic jams are updated.

### onJamsOutdatedWithRoute:

```objectivec
- (void)onJamsOutdatedWithRoute:(nonnull YMKMasstransitRoute *)route;
```

Triggered when traffic jams are outdated.
