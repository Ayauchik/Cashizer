package kz.hackathon.krcm_36.data.network.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("surname")
    val surname: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("phone")
    val phone: String
)
