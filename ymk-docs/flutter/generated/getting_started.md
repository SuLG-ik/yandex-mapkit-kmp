---
title: "Начало работы с MapKit для Flutter"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / Начало работы"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/getting_started.html"
---
# Начало работы с MapKit для Flutter

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/getting_started.html)

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

Библиотека MapKit SDK доступна в репозитории [pub.dev](https://pub.dev/packages/yandex_maps_mapkit_lite).

1. [Создайте](https://docs.flutter.dev/get-started/test-drive?tab=vscode) новый проект или откройте существующий, например, в [Visual Studio Code](https://code.visualstudio.com/) или [Android Studio](http://developer.android.com/intl/ru/tools/studio/index.html).
2. Откройте файл `pubspec.yaml` **приложения (модуля)**. В секции `dependencies` добавьте зависимость:

   ```yaml
   dependencies:
     # Облегченная библиотека, содержит только карту, слой пробок,
     # LocationManager, UserLocationLayer
     # и возможность скачивать офлайн-карты (только в платной версии).
     yandex_maps_mapkit_lite:
       version: ^4.42.0

     # Полная библиотека в дополнение к lite версии предоставляет автомобильную маршрутизацию,
     # веломаршрутизацию, пешеходную маршрутизацию и маршрутизацию на общественном транспорте,
     # поиск, suggest, геокодирование и отображение панорам.
     # yandex_maps_mapkit:
     #   version: ^4.42.0
   ```
3. Выполните `pub get`, чтобы синхронизировать проект и применить изменения.
   Если синхронизация завершилась успешно, при компиляции библиотека будет добавлена в проект автоматически.
4. Добавьте платформенные зависимости в `./android/app/build.gradle`:

   ```groovy
   implementation "com.google.android.gms:play-services-location:21.1.0"

   // Зависимость Work Manager . Вам нужно добавить ее, если Вы хотите использовать офлайн карты
   // implementation "androidx.work:work-runtime:2.9.0"
   ```

## Шаг 3. Добавьте API-ключ для MapKit

Для MapKit SDK необходимо, чтобы вы инициализировали библиотеку и установили API-ключ с помощью функции [initMapkit](https://pub.dev/documentation/yandex_maps_navikit/latest/init/initMapkit.html).

Рекомендуем сделать это в вашей `main()` функции:

```dart
import 'package:yandex_maps_mapkit_lite/init.dart' as init;

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  await init.initMapkit(
    apiKey: 'YOUR_API_KEY'
  );
}
```

> [!WARNING] Важно
> С помощью вызова `init.initMapkit(String apiKey)` загружаются все необходимые для MapKit нативные библиотеки.

Если вы не хотите, чтобы ваш API-ключ хранился файле, который будет включен в **систему контроля версий**, вы можете сделать это одним из способов:

1. Определите флаг времени компиляции:

   ```bash
   flutter run --dart-define MAPKIT_API_KEY=your_api_key
   ```

   И используйте его так:

   ```dart
   import 'package:yandex_maps_mapkit_lite/init.dart' as init;

   void main() async {
     WidgetsFlutterBinding.ensureInitialized();

     final mapkitApiKey = String.fromEnvironment('MAPKIT_API_KEY');

     await init.initMapkit(
       apiKey: mapkitApiKey
     );
   }
   ```
2. Используйте пакет [ENVied](https://pub.dev/packages/envied) или создайте отдельный `.dart` файл, в котором будет находиться глобальная переменная, содержащая API-ключ.

> [!NOTE] Примечание
> Убедитесь, что файлы, содержающие API-ключи, игнорируются вашей **системой контроля версий**.

## Шаг 4. Добавьте карту

1. Добавьте [YandexMap](https://pub.dev/documentation/yandex_maps_navikit/latest/yandex_map/YandexMap-class.html) в дерево виджетов:

   ```dart
   void main() async {
     WidgetsFlutterBinding.ensureInitialized();

     await init.initMapkit(
       apiKey: 'YOUR_API_KEY'
     );
     mapkit.onStart();

     runApp(const MyApp());
   }

   class MyApp extends StatefulWidget {
     const MyApp({super.key});

     @override
     State<MyApp> createState() => _MyAppState();
   }

   class _MyAppState extends State<MyApp> {

     MapWindow? _mapWindow;

     @override
     Widget build(BuildContext context) {
       return MaterialApp(
         home: Scaffold(
           body: YandexMap(onMapCreated: (mapWindow) => _mapWindow = mapWindow)
         )
       );
     }
   }
   ```
2. Когда карта становится видимой или невидимой для пользователя, отправляйте события `onStart` и `onStop` в Mapkit при помощи методов [mapkit.onStart()](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapKit/onStart.html) и [mapkit.onStop()](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapKit/onStop.html) соответственно.<br>
   Иначе Mapkit не сможет отображать карту и прекратит ее обработку, когда приложение с картой станет невидимым для пользователя.

Создайте и запустите приложение. Пример приложения с кликабельной картой:

![Карта с наименьшим увеличением](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/getting_started/map.png)

Чтобы изменить положение или масштаб карты, используйте метод [Map.moveWithAnimation](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/moveWithAnimation.html):

```dart
map.move(
  CameraPosition(
    Point(latitude: 55.751225, longitude: 37.62954),
    zoom: 17.0,
    azimuth: 150.0,
    tilt: 30.0
  )
);
```

[Map.moveWithAnimation](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/moveWithAnimation.html) принимает на вход аргумент [CameraPosition](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/CameraPosition-class.html), который полностью задает положение, масштаб, наклон и азимут карты.

Карты по умолчанию поддерживают несколько действий: перемещение, поворот, изменение масштаба и наклон.

Без дополнительной настройки карта будет отображаться с минимально возможным масштабом для экрана пользователя.

Пример карты после изменения положения камеры:

![Карта после применения](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/getting_started/map_after_move.png)

## Шаг 5. Обратите внимание при дальнейшей работе

MapKit хранит слабые ссылки на передаваемые ему Listener-объекты. Необходимо самим хранить ссылку на них в памяти:

```dart
final class MapCameraListenerImpl implements MapCameraListener {
  // ......
}

final class SomeMapScopedClass {

  final MapWindow _mapWindow;
  final MapCameraListener _cameraListener = MapCameraListenerImpl();

  SomeMapScopedClass(this._mapWindow);

  void addListener() {
    _mapWindow.map.addCameraListener(_cameraListener);
  }
}
```

> [!NOTE] Примечание
> По умолчанию методы всех Listener-объектов и платформенных интерфейсов вызываются на главном потоке, если в документации метода не сказано обратное.

## Шаг 6. Отображение метки на карте

Изменим приложение таким образом, чтобы вы могли показывать на карте кликабельную метку.

1. Добавьте в проект ресурс `png` для изображения метки.
   Например, есть **изображение**, и оно доступно по идентификатору `assets/ic_pin.png`.
   ![Значок метки](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/getting_started/placemark_icon.png)
2. Добавьте метку для коллекции [Map.mapObjects](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/mapObjects.html) в определенное место.
   Используйте [ImageProvider.fromImageProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/image/ImageProvider/ImageProvider.fromImageProvider.html), чтобы создать экземпляр [ImageProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/image/ImageProvider-class.html) для изображения метки.

   ```dart
   final imageProvider = ImageProvider.fromImageProvider(const AssetImage("assets/ic_pin.png"));
   final placemark = mapWindow.map.mapObjects.addPlacemark()
     ..geometry = const Point(latitude: 55.751225, longitude: 37.62954)
     ..setIcon(imageProvider);
   ```
3. Чтобы подписаться на нажатия на созданную метку, используйте метод [MapObject.addTapListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObject/addTapListener.html).

   ```dart
   final class MapObjectTapListenerImpl implements MapObjectTapListener {

     @override
     bool onMapObjectTap(MapObject mapObject, Point point) {
       showSnackBar("Tapped the placemark: Point(latitude: ${point.latitude}, longitude: ${point.longitude})");
       return true;
     }
   }

   final listener = MapObjectTapListenerImpl();
   placemark.addTapListener(listener);
   ```

Соберите и запустите приложение. На карте есть метка с вашим изображением. Коснитесь метки, и появится всплывающее сообщение:

![Карта после нажатия метки](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/getting_started/map_with_placemark_on_tap_message.png)

## Исходный код

Полные примеры кода из руководства вы можете найти в приложении `map_objects` в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-flutter-demo).
