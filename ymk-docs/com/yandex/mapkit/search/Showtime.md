---
title: "Showtime"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Showtime"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Showtime.html"
---
# Showtime

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Showtime.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Showtime

`class Showtime implements Serializable`

Session details.

## Summary

### Constructors

**Signature and Description**

```java
Showtime()
```

Use constructor with parameters in your code.

```java
Showtime(@NonNull Time startTime,
         @Nullable Money price,
         @Nullable java.lang.String ticketId)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Time` | `getStartTime()`<br>Session start time. |
| `synchronized Money` | `getPrice()`<br>Ticket price. |
| `synchronized java.lang.String` | `getTicketId()`<br>Ticket id. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Showtime

```java
Showtime()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Showtime

```java
Showtime(@NonNull Time startTime,
         @Nullable Money price,
         @Nullable java.lang.String ticketId)
```

## Methods

### getStartTime

```java
@NonNull
Time getStartTime()
```

Session start time.

### getPrice

```java
@Nullable
Money getPrice()
```

Ticket price.

Optional field, can be null.

### getTicketId

```java
@Nullable
java.lang.String getTicketId()
```

Ticket id.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
