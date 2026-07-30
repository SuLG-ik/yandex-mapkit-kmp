---
title: "YMKUserLocationObjectListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKUserLocationObjectListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKUserLocationObjectListener.html"
---
# YMKUserLocationObjectListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKUserLocationObjectListener.html)

```objectivec
@protocol YMKUserLocationObjectListener <NSObject>
```

User location events object listener. Use it to customize the user location view. Although some callbacks are unused, the generic structure of the interface is suitable for object layer listeners.

## Summary

### Instance methods

```objectivec
- (void)onObjectAddedWithView:(nonnull YMKUserLocationView *)view;
```

Called when the layer object is added

```objectivec
- (void)onObjectRemovedWithView:(nonnull YMKUserLocationView *)view;
```

Called when the layer object is being removed

```objectivec
- (void)onObjectUpdatedWithView:(nonnull YMKUserLocationView *)view
                          event:(nonnull YMKObjectEvent *)event;
```

Called when the layer object is being updated

## Instance methods

### onObjectAddedWithView:

```objectivec
- (void)onObjectAddedWithView:(nonnull YMKUserLocationView *)view;
```

Called when the layer object is added. It is called once when the user location icon appears the first time.

### onObjectRemovedWithView:

```objectivec
- (void)onObjectRemovedWithView:(nonnull YMKUserLocationView *)view;
```

Called when the layer object is being removed. It is never called for the user location icon.

### onObjectUpdatedWithView:event:

```objectivec
- (void)onObjectUpdatedWithView:(nonnull YMKUserLocationView *)view
                          event:(nonnull YMKObjectEvent *)event;
```

Called when the layer object is being updated. The 'event' parameter can be one of the derived types.
