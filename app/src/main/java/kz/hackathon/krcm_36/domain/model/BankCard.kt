package kz.hackathon.krcm_36.domain.model

data class BankCard(
    val id: Int,
    val bank: Bank,
    val type: String,
    val cardNumber: String,
    val expiryDate: String,
    val user: User,
)
