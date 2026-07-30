---
title: "YMKAnnotatedRoadEvents"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKAnnotatedRoadEvents"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAnnotatedRoadEvents.html"
---
# YMKAnnotatedRoadEvents

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAnnotatedRoadEvents.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
enum YMKAnnotatedRoadEvents : NSUInteger {}
```

## Summary

### Enum cases

```objectivec
YMKAnnotatedRoadEventsDanger = 1
```

```objectivec
YMKAnnotatedRoadEventsReconstruction = 1 << 1
```

```objectivec
YMKAnnotatedRoadEventsAccident = 1 << 2
```

```objectivec
YMKAnnotatedRoadEventsSchool = 1 << 3
```

```objectivec
YMKAnnotatedRoadEventsOvertakingDanger = 1 << 4
```

```objectivec
YMKAnnotatedRoadEventsPedestrianDanger = 1 << 5
```

```objectivec
YMKAnnotatedRoadEventsCrossRoadDanger = 1 << 6
```

```objectivec
YMKAnnotatedRoadEventsLaneControl = 1 << 7
```

Traffic code control

```objectivec
YMKAnnotatedRoadEventsRoadMarkingControl = 1 << 8
```

```objectivec
YMKAnnotatedRoadEventsCrossRoadControl = 1 << 9
```

```objectivec
YMKAnnotatedRoadEventsMobileControl = 1 << 10
```

```objectivec
YMKAnnotatedRoadEventsSpeedLimitControl = 1 << 11
```

```objectivec
YMKAnnotatedRoadEventsTrafficControl = 1 << 12
```

```objectivec
YMKAnnotatedRoadEventsPolicePatrol = 1 << 13
```

```objectivec
YMKAnnotatedRoadEventsTrafficControls =
    YMKAnnotatedRoadEventsLaneControl |
    YMKAnnotatedRoadEventsRoadMarkingControl |
    YMKAnnotatedRoadEventsCrossRoadControl |
    YMKAnnotatedRoadEventsMobileControl |
    YMKAnnotatedRoadEventsSpeedLimitControl |
    YMKAnnotatedRoadEventsTrafficControl | YMKAnnotatedRoadEventsPolicePatrol
```

```objectivec
YMKAnnotatedRoadEventsEverything =
    YMKAnnotatedRoadEventsDanger | YMKAnnotatedRoadEventsReconstruction |
    YMKAnnotatedRoadEventsAccident | YMKAnnotatedRoadEventsSchool |
    YMKAnnotatedRoadEventsOvertakingDanger |
    YMKAnnotatedRoadEventsPedestrianDanger |
    YMKAnnotatedRoadEventsCrossRoadDanger |
    YMKAnnotatedRoadEventsTrafficControls
```

## Enum cases

### YMKAnnotatedRoadEventsDanger

```objectivec
YMKAnnotatedRoadEventsDanger = 1
```

### YMKAnnotatedRoadEventsReconstruction

```objectivec
YMKAnnotatedRoadEventsReconstruction = 1 << 1
```

### YMKAnnotatedRoadEventsAccident

```objectivec
YMKAnnotatedRoadEventsAccident = 1 << 2
```

### YMKAnnotatedRoadEventsSchool

```objectivec
YMKAnnotatedRoadEventsSchool = 1 << 3
```

### YMKAnnotatedRoadEventsOvertakingDanger

```objectivec
YMKAnnotatedRoadEventsOvertakingDanger = 1 << 4
```

### YMKAnnotatedRoadEventsPedestrianDanger

```objectivec
YMKAnnotatedRoadEventsPedestrianDanger = 1 << 5
```

### YMKAnnotatedRoadEventsCrossRoadDanger

```objectivec
YMKAnnotatedRoadEventsCrossRoadDanger = 1 << 6
```

### YMKAnnotatedRoadEventsLaneControl

```objectivec
YMKAnnotatedRoadEventsLaneControl = 1 << 7
```

Traffic code control

### YMKAnnotatedRoadEventsRoadMarkingControl

```objectivec
YMKAnnotatedRoadEventsRoadMarkingControl = 1 << 8
```

### YMKAnnotatedRoadEventsCrossRoadControl

```objectivec
YMKAnnotatedRoadEventsCrossRoadControl = 1 << 9
```

### YMKAnnotatedRoadEventsMobileControl

```objectivec
YMKAnnotatedRoadEventsMobileControl = 1 << 10
```

### YMKAnnotatedRoadEventsSpeedLimitControl

```objectivec
YMKAnnotatedRoadEventsSpeedLimitControl = 1 << 11
```

### YMKAnnotatedRoadEventsTrafficControl

```objectivec
YMKAnnotatedRoadEventsTrafficControl = 1 << 12
```

### YMKAnnotatedRoadEventsPolicePatrol

```objectivec
YMKAnnotatedRoadEventsPolicePatrol = 1 << 13
```

### YMKAnnotatedRoadEventsTrafficControls

```objectivec
YMKAnnotatedRoadEventsTrafficControls =
    YMKAnnotatedRoadEventsLaneControl |
    YMKAnnotatedRoadEventsRoadMarkingControl |
    YMKAnnotatedRoadEventsCrossRoadControl |
    YMKAnnotatedRoadEventsMobileControl |
    YMKAnnotatedRoadEventsSpeedLimitControl |
    YMKAnnotatedRoadEventsTrafficControl | YMKAnnotatedRoadEventsPolicePatrol
```

### YMKAnnotatedRoadEventsEverything

```objectivec
YMKAnnotatedRoadEventsEverything =
    YMKAnnotatedRoadEventsDanger | YMKAnnotatedRoadEventsReconstruction |
    YMKAnnotatedRoadEventsAccident | YMKAnnotatedRoadEventsSchool |
    YMKAnnotatedRoadEventsOvertakingDanger |
    YMKAnnotatedRoadEventsPedestrianDanger |
    YMKAnnotatedRoadEventsCrossRoadDanger |
    YMKAnnotatedRoadEventsTrafficControls
```
