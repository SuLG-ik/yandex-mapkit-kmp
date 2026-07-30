---
title: "YMKRoadEventsEventTag"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKRoadEventsEventTag"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsEventTag.html"
---
# YMKRoadEventsEventTag

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsEventTag.html)

```swift
enum YMKRoadEventsEventTag : UInt, @unchecked Sendable
```

## Summary

### Enum cases

```swift
case other = 0
```

```swift
case feedback = 1
```

```swift
case chat = 2
```

```swift
case localChat = 3
```

Same as Chat but limited by distance that you can see it from

```swift
case drawbridge = 4
```

Temporary issues

```swift
case closed = 5
```

```swift
case reconstruction = 6
```

```swift
case accident = 7
```

```swift
case danger = 8
```

Potentially dangerous zones

```swift
case school = 9
```

```swift
case overtakingDanger = 10
```

```swift
case pedestrianDanger = 11
```

```swift
case crossRoadDanger = 12
```

```swift
case police = 13
```

Generalizing tag that has any traffic code control event

```swift
case laneControl = 14
```

Traffic code control tags

```swift
case roadMarkingControl = 15
```

```swift
case crossRoadControl = 16
```

```swift
case noStoppingControl = 17
```

```swift
case mobileControl = 18
```

```swift
case speedControl = 19
```

```swift
case trafficControl = 20
```

```swift
case policePatrol = 21
```

## Enum cases

### other

```swift
case other = 0
```

### feedback

```swift
case feedback = 1
```

### chat

```swift
case chat = 2
```

### localChat

```swift
case localChat = 3
```

Same as Chat but limited by distance that you can see it from

### drawbridge

```swift
case drawbridge = 4
```

Temporary issues

### closed

```swift
case closed = 5
```

### reconstruction

```swift
case reconstruction = 6
```

### accident

```swift
case accident = 7
```

### danger

```swift
case danger = 8
```

Potentially dangerous zones

### school

```swift
case school = 9
```

### overtakingDanger

```swift
case overtakingDanger = 10
```

### pedestrianDanger

```swift
case pedestrianDanger = 11
```

### crossRoadDanger

```swift
case crossRoadDanger = 12
```

### police

```swift
case police = 13
```

Generalizing tag that has any traffic code control event. In old clients all new events fallback to this tag

### laneControl

```swift
case laneControl = 14
```

Traffic code control tags

### roadMarkingControl

```swift
case roadMarkingControl = 15
```

### crossRoadControl

```swift
case crossRoadControl = 16
```

### noStoppingControl

```swift
case noStoppingControl = 17
```

### mobileControl

```swift
case mobileControl = 18
```

### speedControl

```swift
case speedControl = 19
```

### trafficControl

```swift
case trafficControl = 20
```

### policePatrol

```swift
case policePatrol = 21
```
