package kz.hackathon.krcm_36.data.di

import kz.hackathon.krcm_36.data.network.mapper.BankCardMapper
import kz.hackathon.krcm_36.data.network.mapper.BankMapper
import kz.hackathon.krcm_36.data.network.mapper.CashbackMapper
import kz.hackathon.krcm_36.data.network.mapper.CompanyMapper
import kz.hackathon.krcm_36.data.network.mapper.UserMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { BankMapper() }
    factory { UserMapper() }
    factory { CompanyMapper() }
    factory { BankCardMapper(get(), get()) }
    factory { CashbackMapper(get(), get()) }
}