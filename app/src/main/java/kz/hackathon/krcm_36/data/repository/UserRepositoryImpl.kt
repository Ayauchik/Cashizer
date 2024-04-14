package kz.hackathon.krcm_36.data.repository

import com.google.gson.annotations.SerializedName
import kz.hackathon.krcm_36.data.network.api.PlaceholderService
import kz.hackathon.krcm_36.data.network.mapper.BankMapper
import kz.hackathon.krcm_36.data.network.mapper.CashbackMapper
import kz.hackathon.krcm_36.data.network.mapper.CompanyMapper
import kz.hackathon.krcm_36.domain.model.Bank
import kz.hackathon.krcm_36.domain.model.Cashback
import kz.hackathon.krcm_36.domain.model.Company
import kz.hackathon.krcm_36.domain.repository.UserRepository

class UserRepositoryImpl (
    private val placeholderService: PlaceholderService,
    private val bankMapper: BankMapper,
    private val companyMapper: CompanyMapper,
    private val cashbackMapper: CashbackMapper
) : UserRepository {
    override suspend fun getBanks(): List<Bank> {
        val banks = placeholderService.getBanks()
        return banks.map{ bankMapper.fromRemoteToDomain(it)}
    }

    override suspend fun getCompanies(): List<Company> {
        val companies = placeholderService.getCompany()
        return companies.map { companyMapper.fromRemoteToDomain(it) }
    }

    override suspend fun getCompaniesByName(name: String): List<Company> {
        val companiesByName = placeholderService.getCompanyByName(name = name)
        return companiesByName.map { companyMapper.fromRemoteToDomain(it) }
    }

    override suspend fun getCashbacksByCompanyId(id: Int): List<Cashback> {
        val cashbacks = placeholderService.getCashbacksByCompanyName(id)
        return cashbacks.map { cashbackMapper.fromRemoteToDomain(it) }
    }
}