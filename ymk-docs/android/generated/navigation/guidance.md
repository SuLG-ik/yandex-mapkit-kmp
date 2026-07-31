---
title: "Ведение"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / NaviKit SDK / Ведение"
source: "https://yandex.ru/maps-api/docs/mapkit/android/generated/navigation/guidance.html"
---
# Ведение

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/generated/navigation/guidance.html)

[Guidance](../../../com/yandex/mapkit/navigation/automotive/Guidance.md) - содержит информацию о текущей сессии ведения, позволяет подписаться на различные события во время ведения. Для его получения используйте метод [Navigation.getGuidance](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#getguidance).

## Отслеживание локации

По умолчанию, [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md) создается в режиме **suspended**, в котором локация не отслеживается и ведение не работает. Для включения отслеживания текущей локации устройства, чтобы местоположение пользователя оставалось актуальным, используется режим **resumed**.

Для управления режимом слежения за локацией используются методы [Navigation.resume](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#resume) и [Navigation.suspend](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#suspend).

> [!TIP] Совет
> Хорошей практикой является переключение [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md) в режим **suspended** при сворачивании приложение с картой, и переключение в **resumed** при повторном открытии приложения.
>
>
> Не рекомендуется переводить [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md) в режим **suspended** если вы реализуете сценарий [фонового ведения](guidance.md#background-guidance).

## Старт/стоп ведения

Начать ведение по маршруту можно с помощью метода [Navigation.startGuidance](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#startguidancedrivingroute). В качестве единственного аргумента он принимает маршрут, по которому начнется ведение.

Для окончание ведения существует симметричный метод [Navigation.stopGuidance](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#stopguidance).

> [!NOTE] Примечание
> Число возможных активных сессий ведения ограничено. В любой возможный момент времени можно иметь не больше одной запущенной сессии ведения.

## Данные во время ведении

Рассмотрим основные данные, доступ к которым предоставляет [Guidance](../../../com/yandex/mapkit/navigation/automotive/Guidance.md) во время ведения.

- **Текущий маршрут** - [Guidance.getCurrentRoute](../../../com/yandex/mapkit/navigation/automotive/Guidance.md#getcurrentroute) содержит маршрут, по которому в текущий момент активно ведение, либо значение null если ведения нет. В ходе ведения текущий маршрут может быть изменен, если, например, пользователь съехал с маршрута или был выбран другой [альтернативный маршрут](guidance.md#guidance-alternatives).
- **Локация пользователя** - [Guidance.getLocation](../../../com/yandex/mapkit/navigation/automotive/Guidance.md#getlocation) содержит текущую локацию пользователя. Она состоит из координат, определяющих местоположение, текущего направления, точности определения локации, скорости ведения и т.д.
- **Превышение скорости** - [Guidance.getSpeedLimit](../../../com/yandex/mapkit/navigation/automotive/Guidance.md#getspeedlimit) и [Guidance.getSpeedLimitStatus](../../../com/yandex/mapkit/navigation/automotive/Guidance.md#getspeedlimitstatus) предоставляют информацию о максимально разрешенной скорости на данном участке маршрута. [Guidance.getSpeedLimitsPolicy](../../../com/yandex/mapkit/navigation/automotive/Guidance.md#getspeedlimitspolicy) содержит информацию о скоростных ограничений для данного региона в различных местностях (в городе, загородом и на шоссе).

Полный API приведен в документации [Guidance](../../../com/yandex/mapkit/navigation/automotive/Guidance.md).

## Windshield

С помощью сущности [Windshield](../../../com/yandex/mapkit/navigation/automotive/Windshield.md) предоставляется информация о предстоящих маневрах на маршруте, о дорожной разметке и событиях, скоростных ограничениях и указателях.

Для обращения к объекту [Windshield](../../../com/yandex/mapkit/navigation/automotive/Windshield.md) используется метод [Guidance.getWindshield](../../../com/yandex/mapkit/navigation/automotive/Guidance.md#getwindshield).

Состояние сущности [Windshield](../../../com/yandex/mapkit/navigation/automotive/Windshield.md) определяется следующими данным:

- **Маневры** - с помощью [Guidance.getManoeuvres](../../../com/yandex/mapkit/navigation/automotive/Windshield.md#getmanoeuvres) можно получить список предстоящих маневров на маршруте. Каждый маневр описывается позицией на маршруте, его местоположением и объектом [Annotation](../../../com/yandex/mapkit/directions/driving/Annotation.md), который содержит информацию о его типе.
- **Дорожная разметка** - [Guidance.getLaneSigns](../../../com/yandex/mapkit/navigation/automotive/Windshield.md#getlanesigns) возвращает список, где каждый элемент содержит информацию в какой полосе дороги пользователь должен находиться, он характеризуется позицией на маршруте, и объектом [LaneSign](../../../com/yandex/mapkit/directions/driving/LaneSign.md), который определяет вид разметки на данном участке дороги. Объект [LaneSign](../../../com/yandex/mapkit/directions/driving/LaneSign.md) содержит список [Lane](../../../com/yandex/mapkit/directions/driving/Lane.md) с информацией о каждой конкретной полосе дороги, ее направлении, типе и вариантах маневров.
- **Дорожные события** - при помощи [Guidance.getRoadEvents](../../../com/yandex/mapkit/navigation/automotive/Windshield.md#getroadevents) можно получить список предстоящих дорожных событий на маршруте вместе с информацией о скоростных ограничениях.
- **Указатели** - метод [Guidance.getDirectionSigns](../../../com/yandex/mapkit/navigation/automotive/Windshield.md#getdirectionsigns) возвращает список предстоящих указателей на дороге. Например, указатель того, что следующий участок маршрута будет проходить через туннель или через скоростное шоссе.

С помощью [WindshieldListener](../../../com/yandex/mapkit/navigation/automotive/WindshieldListener.md) можно подписаться на события изменения состояния [Windshield](../../../com/yandex/mapkit/navigation/automotive/Windshield.md).

С примером использования [Windshield](../../../com/yandex/mapkit/navigation/automotive/Windshield.md) для реализации UI-компонента, который отображает информацию о следующем маневре и полосной разметке, можно ознакомиться в [демо-приложении](overview.md#demo-app).

## События

В ходе ведения приложения состояние ведения постоянно изменяется. Для подписки на события ведения используется интерфейс [GuidanceListener](../../../com/yandex/mapkit/navigation/automotive/GuidanceListener.md).

```kotlin
val guidanceListener = object : GuidanceListener {
    override fun onLocationChanged() = Unit
    override fun onCurrentRouteChanged(reason: RouteChangeReason) = Unit
    override fun onRouteLost() = Unit
    override fun onReturnedToRoute() = Unit
    override fun onRouteFinished() = Unit
    override fun onWayPointReached() = Unit
    override fun onStandingStatusChanged() = Unit
    override fun onRoadNameChanged() = Unit
    override fun onSpeedLimitUpdated() = Unit
    override fun onSpeedLimitStatusUpdated() = Unit
    override fun onAlternativesChanged() = Unit
    override fun onFastestAlternativeChanged() = Unit
}
guidance.addListener(guidanceListener)
```

[GuidanceListener](../../../com/yandex/mapkit/navigation/automotive/GuidanceListener.md) предоставляет возможность подписаться на события навигации (съезда с маршрута, возвращение к маршруту, достижение промежуточных и конечных точек маршрута) и изменения состояния ведения (текущей локации пользователя, маршрута, названия улицы, информации о лимитах скорости, списка альтернатив и т.д).

## Альтернативы во время ведения

Альтернативные маршруты, которые доступны во время ведения, называются **локальными альтернативами**. Они имеют свойство автоматически перестраиваться. Для подписки на это событие используется метод [GuidanceListener.onAlternativesChanged](../../../com/yandex/mapkit/navigation/automotive/GuidanceListener.md#onalternativeschanged).

Для смены текущего маршрута на альтернативный используется метод [Guidance.switchToRoute](../../../com/yandex/mapkit/navigation/automotive/Guidance.md#switchtoroutedrivingroute).

## Более быстрые альтернативы

Сессия ведения по маршруту может быть очень продолжительной, иногда достигать нескольких часов. В таких случаях маршрут, который был построен на момент начала ведения, через некоторое время может устареть и стать не таким оптимальным. Эта проблема особенно актуальна при ведении в городе, где дорожная ситуация на дороге способна меняться достаточно часто. NaviKit SDK решает данную проблему и предоставляет возможность получить более быстрый альтернативный маршрут.

Метод [Guidance.getFastestAlternative](../../../com/yandex/mapkit/navigation/automotive/Guidance.md#getfastestalternative) возвращает информацию о более быстрой альтернативе во время ведения, если она существует. Начните ведение по такому маршруту, чтобы изменить текущий маршрут на более оптимальный.

При помощи метода-обработчика [GuidanceListener.onFastestAlternativeChanged](../../../com/yandex/mapkit/navigation/automotive/GuidanceListener.md#onfastestalternativechanged) можно подписаться на оповещения об изменении более быстрого маршрута.

## Аннотации

Для настройки голосовых подсказок на маршруте (голосовых аннотаций), используется класс [Annotator](../../../com/yandex/mapkit/navigation/automotive/Annotator.md).

Для включения и выключения аннотаций используются методы [Annotator.mute](../../../com/yandex/mapkit/navigation/automotive/Annotator.md#mute) и [Annotator.unmute](../../../com/yandex/mapkit/navigation/automotive/Annotator.md#unmute).

Чтобы аннотатор начал свою работу необходимо добавить в него делегат - объект с типом [Speaker](../../../com/yandex/mapkit/annotations/Speaker.md), который нужно реализовать самостоятельно.

> [!NOTE] Примечание
> NaviKit SDK не предоставляет свою реализацию [Speaker](../../../com/yandex/mapkit/annotations/Speaker.md).
>
>
> С примером реализации [`Speaker`](../../../com/yandex/mapkit/annotations/Speaker.md) с помощью Android [TextToSpeech](https://developer.android.com/reference/android/speech/tts/TextToSpeech) можно ознакомиться в [демо-приложении](overview.md#demo-app).
>
>
> В [демо-приложении navikit-demo](https://github.com/yandex/mapkit-android-demo) есть предзаписанные аудио-файлы аннотаций на русском и английском языках, а так же пример их использования в приложении. Вы можете переиспользовать эти данные в вашем навигационном приложении.

Язык аннотаций можно изменять при помощи метода [Navigation.setAnnotationLanguage](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#setannotationlanguage).

Аннотации делятся на несколько видов, связанные с дорожными событиями [AnnotatedRoadEvents](../../../com/yandex/mapkit/navigation/automotive/AnnotatedRoadEvents.md) и с предупреждениями на маршруте [AnnotatedEvents](../../../com/yandex/mapkit/navigation/automotive/AnnotatedEvents.md). При помощи методов [Annotator.setAnnotatedRoadEvents](../../../com/yandex/mapkit/navigation/automotive/Annotator.md#setannotatedroadevents) и [Annotator.setAnnotatedEvents](../../../com/yandex/mapkit/navigation/automotive/Annotator.md#setannotatedevents) можно изменять активность отдельных аннотаций.

Существует возможность подписаться на события класса [Annotator](../../../com/yandex/mapkit/navigation/automotive/Annotator.md) с помощью интерфейса [AnnotatorListener](../../../com/yandex/mapkit/navigation/automotive/AnnotatorListener.md). Он оповещает о действиях аннотатора - какой тип события был воспроизведен.

## Восстановление состояния

Существует возможность восстановления состояния ведения при помощи механизма сериализации/десериализации [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md).

1. Сначала сериализуйте [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md), используя метод [NavigationSerialization.serialize](../../../com/yandex/mapkit/navigation/automotive/NavigationSerialization.md#serializenavigation).

   ```kotlin
   val serializedNavigation = NavigationSerialization().serialize(navigation)
   ```
2. Теперь в `serializedNavigation` хранится слепок навигации. Его можно куда-нибудь сохранить, например на диск, а позже восстановить используя десериализацию.
3. С помощью [NavigationSerialization.deserialize](../../../com/yandex/mapkit/navigation/automotive/NavigationSerialization.md#deserializebyte[]) создайте новый инстанс навигации.

   ```kotlin
   val navigation = NavigationSerialization().deserialize(serializedNavigation)
   ```

Таким образом, перед закрытием приложения можно сохранить [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md) на диск, и затем при следующем открытии восстановить его. Так как состояние ведения содержится в [Guidance](../../../com/yandex/mapkit/navigation/automotive/Guidance.md), а ведение является частью [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md), оно тоже восстановится и последняя сессия ведения продолжится.

С примером реализации логики восстановления состояния ведения можно ознакомиться в нашем [демо-приложении](overview.md#demo-app).

## Симуляция ведения

В ходе разработки и тестирования навигационных приложений часто требуется проверить как работает сценарий ведения по маршруту. Для этого можно использовать сторонние средства симуляции локации пользователя или воспользоваться готовым API симуляции из NaviKit SDK.

Cуществует возможность включения симуляции движения по маршруту или произвольной траектории, для этого используется [LocationSimulator](../../../com/yandex/mapkit/location/LocationSimulator.md) класс.

Пример реализации менеджера для симуляции ведения по маршруту:

```kotlin
class SimulationManager {

    private var locationSimulator: LocationSimulator? = null

    private val locationSimulatorListener: LocationSimulatorListener {
        resetSimulation()
    }

    fun startSimulation(route: DrivingRoute) {
        locationSimulator = MapKitFactory.getInstance().createLocationSimulator(route.geometry)
        locationSimulator?.apply {
            subscribeForSimulatorEvents(locationSimulatorListener)
            speed = 20.0
            MapKitFactory.getInstance().setLocationManager(this)
            startSimulation(SimulationAccuracy.COARSE)
        }
    }

    fun resetSimulation() {
        locationSimulator?.unsubscribeFromSimulatorEvents()
        locationSimulator = null
        MapKitFactory.getInstance().resetLocationManagerToDefault()
    }

    fun setSpeed(value: Double) {
        locationSimulator?.speed = value
    }
}
```

Метод `startSimulation` принимает маршрут, по которому должна начаться симуляция ведения. Затем при помощи [MapKit.createLocationSimulator](../../../com/yandex/mapkit/MapKit.md#createlocationsimulatorpolyline) создается новый экземпляр [LocationSimulator](../../../com/yandex/mapkit/location/LocationSimulator.md), который нужно сконфигурировать:

1. подписаться на событие завершения симуляции при помощи [LocationSimulatorListener](../../../com/yandex/mapkit/location/LocationSimulatorListener.md);
2. выставить значение скорости движения во время ведения;
3. заменить реализацию [LocationManager](../../../com/yandex/mapkit/location/LocationManager.md) на только что созданный `locationSimulator`;
4. начать симуляцию.

В `resetSimulation` происходит сброс симуляции. При помощи [MapKit.resetLocationManagerToDefault](../../../com/yandex/mapkit/MapKit.md#resetlocationmanagertodefault) менеджер симуляции локации меняется на вариант по умолчанию, который считывает настоящую позицию пользователя.

Более подробно с примером реализации симуляции по маршруту можно ознакомиться в [демо-приложении](overview.md#demo-app).

## Фоновое ведение

Фоновым ведением называется такая сессия ведения, которая способна продолжаться после скрытия Activity приложения и даже после её уничтожения.

После того, как Activity приложения теряет focus, через некоторое время она может быть уничтожена Android-системой для освобождения ресурсов, после чего приложение может быть завершено в любой момент. Для обеспечения работы Android-приложения даже после смерти Activity, следует использовать [Foreground service](https://developer.android.com/guide/components/foreground-services) - один из базовых компонентов Android-приложения.

Для реализации фонового ведения нужно во время ведения запускать Foreground service, который будет отображать нотификацию. После закрытия Activity, [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md) должен оставаться в режиме **resumed**. В этом случае приложение будет защищено от уничтожения со стороны Android-системы и ведение с голосовыми подсказками будет работать в фоновом режиме.

> [!NOTE] Примечание
> NaviKit SDK не предоставляет сервис для фонового ведения. Для реализации сценария фонового ведение вам потребуется реализовать свой собственный Foreground service с нотификацией.
>
>
> С примером реализации сервиса фонового ведения можно ознакомиться в [демо-приложении](overview.md#demo-app).

## Генерация отчетов навигации

До завершения интеграции NaviKit SDK рекомендуется включить генерирование отчетов навигации. Данные отчеты позволяют проанализировать проблемы локализиции во время движения авто, такие как некорректное определение локации, отстование от фактического положения и т.д.

Для того чтобы включить генерирование отчетов нужно:

1. Добавить в Manifest.xml вашего проекта инструкцию

   ```xml
   <meta-data android:name="yandex.maps.mapkit.navigation.automotive.collect_rep orts" android:value="enabled" />
   ```
2. Добавить функцию для запроса последнего отчета навигации и его записи на файловую систему

   ```kotlin
       fun getReports() {
           val reports = ReportCollectorFactory.getInstance().reports()
           if (reports.isEmpty()) return
           var reportWriter: FileOutputStream?
           if (reports.last().data().size > 0) {
               val file: File = File(DIRECTORY_PATH + REPORTNAME_PREFIX + reports.last().startTime.absoluteValue.toString() + "_" + reports.last().endTime.absoluteValue.toString())
               if (!file.exists()) {
                   file.createNewFile()
               }
               reportWriter = FileOutputStream(file)
               if (reportWriter != null) {
                   reportWriter.write(reports.last().data())
               }
           }
       }
   ```

   > [!NOTE] Примечание
   > Не забудьте предоставить вашему приложения права на запись в файловую систему.
3. Добавить вызов функции записи отчета после завершения навигации (вызова функции [stopGuidance](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#stopguidance))
4. Сгенерированный файл с отчетом и описанием проблемы должны быть переданы менеджеру Яндекс для проведения анализа.

> [!NOTE] Примечание
> Не забудьте отключить генерицию отчетов навигации в релизной версии вашего приложения.
