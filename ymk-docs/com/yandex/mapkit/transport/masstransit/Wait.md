---
title: "Wait"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Wait"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Wait.html"
---
# Wait

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Wait.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Wait

`class Wait implements Serializable`

Represents a 'wait until suitable tranport arrives' section of a route.

## Summary

### Constructors

**Signature and Description**

```java
Wait(int dummy)
```

```java
Wait()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getDummy()`<br>Dummy object. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Wait

```java
Wait(int dummy)
```

### Wait

```java
Wait()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getDummy

```java
int getDummy()
```

Dummy object.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
