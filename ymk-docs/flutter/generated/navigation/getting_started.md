---
title: "Начало работы с NaviKit SDK"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / NaviKit SDK / Начало работы"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/navigation/getting_started.html"
---
# Начало работы с NaviKit SDK

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/navigation/getting_started.html)

Процесс начала работы с NaviKit SDK имеет много сходств с подключением обычного MapKit, однако имеет несколько важных отличий.

## Шаг 1. Получение ключа для работы с NaviKit SDK

Для работы с NaviKit SDK требуется наличие API-ключа.

1. [Создайте новый](../getting_started.md#key) API-ключ для MapKit SDK или используйте существующий.
2. Чтобы API-ключ можно было использовать в приложениях с NaviKit SDK его необходимо активировать. Для этого напишите нам на почту [paid-api-maps@yandex-team.ru](mailto:paid-api-maps@yandex-team.ru).

## Шаг 2. Добавление NaviKit SDK зависимостей

Для использования всех функций, предоставляемых NaviKit SDK, требуется подключение нескольких зависимостей:

1. Добавьте в `pubspec.yaml` Navikit SDK:

   ```yaml
   dependencies:
     yandex_maps_navikit:
       version: ^4.42.0
   ```
2. После этого добавьте платформенные библиотеки с реализацией интерфейсов [NavigationStyleProvider](navigation_layer.md#navlayer-style-provider) и [RoadEventsStyleProvider](navigation_layer.md#road-events-style-provider), которые предоставляют фирменные UI-элементы Яндекс Карт и иконки для слоя дорожных событий соответственно:
   Для **Android** добавьте зависимости в `./android/app/build.gradle`:

   ```groovy
   implementation 'com.yandex.mapkit.styling:automotivenavigation:4.42.0'
   implementation 'com.yandex.mapkit.styling:roadevents:4.42.0'
   ```

   Для **iOS** добавьте зависимости в `./ios/Podflie`:

   ```ruby
   platform :ios, '13.0'

   target 'Runner' do
     pod 'YMKStylingAutomotiveNavigation', '4.42.0'
     pod 'YMKStylingRoadEvents', '4.42.0'
   end
   ```
3. Выполните `pub get`, чтобы синхронизировать проект и применить изменения

## Шаг 3. Разрешение на запрос локации

Navikit SDK требует разрешение на запрос локации как на [Android](https://developer.android.com/develop/sensors-and-location/location/permissions), так и на [iOS](https://support.apple.com/HT203033)

1. Добавьте в **Android Manifest**, находящийся в `./android/app/main`, объявление разрешения на использование локации:

   ```xml
   <manifest ... >
       <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
       <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
   </manifest>
   ```
2. Для объявления разрешения на использование локации в **iOS** найдите в конце файла `./ios/Podfile` секцию кода, которая содержит информацию:

   ```ruby
   post_install do |installer|
       installer.pods_project.targets.each do |target|
           flutter_additional_ios_build_settings(target)
           ...
   ```

   И добавьте туда разрешение на использование локации, чтобы секция с кодом имела следующий вид:

   ```ruby
   post_install do |installer|
     installer.pods_project.targets.each do |target|
       flutter_additional_ios_build_settings(target)

       target.build_configurations.each do |config|

         config.build_settings['GCC_PREPROCESSOR_DEFINITIONS'] ||= [
           '$(inherited)',
           ## dart: [PermissionGroup.location, PermissionGroup.locationAlways, PermissionGroup.locationWhenInUse]
           'PERMISSION_LOCATION=1',
         ]
       end
     end
   end
   ```

   После этого добавьте в `./ios/Runner/Info.plist` следующую информацию:

   ```xml
   <key>NSLocationWhenInUseUsageDescription</key>
   <string>Your location is required for navigation</string>
   ```
3. Запросите разрешение на использование локации у пользователя во время работы приложения. Сделать это можно, например, при помощи пакета [permission_handler](https://pub.dev/packages/permission_handler).

## Шаг 4. Настройка MapKit SDK

Выполните шаги из [Шаг 3. Добавьте API-ключ для MapKit](../getting_started.md#provide-key): установите ваш API-ключ, инициализируйте MapKit и создайте View с картой.

Если после запуска приложения MapKit карта успешно открылась и ее данные прогрузились, настройки выполнены верно.

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

Когда все зависимости установлены, можно приступить к использованию NaviKit SDK в вашем проекте.

В следующем разделе рассмотрена общая архитектура сущностей NaviKit SDK.
