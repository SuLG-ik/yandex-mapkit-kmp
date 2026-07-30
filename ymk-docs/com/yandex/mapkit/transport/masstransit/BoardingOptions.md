---
title: "BoardingOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / BoardingOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/BoardingOptions.html"
---
# BoardingOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/BoardingOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.BoardingOptions

`class BoardingOptions implements Serializable`

Contains information about underground or railway boarding recommendations.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [BoardingArea](BoardingOptions_BoardingArea.md) | Area recommended for boarding: wagon, sector, etc. |

## Summary

### Constructors

**Signature and Description**

```java
BoardingOptions()
```

Use constructor with parameters in your code.

```java
BoardingOptions(@NonNull java.util.List<BoardingArea> area,
                @NonNull RailwayOptions railwayOptions)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<BoardingArea>` | `getArea()`<br>Vector of recommended areas to board. |
| `synchronized RailwayOptions` | `getRailwayOptions()`<br>Options about boarding to trains. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### BoardingOptions

```java
BoardingOptions()
```

Use constructor with parameters in your code.

This one is for serialization only!

### BoardingOptions

```java
BoardingOptions(@NonNull java.util.List<BoardingArea> area,
                @NonNull RailwayOptions railwayOptions)
```

## Methods

### getArea

```java
@NonNull
java.util.List<BoardingArea> getArea()
```

Vector of recommended areas to board.

### getRailwayOptions

```java
@NonNull
RailwayOptions getRailwayOptions()
```

Options about boarding to trains.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
