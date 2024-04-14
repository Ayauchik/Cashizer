package kz.hackathon.krcm_36.ui

import android.app.Application
import kz.hackathon.krcm_36.data.di.mapperModule
import kz.hackathon.krcm_36.data.di.networkModule
import kz.hackathon.krcm_36.data.di.repositoryModule
import kz.hackathon.krcm_36.ui.di.useCaseModule
import kz.hackathon.krcm_36.ui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf

class CustomApplication : Application() {
    private val modulesToUse = listOf(
        networkModule,
        repositoryModule,
        useCaseModule,
        viewModelModule,
        mapperModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@CustomApplication)
            parametersOf("https://krcm36-7e04a2616e2f.herokuapp.com")
            modules(modulesToUse)
        }
    }
}