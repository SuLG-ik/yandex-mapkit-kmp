---
title: "YMKSearchLayerResponseHandler"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKSearchLayerResponseHandler"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchLayerResponseHandler.html"
---
# YMKSearchLayerResponseHandler

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchLayerResponseHandler.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKSearchLayerResponseHandler <NSObject>
```

Interface for callbacks on search events.

## Summary

### Instance methods

```objectivec
- (void)onSearchStartWithRequestType:(YMKSearchLayerRequestType)requestType;
```

Called when the search starts

```objectivec
- (void)onSearchSuccessWithRequestType:(YMKSearchLayerRequestType)requestType;
```

Called after a succesful search

```objectivec
- (void)onSearchErrorWithError:(nonnull NSError *)error
                   requestType:(YMKSearchLayerRequestType)requestType;
```

Called on any search error

```objectivec
- (void)onPresentedResultsUpdate;
```

Called when presented results are updated and thus search results list can change

```objectivec
- (void)onAllResultsClear;
```

Called before all results are cleared

## Instance methods

### onSearchStartWithRequestType:

```objectivec
- (void)onSearchStartWithRequestType:(YMKSearchLayerRequestType)requestType;
```

Called when the search starts.

| Parameters |   |
| --- | --- |
| requestType | Type of the started request. |

### onSearchSuccessWithRequestType:

```objectivec
- (void)onSearchSuccessWithRequestType:(YMKSearchLayerRequestType)requestType;
```

Called after a succesful search.

| Parameters |   |
| --- | --- |
| requestType | Type of the finished request. |

### onSearchErrorWithError:requestType:

```objectivec
- (void)onSearchErrorWithError:(nonnull NSError *)error
                   requestType:(YMKSearchLayerRequestType)requestType;
```

Called on any search error.

| Parameters |   |
| --- | --- |
| error | Error occured. |
| requestType | Type of the finished request. |

### onPresentedResultsUpdate

```objectivec
- (void)onPresentedResultsUpdate;
```

Called when presented results are updated and thus search results list can change.

### onAllResultsClear

```objectivec
- (void)onAllResultsClear;
```

Called before all results are cleared.
