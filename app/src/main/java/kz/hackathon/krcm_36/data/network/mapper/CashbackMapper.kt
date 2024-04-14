package kz.hackathon.krcm_36.data.network.mapper

import kz.hackathon.krcm_36.data.network.response.CashbackResponse
import kz.hackathon.krcm_36.domain.model.Cashback

class CashbackMapper(
    private val bankCardMapper: BankCardMapper,
    private val companyMapper: CompanyMapper
) {
    fun fromRemoteToDomain(cashbackResponse: CashbackResponse): Cashback{
        return Cashback(
            id = cashbackResponse.id,
            bankCard = bankCardMapper.fromRemoteToDomain(cashbackResponse.bankCard),
            category = cashbackResponse.category,
            percent = cashbackResponse.percent,
            condition = cashbackResponse.condition,
            expiryDate = cashbackResponse.expiryDate,
            restriction = cashbackResponse.restriction,
            company = companyMapper.fromRemoteToDomain(cashbackResponse.company)
        )
    }
}