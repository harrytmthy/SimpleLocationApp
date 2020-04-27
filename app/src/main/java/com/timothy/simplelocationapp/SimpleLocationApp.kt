package com.timothy.simplelocationapp

import android.app.Application
import com.timothy.simplelocationapp.di.component.DaggerApplicationComponent
import com.timothy.simplelocationapp.di.module.ApplicationModule
import timber.log.Timber

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version SimpleLocationApp, v 0.1 27/04/20 09.50 by Harry Timothy
 */
class SimpleLocationApp : Application() {

    val applicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        applicationComponent.inject(this)
    }
}