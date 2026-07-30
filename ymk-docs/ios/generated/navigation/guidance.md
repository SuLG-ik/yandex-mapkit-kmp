---
title: "Ведение"
kind: "Guide"
platform: "ios"
language: "Swift/Objective-C"
section: "iOS / NaviKit SDK / Ведение"
source: "https://yandex.ru/maps-api/docs/mapkit/ios/generated/navigation/guidance.html"
---
# Ведение

`IOS` · `Swift/Objective-C` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/ios/generated/navigation/guidance.html)

[YMKGuidance](../../../Swift/YMKGuidance.md) - содержит информацию о текущей сессии ведения, позволяет подписаться на различные события во время ведения. Для его получения используйте метод [YMKNavigation.guidance](../../../Swift/YMKNavigation.md#guidance).

## Отслеживание локации

По умолчанию, [YMKNavigation](../../../Swift/YMKNavigation.md) создается в режиме **suspended**, в котором локация не отслеживается и ведение не работает. Для включения отслеживания текущей локации устройства, чтобы местоположение пользователя оставалось актуальным, используется режим **resumed**.

Для управления режимом слежения за локацией используются методы [YMKNavigation.resume()](../../../Swift/YMKNavigation.md#resume) и [YMKNavigation.suspend()](../../../Swift/YMKNavigation.md#suspend).

> [!TIP] Совет
> Хорошей практикой является переключение [YMKNavigation](../../../Swift/YMKNavigation.md) в режим **suspended** при сворачивании приложение с картой, и переключение в **resumed** при повторном открытии приложения.
>
>
> Не рекомендуется переводить [YMKNavigation](../../../Swift/YMKNavigation.md) в режим **suspended** если вы реализуете сценарий [фонового ведения](guidance.md#background-guidance).

## Старт/стоп ведения

Начать ведение по маршруту можно с помощью метода [YMKNavigation.startGuidance(with:)](../../../Swift/YMKNavigation.md#startguidancewith). В качестве единственного аргумента он принимает маршрут, по которому начнется ведение.

Для окончание ведения существует симметричный метод [YMKNavigation.stopGuidance()](../../../Swift/YMKNavigation.md#stopguidance).

> [!NOTE] Примечание
> Число возможных активных сессий ведения ограничено. В любой возможный момент времени можно иметь не больше одной запущенной сессии ведения.

## Данные во время ведении

Рассмотрим основные данные, доступ к которым предоставляет [YMKGuidance](../../../Swift/YMKGuidance.md) во время ведения.

- **Текущий маршрут** - [YMKGuidance.currentRoute()](../../../Swift/YMKGuidance.md#currentroute) содержит маршрут, по которому в текущий момент активно ведение, либо значение null если ведения нет. В ходе ведения текущий маршрут может быть изменен, если, например, пользователь съехал с маршрута или был выбран другой [альтернативный маршрут](guidance.md#guidance-alternatives).
- **Локация пользователя** - [YMKGuidance.location](../../../Swift/YMKGuidance.md#location) содержит текущую локацию пользователя. Она состоит из координат, определяющих местоположение, текущего направления, точности определения локации, скорости ведения и т.д.
- **Превышение скорости** - [YMKGuidance.speedLimit](../../../Swift/YMKGuidance.md#speedlimit) и [YMKGuidance.speedLimitStatus](../../../Swift/YMKGuidance.md#speedlimitstatus) предоставляют информацию о максимально разрешенной скорости на данном участке маршрута. [YMKGuidance.speedLimitsPolicy](../../../Swift/YMKGuidance.md#speedlimitspolicy) содержит информацию о скоростных ограничений для данного региона в различных местностях (в городе, загородом и на шоссе).

Полный API приведен в документации [YMKGuidance](../../../Swift/YMKGuidance.md).

## Windshield

С помощью сущности [YMKNavigationWindshield](../../../Swift/YMKNavigationWindshield.md) предоставляется информация о предстоящих маневрах на маршруте, о дорожной разметке и событиях, скоростных ограничениях и указателях.

Для обращения к объекту [YMKNavigationWindshield](../../../Swift/YMKNavigationWindshield.md) используется метод [YMKGuidance.windshield](../../../Swift/YMKGuidance.md#windshield).

Состояние сущности [YMKNavigationWindshield](../../../Swift/YMKNavigationWindshield.md) определяется следующими данным:

- **Маневры** - с помощью [YMKGuidance.Manoeuvres](../../../Swift/YMKNavigationWindshield.md#manoeuvres) можно получить список предстоящих маневров на маршруте. Каждый маневр описывается позицией на маршруте, его местоположением и объектом [YMKDrivingAnnotation](../../../Swift/YMKDrivingAnnotation.md), который содержит информацию о его типе.
- **Дорожная разметка** - [YMKGuidance.laneSigns](../../../Swift/YMKNavigationWindshield.md#lanesigns) возвращает список, где каждый элемент содержит информацию в какой полосе дороги пользователь должен находиться, он характеризуется позицией на маршруте, и объектом [YMKDrivingLaneSign](../../../Swift/YMKDrivingLaneSign.md), который определяет вид разметки на данном участке дороги. Объект [YMKDrivingLaneSign](../../../Swift/YMKDrivingLaneSign.md) содержит список [YMKDrivingLane](../../../Swift/YMKDrivingLane.md) с информацией о каждой конкретной полосе дороги, ее направлении, типе и вариантах маневров.
- **Дорожные события** - при помощи [YMKGuidance.roadEvents](../../../Swift/YMKNavigationWindshield.md#roadevents) можно получить список предстоящих дорожных событий на маршруте вместе с информацией о скоростных ограничениях.
- **Указатели** - метод [YMKGuidance.directionSigns](../../../Swift/YMKNavigationWindshield.md#directionsigns) возвращает список предстоящих указателей на дороге. Например, указатель того, что следующий участок маршрута будет проходить через туннель или через скоростное шоссе.

С помощью [YMKNavigationWindshieldListener](../../../Swift/YMKNavigationWindshieldListener.md) можно подписаться на события изменения состояния [YMKNavigationWindshield](../../../Swift/YMKNavigationWindshield.md).

С примером использования [YMKNavigationWindshield](../../../Swift/YMKNavigationWindshield.md) для реализации UI-компонента, который отображает информацию о следующем маневре и полосной разметке, можно ознакомиться в [демо-приложении](overview.md#demo-app).

## События

В ходе ведения приложения состояние ведения постоянно изменяется. Для подписки на события ведения используется интерфейс [YMKGuidanceListener](../../../Swift/YMKGuidanceListener.md).

```swift
class GuidanceListener: NSObject, YMKGuidanceListener {
    func onLocationChanged() {}
    func onCurrentRouteChanged(with reason: YMKRouteChangeReason) {}
    func onRouteLost() {}
    func onReturnedToRoute() {}
    func onRouteFinished() {}
    func onWayPointReached() {}
    func onStandingStatusChanged() {}
    func onRoadNameChanged() {}
    func onSpeedLimitUpdated() {}
    func onSpeedLimitStatusUpdated() {}
    func onAlternativesChanged() {}
    func onFastestAlternativeChanged() {}
}
let guidanceListener = GuidanceListener()
guidance.addListener(with: guidanceListener)
```

[YMKGuidanceListener](../../../Swift/YMKGuidanceListener.md) предоставляет возможность подписаться на события навигации (съезда с маршрута, возвращение к маршруту, достижение промежуточных и конечных точек маршрута) и изменения состояния ведения (текущей локации пользователя, маршрута, названия улицы, информации о лимитах скорости, списка альтернатив и т.д).

## Альтернативы во время ведения

Альтернативные маршруты, которые доступны во время ведения, называются **локальными альтернативами**. Они имеют свойство автоматически перестраиваться. Для подписки на это событие используется метод [YMKGuidanceListener.onAlternativesChanged()](../../../Swift/YMKGuidanceListener.md#onalternativeschanged).

Для смены текущего маршрута на альтернативный используется метод [YMKGuidance.switchToRoute(with:)](../../../Swift/YMKGuidance.md#switchtoroutewith).

## Более быстрые альтернативы

Сессия ведения по маршруту может быть очень продолжительной, иногда достигать нескольких часов. В таких случаях маршрут, который был построен на момент начала ведения, через некоторое время может устареть и стать не таким оптимальным. Эта проблема особенно актуальна при ведении в городе, где дорожная ситуация на дороге способна меняться достаточно часто. NaviKit SDK решает данную проблему и предоставляет возможность получить более быстрый альтернативный маршрут.

Метод [YMKGuidance.fastestAlternative](../../../Swift/YMKGuidance.md#fastestalternative) возвращает информацию о более быстрой альтернативе во время ведения, если она существует. Начните ведение по такому маршруту, чтобы изменить текущий маршрут на более оптимальный.

При помощи метода-обработчика [YMKGuidanceListener.onFastestAlternativeChanged()](../../../Swift/YMKGuidanceListener.md#onfastestalternativechanged) можно подписаться на оповещения об изменении более быстрого маршрута.

## Аннотации

Для настройки голосовых подсказок на маршруте (голосовых аннотаций), используется класс [YMKAnnotator](../../../Swift/YMKAnnotator.md).

Для включения и выключения аннотаций используются методы [YMKAnnotator.mute()](../../../Swift/YMKAnnotator.md#mute) и [YMKAnnotator.unmute()](../../../Swift/YMKAnnotator.md#unmute).

Чтобы аннотатор начал свою работу необходимо добавить в него делегат - объект с типом [YMKSpeaker](../../../Swift/YMKSpeaker.md), который нужно реализовать самостоятельно.

> [!NOTE] Примечание
> NaviKit SDK не предоставляет свою реализацию [YMKSpeaker](../../../Swift/YMKSpeaker.md).
>
>
> С примером реализации [`YMKSpeaker`](../../../Swift/YMKSpeaker.md) с помощью iOS [AVSpeechSynthesizer](https://developer.apple.com/documentation/avfaudio/avspeechsynthesizer) можно ознакомиться в [демо-приложении](overview.md#demo-app).

Язык аннотаций можно изменять при помощи метода [YMKNavigation.annotationLanguage](../../../Swift/YMKNavigation.md#annotationlanguage).

Аннотации делятся на несколько видов, связанные с дорожными событиями [YMKAnnotatedRoadEvents](../../../Swift/YMKAnnotatedRoadEvents.md) и с предупреждениями на маршруте [YMKAnnotatedEvents](../../../Swift/YMKAnnotatedEvents.md). При помощи методов [YMKAnnotator.annotatedRoadEvents](../../../Swift/YMKAnnotator.md#annotatedroadevents) и [YMKAnnotator.annotatedEvents](../../../Swift/YMKAnnotator.md#annotatedevents) можно изменять активность отдельных аннотаций.

Существует возможность подписаться на события класса [YMKAnnotator](../../../Swift/YMKAnnotator.md) с помощью интерфейса [YMKAnnotatorListener](../../../Swift/YMKAnnotatorListener.md). Он оповещает о действиях аннотатора - какой тип события был воспроизведен.

## Восстановление состояния

Существует возможность восстановления состояния ведения при помощи механизма сериализации/десериализации [YMKNavigation](../../../Swift/YMKNavigation.md).

1. Сначала сериализуйте [YMKNavigation](../../../Swift/YMKNavigation.md), используя метод [YMKNavigationSerialization.serialize(_:)](../../../Swift/YMKNavigationSerialization.md#serialize_).

   ```swift
   let serializedNavigation = YMKNavigationSerialization().serialize(navigation)
   ```
2. Теперь в `serializedNavigation` хранится слепок навигации. Его можно куда-нибудь сохранить, например на диск, а позже восстановить используя десериализацию.
3. С помощью [YMKNavigationSerialization.deserialize(_:)](../../../Swift/YMKNavigationSerialization.md#deserialize_) создайте новый инстанс навигации.

   ```swift
   let navigation = YMKNavigationSerialization().deserialize(serializedNavigation)
   ```

Таким образом, перед закрытием приложения можно сохранить [YMKNavigation](../../../Swift/YMKNavigation.md) на диск, и затем при следующем открытии восстановить его. Так как состояние ведения содержится в [YMKGuidance](../../../Swift/YMKGuidance.md), а ведение является частью [YMKNavigation](../../../Swift/YMKNavigation.md), оно тоже восстановится и последняя сессия ведения продолжится.

С примером реализации логики восстановления состояния ведения можно ознакомиться в нашем [демо-приложении](overview.md#demo-app).

## Симуляция ведения

В ходе разработки и тестирования навигационных приложений часто требуется проверить как работает сценарий ведения по маршруту. Для этого можно использовать сторонние средства симуляции локации пользователя или воспользоваться готовым API симуляции из NaviKit SDK.

Cуществует возможность включения симуляции движения по маршруту или произвольной траектории, для этого используется [YMKLocationSimulator](../../../Swift/YMKLocationSimulator.md) класс.

Пример реализации менеджера для симуляции ведения по маршруту:

```swift
class SimulationManager: NSObject, YMKLocationSimulatorListener {

    // MARK: - Public methods

    func startSimulation(route: YMKDrivingRoute) {
        locationSimulator = YMKMapKit.sharedInstance().createLocationSimulator(withGeometry: route.geometry)

        locationSimulator.subscribeForSimulatorEvents(with: self)
        locationSimulator.speed = 20.0

        YMKMapKit.sharedInstance().setLocationManagerWith(locationSimulator)

        locationSimulator.startSimulation(with: .coarse)
    }

    func resetSimulation() {
        locationSimulator?.unsubscribeFromSimulatorEvents(with: self)
        locationSimulator = nil
        YMKMapKit.sharedInstance().resetLocationManagerToDefault()
    }

    func setSpeed(value: Double) {
        locationSimulator?.speed = speed
    }

    // MARK: - Private properties

    private var locationSimulator: YMKLocationSimulator!
}
```

Метод `startSimulation` принимает маршрут, по которому должна начаться симуляция ведения. Затем при помощи [YMKMapKit.createLocationSimulator(withGeometry:)](../../../Swift/YMKMapKit.md#createlocationsimulatorwithgeometry) создается новый экземпляр [YMKLocationSimulator](../../../Swift/YMKLocationSimulator.md), который нужно сконфигурировать:

1. подписаться на событие завершения симуляции при помощи [YMKLocationSimulatorListener](../../../Swift/YMKLocationSimulatorListener.md);
2. выставить значение скорости движения во время ведения;
3. заменить реализацию [YMKLocationManager](../../../Swift/YMKLocationManager.md) на только что созданный `locationSimulator`;
4. начать симуляцию.

В `resetSimulation` происходит сброс симуляции. При помощи [YMKMapKit.resetLocationManagerToDefault()](../../../Swift/YMKMapKit.md#resetlocationmanagertodefault) менеджер симуляции локации меняется на вариант по умолчанию, который считывает настоящую позицию пользователя.

Более подробно с примером реализации симуляции по маршруту можно ознакомиться в [демо-приложении](overview.md#demo-app).

## Фоновое ведение

Фоновым ведением называется такая сессия ведения, которая способна продолжаться после того, как приложение перешло в фоновый режим.

После того, как приложение переходит в фоновый режим, система iOS может завершить работу приложения для освобождения ресурсов. Для обеспечения работы iOS-приложения в фоне, можено использовать механизм отслеживания локации устройства.

Для реализации фонового ведения подпишитесь на изменения локации устройства, когда приложение перейдет в фоновый режим. После закрытия приложения [YMKNavigation](../../../Swift/YMKNavigation.md) должен оставаться в режиме **resumed**. В этом случае приложение будет защищено от уничтожения со стороны iOS-системы и ведение с голосовыми подсказками будет работать в фоновом режиме.

> [!NOTE] Примечание
> NaviKit SDK не осуществляет подписку на локацию, следовательно, не обеспечивает работу приложения в фоновом режиме. Для реализации сценария фонового ведение вам потребуется реализовать подписку на локацию самостоятельно.
>
>
> С примером реализации сервиса фонового ведения можно ознакомиться в [демо-приложении](overview.md#demo-app).
