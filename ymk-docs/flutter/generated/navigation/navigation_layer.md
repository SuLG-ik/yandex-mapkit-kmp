---
title: "Слой навигации"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / NaviKit SDK / Слой навигации"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/navigation/navigation_layer.html"
---
# Слой навигации

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/navigation/navigation_layer.html)

[NavigationLayer](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayer-class.html) в NaviKit SDK представляет собой дополнительный слой на карте, который включает в себя пользовательский интерфейс (маршруты, точки маршрута, метка пользователя и баллуны) и логику их отображения. Кроме того, [NavigationLayer](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayer-class.html) предоставляет API камеры, которое позволяет изменять положение карты на основе различных навигационных сценариев, например: слежение за меткой пользователя, обзор всего маршрута и свободный режим.

## Создание

Используйте метод [NavigationLayerFactory.createNavigationLayer](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayerFactory/createNavigationLayer.html) для создания нового экземпляра навигационного слоя.

```dart
final navigationLayerManager = NavigationLayerFactory.createNavigationLayer(
  mapWindow,
  roadEventsLayer,
  navigationStyleProvider,
  navigation
);
```

Процесс создания `navigation` - [тут](routes_building.md#navigation-create).

После создания [NavigationLayer](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayer-class.html) при включенном [отслеживании локации](guidance.md#location-tracking) у [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html), на карте отобразиться метка с текущим местоположением пользователя.

## NavigationStyleProvider

Отображение UI-элементов на навигационном слое карты определяется при помощи интерфейса [NavigationStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationStyleProvider-class.html).

С помощью реализации [NavigationStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationStyleProvider-class.html) можно настроить стили отображения отдельных UI-элементов с помощью реализации нужного провайдера стилей:

- Полилинии маршрута - [NavigationRouteViewStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationRouteViewStyleProvider-class.html).
- Баллуны альтернатив и маневров - [NavigationBalloonImageProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationBalloonImageProvider-class.html).
- Точки маршрута - [NavigationRequestPointStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationRequestPointStyleProvider-class.html).
- Модель пользовательской метки - [NavigationUserPlacemarkStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationUserPlacemarkStyleProvider-class.html).
- Метки на маршруте - [NavigationRoutePinsStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationRoutePinsStyleProvider-class.html), включает в себя метки светофоров и предупреждения на маршруте.

Класс `AutomotiveNavigationStyleProvider` - это готовая реализация итерфейса [NavigationStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationStyleProvider-class.html), которая содержит UI-элементы в фирменном стиле Яндекс Карт. Она поставляется в виде [отдельной зависимости](getting_started.md#add-dependencies).

Для того, чтобы изменить некоторые стили UI-элементов, можно реализовать новый [NavigationStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationStyleProvider-class.html), используя `AutomotiveNavigationStyleProvider` в качестве делегата:

```dart
final class NavigationStyleProviderImpl extends AutomotiveNavigationStyleProvider {

  final NavigationRouteViewStyleProvider _routeViewStyleProvider = RouteViewStyleProviderImpl(super.routeViewStyleProvider());

  @override
  NavigationRouteViewStyleProvider routeViewStyleProvider() => _routeViewStyleProvider;
}

final class RouteViewStyleProviderImpl implements NavigationRouteViewStyleProvider {

  final NavigationRouteViewStyleProvider _styleProvider;

  RouteViewStyleProviderImpl(this._styleProvider);

  @override
  void provideRouteStyle(
    DrivingFlags flags,
    bool isSelected,
    bool isNightMode,
    NavigationRouteStyle routeStyle
  ) {
    _styleProvider.provideRouteStyle(flags, isSelected, isNightMode, routeStyle);
    routeStyle.setShowJams(isSelected);
  }

  // ......
}
```

Таким образом, можно реализовать отдельный провайдер стилей для линии маршрута [NavigationRouteViewStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationRouteViewStyleProvider-class.html) и изменить стиль отображения пробок на маршрутах. Для остальных UI-элементов используется стандартная реализация с помощью делегата `AutomotiveNavigationStyleProvider`.

Стили из [NavigationStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationStyleProvider-class.html) обновляются на каждый вызов [NavigationLayer.refreshStyle](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayer/refreshStyle.html).

Подробнее с примером реализации [NavigationStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationStyleProvider-class.html) можно ознакомиться в [демо-приложении](overview.md#demo-app).

## Маршруты

Слой навигации отвечает за отображение маршрутов, которые хранятся в [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html).

![](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/navigation/navigation_layer/navigation_layer_routes.png)

### Отображение маршрутов

Слой навигации способен отображать маршруты на карте. Отрисовка маршрутов происходит по следующему сценарию:

1. При создании [NavigationLayer](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayer-class.html) в него передается объект [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html), с помощью которого слой подписывается на состояние навигации и отслеживает изменение маршрутов в нем. Например, после [запроса маршрутов](routes_building.md#request-routes) с помощью обработчика событий [NavigationListener.onRoutesRequested](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationListener/onRoutesRequested.html) навигация сообщает, что маршрут был запрошен и слой переводит камеру в режим обзора маршрутов.
2. Затем навигация сообщает об успешном получении маршрутов, происходит вызов метода [NavigationListener.onRoutesBuilt](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationListener/onRoutesBuilt.html) и слой отображает маршруты на карте по обновленным данным.

Таким образом, слой навигации отлеживает состояние маршрутов внутри [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html), отображает их на карте и при необходимости перерисовывает.

### Мгновенное ведение

Чтобы пропустить этап сравнения альтернативных маршрутов в режиме обзора маршрутов и начать ведение по первому найденному маршруту следует [начинать ведение](guidance.md#guidance-start-stop) сразу же после получения результатов [запроса маршрутов](routes_building.md#request-routes) в методе обработчике события [NavigationListener.onRoutesBuilt](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationListener/onRoutesBuilt.html).

При этом, в момент когда маршруты уже были запрошены, но ведение еще не началось, можно заметить "промаргивание" UI-маршрутов. Чтобы этого избежать нужно скрыть UI навигационного слоя до начала ведения по маршруту. Например, используя метод [NavigationLayer.isVisible](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayer/isVisible.html), или спрятать линии маршрута используя переопределение стилей через [NavigationStyleProvider](navigation_layer.md#style-provider).

### Режим отображения

[NavigationLayer.mode](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayer/mode.html) позволяет узнать в каком режиме в данный момент находится слой навигации:

- [RouteSelection](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayerMode.html#RouteSelection) - режим обзора.
- [Guidance](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayerMode.html#Guidance) - режим ведения.

### Текущий маршрут

[NavigationLayer](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayer-class.html) хранит информацию о текущем выбранном маршруте. При помощи вызова [NavigationLayer.selectRoute](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayer/selectRoute.html) можно изменить текущий выбранный маршрут в режиме обзора.

Пример назначения текущего маршрута:

```dart
final class RouteViewListenerImpl implements RouteViewListener {

  final NavigationLayer _navigationLayer;

  const RouteViewListenerImpl(this._navigationLayer);

  @override
  void onRouteViewTap(RouteView routeView) {
    switch (_navigationLayer.routesSource) {
      case RoutesSource.Navigation:
        _navigationLayer.selectRoute(route: routeView);
      case RoutesSource.Guidance:
        _navigationLayer.navigation.guidance.switchToRoute(routeView.route);
    }
  }

  @override
  void onRouteViewsChanged() {
    final route = _navigationLayer.routes.firstOrNull;
    if (_navigationLayer.selectedRoute() != null || route == null) {
      return;
    }
    _navigationLayer.selectRoute(route: route);
  }
}

final RouteViewListener listener = RouteViewListenerImpl(navigationLayer);
navigationLayer.addRouteViewListener(listener);
```

Для подписки на состояние маршрутов на карте навигационного слоя используется интерфейс [RouteViewListener](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/RouteViewListener-class.html).

- [RouteViewListener.onRouteViewsChanged](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/RouteViewListener/onRouteViewsChanged.html) сообщает об изменении маршрутов в [NavigationLayer](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayer-class.html), если выбранный маршрут отсутствует, то будет выбран самый быстрый (первый) маршрут.
- [RouteViewListener.onRouteViewTap](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/RouteViewListener/onRouteViewTap.html) обрабатывает событие нажатия на линию маршрута на карте.

> [!NOTE] Примечание
> По умолчанию после [запроса маршрутов](routes_building.md#request-routes) через [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html) текущий маршрут в навигационном слое отсутствует, поэтому его нужно назначить вручную, например, с помощью [RouteViewListener.onRouteViewsChanged](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/RouteViewListener/onRouteViewsChanged.html).

## Точки маршрута

Слой навигации отвечает за отображение *from*, *to* и *via* точек во время ведения и обзора маршрута.

Для подписки на изменение точек и их нажатия используется интерфейс [RequestPointListener](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/RequestPointListener-class.html).

![](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/navigation/navigation_layer/route_points.png)

## Пользовательская метка

Пользовательской меткой называют модель на карте, которая отвечает за отображение текущей локации пользователя и направления его движения. Модель состоит из файла `.OBJ` и текстуры в формате `.PNG`.

![](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/navigation/navigation_layer/placemark.png)

## Баллуны

Баллуны представляют собой UI-элементы на карте с надписью. Существует несколько видов баллунов:

- *баллун маневра* во время ведения указывает на положение следующего маневра на маршруте;
- *баллун альтернативы* показывает информацию о маршруте во время обзора, содержит информацию о сравнении текущего и выбранного маршрута.

![](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/navigation/navigation_layer/balloons_overview.png) ![](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/navigation/navigation_layer/balloons_guidance.png)

Для подписки на события, связанные с баллунами, используется интерфейс [BalloonViewListener](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/BalloonViewListener-class.html).

## Камера

Управление камерой происходит с помощью объета [Camera](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Camera-class.html), который можно получить используя вызов [NavigationLayer.camera](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayer/camera.html).

Переключение режимов камеры происходит с помощью метода [Camera.setCameraMode](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Camera/setCameraMode.html). Поддерживаются следующие типы режимов:

- Following - режим слежения камеры за меткой пользователя во время ведения.
- Overview - обзор запрошенных маршрутов.
- Free - режим по умолчанию.

По умолчанию [Camera](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Camera-class.html) имеет полный контроль над картой и автоматически изменяет состояние камеры. При реализации специальных режимов камеры может быть полезно ограничить контроль камеры.

При помощи методов [Camera](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Camera-class.html) и [NavigationLayer](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationLayer-class.html) можно изменять следующие параметры камеры:

- автоматическое приближение камеры;
- автоматический поворот камеры;
- автоматическое переключение режимов камеры;
- параметр корректировки приближения во время ведения;
- включение/отключение 2D режима камеры.

При создании комплексного интерфейса поверх карты UI-элементы могут перекрывать некоторые области карты. Для того, чтобы это избежать существует возможность настроить параметры видимой области карты.

Поддержаны следующие настройки видимой области карты:

- [Camera.setOverviewRect](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Camera/setOverviewRect.html) - определяет область карты, в пределах которой будут отображены маршруты в режиме обзора.
- [Camera.setExtraOverviewPoints](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Camera/setExtraOverviewPoints.html) - задает список точек, которые должны быть видны на карте при переходе в режим обзора.

# Слой дорожных событий

Дорожные события - это информация о различных событиях, которые могут происходить на дорогах. Это могут быть сведения о дорожных происшествиях, ограничениях движения, ремонтных работах, камерах контроля скорости и т.д. Полный список доступных дорожных событий можно найти в перечислении [RoadEventsEventTag](https://pub.dev/documentation/yandex_maps_navikit/latest/yandex_map/YandexMap-class.html).

Слой дорожных событий способен отображать дорожные события на маршруте в виде иконок.

![](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/navigation/road_events_layer/road_events_in_overview.png) ![](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/navigation/road_events_layer/road_events_in_guidance.png)

## RoadEventsLayerStyleProvider

Для кастомизации отображения дорожных событий используется интерфейс [RoadEventsLayerStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/RoadEventsLayerStyleProvider-class.html).

Существует готовая реализация [RoadEventsLayerStyleProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/RoadEventsLayerStyleProvider-class.html), которая предоставляет стили и ресурсы иконок дорожных событий в фирменном стиле Яндекс Карт. Подробнее о подключении данной зависимости можно почитать [по ссылке](getting_started.md#add-dependencies).
