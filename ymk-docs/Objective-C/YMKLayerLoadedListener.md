---
title: "YMKLayerLoadedListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKLayerLoadedListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLayerLoadedListener.html"
---
# YMKLayerLoadedListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLayerLoadedListener.html)

```objectivec
@protocol YMKLayerLoadedListener <NSObject>
```

Allows user to be notified when the layer has finished loading. This occurs after all tiles required to render the layer have been fetched, and are ready to be rendered. This event will not fire if the layer never loads due to connectivity issues, or if the layer is continuously changing and never completes loading due to the user constantly interacting with the map.

## Summary

### Instance methods

```objectivec
- (void)onLayerLoaded;
```

Called after the layer has finished loading all visible tiles

## Instance methods

### onLayerLoaded

```objectivec
- (void)onLayerLoaded;
```

Called after the layer has finished loading all visible tiles. This will only be called once. You must set another listener if you want to be notified again.
