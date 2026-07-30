---
title: "YMKSearchBusinessObjectMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchBusinessObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessObjectMetadata.html"
---
# YMKSearchBusinessObjectMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchBusinessObjectMetadata : NSObject <YMKBaseMetadata>
```

Extended information about company.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchBusinessObjectMetadata *)businessObjectMetadataWithOid:(nonnull NSString *)oid
                                                                      name:(nonnull NSString *)name
                                                                   address:(nonnull YMKSearchAddress *)address
                                                                categories:(nonnull NSArray<YMKSearchCategory *> *)categories
                                                                    phones:(nonnull NSArray<YMKSearchPhone *> *)phones
                                                              workingHours:(nullable YMKSearchWorkingHours *)workingHours
                                                                 precision:(nullable NSNumber *)precision
                                                                  features:(nonnull NSArray<YMKSearchFeature *> *)features
                                                         importantFeatures:(nullable YMKSearchFeatureSet *)importantFeatures
                                                                     links:(nonnull NSArray<YMKSearchLink *> *)links
                                                                  distance:(nullable YMKLocalizedValue *)distance
                                                                    chains:(nonnull NSArray<YMKSearchChain *> *)chains
                                                                    closed:(nullable NSNumber *)closed
                                                                unreliable:(nullable NSNumber *)unreliable
                                                                   seoname:(nullable NSString *)seoname
                                                                 shortName:(nullable NSString *)shortName
                                                                properties:(nullable YMKSearchProperties *)properties
                                                             featureGroups:(nonnull NSArray<YMKSearchFeatureGroup *> *)featureGroups
                                                               indoorLevel:(nullable NSString *)indoorLevel;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *oid;
```

Permanent company id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Company name

```objectivec
@property (nonatomic, readonly, nonnull) YMKSearchAddress *address;
```

Company address

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchCategory *> *categories;
```

List of categories associated with the company

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchPhone *> *phones;
```

List of phone numbers for the company

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchWorkingHours *workingHours;
```

Open hours for the company

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *precision;
```

Address precision for the company

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchFeature *> *features;
```

List of features for the company

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchFeatureSet *importantFeatures;
```

Collection of features that probably are of utmost interest to the user

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchLink *> *links;
```

List of links for the company

```objectivec
@property (nonatomic, readonly, nullable) YMKLocalizedValue *distance;
```

Optional distance to the company from geometry provided in request

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchChain *> *chains;
```

List of chains associated with the company

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *closed;
```

Company status, present if it is closed

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *unreliable;
```

If true, company information is not reliable

```objectivec
@property (nonatomic, readonly, nullable) NSString *seoname;
```

Technical field for SEO (transliterated and simplified company name)

```objectivec
@property (nonatomic, readonly, nullable) NSString *shortName;
```

Short company name

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchProperties *properties;
```

Additional company properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchFeatureGroup *> *featureGroups;
```

List of feature groups for the company

```objectivec
@property (nonatomic, readonly, nullable) NSString *indoorLevel;
```

Indoor level id (obsolete)

## Class methods

### businessObjectMetadataWithOid:name:address:categories:phones:workingHours:precision:features:importantFeatures:links:distance:chains:closed:unreliable:seoname:shortName:properties:featureGroups:indoorLevel:

```objectivec
+ (nonnull YMKSearchBusinessObjectMetadata *)businessObjectMetadataWithOid:(nonnull NSString *)oid
                                                                      name:(nonnull NSString *)name
                                                                   address:(nonnull YMKSearchAddress *)address
                                                                categories:(nonnull NSArray<YMKSearchCategory *> *)categories
                                                                    phones:(nonnull NSArray<YMKSearchPhone *> *)phones
                                                              workingHours:(nullable YMKSearchWorkingHours *)workingHours
                                                                 precision:(nullable NSNumber *)precision
                                                                  features:(nonnull NSArray<YMKSearchFeature *> *)features
                                                         importantFeatures:(nullable YMKSearchFeatureSet *)importantFeatures
                                                                     links:(nonnull NSArray<YMKSearchLink *> *)links
                                                                  distance:(nullable YMKLocalizedValue *)distance
                                                                    chains:(nonnull NSArray<YMKSearchChain *> *)chains
                                                                    closed:(nullable NSNumber *)closed
                                                                unreliable:(nullable NSNumber *)unreliable
                                                                   seoname:(nullable NSString *)seoname
                                                                 shortName:(nullable NSString *)shortName
                                                                properties:(nullable YMKSearchProperties *)properties
                                                             featureGroups:(nonnull NSArray<YMKSearchFeatureGroup *> *)featureGroups
                                                               indoorLevel:(nullable NSString *)indoorLevel;
```

## Properties

### oid

```objectivec
@property (nonatomic, readonly, nonnull) NSString *oid;
```

Permanent company id.

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

Company name.

### address

```objectivec
@property (nonatomic, readonly, nonnull) YMKSearchAddress *address;
```

Company address.

### categories

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchCategory *> *categories;
```

List of categories associated with the company.

### phones

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchPhone *> *phones;
```

List of phone numbers for the company.

### workingHours

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchWorkingHours *workingHours;
```

Open hours for the company.

Optional field, can be nil.

### precision

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *precision;
```

Address precision for the company.

Optional field, can be nil.

### features

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchFeature *> *features;
```

List of features for the company.

### importantFeatures

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchFeatureSet *importantFeatures;
```

Collection of features that probably are of utmost interest to the user.

Optional field, can be nil.

### links

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchLink *> *links;
```

List of links for the company.

### distance

```objectivec
@property (nonatomic, readonly, nullable) YMKLocalizedValue *distance;
```

Optional distance to the company from geometry provided in request.

Optional field, can be nil.

### chains

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchChain *> *chains;
```

List of chains associated with the company.

### closed

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *closed;
```

Company status, present if it is closed.

Optional field, can be nil.

### unreliable

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *unreliable;
```

If true, company information is not reliable.

Optional field, can be nil.

### seoname

```objectivec
@property (nonatomic, readonly, nullable) NSString *seoname;
```

Technical field for SEO (transliterated and simplified company name).

Optional field, can be nil.

### shortName

```objectivec
@property (nonatomic, readonly, nullable) NSString *shortName;
```

Short company name.

Optional field, can be nil.

### properties

```objectivec
@property (nonatomic, readonly, nullable) YMKSearchProperties *properties;
```

Additional company properties.

Optional field, can be nil.

### featureGroups

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchFeatureGroup *> *featureGroups;
```

List of feature groups for the company.

### indoorLevel

```objectivec
@property (nonatomic, readonly, nullable) NSString *indoorLevel;
```

Indoor level id (obsolete).

Optional field, can be nil.
