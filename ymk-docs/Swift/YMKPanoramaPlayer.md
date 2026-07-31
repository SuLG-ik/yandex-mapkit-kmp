---
title: "YMKPanoramaPlayer"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoramaPlayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaPlayer.html"
---
# YMKPanoramaPlayer

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaPlayer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoramaPlayer : NSObject
```

Panorama player that is used to open panoramas.

## Summary

### Instance methods

```swift
func openPanorama(withPanoramaId panoramaId: String)
```

Opens the panorama with the given ID

```swift
func openUserPanoramaWithLocalDataSource(with panoramaDescription: YMKPanoramaDescription,
                                                tileImageProvider: any YMKPanoramaTileImageFactory,
                                                iconImageProvider: any YMKPanoramaIconImageFactory,
                                        userPanoramaEventListener: any YMKPanoramaUserPanoramaDelegate)
```

Opens the panorama from the local datasource

```swift
func openUserPanoramaWithNetworkDataSource(with panoramaDescription: YMKPanoramaDescription,
                                                    tileUrlProvider: any YMKPanoramaTileUrlProvider,
                                                    iconUrlProvider: any YMKPanoramaIconUrlProvider,
                                          userPanoramaEventListener: any YMKPanoramaUserPanoramaDelegate)
```

Opens the panorama from the network datasource

```swift
func panoramaId() -> String
```

Opened the panorama with the given ID

```swift
func position() -> YMKPoint
```

Geo position of current panorama

```swift
func lookAt(withPosition position: YMKPoint)
```

Sets the view direction to the center of the given geo position

```swift
func direction() -> YMKDirection
```

View direction of the opened panorama

```swift
func setDirectionWith(_ direction: YMKDirection)
```

Sets the view direction bearing and tilt

```swift
func span() -> YMKSpan
```

View span of the opened panorama

```swift
func setSpanWith(_ span: YMKSpan)
```

Sets the view area span

```swift
func reset()
```

Closes the opened panorama and stops all player actions

```swift
func historicalPanoramas() -> [YMKHistoricalPanorama]
```

```swift
func enableZoom()
```

Enables player zoom controls

```swift
func disableZoom()
```

Disables player zoom controls

```swift
func zoomEnabled() -> Bool
```

Checks if zoom controls are enabled

```swift
func enableMove()
```

Shows transition arrows and allows switching panoramas

```swift
func disableMove()
```

Hides transition arrows and disallows switching panoramas

```swift
func moveEnabled() -> Bool
```

Checks if switching panoramas is enabled

```swift
func enableRotation()
```

Allows the user to rotate panoramas

```swift
func disableRotation()
```

Disallows the user to rotate panoramas

```swift
func rotationEnabled() -> Bool
```

Checks if player rotation is enabled

```swift
func enableMarkers()
```

Allows markers (house numbers, railway stations, airports) to be shown

```swift
func disableMarkers()
```

Disallows markers (house numbers, railway stations, airports) to be shown

```swift
func markersEnabled() -> Bool
```

Checks if markers are enabled

```swift
func enableCompanies()
```

Allows companies (company names and icons) to be shown

```swift
func disableCompanies()
```

Disallows companies (company names and icons) to be shown

```swift
func companiesEnabled() -> Bool
```

Checks if companies are enabled

```swift
func addPanoramaChangeListener(withPanoramaChangeListener panoramaChangeListener: any YMKPanoramaChangeDelegate)
```

Adds a panorama change listener

```swift
func removePanoramaChangeListener(withPanoramaChangeListener panoramaChangeListener: any YMKPanoramaChangeDelegate)
```

Removes the panorama change listener

```swift
func addDirectionChangeListener(withDirectionChangeListener directionChangeListener: any YMKPanoramaDirectionChangeDelegate)
```

Adds direction listener

```swift
func removeDirectionChangeListener(withDirectionChangeListener directionChangeListener: any YMKPanoramaDirectionChangeDelegate)
```

Removes the direction listener

```swift
func addSpanChangeListener(withSpanChangeListener spanChangeListener: any YMKPanoramaSpanChangeDelegate)
```

Adds span listener

```swift
func removeSpanChangeListener(withSpanChangeListener spanChangeListener: any YMKPanoramaSpanChangeDelegate)
```

Removes span listener

```swift
func addCompanyTapListener(withCompanyTapListener companyTapListener: any YMKPanoramaCompanyTapDelegate)
```

Adds company tap listener

```swift
func removeCompanyTapListener(withCompanyTapListener companyTapListener: any YMKPanoramaCompanyTapDelegate)
```

Removes company tap listener

```swift
func addErrorListenerWithErrorListener(_ errorListener: any YMKPanoramaErrorDelegate)
```

Adds error listener

```swift
func removeErrorListenerWithErrorListener(_ errorListener: any YMKPanoramaErrorDelegate)
```

Removes error listener

```swift
func enableLoadingWheel()
```

Allows showing loading wheels

```swift
func disableLoadingWheel()
```

Disallows showing loading wheels

```swift
func loadingWheelEnabled() -> Bool
```

Checks if loading wheels can be shown while the panorama is opening

```swift
func onMemoryWarning()
```

Called when a memory warning happens

### Properties

```swift
var logo: YMKLogo { get }
```

Yandex logo object

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### openPanorama(withPanoramaId:)

```swift
func openPanorama(withPanoramaId panoramaId: String)
```

Opens the panorama with the given ID.

| Parameters |   |
| --- | --- |
| panoramaId | The panoramaId that specifies the panorama to open. You can get the panoramaId by using the PanoramaService methods. |

### openUserPanoramaWithLocalDataSource(with:tileImageProvider:iconImageProvider:userPanoramaEventListener:)

```swift
func openUserPanoramaWithLocalDataSource(with panoramaDescription: YMKPanoramaDescription,
                                                tileImageProvider: any YMKPanoramaTileImageFactory,
                                                iconImageProvider: any YMKPanoramaIconImageFactory,
                                        userPanoramaEventListener: any YMKPanoramaUserPanoramaDelegate)
```

Opens the panorama from the local datasource.

The class maintains a strong reference to the object in the 'tileImageProvider' parameter until it (the class) is invalidated.

The class maintains a strong reference to the object in the 'iconImageProvider' parameter until it (the class) is invalidated.

The class does not retain the object in the 'userPanoramaEventListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| panoramaDescription | Initialize this struct to open panorama |
| tileImageProvider | The tile datasource |
| iconImageProvider | The icon datasource |
| userPanoramaEventListener | The user panorama notification listener |

### openUserPanoramaWithNetworkDataSource(with:tileUrlProvider:iconUrlProvider:userPanoramaEventListener:)

```swift
func openUserPanoramaWithNetworkDataSource(with panoramaDescription: YMKPanoramaDescription,
                                                    tileUrlProvider: any YMKPanoramaTileUrlProvider,
                                                    iconUrlProvider: any YMKPanoramaIconUrlProvider,
                                          userPanoramaEventListener: any YMKPanoramaUserPanoramaDelegate)
```

Opens the panorama from the network datasource.

The class maintains a strong reference to the object in the 'tileUrlProvider' parameter until it (the class) is invalidated.

The class maintains a strong reference to the object in the 'iconUrlProvider' parameter until it (the class) is invalidated.

The class does not retain the object in the 'userPanoramaEventListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| panoramaDescription | Initialize this struct to open panorama |
| tileUrlProvider | The network tile datasource |
| iconUrlProvider | The netwokr icon datasource |
| userPanoramaEventListener | The user panorama notification listener |

### panoramaId()

```swift
func panoramaId() -> String
```

Opened the panorama with the given ID.

**Returns**

PanoramaId of the currently opened panorama. Empty if no

panorama is open.

### position()

```swift
func position() -> YMKPoint
```

Geo position of current panorama.

**Returns**

Geo position of the currently opened panorama. Empty if no

panorama is open.

### lookAt(withPosition:)

```swift
func lookAt(withPosition position: YMKPoint)
```

Sets the view direction to the center of the given geo position.

| Parameters |   |
| --- | --- |
| position | The position to look at. |

### direction()

```swift
func direction() -> YMKDirection
```

View direction of the opened panorama.

**Returns**

View direction of the opened panorama. Empty if no panorama

is open.

### setDirectionWith(_:)

```swift
func setDirectionWith(_ direction: YMKDirection)
```

Sets the view direction bearing and tilt.

| Parameters |   |
| --- | --- |
| direction | View direction. |

### span()

```swift
func span() -> YMKSpan
```

View span of the opened panorama.

**Returns**

Current view span of the opened panorama. May be different

from the span provided by the setSpan(span) method.

### setSpanWith(_:)

```swift
func setSpanWith(_ span: YMKSpan)
```

Sets the view area span. Invalid values are adjusted by the player to the closest valid values.

| Parameters |   |
| --- | --- |
| span | View area span. May be adjusted by the player. |

### reset()

```swift
func reset()
```

Closes the opened panorama and stops all player actions.

### historicalPanoramas()

```swift
func historicalPanoramas() -> [YMKHistoricalPanorama]
```

**Returns**

panoramas published earlier at the current panorama position.

Result is updated on the YMKPanoramaChangeDelegate callback

### enableZoom()

```swift
func enableZoom()
```

Enables player zoom controls.

### disableZoom()

```swift
func disableZoom()
```

Disables player zoom controls.

### zoomEnabled()

```swift
func zoomEnabled() -> Bool
```

Checks if zoom controls are enabled.

### enableMove()

```swift
func enableMove()
```

Shows transition arrows and allows switching panoramas.

### disableMove()

```swift
func disableMove()
```

Hides transition arrows and disallows switching panoramas.

### moveEnabled()

```swift
func moveEnabled() -> Bool
```

Checks if switching panoramas is enabled.

### enableRotation()

```swift
func enableRotation()
```

Allows the user to rotate panoramas.

### disableRotation()

```swift
func disableRotation()
```

Disallows the user to rotate panoramas.

### rotationEnabled()

```swift
func rotationEnabled() -> Bool
```

Checks if player rotation is enabled.

### enableMarkers()

```swift
func enableMarkers()
```

Allows markers (house numbers, railway stations, airports) to be shown.

### disableMarkers()

```swift
func disableMarkers()
```

Disallows markers (house numbers, railway stations, airports) to be shown.

### markersEnabled()

```swift
func markersEnabled() -> Bool
```

Checks if markers are enabled.

### enableCompanies()

```swift
func enableCompanies()
```

Allows companies (company names and icons) to be shown.

### disableCompanies()

```swift
func disableCompanies()
```

Disallows companies (company names and icons) to be shown.

### companiesEnabled()

```swift
func companiesEnabled() -> Bool
```

Checks if companies are enabled.

### addPanoramaChangeListener(withPanoramaChangeListener:)

```swift
func addPanoramaChangeListener(withPanoramaChangeListener panoramaChangeListener: any YMKPanoramaChangeDelegate)
```

Adds a panorama change listener.

The class does not retain the object in the 'panoramaChangeListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| panoramaChangeListener | Panorama change listener. |

### removePanoramaChangeListener(withPanoramaChangeListener:)

```swift
func removePanoramaChangeListener(withPanoramaChangeListener panoramaChangeListener: any YMKPanoramaChangeDelegate)
```

Removes the panorama change listener.

| Parameters |   |
| --- | --- |
| panoramaChangeListener | The panorama change listener to remove. |

### addDirectionChangeListener(withDirectionChangeListener:)

```swift
func addDirectionChangeListener(withDirectionChangeListener directionChangeListener: any YMKPanoramaDirectionChangeDelegate)
```

Adds direction listener.

The class does not retain the object in the 'directionChangeListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| directionChangeListener | Panorama direction listener. |

### removeDirectionChangeListener(withDirectionChangeListener:)

```swift
func removeDirectionChangeListener(withDirectionChangeListener directionChangeListener: any YMKPanoramaDirectionChangeDelegate)
```

Removes the direction listener.

| Parameters |   |
| --- | --- |
| directionChangeListener | The panorama direction listener to remove. |

### addSpanChangeListener(withSpanChangeListener:)

```swift
func addSpanChangeListener(withSpanChangeListener spanChangeListener: any YMKPanoramaSpanChangeDelegate)
```

Adds span listener.

The class does not retain the object in the 'spanChangeListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| spanChangeListener | Panorama span listener. |

### removeSpanChangeListener(withSpanChangeListener:)

```swift
func removeSpanChangeListener(withSpanChangeListener spanChangeListener: any YMKPanoramaSpanChangeDelegate)
```

Removes span listener.

| Parameters |   |
| --- | --- |
| spanChangeListener | The span listener to remove. |

### addCompanyTapListener(withCompanyTapListener:)

```swift
func addCompanyTapListener(withCompanyTapListener companyTapListener: any YMKPanoramaCompanyTapDelegate)
```

Adds company tap listener.

The class does not retain the object in the 'companyTapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| companyTapListener | Company tap listener. |

### removeCompanyTapListener(withCompanyTapListener:)

```swift
func removeCompanyTapListener(withCompanyTapListener companyTapListener: any YMKPanoramaCompanyTapDelegate)
```

Removes company tap listener.

| Parameters |   |
| --- | --- |
| companyTapListener | The company tap listener to remove. |

### addErrorListenerWithErrorListener(_:)

```swift
func addErrorListenerWithErrorListener(_ errorListener: any YMKPanoramaErrorDelegate)
```

Adds error listener.

The class does not retain the object in the 'errorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| errorListener | Listeners that notify when a panorama failed to open. |

### removeErrorListenerWithErrorListener(_:)

```swift
func removeErrorListenerWithErrorListener(_ errorListener: any YMKPanoramaErrorDelegate)
```

Removes error listener.

| Parameters |   |
| --- | --- |
| errorListener | The listener to remove. |

### enableLoadingWheel()

```swift
func enableLoadingWheel()
```

Allows showing loading wheels.

### disableLoadingWheel()

```swift
func disableLoadingWheel()
```

Disallows showing loading wheels.

### loadingWheelEnabled()

```swift
func loadingWheelEnabled() -> Bool
```

Checks if loading wheels can be shown while the panorama is opening.

### onMemoryWarning()

```swift
func onMemoryWarning()
```

Called when a memory warning happens.

## Properties

### logo

```swift
var logo: YMKLogo { get }
```

Yandex logo object.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
