package ru.sulgik.mapkit.offline_cache

import ru.sulgik.mapkit.runtime.Error

/**
 * A failure reported by the offline cache.
 *
 * The two properties are mutually exclusive because the platforms report the failure differently:
 * Android hands over a typed [ru.sulgik.mapkit.runtime.Error], iOS an `NSError` that only carries
 * a message.
 */
public expect class OfflineCacheError {

    /**
     * A human readable description of the failure, `null` on Android.
     */
    public val description: String?

    /**
     * The typed MapKit error, `null` on iOS.
     */
    public val error: Error?
}
