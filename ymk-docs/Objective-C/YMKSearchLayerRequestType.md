---
title: "YMKSearchLayerRequestType"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKSearchLayerRequestType"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchLayerRequestType.html"
---
# YMKSearchLayerRequestType

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchLayerRequestType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
enum YMKSearchLayerRequestType : NSUInteger {}
```

Type of search layer's search requests.

## Summary

### Enum cases

```objectivec
YMKSearchLayerRequestTypeNewQuery
```

Primary request initiated via new query methods

```objectivec
YMKSearchLayerRequestTypeManualResubmit
```

Manual resubmit on search layer

```objectivec
YMKSearchLayerRequestTypeFetchNextPage
```

Request to fetch next page of results

```objectivec
YMKSearchLayerRequestTypeMapMoveByApp
```

Request was initiated by map moved via API call

```objectivec
YMKSearchLayerRequestTypeMapMoveByGesture
```

Request was initiated by map moved via user gesture

## Enum cases

### YMKSearchLayerRequestTypeNewQuery

```objectivec
YMKSearchLayerRequestTypeNewQuery
```

Primary request initiated via new query methods.

### YMKSearchLayerRequestTypeManualResubmit

```objectivec
YMKSearchLayerRequestTypeManualResubmit
```

Manual resubmit on search layer.

### YMKSearchLayerRequestTypeFetchNextPage

```objectivec
YMKSearchLayerRequestTypeFetchNextPage
```

Request to fetch next page of results.

### YMKSearchLayerRequestTypeMapMoveByApp

```objectivec
YMKSearchLayerRequestTypeMapMoveByApp
```

Request was initiated by map moved via API call.

### YMKSearchLayerRequestTypeMapMoveByGesture

```objectivec
YMKSearchLayerRequestTypeMapMoveByGesture
```

Request was initiated by map moved via user gesture.
