---
title: "Начало работы с NaviKit SDK"
kind: "Guide"
platform: "ios"
language: "Swift/Objective-C"
section: "iOS / NaviKit SDK / Начало работы"
source: "https://yandex.ru/maps-api/docs/mapkit/ios/generated/navigation/getting_started.html"
---
# Начало работы с NaviKit SDK

`IOS` · `Swift/Objective-C` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/ios/generated/navigation/getting_started.html)

Процесс начала работы с NaviKit SDK имеет много сходств с подключением обычного MapKit, однако имеет несколько важных отличий.

## Шаг 1. Получение ключа для работы с NaviKit SDK

Для работы с NaviKit SDK требуется наличие API-ключа.

1. [Создайте новый](../getting_started.md#key) API-ключ для MapKit SDK или используйте существующий.
2. Чтобы API-ключ можно было использовать в приложениях с NaviKit SDK его необходимо активировать. Для этого напишите нам на почту [paid-api-maps@yandex-team.ru](mailto:paid-api-maps@yandex-team.ru).

## Шаг 2. Добавление NaviKit SDK зависимостей

Для использования всех функций, предоставляемых NaviKit SDK, вам необходимо добавить зависимость в ваш `Podfile`:

```ruby
platform :ios, '13.0'

target 'NavikitDemo' do
    pod 'YandexMapsMobile', '4.42.0-navikit'
    pod 'YMKStylingAutomotiveNavigation', '4.42.0'
    pod 'YMKStylingRoadEvents', '4.42.0'
end
```

## Шаг 3. Разрешение на запрос локации

NaviKit SDK для iOS требует [разрешение на доступ к локации](https://support.apple.com/HT203033) для отслеживания текущего местоположения устройства.

1. Добавьте следующее поле в ваш `Info.plist` файл:

   ```xml
   <key>NSLocationWhenInUseUsageDescription</key>
   <string>Your location is required for navigation</string>
   ```
2. Создайте `locationManager` и запросите разрешение на доступ к локации пользователя. Например, это можно сделать в методе `viewDidLoad()` вашего ViewController:

   ```swift
   import CoreLocation
   import UIKit

   class MainViewController: UIViewController, CLLocationManagerDelegate {
       override func viewDidLoad() {
           super.viewDidLoad()
           locationManager.delegate = self
           locationManager.requestAlwaysAuthorization()
       }
       private let locationManager = CLLocationManager()
   }
   ```

## Шаг 4. Настройка MapKit SDK

Выполните шаги из [Шаг 3. Добавьте API-ключ для MapKit](../getting_started.md#provide-key): установите ваш API-ключ, инициализируйте MapKit и создайте View с картой.

Если после запуска приложения MapKit карта успешно открылась и ее данные прогрузились, настройки выполнены верно.

## Шаг 5. Обратите внимание при дальнейшей работе

MapKit хранит слабые ссылки на передаваемые ему Listener-объекты. Необходимо самим хранить ссылку на них в памяти:

> [!NOTE] Примечание
> Все Listener-объекты должны наследоваться от класса `NSObject`.

```swift
internal class CameraListener: NSObject, YMKMapCameraListener {
    func onCameraPositionChanged(
        with map: YMKMap?,
        cameraPosition: YMKCameraPosition,
        cameraUpdateReason: YMKCameraUpdateReason,
        finished: Bool
    ) {
        // Do something
    }
}

let cameraListener = CameraListener()

override func viewDidLoad() {
    super.viewDidLoad()
    mapView.mapWindow.map!.addCameraListener(with: cameraListener)
}
```

Когда все зависимости установлены, можно приступить к использованию NaviKit SDK в вашем проекте.

В следующем разделе рассмотрена общая архитектура сущностей NaviKit SDK.
