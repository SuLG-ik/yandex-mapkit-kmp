---
title: "DeleteAllPersonalSuggestSession"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / DeleteAllPersonalSuggestSession"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/DeleteAllPersonalSuggestSession.html"
---
# DeleteAllPersonalSuggestSession

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/DeleteAllPersonalSuggestSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

`interface DeleteAllPersonalSuggestSession`

Interface to handle remove all user personalized suggest request.

Allows request cancellation and retry.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `cancel()`<br>Cancels the current request. |
| `void` | `retry(@NonNull PersonalSuggestListener personalSuggestListener)`<br>Retries the last request. |

## Methods

### cancel

```java
void cancel()
```

Cancels the current request.

### retry

```java
void retry(@NonNull PersonalSuggestListener personalSuggestListener)
```

Retries the last request.

If there is an active request, it is cancelled.

| Parameters |   |
| --- | --- |
| `personalSuggestListener` | Listener to handle result. |
