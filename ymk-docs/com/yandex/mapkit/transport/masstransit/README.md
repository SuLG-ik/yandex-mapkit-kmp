# `com.yandex.mapkit.transport.masstransit`

Пакет справочника MapKit SDK для Android. Типов: **89**.

[← Ко всей документации](../../../../../README.md) · [Все пакеты Android](../../../../../INDEX-android.md)

## Class (63)

| Тип | Описание |
| --- | --- |
| [Annotation](Annotation.md) | Contains info about actions on part of route. |
| [BoardingArea](BoardingOptions_BoardingArea.md) | Area recommended for boarding: wagon, sector, etc. |
| [BoardingOptions](BoardingOptions.md) | Contains information about underground or railway boarding recommendations. |
| [Closed](TransportThreadAlert_Closed.md) | Thread is not operational on that day. |
| [ClosedUntil](TransportThreadAlert_ClosedUntil.md) | Thread is not operational until specified time. |
| [Connector](Connector.md) | Connectors connect two floors, indoor and outdoor, two indoor plans. |
| [ConstructionMask](ConstructionMask.md) | Constructions that can be found on pedestrian, bicycle paths or on mass transit transfers. |
| [ConstructionSegment](ConstructionSegment.md) | Describes part of pedestrian or bicycle path with the same construction. |
| [DrivingJamsPainter](DrivingJamsPainter.md) |   |
| [DropOffOptions](DropOffOptions.md) | Options about railway station dropoff expectations. |
| [ElevationData](ElevationData.md) | Information of elevation gain in loss in a fitness section |
| [ElevationPoint](ElevationPoint.md) | Information of elevation in point |
| [EssentialStop](EssentialStop.md) | Essential stop on thread |
| [EssentialStopInfo](EssentialStopInfo.md) | Info for essential stop |
| [Fitness](Fitness.md) | Represent a section where we have to move by ourself (like pedestrian, or by bicycle and scooter) |
| [FitnessOptions](FitnessOptions.md) |   |
| [Flags](Flags.md) | Indicates whether the suggested route has one or more of the specified properties. |
| [InclineSection](InclineSection.md) | represents a section of continuous non-trivial gradient |
| [IndoorData](IndoorSegment_IndoorData.md) |   |
| [IndoorLevel](IndoorLevel.md) | Indoor level (floor). |
| [IndoorSegment](IndoorSegment.md) | Indoor segment of the fitness section. |
| [LastTrip](TransportThreadAlert_LastTrip.md) | Last trip for the thread. |
| [Line](Line.md) |   |
| [Payment](Payment.md) |   |
| [PaymentMedia](PaymentMedia.md) |   |
| [RailwayOptions](RailwayOptions.md) | Contains information about boarding to or dropOff from trains. |
| [RestrictedEntriesContainer](RestrictedEntriesContainer.md) | Defines a vector of points on a pedestrian path. |
| [RestrictedEntry](RestrictedEntry.md) | Defines a point on a pedestrian path. |
| [RouteMetadata](RouteMetadata.md) |   |
| [RouteOptions](RouteOptions.md) | Settings for router, which help personalize or optimize routes |
| [RoutePaymentOption](RoutePaymentOption.md) |   |
| [RouteSettings](RouteSettings.md) | Route settings that were used by the mass transit router for a specific route. |
| [RouteStop](RouteStop.md) | Describes a mapkit.transport.masstransit.Stop on a mapkit.transport.masstransit.Route. |
| [RouteStopMetadata](RouteStopMetadata.md) |   |
| [Section](Section.md) | Contains information about an individual section of a mass transit mapkit.transport.masstransit.Route. |
| [SectionData](SectionMetadata_SectionData.md) | A choice of information specific to the section type. |
| [SectionMetadata](SectionMetadata.md) | General information about a section of a route. |
| [SectionPaymentOption](SectionPaymentOption.md) |   |
| [Stairs](Stairs.md) | Represents stairs objects along the route |
| [StairsSummary](StairsSummary.md) | Represents summary info about stairs along the route |
| [Stop](Stop.md) |   |
| [StopFeatureMask](StopFeatureMask.md) | Describes various features a stop can have. |
| [Style](Line_Style.md) | Describes the style of line. |
| [Style](TransportContour_Style.md) | Describes the style of transport contour objects |
| [Summary](Summary.md) | Contains brief information associated with a route constructed by the mass transit router. |
| [Taxi](Taxi.md) | Represents a taxi part of route. |
| [Thread](Thread.md) |   |
| [ThreadStop](ThreadStop.md) | Describes a mapkit.transport.masstransit.Stop on a mapkit.transport.masstransit.Thread. |
| [TimeOptions](TimeOptions.md) | Desired departure/arrival time settings. |
| [Toponym](Toponym.md) |   |
| [TrafficTypeSegment](TrafficTypeSegment.md) | Describes part of bicycle or scooter path with the same traffic type. |
| [Transfer](Transfer.md) | Represents a transfer to another mass transit line or to another stop. |
| [TransferStop](TransferStop.md) | Represents a stop in path which is not a part of any transport trip but must be visited according travelling. |
| [TransitOptions](TransitOptions.md) | User-defined options, like time options and filter options. |
| [Transport](Transport.md) | Contains information about the mass transit ride section of a mapkit.transport.masstransit.Route for a specific mass transit mapkit.transport.masstransit.Line. |
| [TransportContour](TransportContour.md) | Describes transport contours and it's properties |
| [TransportStop](TransportStop.md) | The data about the public transport stop. |
| [TransportThread](Transport_TransportThread.md) | mapkit.transport.masstransit.Thread specific properties of a mass transit ride section of a mapkit.transport.masstransit.Route. |
| [TransportThreadAlert](TransportThreadAlert.md) | TransportThreadAlert are important annotations for mass transit ride sections of routes. |
| [TravelEstimation](TravelEstimation.md) | Arrival and departure time estimations for time-dependent routes or sections of time-dependent routes. |
| [Wait](Wait.md) | Represents a 'wait until suitable tranport arrives' section of a route. |
| [WayPoint](WayPoint.md) | A waypoint is the origin, destination or intermediate destination on the route. |
| [Weight](Weight.md) | Numeric characteristics of a route or a route section. |

## Enum (16)

| Тип | Описание |
| --- | --- |
| [ActionID](ActionID.md) | Action that can be performed |
| [AppliedFare](SectionPaymentOption_AppliedFare.md) |   |
| [ComfortTag](ComfortTag.md) |   |
| [Elevator](Elevator.md) | Elevator direction of moving relative to the route. |
| [Escalator](Escalator.md) | Escalator direction of moving relative to the route. |
| [FilterVehicleTypes](FilterVehicleTypes.md) | Types which are allowed to be used in filters. |
| [FitnessType](FitnessType.md) |   |
| [InclineType](InclineType.md) | Rough estimate of user experience on a specific section of a fitness route |
| [LandmarkID](LandmarkID.md) | Landmark type |
| [MediaType](PaymentMedia_MediaType.md) |   |
| [Pass](Pass.md) |   |
| [StairsDirection](StairsDirection.md) | Stairs direction of moving relative to the route. |
| [ThreadCategory](ThreadCategory.md) |   |
| [TrafficTypeID](TrafficTypeID.md) | TrafficTypeID describes who the road is designed for. |
| [TransportType](TransportType.md) | Transport types |
| [Travolator](Travolator.md) | Travolator direction of moving relative to the route. |

## Interface (10)

| Тип | Описание |
| --- | --- |
| [BicycleRouterV2](BicycleRouterV2.md) | Provides methods for submitting bicycle routing requests. |
| [MasstransitRouter](MasstransitRouter.md) | Provides methods for submitting mass transit routing requests. |
| [MasstransitRouteSerializer](MasstransitRouteSerializer.md) |   |
| [PedestrianRouter](PedestrianRouter.md) | Provides methods for submitting pedestrian routing requests. |
| [Route](Route.md) | Contains information about a route constructed by the mass transit router. |
| [RouteJamsListener](RouteJamsListener.md) | A listener to monitor changes to traffic jams on the route. |
| [RouteListener](RouteListener.md) |   |
| [Session](Session.md) | Handler for an async request for mass transit routes. |
| [SummaryListener](SummaryListener.md) |   |
| [SummarySession](SummarySession.md) | Handler for an async request for a summary of mass transit routes. |
