package com.inuceng.evdesaglik

import android.app.Application
import com.inuceng.evdesaglik.di.loginModule
import org.koin.core.context.startKoin

class EvdeSaglikApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(loginModule))        }
    }
}