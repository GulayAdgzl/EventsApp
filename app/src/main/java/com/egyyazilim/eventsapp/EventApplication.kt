package com.egyyazilim.eventsapp

import android.app.Application
import timber.log.Timber

class EventApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}