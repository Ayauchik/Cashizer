package kz.hackathon.krcm_36.data.network.mapper

import kz.hackathon.krcm_36.data.network.response.GetBankResponse
import kz.hackathon.krcm_36.domain.model.Bank

class BankMapper {
    fun fromRemoteToDomain(bankResponse: GetBankResponse): Bank{
        return Bank(
            id = bankResponse.id,
            name = bankResponse.name
        )
    }
}