package kz.hackathon.krcm_36.data.network.response

import com.google.gson.annotations.SerializedName

data class CashbackResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("bankCard")
    val bankCard: BankCardResponse,
    @SerializedName("category")
    val category: String,
    @SerializedName("percent")
    val percent: Int,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("expiryDate")
    val expiryDate: String,
    @SerializedName("restriction")
    val restriction: String,
    @SerializedName("company")
    val company: CompanyResponse
)
