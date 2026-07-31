---
title: "CompanyTapListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / CompanyTapListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/CompanyTapListener.html"
---
# CompanyTapListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/CompanyTapListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`interface CompanyTapListener`

Listener to handle the taps on company text and icon.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onCompanyTap(@NonNull Player player, @NonNull CompanyTapInfo info)`<br>Called if the user tapped on company icon or text below it. |

## Methods

### onCompanyTap

```java
@UiThread
void onCompanyTap(@NonNull Player player,
                  @NonNull CompanyTapInfo info)
```

Called if the user tapped on company icon or text below it.

| Parameters |   |
| --- | --- |
| `player` | Panorama player that sent the event. |
| `info` | Information about tapped company. |
