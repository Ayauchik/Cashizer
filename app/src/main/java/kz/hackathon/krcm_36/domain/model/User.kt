package kz.hackathon.krcm_36.domain.model

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    val name: String,
    val surname: String,
    val email: String,
    val address: String,
    val phone: String
)