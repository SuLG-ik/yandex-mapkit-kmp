---
title: "ConditionsListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / ConditionsListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ConditionsListener.html"
---
# ConditionsListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ConditionsListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

`interface ConditionsListener`

A listener to monitor route condition changes.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onConditionsUpdated()`<br>Triggers when the conditions are updated. |
| `void` | `onConditionsOutdated()`<br>Triggers when the conditions are outdated. |

## Methods

### onConditionsUpdated

```java
@UiThread
void onConditionsUpdated()
```

Triggers when the conditions are updated.

### onConditionsOutdated

```java
@UiThread
void onConditionsOutdated()
```

Triggers when the conditions are outdated.
