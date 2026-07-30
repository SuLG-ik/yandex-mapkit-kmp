---
title: "YMKAnnotatedEvents"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKAnnotatedEvents"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAnnotatedEvents.html"
---
# YMKAnnotatedEvents

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAnnotatedEvents.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
enum YMKAnnotatedEvents : NSUInteger {}
```

## Summary

### Enum cases

```objectivec
YMKAnnotatedEventsManoeuvres = 1
```

```objectivec
YMKAnnotatedEventsFasterAlternative = 1 << 1
```

```objectivec
YMKAnnotatedEventsRoadEvents = 1 << 2
```

```objectivec
YMKAnnotatedEventsTollRoadAhead = 1 << 3
```

```objectivec
YMKAnnotatedEventsSpeedLimitExceeded = 1 << 4
```

```objectivec
YMKAnnotatedEventsParkingRoutes = 1 << 5
```

```objectivec
YMKAnnotatedEventsStreets = 1 << 6
```

```objectivec
YMKAnnotatedEventsRouteStatus = 1 << 7
```

```objectivec
YMKAnnotatedEventsWayPoints = 1 << 8
```

```objectivec
YMKAnnotatedEventsSpeedBumps = 1 << 9
```

```objectivec
YMKAnnotatedEventsRailwayCrossings = 1 << 10
```

```objectivec
YMKAnnotatedEventsLanes = 1 << 11
```

```objectivec
YMKAnnotatedEventsRouteActions =
    YMKAnnotatedEventsManoeuvres | YMKAnnotatedEventsRouteStatus |
    YMKAnnotatedEventsWayPoints | YMKAnnotatedEventsLanes
```

```objectivec
YMKAnnotatedEventsEverything =
    YMKAnnotatedEventsManoeuvres | YMKAnnotatedEventsFasterAlternative |
    YMKAnnotatedEventsRoadEvents | YMKAnnotatedEventsTollRoadAhead |
    YMKAnnotatedEventsSpeedLimitExceeded | YMKAnnotatedEventsParkingRoutes |
    YMKAnnotatedEventsStreets | YMKAnnotatedEventsRouteStatus |
    YMKAnnotatedEventsWayPoints | YMKAnnotatedEventsSpeedBumps |
    YMKAnnotatedEventsRailwayCrossings | YMKAnnotatedEventsLanes
```

## Enum cases

### YMKAnnotatedEventsManoeuvres

```objectivec
YMKAnnotatedEventsManoeuvres = 1
```

### YMKAnnotatedEventsFasterAlternative

```objectivec
YMKAnnotatedEventsFasterAlternative = 1 << 1
```

### YMKAnnotatedEventsRoadEvents

```objectivec
YMKAnnotatedEventsRoadEvents = 1 << 2
```

### YMKAnnotatedEventsTollRoadAhead

```objectivec
YMKAnnotatedEventsTollRoadAhead = 1 << 3
```

### YMKAnnotatedEventsSpeedLimitExceeded

```objectivec
YMKAnnotatedEventsSpeedLimitExceeded = 1 << 4
```

### YMKAnnotatedEventsParkingRoutes

```objectivec
YMKAnnotatedEventsParkingRoutes = 1 << 5
```

### YMKAnnotatedEventsStreets

```objectivec
YMKAnnotatedEventsStreets = 1 << 6
```

### YMKAnnotatedEventsRouteStatus

```objectivec
YMKAnnotatedEventsRouteStatus = 1 << 7
```

### YMKAnnotatedEventsWayPoints

```objectivec
YMKAnnotatedEventsWayPoints = 1 << 8
```

### YMKAnnotatedEventsSpeedBumps

```objectivec
YMKAnnotatedEventsSpeedBumps = 1 << 9
```

### YMKAnnotatedEventsRailwayCrossings

```objectivec
YMKAnnotatedEventsRailwayCrossings = 1 << 10
```

### YMKAnnotatedEventsLanes

```objectivec
YMKAnnotatedEventsLanes = 1 << 11
```

### YMKAnnotatedEventsRouteActions

```objectivec
YMKAnnotatedEventsRouteActions =
    YMKAnnotatedEventsManoeuvres | YMKAnnotatedEventsRouteStatus |
    YMKAnnotatedEventsWayPoints | YMKAnnotatedEventsLanes
```

### YMKAnnotatedEventsEverything

```objectivec
YMKAnnotatedEventsEverything =
    YMKAnnotatedEventsManoeuvres | YMKAnnotatedEventsFasterAlternative |
    YMKAnnotatedEventsRoadEvents | YMKAnnotatedEventsTollRoadAhead |
    YMKAnnotatedEventsSpeedLimitExceeded | YMKAnnotatedEventsParkingRoutes |
    YMKAnnotatedEventsStreets | YMKAnnotatedEventsRouteStatus |
    YMKAnnotatedEventsWayPoints | YMKAnnotatedEventsSpeedBumps |
    YMKAnnotatedEventsRailwayCrossings | YMKAnnotatedEventsLanes
```
