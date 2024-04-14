package kz.hackathon.krcm_36.data.network.response

import com.google.gson.annotations.SerializedName

data class BankCardResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("bank")
    val bank: GetBankResponse,
    @SerializedName("type")
    val type: String,
    @SerializedName("cardNumber")
    val cardNumber: String,
    @SerializedName("expiryDate")
    val expiryDate: String,
    @SerializedName("user")
    val user: UserResponse,
)
