---
title: "YMKModel"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKModel"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKModel.html"
---
# YMKModel

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKModel.html)

```objectivec
@interface YMKModel : YMKPlacemarkPresentation
```

describes model presentation of PlacemarkMapObject

## Summary

### Instance methods

```objectivec
- (void)setDataWithGltfDataProvider:
    (nonnull id<YRTDataProviderWithId>)gltfDataProvider;
```

Sets glTF data provider

```objectivec
- (void)setDataWithGltfDataProvider:
            (nonnull id<YRTDataProviderWithId>)gltfDataProvider
                           callback:(nullable YMKCallback)callback;
```

Sets glTF data provider

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKModelStyle *modelStyle;
```

The style properties (scale, unitType, etc

## Instance methods

### setDataWithGltfDataProvider:

```objectivec
- (void)setDataWithGltfDataProvider:
    (nonnull id<YRTDataProviderWithId>)gltfDataProvider;
```

Sets glTF data provider.

The class maintains a strong reference to the object in the 'gltfDataProvider' parameter until it (the class) is invalidated.

| Parameters |   |
| --- | --- |
| onFinished | Called when the model is loaded. |

### setDataWithGltfDataProvider:callback:

```objectivec
- (void)setDataWithGltfDataProvider:
            (nonnull id<YRTDataProviderWithId>)gltfDataProvider
                           callback:(nullable YMKCallback)callback;
```

Sets glTF data provider.

The class maintains a strong reference to the object in the 'gltfDataProvider' parameter until it (the class) is invalidated.

| Parameters |   |
| --- | --- |
| onFinished | Called when the model is loaded. |

## Properties

### modelStyle

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKModelStyle *modelStyle;
```

The style properties (scale, unitType, etc.) of the model placemark. Note: The current style cannot be modified directly - you must reset it to apply changes.
