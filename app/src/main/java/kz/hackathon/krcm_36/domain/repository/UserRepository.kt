package kz.hackathon.krcm_36.domain.repository

import kz.hackathon.krcm_36.domain.model.Bank
import kz.hackathon.krcm_36.domain.model.Cashback
import kz.hackathon.krcm_36.domain.model.Company

interface UserRepository {
    suspend fun getBanks(): List<Bank>
    suspend fun getCompanies(): List<Company>
    suspend fun getCompaniesByName(name: String): List<Company>
    suspend fun getCashbacks(): List<Cashback>
    suspend fun getCashbacksByCompanyId(id: Int): List<Cashback>
}