---
title: "YMKMasstransitThread"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitThread"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitThread.html"
---
# YMKMasstransitThread

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitThread.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitThread : NSObject <YMKBaseMetadata>
```

Describes a public transport thread. A thread is one of the YMKMasstransitLine variants. For example, one line can have two threads: direct and return.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitThread *)threadWithId:(nonnull NSString *)id
                                essentialStops:(nonnull NSArray<YMKMasstransitEssentialStop *> *)essentialStops
                                   description:(nullable NSString *)description
                                      category:(nonnull NSArray<NSNumber *> *)category
                                  comfortClass:(nullable NSString *)comfortClass;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Thread ID

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitEssentialStop *> *essentialStops;
```

List of important stops on the thread, such as the first and last stops

```objectivec
@property (nonatomic, readonly, nullable) NSString *description;
```

'Description' is a specific thread name which must be used in addition to the corresponding YMKMasstransitLine name

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *category;
```

List of categories describing important traits of the thread

```objectivec
@property (nonatomic, readonly, nullable) NSString *comfortClass;
```

Comfort class of transport, e

## Class methods

### threadWithId:essentialStops:description:category:comfortClass:

```objectivec
+ (nonnull YMKMasstransitThread *)threadWithId:(nonnull NSString *)id
                                essentialStops:(nonnull NSArray<YMKMasstransitEssentialStop *> *)essentialStops
                                   description:(nullable NSString *)description
                                      category:(nonnull NSArray<NSNumber *> *)category
                                  comfortClass:(nullable NSString *)comfortClass;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Thread ID.

### essentialStops

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitEssentialStop *> *essentialStops;
```

List of important stops on the thread, such as the first and last stops.

### description

```objectivec
@property (nonatomic, readonly, nullable) NSString *description;
```

'Description' is a specific thread name which must be used in addition to the corresponding YMKMasstransitLine name.

For example, line "bus 34" has two thread with descriptions: "short" and "long". To get full thread name you should combine line name and thread description. After this, you get two threads name: "bus 34 short" and "bus 34 long".

Optional field, can be nil.

### category

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *category;
```

List of categories describing important traits of the thread. For example, "primary", "secondary", "to_depot"

### comfortClass

```objectivec
@property (nonatomic, readonly, nullable) NSString *comfortClass;
```

Comfort class of transport, e.g. "Standart plus", "Lastochka" for trains.

Optional field, can be nil.
