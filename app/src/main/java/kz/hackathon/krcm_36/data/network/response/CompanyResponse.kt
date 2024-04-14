package kz.hackathon.krcm_36.data.network.response

import com.google.gson.annotations.SerializedName

data class CompanyResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
//    @SerializedName("category")
//    val category: String
)
