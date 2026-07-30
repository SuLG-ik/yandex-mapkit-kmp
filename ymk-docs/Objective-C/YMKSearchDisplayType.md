---
title: "YMKSearchDisplayType"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKSearchDisplayType"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchDisplayType.html"
---
# YMKSearchDisplayType

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchDisplayType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
enum YMKSearchDisplayType : NSUInteger {}
```

Result display type.

## Summary

### Enum cases

```objectivec
YMKSearchDisplayTypeSingle
```

Each result makes sense without the others (that is toponyms), they probably shouldn'be displayed as a group, and probably there's no need to make additional requests after user moves the map or zooms in or out

```objectivec
YMKSearchDisplayTypeMultiple
```

Results are meaningful as a group (that is category query), they should be displayed all together, and it makes sense to send additional requests after user changes visible map region

## Enum cases

### YMKSearchDisplayTypeSingle

```objectivec
YMKSearchDisplayTypeSingle
```

Each result makes sense without the others (that is toponyms), they probably shouldn'be displayed as a group, and probably there's no need to make additional requests after user moves the map or zooms in or out.

### YMKSearchDisplayTypeMultiple

```objectivec
YMKSearchDisplayTypeMultiple
```

Results are meaningful as a group (that is category query), they should be displayed all together, and it makes sense to send additional requests after user changes visible map region.
