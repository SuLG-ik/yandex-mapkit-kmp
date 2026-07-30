---
title: "YMKMasstransitEssentialStopInfo"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitEssentialStopInfo"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitEssentialStopInfo.html"
---
# YMKMasstransitEssentialStopInfo

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitEssentialStopInfo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitEssentialStopInfo : NSObject
```

Info for essential stop

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitEssentialStopInfo *)essentialStopInfoWithFirst_stop:( BOOL)first_stop
                                                       intermediate_terminus:( BOOL)intermediate_terminus
                                                                   important:( BOOL)important
                                                                   last_stop:( BOOL)last_stop;
```

### Instance methods

```objectivec
- (nonnull YMKMasstransitEssentialStopInfo *)init;
```

### Properties

```objectivec
@property (nonatomic, readonly) BOOL first_stop;
```

First stop on thread

```objectivec
@property (nonatomic, readonly) BOOL intermediate_terminus;
```

Intermediate terminus stop on thread

```objectivec
@property (nonatomic, readonly) BOOL important;
```

Important stop on thread

```objectivec
@property (nonatomic, readonly) BOOL last_stop;
```

Last stop on thread

## Class methods

### essentialStopInfoWithFirst_stop:intermediate_terminus:important:last_stop:

```objectivec
+ (nonnull YMKMasstransitEssentialStopInfo *)essentialStopInfoWithFirst_stop:( BOOL)first_stop
                                                       intermediate_terminus:( BOOL)intermediate_terminus
                                                                   important:( BOOL)important
                                                                   last_stop:( BOOL)last_stop;
```

## Instance methods

### init

```objectivec
- (nonnull YMKMasstransitEssentialStopInfo *)init;
```

## Properties

### first_stop

```objectivec
@property (nonatomic, readonly) BOOL first_stop;
```

First stop on thread

### intermediate_terminus

```objectivec
@property (nonatomic, readonly) BOOL intermediate_terminus;
```

Intermediate terminus stop on thread

### important

```objectivec
@property (nonatomic, readonly) BOOL important;
```

Important stop on thread

### last_stop

```objectivec
@property (nonatomic, readonly) BOOL last_stop;
```

Last stop on thread
