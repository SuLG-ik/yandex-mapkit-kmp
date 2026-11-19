package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.SectionMetadata as NativeSectionMetadata
import com.yandex.mapkit.transport.masstransit.SectionMetadata.SectionData as NativeSectionData

/** Information about a section of a transport route. */
public actual class SectionMetadata internal constructor(
    private val nativeSectionMetadata: NativeSectionMetadata,
) {
    /** Returns the wrapped native handle. */
    public fun toNative(): NativeSectionMetadata = nativeSectionMetadata

    /** Travel time, walking distance and transfer count. */
    public actual val weight: Weight
        get() = nativeSectionMetadata.weight.toCommon()

    /** The data specific to the section type. */
    public actual val data: SectionData
        get() = nativeSectionMetadata.data.toCommon()

    /** Estimated section times, when reported. */
    public actual val estimation: TravelEstimation?
        get() = nativeSectionMetadata.estimation?.toCommon()

    /** Index of the leg between two consecutive waypoints. */
    public actual val legIndex: Int
        get() = nativeSectionMetadata.legIndex

    /** A choice of data specific to a transport section. */
    public actual class SectionData internal constructor(
        private val nativeSectionData: NativeSectionData,
    ) {
        /** Returns the wrapped native handle. */
        public fun toNative(): NativeSectionData = nativeSectionData

        /** Data for waiting. */
        public actual val wait: Wait?
            get() = nativeSectionData.wait?.toCommon()

        /** Data for walking or cycling. */
        public actual val fitness: Fitness?
            get() = nativeSectionData.fitness?.toCommon()

        /** Data for a transfer. */
        public actual val transfer: Transfer?
            get() = nativeSectionData.transfer?.toCommon()

        /** Data for a taxi ride. */
        public actual val taxi: Taxi?
            get() = nativeSectionData.taxi?.toCommon()

        /** Transport alternatives for a ride, when present. */
        public actual val transports: List<Transport>?
            get() = nativeSectionData.transports?.map { it.toCommon() }

        /** Reports whether two wrappers hold the same native handle. */
        actual override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is SectionData) return false
            return nativeSectionData == other.nativeSectionData
        }

        /** Returns the native handle's hash code. */
        actual override fun hashCode(): Int = nativeSectionData.hashCode()
    }

    /** Reports whether two wrappers hold the same native handle. */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SectionMetadata) return false
        return nativeSectionMetadata == other.nativeSectionMetadata
    }

    /** Returns the native handle's hash code. */
    actual override fun hashCode(): Int = nativeSectionMetadata.hashCode()
}

/** Wraps this native handle. */
public fun NativeSectionMetadata.toCommon(): SectionMetadata = SectionMetadata(this)

/** Wraps this native section data. */
public fun NativeSectionData.toCommon(): SectionMetadata.SectionData = SectionMetadata.SectionData(this)
