---
title: "YMKMapLoadStatistics"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMapLoadStatistics"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapLoadStatistics.html"
---
# YMKMapLoadStatistics

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapLoadStatistics.html)

```objectivec
@interface YMKMapLoadStatistics : NSObject
```

The time it took to load map elements.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMapLoadStatistics *)mapLoadStatisticsWithCurZoomGeometryLoaded:( NSTimeInterval)curZoomGeometryLoaded
                                                     curZoomPlacemarksLoaded:( NSTimeInterval)curZoomPlacemarksLoaded
                                                         curZoomLabelsLoaded:( NSTimeInterval)curZoomLabelsLoaded
                                                       delayedGeometryLoaded:( NSTimeInterval)delayedGeometryLoaded
                                                         curZoomModelsLoaded:( NSTimeInterval)curZoomModelsLoaded
                                                                 fullyLoaded:( NSTimeInterval)fullyLoaded
                                                               fullyAppeared:( NSTimeInterval)fullyAppeared
                                                           renderObjectCount:( NSInteger)renderObjectCount
                                                             tileMemoryUsage:( NSUInteger)tileMemoryUsage;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSTimeInterval curZoomGeometryLoaded;
```

```objectivec
@property (nonatomic, readonly) NSTimeInterval curZoomPlacemarksLoaded;
```

```objectivec
@property (nonatomic, readonly) NSTimeInterval curZoomLabelsLoaded;
```

```objectivec
@property (nonatomic, readonly) NSTimeInterval delayedGeometryLoaded;
```

The time it took to load delayed geometry

```objectivec
@property (nonatomic, readonly) NSTimeInterval curZoomModelsLoaded;
```

The time it took to load models

```objectivec
@property (nonatomic, readonly) NSTimeInterval fullyLoaded;
```

The time it took to load all map objects

```objectivec
@property (nonatomic, readonly) NSTimeInterval fullyAppeared;
```

The time it took for all map objects to appear

```objectivec
@property (nonatomic, readonly) NSInteger renderObjectCount;
```

```objectivec
@property (nonatomic, readonly) NSUInteger tileMemoryUsage;
```

Tile memory usage in bytes

## Class methods

### mapLoadStatisticsWithCurZoomGeometryLoaded:curZoomPlacemarksLoaded:curZoomLabelsLoaded:delayedGeometryLoaded:curZoomModelsLoaded:fullyLoaded:fullyAppeared:renderObjectCount:tileMemoryUsage:

```objectivec
+ (nonnull YMKMapLoadStatistics *)mapLoadStatisticsWithCurZoomGeometryLoaded:( NSTimeInterval)curZoomGeometryLoaded
                                                     curZoomPlacemarksLoaded:( NSTimeInterval)curZoomPlacemarksLoaded
                                                         curZoomLabelsLoaded:( NSTimeInterval)curZoomLabelsLoaded
                                                       delayedGeometryLoaded:( NSTimeInterval)delayedGeometryLoaded
                                                         curZoomModelsLoaded:( NSTimeInterval)curZoomModelsLoaded
                                                                 fullyLoaded:( NSTimeInterval)fullyLoaded
                                                               fullyAppeared:( NSTimeInterval)fullyAppeared
                                                           renderObjectCount:( NSInteger)renderObjectCount
                                                             tileMemoryUsage:( NSUInteger)tileMemoryUsage;
```

## Properties

### curZoomGeometryLoaded

```objectivec
@property (nonatomic, readonly) NSTimeInterval curZoomGeometryLoaded;
```

### curZoomPlacemarksLoaded

```objectivec
@property (nonatomic, readonly) NSTimeInterval curZoomPlacemarksLoaded;
```

### curZoomLabelsLoaded

```objectivec
@property (nonatomic, readonly) NSTimeInterval curZoomLabelsLoaded;
```

### delayedGeometryLoaded

```objectivec
@property (nonatomic, readonly) NSTimeInterval delayedGeometryLoaded;
```

The time it took to load delayed geometry.

### curZoomModelsLoaded

```objectivec
@property (nonatomic, readonly) NSTimeInterval curZoomModelsLoaded;
```

The time it took to load models.

### fullyLoaded

```objectivec
@property (nonatomic, readonly) NSTimeInterval fullyLoaded;
```

The time it took to load all map objects.

### fullyAppeared

```objectivec
@property (nonatomic, readonly) NSTimeInterval fullyAppeared;
```

The time it took for all map objects to appear.

### renderObjectCount

```objectivec
@property (nonatomic, readonly) NSInteger renderObjectCount;
```

### tileMemoryUsage

```objectivec
@property (nonatomic, readonly) NSUInteger tileMemoryUsage;
```

Tile memory usage in bytes
