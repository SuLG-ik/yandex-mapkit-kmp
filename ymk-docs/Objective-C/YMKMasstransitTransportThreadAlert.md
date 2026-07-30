---
title: "YMKMasstransitTransportThreadAlert"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTransportThreadAlert"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportThreadAlert.html"
---
# YMKMasstransitTransportThreadAlert

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportThreadAlert.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTransportThreadAlert : NSObject
```

TransportThreadAlert are important annotations for mass transit ride sections of routes.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTransportThreadAlert *)transportThreadAlertWithText:(nonnull NSString *)text
                                                                      closed:(nullable YMKMasstransitTransportThreadAlertClosed *)closed
                                                                 closedUntil:(nullable YMKMasstransitTransportThreadAlertClosedUntil *)closedUntil
                                                                    lastTrip:(nullable YMKMasstransitTransportThreadAlertLastTrip *)lastTrip;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

Standard alert text

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTransportThreadAlertClosed *closed;
```

The value is set if the thread is not operational on that day

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTransportThreadAlertClosedUntil *closedUntil;
```

The value is set if the thread is not operational until the specified time

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTransportThreadAlertLastTrip *lastTrip;
```

The value is set if this trip is the last trip for the thread

## Class methods

### transportThreadAlertWithText:closed:closedUntil:lastTrip:

```objectivec
+ (nonnull YMKMasstransitTransportThreadAlert *)transportThreadAlertWithText:(nonnull NSString *)text
                                                                      closed:(nullable YMKMasstransitTransportThreadAlertClosed *)closed
                                                                 closedUntil:(nullable YMKMasstransitTransportThreadAlertClosedUntil *)closedUntil
                                                                    lastTrip:(nullable YMKMasstransitTransportThreadAlertLastTrip *)lastTrip;
```

## Properties

### text

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

Standard alert text. Simple clients could use this text to get a pre-formatted message. If the client is unable to recognize the known structured alert, it should use the text field instead.

### closed

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTransportThreadAlertClosed *closed;
```

The value is set if the thread is not operational on that day. Only one of the values close, closedUntil and lastTrip is set for an alert.

Optional field, can be nil.

### closedUntil

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTransportThreadAlertClosedUntil *closedUntil;
```

The value is set if the thread is not operational until the specified time. Only one of the values close, closedUntil and lastTrip is set for an alert.

Optional field, can be nil.

### lastTrip

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTransportThreadAlertLastTrip *lastTrip;
```

The value is set if this trip is the last trip for the thread. Only one of the values close, closedUntil and lastTrip is set for an alert.

Optional field, can be nil.
