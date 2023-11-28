package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RedBlue(
    @SerialName(value = "back_default")
    val backDefault: String?,
    @SerialName(value = "back_gray")
    val backGray: String?,
    @SerialName(value = "back_transparent")
    val backTransparent: String?,
    @SerialName(value = "front_default")
    val frontDefault: String?,
    @SerialName(value = "front_gray")
    val frontGray: String?,
    @SerialName(value = "front_transparent")
    val frontTransparent: String?
)