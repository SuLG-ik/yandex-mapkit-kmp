---
title: "Thread"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Thread"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Thread.html"
---
# Thread

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Thread.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Thread

## All Superinterfaces:

*[BaseMetadata](../../BaseMetadata.md)*

`class Thread implements BaseMetadata, Serializable`

Describes a public transport thread.

A thread is one of the [mapkit.transport.masstransit.Line](Line.md) variants. For example, one line can have two threads: direct and return.

## Summary

### Constructors

**Signature and Description**

```java
Thread()
```

Use constructor with parameters in your code.

```java
Thread(@NonNull java.lang.String id,
       @NonNull java.util.List<EssentialStop> essentialStops,
       @Nullable java.lang.String description,
       @NonNull java.util.List<ThreadCategory> category,
       @Nullable java.lang.String comfortClass)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getId()`<br>Thread ID. |
| `synchronized java.util.List<EssentialStop>` | `getEssentialStops()`<br>List of important stops on the thread, such as the first and last stops. |
| `synchronized java.lang.String` | `getDescription()`<br>'Description' is a specific thread name which must be used in addition to the corresponding [mapkit.transport.masstransit.Line](Line.md) name. |
| `synchronized java.util.List<ThreadCategory>` | `getCategory()`<br>List of categories describing important traits of the thread. |
| `synchronized java.lang.String` | `getComfortClass()`<br>Comfort class of transport, e.g. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Thread

```java
Thread()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Thread

```java
Thread(@NonNull java.lang.String id,
       @NonNull java.util.List<EssentialStop> essentialStops,
       @Nullable java.lang.String description,
       @NonNull java.util.List<ThreadCategory> category,
       @Nullable java.lang.String comfortClass)
```

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

Thread ID.

### getEssentialStops

```java
@NonNull
java.util.List<EssentialStop> getEssentialStops()
```

List of important stops on the thread, such as the first and last stops.

### getDescription

```java
@Nullable
java.lang.String getDescription()
```

'Description' is a specific thread name which must be used in addition to the corresponding [mapkit.transport.masstransit.Line](Line.md) name.

For example, line "bus 34" has two thread with descriptions: "short" and "long". To get full thread name you should combine line name and thread description. After this, you get two threads name: "bus 34 short" and "bus 34 long".

Optional field, can be null.

### getCategory

```java
@NonNull
java.util.List<ThreadCategory> getCategory()
```

List of categories describing important traits of the thread.

For example, "primary", "secondary", "to_depot"

### getComfortClass

```java
@Nullable
java.lang.String getComfortClass()
```

Comfort class of transport, e.g.

"Standart plus", "Lastochka" for trains.

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
