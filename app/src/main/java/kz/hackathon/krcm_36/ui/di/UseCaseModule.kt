package kz.hackathon.krcm_36.ui.di

import kz.hackathon.krcm_36.domain.use_cases.GetBanksUseCase
import org.koin.dsl.module

val useCaseModule = module{
    factory { GetBanksUseCase(get()) }
}