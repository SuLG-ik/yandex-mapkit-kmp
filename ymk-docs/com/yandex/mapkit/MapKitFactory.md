---
title: "MapKitFactory"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / MapKitFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/MapKitFactory.html"
---
# MapKitFactory

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/MapKitFactory.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.MapKitFactory

`final class MapKitFactory`

## Summary

### Constructors

**Signature and Description**

```java
MapKitFactory()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static synchronized void` | `initialize(android.content.Context context)` |
| `static synchronized void` | `setApiKey(@NonNull java.lang.String apiKey)` |
| `static synchronized void` | `setLocale(@Nullable java.lang.String locale)` |
| `static synchronized void` | `setUserId(java.lang.String userId)` |
| `static synchronized void` | `initializeBackgroundDownload(android.content.Context context, com.yandex.mapkit.offline_cache.internal.BackgroundDownloadInitializer initializer)`<br>This method checks if background downloading is needed. |
| `static native MapKit` | `getInstance()` |

## Constuctors

### MapKitFactory

```java
MapKitFactory()
```

## Methods

### initialize

```java
void initialize(android.content.Context context)
```

### setApiKey

```java
void setApiKey(@NonNull java.lang.String apiKey)
```

### setLocale

```java
void setLocale(@Nullable java.lang.String locale)
```

### setUserId

```java
void setUserId(java.lang.String userId)
```

### initializeBackgroundDownload

```java
void initializeBackgroundDownload(android.content.Context context,
                                  com.yandex.mapkit.offline_cache.internal.BackgroundDownloadInitializer initializer)
```

This method checks if background downloading is needed.

If it is, the method initializes mapkit with `BackgroundDownloadInitializer::initializeMapkit()` and starts downloading. Else nothing happens. This method is lightweight, please invoke it from Application.onCreate.

### getInstance

```java
MapKit getInstance()
```
