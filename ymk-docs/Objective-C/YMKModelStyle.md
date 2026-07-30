---
title: "YMKModelStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKModelStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKModelStyle.html"
---
# YMKModelStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKModelStyle.html)

```objectivec
@interface YMKModelStyle : NSObject
```

The style of the model.

## Summary

### Class methods

```objectivec
+ (nonnull YMKModelStyle *)modelStyleWithScale:( float)scale
                                      unitType:( YMKModelStyleUnitType)unitType
                                    renderMode:( YMKModelStyleRenderMode)renderMode
                                   variantName:(nullable NSString *)variantName;
```

### Instance methods

```objectivec
- (nonnull YMKModelStyle *)init;
```

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float scale;
```

Scale the model by this value

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKModelStyleUnitType unitType;
```

Unit type of the model

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKModelStyleRenderMode renderMode;
```

Defines should it be rendered with buildings from ground layer

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSString *variantName;
```

Name of variant to render model with

## Class methods

### modelStyleWithScale:unitType:renderMode:variantName:

```objectivec
+ (nonnull YMKModelStyle *)modelStyleWithScale:( float)scale
                                      unitType:( YMKModelStyleUnitType)unitType
                                    renderMode:( YMKModelStyleRenderMode)renderMode
                                   variantName:(nullable NSString *)variantName;
```

## Instance methods

### init

```objectivec
- (nonnull YMKModelStyle *)init;
```

## Properties

### scale

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float scale;
```

Scale the model by this value.

### unitType

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKModelStyleUnitType unitType;
```

Unit type of the model.

### renderMode

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKModelStyleRenderMode renderMode;
```

Defines should it be rendered with buildings from ground layer.

### variantName

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSString *variantName;
```

Name of variant to render model with. See KHR_materials_variants gltf extension. This works only for glTF models.

Optional field, can be nil.
