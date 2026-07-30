---
title: "YMKSearchSortOrigin"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKSearchSortOrigin"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSortOrigin.html"
---
# YMKSearchSortOrigin

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSortOrigin.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
enum YMKSearchSortOrigin : NSUInteger {}
```

Sort origin types when results are ordered by distance (see YMKSearchSortType).

## Summary

### Enum cases

```objectivec
YMKSearchSortOriginUser
```

Sort origin is a user position

```objectivec
YMKSearchSortOriginQuery
```

Sort origin is a toponym extracted from the user query

```objectivec
YMKSearchSortOriginRequest
```

Sort origin is directly specified by client

## Enum cases

### YMKSearchSortOriginUser

```objectivec
YMKSearchSortOriginUser
```

Sort origin is a user position. User position can be set via {link SearchOptions}.

### YMKSearchSortOriginQuery

```objectivec
YMKSearchSortOriginQuery
```

Sort origin is a toponym extracted from the user query. For example this type can be set for queries like "cafe near Central Park".

### YMKSearchSortOriginRequest

```objectivec
YMKSearchSortOriginRequest
```

Sort origin is directly specified by client. This type can be set for sessions with {link search.Session#setSortByDistance(const mapkit.geometry.Geometry)} called.
