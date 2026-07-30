---
title: "Yandex MapKit и NaviKit SDK"
kind: "Guide"
platform: "common"
section: "О MapKit"
source: "https://yandex.ru/maps-api/docs/mapkit/index.html"
---
# Yandex MapKit и NaviKit SDK

`MapKit` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/index.html)

Yandex MapKit и NaviKit SDK — это кроссплатформенные библиотеки, которые позволяют использовать возможности Яндекс.Карт в мобильных приложениях для iOS и Android.

![](https://yandex.ru/maps-api/docs/mapkit/_assets/logo.png)

## Возможности MapKit

MapKit позволяет создать приложение с картами Яндекса для операционных систем iOS и Android. В таком приложении можно использовать поиск по организациям и топонимам, строить автомобильные и пешеходные маршруты с учетом актуальной дорожной ситуации, а также отображать информацию о пробках или панорамы.

На созданной с помощью MapKit карте будут появляться строящиеся дома, новые дороги и развязки, недавно открытые организации. На ней будут доступны все те изменения, которые вносятся на Яндекс Карты.

**Список возможностей**

- Получить доступ к картам Яндекса с последними обновлениями.
- Проложить автомобильный маршрут с учетом дорожной ситуации.
- Проложить пешеходный маршрут или маршрут с использованием общественного транспорта.
- Отобразить пробки на карте.
- Получить данные о топонимах и организациях.

## Возможности NaviKit

NaviKit SDK позволяет добавить в ваше приложение навигацию, которая работает в режиме реального времени с поддержкой голосовых подсказок.
Помимо того, что NaviKit SDK включает в себя все возможности MapKit SDK, также поддерживается дополнительный функционал, связанный с навигацией.

**Список возможностей**

- Сценарий ведения с голосовыми подсказками по маршруту.
- Предупреждения о ближайших маневрах на маршруте.
- Поддержка различных сценариев работы с камерой на карте, например обзор маршрутов и слежение за меткой пользователя.
- Отображение информации и голосовые уведомления о камерах контроля скорости.
- Отображение маршрутов на карте с информацией о пробках, дорожных событиях и ограничениях.
- Построение маршрутов с учетом ограничений и особенностей для различных транспортных средств: автомобилей, грузовиков, мотоциклов и такси.
- Просмотр альтернативных маршрутов.

## Тарифы MapKit

С тарифами MapKit вы можете ознакомиться по [ссылке](https://yandex.ru/maps-api/products/mapkit#tariffs).

## Условия использования NaviKit

В настоящее время функциональность NaviKit SDK доступна только по запросу.
Чтобы оставить запрос на подключение напишите нам на [paid-api-maps@yandex-team.ru](mailto:paid-api-maps@yandex-team.ru).

## Поддерживаемые платформы

Для стабильной работы MapKit требуется:

- Android API 26 (Android 8.0 "Oreo") или выше. Поддерживаются как Java, так и Kotlin.
- iOS 13 или выше.

## Начало работы

- [Как начать работу с MapKit для Android](android/generated/getting_started.md)
- [Как начать работу с MapKit для iOS](ios/generated/getting_started.md)
- [Как начать работу с MapKit для Flutter](flutter/generated/getting_started.md)
- [Как начать работу с NaviKit для Android](android/generated/navigation/getting_started.md)
- [Как начать работу с NaviKit для iOS](ios/generated/navigation/getting_started.md)
- [Как начать работу с NaviKit для Flutter](flutter/generated/navigation/getting_started.md)
- [Поиск по карте в MapKit](https://habr.com/ru/company/yandex/blog/428564/)

## Примеры использования

### Android

[MapKit и NaviKit для Android](https://search.maven.org/artifact/com.yandex.android/maps.mobile)

[Примеры](https://github.com/yandex/mapkit-android-demo)

### iOS

[MapKit и NaviKit для iOS](https://github.com/CocoaPods/Specs/tree/master/Specs/d/d/0/YandexMapsMobile)

[Примеры](https://github.com/yandex/mapkit-ios-demo)

### Flutter

[MapKit для Flutter](https://pub.dev/packages/yandex_maps_mapkit)

[MapKit Lite для Flutter](https://pub.dev/packages/yandex_maps_mapkit_lite)

[NaviKit для Flutter](https://pub.dev/packages/yandex_maps_navikit)

[Примеры](https://github.com/yandex/mapkit-flutter-demo)
