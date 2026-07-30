---
title: "YMKPurpose"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKPurpose"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPurpose.html"
---
# YMKPurpose

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPurpose.html)

```objectivec
enum YMKPurpose : NSUInteger {}
```

## Summary

### Enum cases

```objectivec
YMKPurposeGeneral
```

This mode uses less resources and is the default

```objectivec
YMKPurposeAutomotiveNavigation
```

This mode is used to configure LocationManager for automotive navigation

```objectivec
YMKPurposePedestrianNavigation
```

This mode is used to configure LocationManager for pedestrian navigation

```objectivec
YMKPurposeBicycleNavigation
```

This mode is used to configure LocationManager for bicycle navigation

```objectivec
YMKPurposeScooterNavigation
```

This mode is used to configure LocationManager for scooter navigation

```objectivec
YMKPurposeStaticDisplayLocation
```

This mode is used to configure LocationManager for show current user location

## Enum cases

### YMKPurposeGeneral

```objectivec
YMKPurposeGeneral
```

This mode uses less resources and is the default.

### YMKPurposeAutomotiveNavigation

```objectivec
YMKPurposeAutomotiveNavigation
```

This mode is used to configure LocationManager for automotive navigation. Frequent location updates are desired even though more resources are used.

### YMKPurposePedestrianNavigation

```objectivec
YMKPurposePedestrianNavigation
```

This mode is used to configure LocationManager for pedestrian navigation. Frequent location updates are desired even though more resources are used.

### YMKPurposeBicycleNavigation

```objectivec
YMKPurposeBicycleNavigation
```

This mode is used to configure LocationManager for bicycle navigation. Frequent location updates are desired even though more resources are used.

### YMKPurposeScooterNavigation

```objectivec
YMKPurposeScooterNavigation
```

This mode is used to configure LocationManager for scooter navigation. Frequent location updates are desired even though more resources are used.

### YMKPurposeStaticDisplayLocation

```objectivec
YMKPurposeStaticDisplayLocation
```

This mode is used to configure LocationManager for show current user location. This mode uses less resources and as the default value, but this value turns on location reporting.
