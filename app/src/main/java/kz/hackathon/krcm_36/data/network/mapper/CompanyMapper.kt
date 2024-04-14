package kz.hackathon.krcm_36.data.network.mapper

import kz.hackathon.krcm_36.data.network.response.CompanyResponse
import kz.hackathon.krcm_36.domain.model.Company

class CompanyMapper {
    fun fromRemoteToDomain(companyResponse: CompanyResponse): Company{
        return Company(
            id = companyResponse.id,
            name = companyResponse.name,
           // category = companyResponse.category
        )
    }
}