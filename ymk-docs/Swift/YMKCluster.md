---
title: "YMKCluster"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKCluster"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCluster.html"
---
# YMKCluster

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCluster.html)

```swift
class YMKCluster : NSObject
```

## Summary

### Instance methods

```swift
func addClusterTapListener(with clusterTapListener: any YMKClusterTapListener)
```

Adds a tap listener for cluster

```swift
func removeClusterTapListener(with clusterTapListener: any YMKClusterTapListener)
```

Removes tap listener

### Properties

```swift
var placemarks: [YMKPlacemarkMapObject] { get }
```

A list of placemarks the cluster contains

```swift
var size: UInt { get }
```

Cluster size

```swift
var appearance: YMKPlacemarkMapObject { get }
```

Cluster representation displayed on the map

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### addClusterTapListener(with:)

```swift
func addClusterTapListener(with clusterTapListener: any YMKClusterTapListener)
```

Adds a tap listener for cluster.

The class does not retain the object in the 'clusterTapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeClusterTapListener(with:)

```swift
func removeClusterTapListener(with clusterTapListener: any YMKClusterTapListener)
```

Removes tap listener.

## Properties

### placemarks

```swift
var placemarks: [YMKPlacemarkMapObject] { get }
```

A list of placemarks the cluster contains.

### size

```swift
var size: UInt { get }
```

Cluster size.

### appearance

```swift
var appearance: YMKPlacemarkMapObject { get }
```

Cluster representation displayed on the map.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
