---
title: "Начало работы с NaviKit SDK"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / NaviKit SDK / Начало работы"
source: "https://yandex.ru/maps-api/docs/mapkit/android/generated/navigation/getting_started.html"
---
# Начало работы с NaviKit SDK

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/generated/navigation/getting_started.html)

Процесс начала работы с NaviKit SDK имеет много сходств с подключением обычного MapKit, однако имеет несколько важных отличий.

## Шаг 1. Получение ключа для работы с NaviKit SDK

Для работы с NaviKit SDK требуется наличие API-ключа.

1. [Создайте новый](../getting_started.md#key) API-ключ для MapKit SDK или используйте существующий.
2. Чтобы API-ключ можно было использовать в приложениях с NaviKit SDK его необходимо активировать. Для этого напишите нам на почту [paid-api-maps@yandex-team.ru](mailto:paid-api-maps@yandex-team.ru).

## Шаг 2. Добавление NaviKit SDK зависимостей

Для использования всех функций, предоставляемых NaviKit SDK, требуется подключение нескольких зависимостей:

1. NaviKit SDK последней доступной версии.

   ```groovy
   implementation 'com.yandex.android:maps.mobile:4.42.0-navikit'
   ```
2. [Google Play services](https://developers.google.com/android/guides/setup) зависимость.

   ```groovy
   implementation 'com.google.android.gms:play-services-location:21.0.1'
   ```
3. Библиотека с реализацией [NavigationStyleProvider](navigation_layer.md#navlayer-style-provider) с фирменными UI элементами Яндекс Карт.

   ```groovy
   implementation 'com.yandex.mapkit.styling:automotivenavigation:4.42.0'
   ```
4. Библиотека с реализацией [StyleProvider](navigation_layer.md#road-events-style-provider) для слоя дорожных событий c фирменными иконками Яндекс Карт.

   ```groovy
   implementation 'com.yandex.mapkit.styling:roadevents:4.42.0'
   ```

Синхронизируйте проект чтобы применить изменения. После успешной синхронизации все зависимости будут добавлены в ваш проект.

## Шаг 3. Разрешение на запрос локации

NaviKit SDK для Android требует [разрешение на запрос локации](https://developer.android.com/training/location/permissions) для отслеживания текущего местоположения устройства.

1. Добавьте в **AndroidManifest** приложения объявление разрешения на использование локации:

   ```xml
   <manifest ... >
       <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
       <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
   </manifest>
   ```
2. [Запросите разрешение](https://developer.android.com/training/location/permissions#request-location-access-runtime) на использование локации у пользователя во время работы приложения.

## Шаг 4. Настройка MapKit SDK

Выполните шаги из [Шаг 3. Добавьте API-ключ для MapKit](../getting_started.md#provide-key): установите ваш API-ключ, инициализируйте MapKit и создайте View с картой.

Если после запуска приложения MapKit карта успешно открылась и ее данные прогрузились, настройки выполнены верно.

## Шаг 5. Обратите внимание при дальнейшей работе

MapKit хранит слабые ссылки на передаваемые ему Listener-объекты. Необходимо самим хранить ссылку на них в памяти:

```kotlin
val cameraListener = CameraListener { _, _, _, _ ->
    // ...
}
mapView.mapWindow.map.addCameraListener(cameraListener)
```

Когда все зависимости установлены, можно приступить к использованию NaviKit SDK в вашем проекте.

В следующем разделе рассмотрена общая архитектура сущностей NaviKit SDK.
