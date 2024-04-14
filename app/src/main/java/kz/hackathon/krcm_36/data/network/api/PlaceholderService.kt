package kz.hackathon.krcm_36.data.network.api

import kz.hackathon.krcm_36.data.network.response.CashbackResponse
import kz.hackathon.krcm_36.data.network.response.CompanyResponse
import kz.hackathon.krcm_36.data.network.response.GetBankResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceholderService  {
    @GET("bank")
    suspend fun getBanks(): List<GetBankResponse>

    @GET("company")
    suspend fun getCompany(): List<CompanyResponse>

    @GET("company/{name}")
    suspend fun getCompanyByName(@Path("name")name: String): List<CompanyResponse>

    @GET("company/{id}/cashback")
    suspend fun getCashbacksByCompanyName(@Path("id")id: Int): List<CashbackResponse>
}