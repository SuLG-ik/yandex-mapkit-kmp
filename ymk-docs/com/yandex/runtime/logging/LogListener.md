---
title: "LogListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.runtime.logging"
section: "Android / Справочник / com.yandex.runtime.logging / LogListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/logging/LogListener.html"
---
# LogListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/logging/LogListener.html)

**Package** com.yandex.runtime.logging

`interface LogListener`

Listener interface for receiving log messages.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onMessageReceived(@NonNull LogMessage message)`<br>Called when a new log message is received. |

## Methods

### onMessageReceived

```java
@UiThread
void onMessageReceived(@NonNull LogMessage message)
```

Called when a new log message is received.

| Parameters |   |
| --- | --- |
| `message` | The log message that was received. |
