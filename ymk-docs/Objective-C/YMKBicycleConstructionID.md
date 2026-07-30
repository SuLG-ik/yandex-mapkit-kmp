---
title: "YMKBicycleConstructionID"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKBicycleConstructionID"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleConstructionID.html"
---
# YMKBicycleConstructionID

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleConstructionID.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
enum YMKBicycleConstructionID : NSUInteger {}
```

Construction types for the segments in the geometry.

## Summary

### Enum cases

```objectivec
YMKBicycleConstructionIDUnknown
```

Regular bicycle path segment or a segment without any additional information known

```objectivec
YMKBicycleConstructionIDBinding
```

Edge connecting the route endpoint to the bicycle route network

```objectivec
YMKBicycleConstructionIDStairsUp
```

Stairway with stairs going up along a path

```objectivec
YMKBicycleConstructionIDStairsDown
```

Stairway with stairs going down along a path

```objectivec
YMKBicycleConstructionIDStairsUnknown
```

Stairway with no information whether stairs go up or down along a path

```objectivec
YMKBicycleConstructionIDUnderpass
```

Underground crossing

```objectivec
YMKBicycleConstructionIDOverpass
```

Overground crossing

```objectivec
YMKBicycleConstructionIDCrossing
```

Crossing that is not an underground tunnel or a bridge

```objectivec
YMKBicycleConstructionIDTunnel
```

Tunnel that is not a crossing

## Enum cases

### YMKBicycleConstructionIDUnknown

```objectivec
YMKBicycleConstructionIDUnknown
```

Regular bicycle path segment or a segment without any additional information known.

### YMKBicycleConstructionIDBinding

```objectivec
YMKBicycleConstructionIDBinding
```

Edge connecting the route endpoint to the bicycle route network.

### YMKBicycleConstructionIDStairsUp

```objectivec
YMKBicycleConstructionIDStairsUp
```

Stairway with stairs going up along a path.

### YMKBicycleConstructionIDStairsDown

```objectivec
YMKBicycleConstructionIDStairsDown
```

Stairway with stairs going down along a path.

### YMKBicycleConstructionIDStairsUnknown

```objectivec
YMKBicycleConstructionIDStairsUnknown
```

Stairway with no information whether stairs go up or down along a path.

### YMKBicycleConstructionIDUnderpass

```objectivec
YMKBicycleConstructionIDUnderpass
```

Underground crossing.

### YMKBicycleConstructionIDOverpass

```objectivec
YMKBicycleConstructionIDOverpass
```

Overground crossing.

### YMKBicycleConstructionIDCrossing

```objectivec
YMKBicycleConstructionIDCrossing
```

Crossing that is not an underground tunnel or a bridge.

### YMKBicycleConstructionIDTunnel

```objectivec
YMKBicycleConstructionIDTunnel
```

Tunnel that is not a crossing.
