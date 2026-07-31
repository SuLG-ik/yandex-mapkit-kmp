---
title: "YMKMasstransitSectionMetadataSectionData"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitSectionMetadataSectionData"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSectionMetadataSectionData.html"
---
# YMKMasstransitSectionMetadataSectionData

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSectionMetadataSectionData.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitSectionMetadataSectionData : NSObject
```

A choice of information specific to the section type.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitSectionMetadataSectionData *)sectionDataWithWait:(nonnull YMKMasstransitWait *)wait;
```

```objectivec
+ (nonnull YMKMasstransitSectionMetadataSectionData *)sectionDataWithFitness:(nonnull YMKMasstransitFitness *)fitness;
```

```objectivec
+ (nonnull YMKMasstransitSectionMetadataSectionData *)sectionDataWithTransfer:(nonnull YMKMasstransitTransfer *)transfer;
```

```objectivec
+ (nonnull YMKMasstransitSectionMetadataSectionData *)sectionDataWithTaxi:(nonnull YMKMasstransitTaxi *)taxi;
```

```objectivec
+ (nonnull YMKMasstransitSectionMetadataSectionData *)sectionDataWithTransports:(nonnull NSArray<YMKMasstransitTransport *> *)transports;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitWait *wait
```

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitFitness *fitness
```

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitTransfer *transfer
```

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitTaxi *taxi
```

```objectivec
@property (nonatomic, readonly, nullable) NSArray<YMKMasstransitTransport *> *transports
```

## Class methods

### sectionDataWithWait:

```objectivec
+ (nonnull YMKMasstransitSectionMetadataSectionData *)sectionDataWithWait:(nonnull YMKMasstransitWait *)wait;
```

### sectionDataWithFitness:

```objectivec
+ (nonnull YMKMasstransitSectionMetadataSectionData *)sectionDataWithFitness:(nonnull YMKMasstransitFitness *)fitness;
```

### sectionDataWithTransfer:

```objectivec
+ (nonnull YMKMasstransitSectionMetadataSectionData *)sectionDataWithTransfer:(nonnull YMKMasstransitTransfer *)transfer;
```

### sectionDataWithTaxi:

```objectivec
+ (nonnull YMKMasstransitSectionMetadataSectionData *)sectionDataWithTaxi:(nonnull YMKMasstransitTaxi *)taxi;
```

### sectionDataWithTransports:

```objectivec
+ (nonnull YMKMasstransitSectionMetadataSectionData *)sectionDataWithTransports:(nonnull NSArray<YMKMasstransitTransport *> *)transports;
```

## Properties

### wait

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitWait *wait
```

### fitness

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitFitness *fitness
```

### transfer

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitTransfer *transfer
```

### taxi

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitTaxi *taxi
```

### transports

```objectivec
@property (nonatomic, readonly, nullable) NSArray<YMKMasstransitTransport *> *transports
```
