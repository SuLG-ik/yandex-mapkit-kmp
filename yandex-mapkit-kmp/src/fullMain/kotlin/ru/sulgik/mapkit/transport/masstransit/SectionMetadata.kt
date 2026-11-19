package ru.sulgik.mapkit.transport.masstransit

/** Information about a section of a transport route. */
public expect class SectionMetadata {
    /** Travel time, walking distance and transfer count. */
    public val weight: Weight

    /** The data specific to the section type. */
    public val data: SectionData

    /** Estimated section times, when reported. */
    public val estimation: TravelEstimation?

    /** Index of the leg between two consecutive waypoints. */
    public val legIndex: Int

    /** A choice of data specific to a transport section. */
    public class SectionData {
        /** Data for waiting. */
        public val wait: Wait?

        /** Data for walking or cycling. */
        public val fitness: Fitness?

        /** Data for a transfer. */
        public val transfer: Transfer?

        /** Data for a taxi ride. */
        public val taxi: Taxi?

        /** Transport alternatives for a ride, when present. */
        public val transports: List<Transport>?

        /** Reports whether two wrappers hold the same native handle. */
        override fun equals(other: Any?): Boolean

        /** Returns the native handle's hash code. */
        override fun hashCode(): Int
    }

    /** Reports whether two wrappers hold the same native handle. */
    override fun equals(other: Any?): Boolean

    /** Returns the native handle's hash code. */
    override fun hashCode(): Int
}
