---
title: "Logging"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.runtime.logging"
section: "Android / Справочник / com.yandex.runtime.logging / Logging"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/logging/Logging.html"
---
# Logging

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/logging/Logging.html)

**Package** com.yandex.runtime.logging

`interface Logging`

Interface for subscribing to and unsubscribing from log messages.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `subscribe(@NonNull LogListener logListener)`<br>Subscribes a listener to receive log messages. |
| `void` | `unsubscribe(@NonNull LogListener logListener)`<br>Unsubscribes a listener from receiving log messages. |
| `boolean` | `isValid()`<br>Tells if this **Logging** is valid or not. |

## Methods

### subscribe

```java
void subscribe(@NonNull LogListener logListener)
```

Subscribes a listener to receive log messages.

The class does not retain the object in the 'logListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `logListener` | The listener to subscribe. |

### unsubscribe

```java
void unsubscribe(@NonNull LogListener logListener)
```

Unsubscribes a listener from receiving log messages.

The class does not retain the object in the 'logListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `logListener` | The listener to unsubscribe. |

### isValid

```java
boolean isValid()
```

Tells if this **Logging** is valid or not.

Any other method (except for this one) called on an invalid **Logging** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
