package kz.hackathon.krcm_36.data.network.mapper

import kz.hackathon.krcm_36.data.network.response.BankCardResponse
import kz.hackathon.krcm_36.domain.model.BankCard

class BankCardMapper(
    private val bankMapper: BankMapper,
    private val userMapper: UserMapper
) {
    fun fromRemoteToDomain(bankCardResponse: BankCardResponse): BankCard {
        return BankCard(
            id = bankCardResponse.id,
            bank = bankMapper.fromRemoteToDomain(bankCardResponse.bank),
            type = bankCardResponse.type,
            cardNumber = bankCardResponse.cardNumber,
            expiryDate = bankCardResponse.expiryDate,
            user = userMapper.fromRemoteToDomain(bankCardResponse.user)
        )
    }
}