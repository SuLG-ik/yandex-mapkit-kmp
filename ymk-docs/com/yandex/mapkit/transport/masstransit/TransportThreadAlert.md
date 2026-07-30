---
title: "TransportThreadAlert"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TransportThreadAlert"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportThreadAlert.html"
---
# TransportThreadAlert

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TransportThreadAlert.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.TransportThreadAlert

`class TransportThreadAlert implements Serializable`

TransportThreadAlert are important annotations for mass transit ride sections of routes.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [Closed](TransportThreadAlert_Closed.md) | Thread is not operational on that day. |
| `static` | [ClosedUntil](TransportThreadAlert_ClosedUntil.md) | Thread is not operational until specified time. |
| `static` | [LastTrip](TransportThreadAlert_LastTrip.md) | Last trip for the thread.<br>Allows to get the time it takes to get to the end of the route. |

## Summary

### Constructors

**Signature and Description**

```java
TransportThreadAlert(@NonNull java.lang.String text,
                     @Nullable Closed closed,
                     @Nullable ClosedUntil closedUntil,
                     @Nullable LastTrip lastTrip)
```

```java
TransportThreadAlert()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getText()`<br>Standard alert text. |
| `Closed` | `getClosed()`<br>The value is set if the thread is not operational on that day. |
| `ClosedUntil` | `getClosedUntil()`<br>The value is set if the thread is not operational until the specified time. |
| `LastTrip` | `getLastTrip()`<br>The value is set if this trip is the last trip for the thread. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### TransportThreadAlert

```java
TransportThreadAlert(@NonNull java.lang.String text,
                     @Nullable Closed closed,
                     @Nullable ClosedUntil closedUntil,
                     @Nullable LastTrip lastTrip)
```

### TransportThreadAlert

```java
TransportThreadAlert()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getText

```java
@NonNull
java.lang.String getText()
```

Standard alert text.

Simple clients could use this text to get a pre-formatted message. If the client is unable to recognize the known structured alert, it should use the text field instead.

### getClosed

```java
@Nullable
Closed getClosed()
```

The value is set if the thread is not operational on that day.

Only one of the values close, closedUntil and lastTrip is set for an alert.

Optional field, can be null.

### getClosedUntil

```java
@Nullable
ClosedUntil getClosedUntil()
```

The value is set if the thread is not operational until the specified time.

Only one of the values close, closedUntil and lastTrip is set for an alert.

Optional field, can be null.

### getLastTrip

```java
@Nullable
LastTrip getLastTrip()
```

The value is set if this trip is the last trip for the thread.

Only one of the values close, closedUntil and lastTrip is set for an alert.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
