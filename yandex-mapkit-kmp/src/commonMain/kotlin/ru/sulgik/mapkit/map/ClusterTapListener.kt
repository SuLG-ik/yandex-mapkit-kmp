package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster

expect class ClusterTapListener(onClusterTap: (cluster: Cluster) -> Boolean)