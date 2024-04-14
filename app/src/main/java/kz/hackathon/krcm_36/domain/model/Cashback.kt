package kz.hackathon.krcm_36.domain.model


data class Cashback(
    val id: Int,
    val bankCard: BankCard,
    val category: String,
    val percent: Int,
    val condition: String,
    val expiryDate: String,
    val restriction: String,
    val company: Company
)
