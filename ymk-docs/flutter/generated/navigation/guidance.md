---
title: "Ведение"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / NaviKit SDK / Ведение"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/navigation/guidance.html"
---
# Ведение

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/navigation/guidance.html)

[Guidance](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance-class.html) - содержит информацию о текущей сессии ведения, позволяет подписаться на различные события во время ведения. Для его получения используйте метод [Navigation.guidance](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/guidance.html).

## Отслеживание локации

По умолчанию, [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html) создается в режиме **suspended**, в котором локация не отслеживается и ведение не работает. Для включения отслеживания текущей локации устройства, чтобы местоположение пользователя оставалось актуальным, используется режим **resumed**.

Для управления режимом слежения за локацией используются методы [Navigation.resume](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/resume.html) и [Navigation.suspend](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/suspend.html).

> [!TIP] Совет
> Хорошей практикой является переключение [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html) в режим **suspended** при сворачивании приложение с картой, и переключение в **resumed** при повторном открытии приложения.
>
>
> Не рекомендуется переводить [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html) в режим **suspended** если вы реализуете сценарий [фонового ведения](guidance.md#background-guidance).

## Старт/стоп ведения

Начать ведение по маршруту можно с помощью метода [Navigation.startGuidance](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/startGuidance.html). В качестве единственного аргумента он принимает маршрут, по которому начнется ведение.

Для окончание ведения существует симметричный метод [Navigation.stopGuidance](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/stopGuidance.html).

> [!NOTE] Примечание
> Число возможных активных сессий ведения ограничено. В любой возможный момент времени можно иметь не больше одной запущенной сессии ведения.

## Данные во время ведении

Рассмотрим основные данные, доступ к которым предоставляет [Guidance](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance-class.html) во время ведения.

- **Текущий маршрут** - [Guidance.currentRoute](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance/currentRoute.html) содержит маршрут, по которому в текущий момент активно ведение, либо значение null если ведения нет. В ходе ведения текущий маршрут может быть изменен, если, например, пользователь съехал с маршрута или был выбран другой [альтернативный маршрут](guidance.md#guidance-alternatives).
- **Локация пользователя** - [Guidance.location](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance/location.html) содержит текущую локацию пользователя. Она состоит из координат, определяющих местоположение, текущего направления, точности определения локации, скорости ведения и т.д.
- **Превышение скорости** - [Guidance.speedLimit](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance/speedLimit.html) и [Guidance.speedLimitStatus](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance/speedLimitStatus.html) предоставляют информацию о максимально разрешенной скорости на данном участке маршрута. [Guidance.speedLimitsPolicy](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance/speedLimitsPolicy.html) содержит информацию о скоростных ограничений для данного региона в различных местностях (в городе, загородом и на шоссе).

Полный API приведен в документации [Guidance](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance-class.html).

## Windshield

С помощью сущности [NavigationWindshield](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationWindshield-class.html) предоставляется информация о предстоящих маневрах на маршруте, о дорожной разметке и событиях, скоростных ограничениях и указателях.

Для обращения к объекту [NavigationWindshield](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationWindshield-class.html) используется метод [Guidance.windshield](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance/windshield.html).

Состояние сущности [NavigationWindshield](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationWindshield-class.html) определяется следующими данным:

- **Маневры** - с помощью [NavigationWindshield.manoeuvres](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationWindshield/manoeuvres.html) можно получить список предстоящих маневров на маршруте. Каждый маневр описывается позицией на маршруте, его местоположением и объектом [DrivingAnnotation](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingAnnotation-class.html), который содержит информацию о его типе.
- **Дорожная разметка** - [NavigationWindshield.laneSigns](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationWindshield/laneSigns.html) возвращает список, где каждый элемент содержит информацию в какой полосе дороги пользователь должен находиться, он характеризуется позицией на маршруте, и объектом [DrivingLaneSign](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingLaneSign-class.html), который определяет вид разметки на данном участке дороги. Объект [DrivingLaneSign](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingLaneSign-class.html) содержит список [DrivingLane](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingLane-class.html) с информацией о каждой конкретной полосе дороги, ее направлении, типе и вариантах маневров.
- **Дорожные события** - при помощи [NavigationWindshield.roadEvents](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationWindshield/roadEvents.html) можно получить список предстоящих дорожных событий на маршруте вместе с информацией о скоростных ограничениях.
- **Указатели** - метод [NavigationWindshield.directionSigns](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationWindshield/directionSigns.html) возвращает список предстоящих указателей на дороге. Например, указатель того, что следующий участок маршрута будет проходить через туннель или через скоростное шоссе.

С помощью [NavigationWindshieldListener](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationWindshieldListener-class.html) можно подписаться на события изменения состояния [NavigationWindshield](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationWindshield-class.html).

С примером использования [NavigationWindshield](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationWindshield-class.html) для реализации UI-компонента, который отображает информацию о следующем маневре и полосной разметке, можно ознакомиться в [демо-приложении](overview.md#demo-app).

## События

В ходе ведения приложения состояние ведения постоянно изменяется. Для подписки на события ведения используется интерфейс [GuidanceListener](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/GuidanceListener-class.html).

```dart
final class GuidanceListenerImpl implements GuidanceListener {

  @override
  void onAlternativesChanged() {}

  @override
  void onCurrentRouteChanged(RouteChangeReason reason) {}

  @override
  void onFastestAlternativeChanged() {}

  @override
  void onLocationChanged() {}

  @override
  void onReturnedToRoute() {}

  @override
  void onRoadNameChanged() {}

  @override
  void onRouteFinished() {}

  @override
  void onRouteLost() {}

  @override
  void onSpeedLimitStatusUpdated() {}

  @override
  void onSpeedLimitUpdated() {}

  @override
  void onStandingStatusChanged() {}

  @override
  void onWayPointReached() {}
}

final GuidanceListener listener = GuidanceListenerImpl();
guidance.addListener(listener);
```

[GuidanceListener](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/GuidanceListener-class.html) предоставляет возможность подписаться на события навигации (съезда с маршрута, возвращение к маршруту, достижение промежуточных и конечных точек маршрута) и изменения состояния ведения (текущей локации пользователя, маршрута, названия улицы, информации о лимитах скорости, списка альтернатив и т.д).

## Альтернативы во время ведения

Альтернативные маршруты, которые доступны во время ведения, называются **локальными альтернативами**. Они имеют свойство автоматически перестраиваться. Для подписки на это событие используется метод [GuidanceListener.onAlternativesChanged](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/GuidanceListener/onAlternativesChanged.html).

Для смены текущего маршрута на альтернативный используется метод [Guidance.switchToRoute](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance/switchToRoute.html).

## Более быстрые альтернативы

Сессия ведения по маршруту может быть очень продолжительной, иногда достигать нескольких часов. В таких случаях маршрут, который был построен на момент начала ведения, через некоторое время может устареть и стать не таким оптимальным. Эта проблема особенно актуальна при ведении в городе, где дорожная ситуация на дороге способна меняться достаточно часто. NaviKit SDK решает данную проблему и предоставляет возможность получить более быстрый альтернативный маршрут.

Метод [Guidance.fastestAlernative](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance/fastestAlternative.html) возвращает информацию о более быстрой альтернативе во время ведения, если она существует. Начните ведение по такому маршруту, чтобы изменить текущий маршрут на более оптимальный.

При помощи метода-обработчика [GuidanceListener.onFastestAlternativeChanged](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/GuidanceListener/onFastestAlternativeChanged.html) можно подписаться на оповещения об изменении более быстрого маршрута.

## Аннотации

Для настройки голосовых подсказок на маршруте (голосовых аннотаций), используется класс [Annotator](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Annotator-class.html).

Для включения и выключения аннотаций используются методы [Annotator.mute](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Annotator/mute.html) и [Annotator.unmute](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Annotator/unmute.html).

Чтобы аннотатор начал свою работу необходимо добавить в него делегат - объект с типом [Speaker](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Speaker-class.html), который нужно реализовать самостоятельно.

> [!NOTE] Примечание
> NaviKit SDK не предоставляет свою реализацию [Speaker](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Speaker-class.html).

Язык аннотаций можно изменять при помощи метода [Navigation.annotationLanguage](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/annotationLanguage.html).

Аннотации делятся на несколько видов, связанные с дорожными событиями [AnnotatedRoadEvents](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/AnnotatedRoadEvents-class.html) и с предупреждениями на маршруте [AnnotatedEvents](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/AnnotatedEvents-class.html). При помощи методов [Annotator.annotatedRoadEvents](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Annotator/annotatedRoadEvents.html) и [Annotator.annotatedEvents](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Annotator/annotatedEvents.html) можно изменять активность отдельных аннотаций.

Существует возможность подписаться на события класса [Annotator](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Annotator-class.html) с помощью интерфейса [AnnotatorListener](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/AnnotatorListener-class.html). Он оповещает о действиях аннотатора - какой тип события был воспроизведен.

## Восстановление состояния

Существует возможность восстановления состояния ведения при помощи механизма сериализации/десериализации [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html).

1. Сначала сериализуйте [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html), используя метод [NavigationSerialization.serialize](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationSerialization/serialize.html).

   ```dart
   final serializedNavigation = NavigationSerialization.serialize(navigation);
   ```
2. Теперь в `serializedNavigation` хранится слепок навигации. Его можно куда-нибудь сохранить, например на диск, а позже восстановить используя десериализацию.
3. С помощью [NavigationSerialization.deserialize](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationSerialization/deserialize.html) создайте новый инстанс навигации.

   ```dart
   final navigation = NavigationSerialization.deserialize(serializedNavigation);
   ```

Таким образом, перед закрытием приложения можно сохранить [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html) на диск, и затем при следующем открытии восстановить его. Так как состояние ведения содержится в [Guidance](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance-class.html), а ведение является частью [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html), оно тоже восстановится и последняя сессия ведения продолжится.

С примером реализации логики восстановления состояния ведения можно ознакомиться в нашем [демо-приложении](overview.md#demo-app).

## Симуляция ведения

В ходе разработки и тестирования навигационных приложений часто требуется проверить как работает сценарий ведения по маршруту. Для этого можно использовать сторонние средства симуляции локации пользователя или воспользоваться готовым API симуляции из NaviKit SDK.

Cуществует возможность включения симуляции движения по маршруту или произвольной траектории, для этого используется [LocationSimulator](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/LocationSimulator-class.html) класс.

Пример реализации менеджера для симуляции ведения по маршруту:

```dart
final class SimulationManager {

  LocationSimulator? _locationSimulator;

  late final _locationSimulatorListener = LocationSimulatorListenerImpl(stopSimulation);

  @override
  void startSimulation(DrivingRoute route) {
    _locationSimulator = mapkit.createLocationSimulatorWithGeometry(route.geometry)
      ..subscribeForSimulatorEvents(_locationSimulatorListener)
      ..speed = 20.0;

    _locationSimulator?.let((it) {
      mapkit.setLocationManager(it);
      it.startSimulation(SimulationAccuracy.Coarse);
    });
  }

  void resetSimulation() {
    _locationSimulator?.unsubscribeFromSimulatorEvents(_locationSimulatorListener);
    _locationSimulator = null;
    mapkit.resetLocationManagerToDefault();
  }

  void setSpeed(double speed) {
    _locationSimulator?.speed = speed;
  }
}
```

```dart
final class LocationSimulatorListenerImpl implements LocationSimulatorListener {

  final void Function() _onSimulationFinished;

  const LocationSimulatorListenerImpl(this._onSimulationFinished);

  @override
  void onSimulationFinished() => _onSimulationFinished();
}

extension LetExtension<T> on T {
  R let<R>(R Function(T it) block) => block(this);
}
```

Метод `startSimulation` принимает маршрут, по которому должна начаться симуляция ведения. Затем при помощи [mapkit.createLocationSimulatorWithGeometry](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapKit/createLocationSimulatorWithGeometry.html) создается новый экземпляр [LocationSimulator](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/LocationSimulator-class.html), который нужно сконфигурировать:

1. подписаться на событие завершения симуляции при помощи [LocationSimulatorListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/LocationSimulatorListener-class.html);
2. выставить значение скорости движения во время ведения;
3. заменить реализацию [LocationManager](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/LocationManager-class.html) на только что созданный `locationSimulator`;
4. начать симуляцию.

В `resetSimulation` происходит сброс симуляции. При помощи [mapkit.resetLocationManagerToDefault](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapKit/resetLocationManagerToDefault.html) менеджер симуляции локации меняется на вариант по умолчанию, который считывает настоящую позицию пользователя.

Более подробно с примером реализации симуляции по маршруту можно ознакомиться в [демо-приложении](overview.md#demo-app).

## Фоновое ведение

Фоновым ведением называется такая сессия ведения, которая способна продолжаться после скрытия приложения и даже после уничтожения его процесса.

После того, как приложение теряет фокус, через некоторое время оно может быть уничтожено системой для освобождения ресурсов.

> [!NOTE] Примечание
> NaviKit SDK не предоставляет сервис для фонового ведения. Для реализации сценария фонового ведение вам потребуется реализовать свой собственный Foreground service с нотификацией.
