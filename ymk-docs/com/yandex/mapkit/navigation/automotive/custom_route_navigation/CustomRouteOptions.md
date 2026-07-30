---
title: "CustomRouteOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.custom_route_navigation"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.custom_route_navigation / CustomRouteOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/custom_route_navigation/CustomRouteOptions.html"
---
# CustomRouteOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/custom_route_navigation/CustomRouteOptions.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.custom_route_navigation

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.custom_route_navigation.CustomRouteOptions

`final class CustomRouteOptions implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
CustomRouteOptions(@Nullable java.lang.Boolean allowMoreUturns)
```

```java
CustomRouteOptions()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.Boolean` | `getAllowMoreUturns()`<br>Enabling this option will reduce the total route mileage but will include more u-turns along the route<br>Optional field, can be null. |
| `CustomRouteOptions` | `setAllowMoreUturns(@Nullable java.lang.Boolean allowMoreUturns)`<br>See **#getAllowMoreUturns()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### CustomRouteOptions

```java
CustomRouteOptions(@Nullable java.lang.Boolean allowMoreUturns)
```

### CustomRouteOptions

```java
CustomRouteOptions()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getAllowMoreUturns

```java
@Nullable
java.lang.Boolean getAllowMoreUturns()
```

Enabling this option will reduce the total route mileage but will include more u-turns along the route

Optional field, can be null.

### setAllowMoreUturns

```java
CustomRouteOptions setAllowMoreUturns(@Nullable java.lang.Boolean allowMoreUturns)
```

See **#getAllowMoreUturns()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
