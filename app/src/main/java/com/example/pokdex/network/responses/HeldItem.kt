package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeldItem(
    val item: Item,
    @SerialName(value = "version_details")
    val versionDetails: List<VersionDetail>
)