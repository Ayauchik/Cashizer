package kz.hackathon.krcm_36.ui.di

import kz.hackathon.krcm_36.ui.screens.main.BankViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { BankViewModel(get()) }
}