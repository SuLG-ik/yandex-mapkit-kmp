---
title: "BusinessObjectMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / BusinessObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessObjectMetadata.html"
---
# BusinessObjectMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.BusinessObjectMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class BusinessObjectMetadata implements BaseMetadata, Serializable`

Extended information about company.

## Summary

### Constructors

**Signature and Description**

```java
BusinessObjectMetadata()
```

Use constructor with parameters in your code.

```java
BusinessObjectMetadata(@NonNull java.lang.String oid,
                       @NonNull java.lang.String name,
                       @NonNull Address address,
                       @NonNull java.util.List<Category> categories,
                       @NonNull java.util.List<Phone> phones,
                       @Nullable WorkingHours workingHours,
                       @Nullable Precision precision,
                       @NonNull java.util.List<Feature> features,
                       @Nullable FeatureSet importantFeatures,
                       @NonNull java.util.List<SearchLink> links,
                       @Nullable LocalizedValue distance,
                       @NonNull java.util.List<Chain> chains,
                       @Nullable Closed closed,
                       @Nullable java.lang.Boolean unreliable,
                       @Nullable java.lang.String seoname,
                       @Nullable java.lang.String shortName,
                       @Nullable Properties properties,
                       @NonNull java.util.List<FeatureGroup> featureGroups,
                       @Nullable java.lang.String indoorLevel)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getOid()`<br>Permanent company id. |
| `synchronized java.lang.String` | `getName()`<br>Company name. |
| `synchronized Address` | `getAddress()`<br>Company address. |
| `synchronized java.util.List<Category>` | `getCategories()`<br>List of categories associated with the company. |
| `synchronized java.util.List<Phone>` | `getPhones()`<br>List of phone numbers for the company. |
| `synchronized WorkingHours` | `getWorkingHours()`<br>Open hours for the company. |
| `synchronized Precision` | `getPrecision()`<br>Address precision for the company. |
| `synchronized java.util.List<Feature>` | `getFeatures()`<br>List of features for the company. |
| `synchronized FeatureSet` | `getImportantFeatures()`<br>Collection of features that probably are of utmost interest to the user. |
| `synchronized java.util.List<SearchLink>` | `getLinks()`<br>List of links for the company. |
| `synchronized LocalizedValue` | `getDistance()`<br>Optional distance to the company from geometry provided in request. |
| `synchronized java.util.List<Chain>` | `getChains()`<br>List of chains associated with the company. |
| `synchronized Closed` | `getClosed()`<br>Company status, present if it is closed. |
| `synchronized java.lang.Boolean` | `getUnreliable()`<br>If true, company information is not reliable. |
| `synchronized java.lang.String` | `getSeoname()`<br>Technical field for SEO (transliterated and simplified company name). |
| `synchronized java.lang.String` | `getShortName()`<br>Short company name. |
| `synchronized Properties` | `getProperties()`<br>Additional company properties. |
| `synchronized java.util.List<FeatureGroup>` | `getFeatureGroups()`<br>List of feature groups for the company. |
| `synchronized java.lang.String` | `getIndoorLevel()`<br>Indoor level id (obsolete). |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### BusinessObjectMetadata

```java
BusinessObjectMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### BusinessObjectMetadata

```java
BusinessObjectMetadata(@NonNull java.lang.String oid,
                       @NonNull java.lang.String name,
                       @NonNull Address address,
                       @NonNull java.util.List<Category> categories,
                       @NonNull java.util.List<Phone> phones,
                       @Nullable WorkingHours workingHours,
                       @Nullable Precision precision,
                       @NonNull java.util.List<Feature> features,
                       @Nullable FeatureSet importantFeatures,
                       @NonNull java.util.List<SearchLink> links,
                       @Nullable LocalizedValue distance,
                       @NonNull java.util.List<Chain> chains,
                       @Nullable Closed closed,
                       @Nullable java.lang.Boolean unreliable,
                       @Nullable java.lang.String seoname,
                       @Nullable java.lang.String shortName,
                       @Nullable Properties properties,
                       @NonNull java.util.List<FeatureGroup> featureGroups,
                       @Nullable java.lang.String indoorLevel)
```

## Methods

### getOid

```java
@NonNull
java.lang.String getOid()
```

Permanent company id.

### getName

```java
@NonNull
java.lang.String getName()
```

Company name.

### getAddress

```java
@NonNull
Address getAddress()
```

Company address.

### getCategories

```java
@NonNull
java.util.List<Category> getCategories()
```

List of categories associated with the company.

### getPhones

```java
@NonNull
java.util.List<Phone> getPhones()
```

List of phone numbers for the company.

### getWorkingHours

```java
@Nullable
WorkingHours getWorkingHours()
```

Open hours for the company.

Optional field, can be null.

### getPrecision

```java
@Nullable
Precision getPrecision()
```

Address precision for the company.

Optional field, can be null.

### getFeatures

```java
@NonNull
java.util.List<Feature> getFeatures()
```

List of features for the company.

### getImportantFeatures

```java
@Nullable
FeatureSet getImportantFeatures()
```

Collection of features that probably are of utmost interest to the user.

Optional field, can be null.

### getLinks

```java
@NonNull
java.util.List<SearchLink> getLinks()
```

List of links for the company.

### getDistance

```java
@Nullable
LocalizedValue getDistance()
```

Optional distance to the company from geometry provided in request.

Optional field, can be null.

### getChains

```java
@NonNull
java.util.List<Chain> getChains()
```

List of chains associated with the company.

### getClosed

```java
@Nullable
Closed getClosed()
```

Company status, present if it is closed.

Optional field, can be null.

### getUnreliable

```java
@Nullable
java.lang.Boolean getUnreliable()
```

If true, company information is not reliable.

Optional field, can be null.

### getSeoname

```java
@Nullable
java.lang.String getSeoname()
```

Technical field for SEO (transliterated and simplified company name).

Optional field, can be null.

### getShortName

```java
@Nullable
java.lang.String getShortName()
```

Short company name.

Optional field, can be null.

### getProperties

```java
@Nullable
Properties getProperties()
```

Additional company properties.

Optional field, can be null.

### getFeatureGroups

```java
@NonNull
java.util.List<FeatureGroup> getFeatureGroups()
```

List of feature groups for the company.

### getIndoorLevel

```java
@Nullable
java.lang.String getIndoorLevel()
```

Indoor level id (obsolete).

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
