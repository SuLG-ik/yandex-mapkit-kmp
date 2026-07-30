---
title: "YMKLocationSubscriptionSettings"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLocationSubscriptionSettings"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationSubscriptionSettings.html"
---
# YMKLocationSubscriptionSettings

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocationSubscriptionSettings.html)

```objectivec
@interface YMKLocationSubscriptionSettings : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKLocationSubscriptionSettings *)subscriptionSettingsWithUseInBackground:( YMKLocationUseInBackground)useInBackground
                                                                             purpose:( YMKPurpose)purpose;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKLocationUseInBackground useInBackground;
```

If UseInBackground is Allow then the 'location' flag must be set in 'UIBackgroundModes' of the application

```objectivec
@property (nonatomic, readonly) YMKPurpose purpose;
```

Defines for what purpose the locations from the subscription will be used

## Class methods

### subscriptionSettingsWithUseInBackground:purpose:

```objectivec
+ (nonnull YMKLocationSubscriptionSettings *)subscriptionSettingsWithUseInBackground:( YMKLocationUseInBackground)useInBackground
                                                                             purpose:( YMKPurpose)purpose;
```

## Properties

### useInBackground

```objectivec
@property (nonatomic, readonly) YMKLocationUseInBackground useInBackground;
```

If UseInBackground is Allow then the 'location' flag must be set in 'UIBackgroundModes' of the application.

### purpose

```objectivec
@property (nonatomic, readonly) YMKPurpose purpose;
```

Defines for what purpose the locations from the subscription will be used. Depending on the purpose, it tries to optimize requests for locations.
