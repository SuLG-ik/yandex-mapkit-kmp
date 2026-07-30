---
title: "YRTExperimentData"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTExperimentData"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTExperimentData.html"
---
# YRTExperimentData

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTExperimentData.html)

```objectivec
@interface YRTExperimentData : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YRTExperimentData *)experimentDataWithTestId:( NSUInteger)testId
                                              userGroup:( NSUInteger)userGroup
                                             userBucket:( NSUInteger)userBucket;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger testId;
```

```objectivec
@property (nonatomic, readonly) NSUInteger userGroup;
```

```objectivec
@property (nonatomic, readonly) NSUInteger userBucket;
```

## Class methods

### experimentDataWithTestId:userGroup:userBucket:

```objectivec
+ (nonnull YRTExperimentData *)experimentDataWithTestId:( NSUInteger)testId
                                              userGroup:( NSUInteger)userGroup
                                             userBucket:( NSUInteger)userBucket;
```

## Properties

### testId

```objectivec
@property (nonatomic, readonly) NSUInteger testId;
```

### userGroup

```objectivec
@property (nonatomic, readonly) NSUInteger userGroup;
```

### userBucket

```objectivec
@property (nonatomic, readonly) NSUInteger userBucket;
```
