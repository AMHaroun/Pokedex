package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionGroupDetail(
    @SerialName(value = "level_learned_at")
    val levelLearnedAt: Int,
    @SerialName(value = "move_learn_method")
    val moveLearnMethod: MoveLearnMethod,
    @SerialName(value = "version_group")
    val versionGroup: VersionGroup
)