# `com.yandex.mapkit.search`

Пакет справочника MapKit SDK для Android. Типов: **93**.

[← Ко всей документации](../../../../README.md) · [Все пакеты Android](../../../../INDEX-android.md)

## Class (67)

| Тип | Описание |
| --- | --- |
| [Address](Address.md) | Contains structured address, formatted address, postal code and country code. |
| [Availability](Availability.md) | A single value of availability information. |
| [BooleanValue](BusinessFilter_BooleanValue.md) | Value for boolean filters. |
| [BooleanValue](Feature_BooleanValue.md) |   |
| [BusinessFilter](BusinessFilter.md) | A filter that could be applied to search results. |
| [BusinessFilterGroup](BusinessFilterGroup.md) | Group of filters. |
| [BusinessObjectMetadata](BusinessObjectMetadata.md) |   |
| [BusinessPhotoObjectMetadata](BusinessPhotoObjectMetadata.md) |   |
| [BusinessRating1xObjectMetadata](BusinessRating1xObjectMetadata.md) |   |
| [BusinessResultMetadata](BusinessResultMetadata.md) | Common info for business search response. |
| [Category](Category.md) | Single category (also known as rubric) description. |
| [Chain](Chain.md) | Single chain (group of companies) description. |
| [Component](Address_Component.md) | Single address component. |
| [CurrencyExchangeMetadata](CurrencyExchangeMetadata.md) |   |
| [CurrencyExchangeType](CurrencyExchangeType.md) | Single currency exchange prices. |
| [DateRange](FilterCollection_DateRange.md) | Date range. |
| [DateValue](BusinessFilter_DateValue.md) | Value for date filters. |
| [EncyclopediaObjectMetadata](EncyclopediaObjectMetadata.md) |   |
| [Entrance](Entrance.md) | An entrance to a building |
| [EnumValue](BusinessFilter_EnumValue.md) | Value for enum filters. |
| [Feature](Feature.md) | Describes some common feature of organizations. |
| [FeatureEnumValue](Feature_FeatureEnumValue.md) | Value for enumerated features. |
| [FeatureGroup](FeatureGroup.md) | Group of features. |
| [FeatureSet](FeatureSet.md) | Collection of features. |
| [FilterCollection](FilterCollection.md) | Filters for search request. |
| [FilterCollectionUtils](FilterCollectionUtils.md) |   |
| [FilterSet](FilterSet.md) | Collection of filters. |
| [FuelMetadata](FuelMetadata.md) |   |
| [FuelType](FuelType.md) | Fuel name and price. |
| [Item](Properties_Item.md) | Single property item. |
| [Line](Line.md) |   |
| [NumberRange](FilterCollection_NumberRange.md) | Number range. |
| [OrgOwnershipObjectMetadata](OrgOwnershipObjectMetadata.md) |   |
| [Panorama](Panorama.md) | Panorama info. |
| [PanoramasObjectMetadata](PanoramasObjectMetadata.md) |   |
| [ParkingAttributes](ParkingAttributes.md) |   |
| [Phone](Phone.md) | Organization phone. |
| [Photo](BusinessPhotoObjectMetadata_Photo.md) | Information about single photos. |
| [PhotoLink](Photo_BusinessPhotoObjectMetadata_PhotoLink.md) | Photo link details. |
| [PlaceInfo](PlaceInfo.md) | Related place information. |
| [Properties](Properties.md) | Generic key-value property storage. |
| [RangeValue](BusinessFilter_RangeValue.md) | Value for range filters. |
| [ReferencesObjectMetadata](ReferencesObjectMetadata.md) |   |
| [ReferenceType](ReferenceType.md) | The type of reference. |
| [RelatedPlacesObjectMetadata](RelatedPlacesObjectMetadata.md) |   |
| [Response](Response.md) | Top level structure for search response. |
| [ResponseInfo](ToponymResultMetadata_ResponseInfo.md) | Additional response info. |
| [SearchFactory](SearchFactory.md) |   |
| [SearchLink](SearchLink.md) | Link structure. |
| [SearchMetadata](SearchMetadata.md) |   |
| [SearchOptions](SearchOptions.md) | Struct to fine-tune search request. |
| [SearchUtils](SearchUtils.md) |   |
| [Showtime](Showtime.md) | Session details. |
| [ShowtimesObjectMetadata](ShowtimesObjectMetadata.md) |   |
| [Sort](Sort.md) | Describes response sort. |
| [State](State.md) | Describes if an organization is open or closed now. |
| [SubtitleItem](SubtitleItem.md) | Separate subtitle of a certain type. |
| [SubtitleMetadata](SubtitleMetadata.md) |   |
| [SuggestItem](SuggestItem.md) | A single suggested item. |
| [SuggestOptions](SuggestOptions.md) | Struct to fine-tune suggest request. |
| [SuggestResponse](SuggestResponse.md) | A suggest response |
| [TimeRange](TimeRange.md) | The time interval used to compose availability info. |
| [ToponymObjectMetadata](ToponymObjectMetadata.md) |   |
| [ToponymResultMetadata](ToponymResultMetadata.md) |   |
| [Values](BusinessFilter_Values.md) | Possible filter values. |
| [VariantValue](Feature_VariantValue.md) | A variant combining possible feature values. |
| [WorkingHours](WorkingHours.md) | Open hours for an organization. |

## Enum (16)

| Тип | Описание |
| --- | --- |
| [Action](SuggestItem_Action.md) | Action to be performed when user selected suggest item. |
| [BusinessContext](SuggestItem_BusinessContext.md) | More detailed info about type=Business response |
| [Closed](Closed.md) | Company working status. |
| [DayGroup](DayGroup.md) | A group of week days. |
| [DisplayType](DisplayType.md) | Result display type. |
| [Kind](Component_Address_Kind.md) | An address component kind, for example, large administrative area. |
| [PhoneType](PhoneType.md) | Phone type |
| [Precision](Precision.md) | Precision for matching house numbers (response vs. |
| [SearchManagerType](SearchManagerType.md) | Search manager type. |
| [SearchMode](ToponymResultMetadata_SearchMode.md) | Search mode. |
| [SearchType](SearchType.md) | Bitmask for requested search types. |
| [Snippet](Snippet.md) | Requested snippets bitmask. |
| [SortOrigin](SortOrigin.md) | Sort origin types when results are ordered by distance (see mapkit.search.SortType). |
| [SortType](SortType.md) | Sort type as returned in response. |
| [SuggestType](SuggestType.md) | Bitmask for requested suggest types. |
| [Type](SuggestItem_Type.md) | Suggest item type. |

## Interface (10)

| Тип | Описание |
| --- | --- |
| [CacheUnavailableError](CacheUnavailableError.md) |   |
| [DeleteAllPersonalSuggestSession](DeleteAllPersonalSuggestSession.md) | Interface to handle remove all user personalized suggest request. |
| [FilterCollectionBuilder](FilterCollectionBuilder.md) | Builder for filter collection. |
| [PersonalSuggestListener](PersonalSuggestListener.md) |   |
| [Search](Search.md) |   |
| [SearchListener](SearchListener.md) |   |
| [SearchManager](SearchManager.md) | Main interface to start search. |
| [Session](Session.md) | Interface denoting ongoing search session. |
| [SuggestListener](SuggestListener.md) |   |
| [SuggestSession](SuggestSession.md) |   |
