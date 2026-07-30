---
title: "AdjustedClock"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.time"
section: "Android / Справочник / com.yandex.mapkit.transport.time / AdjustedClock"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/time/AdjustedClock.html"
---
# AdjustedClock

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/time/AdjustedClock.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.time

`interface AdjustedClock`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `long` | `now()`<br>This method returns the time that has been synchronized with Yandex servers. |
| `void` | `resume()`<br>Notifies AdjustedClock when the application resumes the foreground state. |
| `void` | `pause()`<br>Notifies AdjustedClock when the application pauses and goes to the background. |
| `boolean` | `isValid()`<br>Tells if this **AdjustedClock** is valid or not. |

## Methods

### now

```java
long now()
```

This method returns the time that has been synchronized with Yandex servers.

Use it if you don't trust the time on the local device because the user could have set it incorrectly. If time synchronization has failed or not yet finished, the returned value equals the local device's time.

**Returns**

POSIX time. For more information, see https://en.wikipedia.org/wiki/Unix_time.

### resume

```java
void resume()
```

Notifies AdjustedClock when the application resumes the foreground state.

### pause

```java
void pause()
```

Notifies AdjustedClock when the application pauses and goes to the background.

### isValid

```java
boolean isValid()
```

Tells if this **AdjustedClock** is valid or not.

Any other method (except for this one) called on an invalid **AdjustedClock** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
