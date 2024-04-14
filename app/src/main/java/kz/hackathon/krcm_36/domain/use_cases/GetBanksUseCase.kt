package kz.hackathon.krcm_36.domain.use_cases

import kz.hackathon.krcm_36.domain.model.Bank
import kz.hackathon.krcm_36.domain.model.Cashback
import kz.hackathon.krcm_36.domain.model.Company
import kz.hackathon.krcm_36.domain.repository.UserRepository

class GetBanksUseCase(private val repository: UserRepository) {
    suspend fun getBanks(): List<Bank>{
        return repository.getBanks()
    }

    suspend fun getCompanies(): List<Company>{
        return repository.getCompanies()
    }

    suspend fun getCompaniesByName(name:String): List<Company>{
        return repository.getCompaniesByName(name)
    }

    suspend fun getCashbacks(): List<Cashback>{
        return repository.getCashbacks()
    }
    suspend fun getCashbacksByCompanyId(id: Int): List<Cashback>{
        return repository.getCashbacksByCompanyId(id)
    }
}