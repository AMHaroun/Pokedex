package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Move(
    val move: MoveX,
    @SerialName(value = "version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>
)