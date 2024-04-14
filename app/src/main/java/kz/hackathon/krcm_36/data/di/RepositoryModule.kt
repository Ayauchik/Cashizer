package kz.hackathon.krcm_36.data.di

import kz.hackathon.krcm_36.data.repository.UserRepositoryImpl
import kz.hackathon.krcm_36.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module{
    factory<UserRepository> {UserRepositoryImpl(get(), get(), get())}
}