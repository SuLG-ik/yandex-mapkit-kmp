---
title: "RouteOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / RouteOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/RouteOptions.html"
---
# RouteOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/RouteOptions.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.RouteOptions

`final class RouteOptions implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
RouteOptions(@Nullable java.lang.Double initialAzimuth,
             @Nullable java.lang.Integer routesCount)
```

```java
RouteOptions()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.Double` | `getInitialAzimuth()`<br>Optional field, can be null. |
| `RouteOptions` | `setInitialAzimuth(@Nullable java.lang.Double initialAzimuth)`<br>See **#getInitialAzimuth()**. |
| `java.lang.Integer` | `getRoutesCount()`<br>Optional field, can be null. |
| `RouteOptions` | `setRoutesCount(@Nullable java.lang.Integer routesCount)`<br>See **#getRoutesCount()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### RouteOptions

```java
RouteOptions(@Nullable java.lang.Double initialAzimuth,
             @Nullable java.lang.Integer routesCount)
```

### RouteOptions

```java
RouteOptions()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getInitialAzimuth

```java
@Nullable
java.lang.Double getInitialAzimuth()
```

Optional field, can be null.

### setInitialAzimuth

```java
RouteOptions setInitialAzimuth(@Nullable java.lang.Double initialAzimuth)
```

See **#getInitialAzimuth()**.

### getRoutesCount

```java
@Nullable
java.lang.Integer getRoutesCount()
```

Optional field, can be null.

### setRoutesCount

```java
RouteOptions setRoutesCount(@Nullable java.lang.Integer routesCount)
```

See **#getRoutesCount()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
