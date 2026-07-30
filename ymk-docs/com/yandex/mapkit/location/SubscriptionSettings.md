---
title: "SubscriptionSettings"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / SubscriptionSettings"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/SubscriptionSettings.html"
---
# SubscriptionSettings

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/SubscriptionSettings.html)

**Package** com.yandex.mapkit.location

java.lang.Object
↳ com.yandex.mapkit.location.SubscriptionSettings

`class SubscriptionSettings implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
SubscriptionSettings(@NonNull UseInBackground useInBackground,
                     @NonNull Purpose purpose)
```

```java
SubscriptionSettings()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `UseInBackground` | `getUseInBackground()`<br>If UseInBackground is Allow then the 'location' flag must be set in 'UIBackgroundModes' of the application. |
| `Purpose` | `getPurpose()`<br>Defines for what purpose the locations from the subscription will be used. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### SubscriptionSettings

```java
SubscriptionSettings(@NonNull UseInBackground useInBackground,
                     @NonNull Purpose purpose)
```

### SubscriptionSettings

```java
SubscriptionSettings()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getUseInBackground

```java
@NonNull
UseInBackground getUseInBackground()
```

If UseInBackground is Allow then the 'location' flag must be set in 'UIBackgroundModes' of the application.

### getPurpose

```java
@NonNull
Purpose getPurpose()
```

Defines for what purpose the locations from the subscription will be used.

Depending on the purpose, it tries to optimize requests for locations.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
