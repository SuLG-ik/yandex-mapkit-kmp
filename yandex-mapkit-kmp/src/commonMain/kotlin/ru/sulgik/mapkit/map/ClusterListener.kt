package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Cluster

expect class ClusterListener(onClusterAdded: (cluster: Cluster) -> Unit)