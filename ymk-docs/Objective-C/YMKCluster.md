---
title: "YMKCluster"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKCluster"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCluster.html"
---
# YMKCluster

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCluster.html)

```objectivec
@interface YMKCluster : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)addClusterTapListenerWithClusterTapListener:
    (nonnull id<YMKClusterTapListener>)clusterTapListener;
```

Adds a tap listener for cluster

```objectivec
- (void)removeClusterTapListenerWithClusterTapListener:
    (nonnull id<YMKClusterTapListener>)clusterTapListener;
```

Removes tap listener

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPlacemarkMapObject *> *placemarks;
```

A list of placemarks the cluster contains

```objectivec
@property (nonatomic, readonly) NSUInteger size;
```

Cluster size

```objectivec
@property (nonatomic, readonly, nonnull) YMKPlacemarkMapObject *appearance;
```

Cluster representation displayed on the map

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### addClusterTapListenerWithClusterTapListener:

```objectivec
- (void)addClusterTapListenerWithClusterTapListener:
    (nonnull id<YMKClusterTapListener>)clusterTapListener;
```

Adds a tap listener for cluster.

The class does not retain the object in the 'clusterTapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeClusterTapListenerWithClusterTapListener:

```objectivec
- (void)removeClusterTapListenerWithClusterTapListener:
    (nonnull id<YMKClusterTapListener>)clusterTapListener;
```

Removes tap listener.

## Properties

### placemarks

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPlacemarkMapObject *> *placemarks;
```

A list of placemarks the cluster contains.

### size

```objectivec
@property (nonatomic, readonly) NSUInteger size;
```

Cluster size.

### appearance

```objectivec
@property (nonatomic, readonly, nonnull) YMKPlacemarkMapObject *appearance;
```

Cluster representation displayed on the map.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
