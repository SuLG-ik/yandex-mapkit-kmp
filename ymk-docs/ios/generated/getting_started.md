---
title: "Начало работы с MapKit для iOS"
kind: "Guide"
platform: "ios"
language: "Swift/Objective-C"
section: "iOS / Начало работы"
source: "https://yandex.ru/maps-api/docs/mapkit/ios/generated/getting_started.html"
---
# Начало работы с MapKit для iOS

`IOS` · `Swift/Objective-C` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/ios/generated/getting_started.html)

В этом руководстве объясняется как установить и настроить библиотеку MapKit и создать карту с меткой для определенной локации.

## Шаг 1. Получите API-ключ для работы с MapKit

Перед тем, как использовать MapKit SDK в своем приложении, вам нужно получить API-ключ.

1. Перейдите в [Кабинет Разработчика](https://developer.tech.yandex.ru/services/).
2. Авторизуйтесь, используя учетную запись Яндекса, или зарегистрируйте новый аккаунт.
3. Нажмите **Подключить API** и выберите **MapKit – мобильный SDK**.
4. Введите информацию о себе и своем проекте, выберите тарифный план и нажмите **Продолжить**.
5. После того, как ваш API-ключ будет успешно создан, он будет доступен на вкладке **Интерфейсы API** → **MapKit – мобильный SDK**.

> [!NOTE] Примечание
> Активация API-ключей занимает около 15 минут.

## Шаг 2. Добавьте библиотеку MapKit в проект

Добавьте библиотеку в проект с помощью CocoaPods.

1. Перейдите в каталог с [Xcode](https://developer.apple.com/xcode/)-проектом.
2. Создайте [Podfile](http://guides.cocoapods.org/using/the-podfile.html) для перечисления зависимостей от других библиотек:

   ```bash
   pod init
   ```
3. Откройте Podfile в текстовом редакторе и добавьте зависимость для своей цели:

   ```
   use_frameworks!
   # Облегченная библиотека, содержит только карту, слой пробок,
   # LocationManager, UserLocationLayer
   # и возможность скачивать офлайн-карты (только в платной версии).
   pod 'YandexMapsMobile', '4.42.0-lite'

   # Полная библиотека в дополнение к lite версии предоставляет автомобильную маршрутизацию,
   # веломаршрутизацию, пешеходную маршрутизацию и маршрутизацию на общественном транспорте,
   # поиск, suggest, геокодирование и отображение панорам.
   # pod 'YandexMapsMobile', '4.42.0-full'
   ```
4. Выполните в каталоге проекта команду:

   ```bash
   pod install
   ```

   Чтобы открыть файл проекта, выполните команду:

   ```bash
   open *.xcworkspace
   ```

## Шаг 3. Добавьте API-ключ для MapKit

Для MapKit SDK необходимо, чтобы вы установили API-ключ с помощью [YMKMapKit(Factory).setApiKey](../../Swift/YMKMapKit%28Factory%29.md##setapikey_).

Задайте ваш API-ключ в методе `application(_:didFinishLaunchingWithOptions:)` делегата приложения и инстанцируйте объект `YMKMapKit`:

```swift
func application(
    _ application: UIApplication,
    didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?
) -> Bool {
    YMKMapKit.setApiKey("Ваш API-ключ")
    YMKMapKit.sharedInstance()
}
```

> [!NOTE] Примечание
> Если вы используете многомодульное приложение и хотите инициализировать MapKit не в `application(_:didFinishLaunchingWithOptions:)`, то после создания объекта MapKit вызовите метод `onStart()`:
>
>
> ```swift
> YMKMapKit.setApiKey("MAPKIT_API_KEY")
> YMKMapKit.sharedInstance().onStart()
> ```

## Шаг 4. Добавьте карту

Инициализируйте карту в контроллере нужного View:

```swift
override func viewDidLoad() {
    super.viewDidLoad()

    mapView.mapWindow.map!.move(
        with: YMKCameraPosition(
            target: YMKPoint(latitude: 55.751225, longitude: 37.62954),
            zoom: 15,
            azimuth: 0,
            tilt: 0
        ),
        animation: YMKAnimation(type: YMKAnimationType.smooth, duration: 5),
        cameraCallback: nil
    )
}
```

Создайте и запустите приложение. Пример приложения с кликабельной картой:

![Карта с наименьшим увеличением](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/getting_started/map.png)

Чтобы изменить положение или масштаб карты, используйте метод [YMKMap.move(with:animation:cameraCallback:)](../../Swift/YMKMap.md#movewithanimationcameracallback):

```swift
private func move(_ map: YMKMap) {
    let cameraPosition = YMKCameraPosition(
        target: YMKPoint(latitude: 55.751225, longitude: 37.62954),
        zoom: 17.0,
        azimuth: 150.0,
        tilt: 30.0
    )

    map.move(with: cameraPosition, animation: YMKAnimation(type: .smooth, duration: 1.0))
}
```

[YMKMap.move(with:animation:cameraCallback:)](../../Swift/YMKMap.md#movewithanimationcameracallback) принимает на вход аргумент [YMKCameraPosition](../../Swift/YMKCameraPosition.md), который полностью задает положение, масштаб, наклон и азимут карты.

Карты по умолчанию поддерживают несколько действий: перемещение, поворот, изменение масштаба и наклон.

Без дополнительной настройки карта будет отображаться с минимально возможным масштабом для экрана пользователя.

Пример карты после изменения положения камеры:

![Карта после применения](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/getting_started/map_after_move.png)

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

> [!NOTE] Примечание
> По умолчанию методы всех Listener-объектов и платформенных интерфейсов вызываются на главном потоке, если в документации метода не сказано обратное.
>
>
> - Для эмулятора под M1 минимальная поддерживая версия: iOS 13.
> - На эмуляторе под M1 не поддерживается OpenGL, поэтому в конструкторы `YMKMapView` и `YMKPanoView` необходимо передавать `vulkanPreferred: true`. Эта настройка требуется только для сборки под эмулятор.
> - Рекомендуемый флаг линковки: `-ObjС`.

## Шаг 6. Отображение метки на карте

Изменим приложение таким образом, чтобы вы могли показывать на карте кликабельную метку.

1. Добавьте в проект ресурс `png` для изображения метки.
   Например, у нас есть **изображение**, названное `placemark_icon.png` в директории `Assets`.
   ![Значок метки](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/getting_started/placemark_icon.png)
2. Добавьте метку для коллекции [YMKMap.mapObjects](../../Swift/YMKMap.md#mapobjects) в определенное место.
   Получите изображение для метки, используя `UIImage(named:)` конструктор.

   ```swift
   private func addPlacemark(_ map: YMKMap) {
       let image = UIImage(named: "placemark_icon") ?? UIImage()
       let placemark = map.mapObjects.addPlacemark()
       placemark.geometry = YMKPoint(latitude: 55.751225, longitude: 37.62954
       placemark.setIconWith(image)
   }
   ```

   Вы также можете добавить текст для метки и кастомизировать его стиль, используя метод [`YMKPlacemarkMapObject.setTextWithText(_:style:)`](../../Swift/YMKPlacemarkMapObject.md#settextwithtext_style):

   ```swift
   placemark.setTextWithText(
       "Sample placemark",
       style: YMKTextStyle(
           size: 10.0,
           color: .black,
           outlineColor: .white,
           placement: .top,
           offset: 0.0,
           offsetFromIcon: true,
           textOptional: false
       )
   )
   ```
3. Чтобы подписаться на нажатия на созданную метку, используйте метод [YMKMapObject.addTapListener(with:)](../../Swift/YMKMapObject.md#addtaplistenerwith).
   Для начала, нам нужно создать класс-обработчик, который имплементирует метод [`YMKMapObjectTapListener.onMapObjectTap(with:point:)`](../../Swift/YMKMapObjectTapListener.md#onmapobjecttapwithpoint):

   ```swift
   final private class MapObjectTapListener: NSObject, YMKMapObjectTapListener {
       init(controller: UIViewController) {
           self.controller = controller
       }

       func onMapObjectTap(with mapObject: YMKMapObject, point: YMKPoint) -> Bool {
           AlertPresenter.present(
               with: "Tapped point",
               message: "\((point.latitude, point.longitude))",
               from: controller
           )
           return true
       }

       private let controller: UIViewController
   }
   ```

   Затем мы можем создать экземпляр класса и назначить его метке:

   ```swift
   private lazy var mapObjectTapListener: YMKMapObjectTapListener = MapObjectTapListener(controller: self)

   private func addPlacemark(_ map: YMKMap) {
       placemark.addTapListener(with: mapObjectTapListener)
   }
   ```

Соберите и запустите приложение. На карте есть метка с вашим изображением. Коснитесь метки, и появится всплывающее сообщение:

![Карта после нажатия метки](https://yandex.ru/maps-api/docs/mapkit/ios/_assets/yandex/getting_started/map_with_placemark_on_tap_message.png)

## Исходный код

Полные примеры кода из руководства вы можете найти в приложении `MapWithPlacemark` в  нашем [репозитории на GitHub](https://github.com/yandex/mapkit-ios-demo).
