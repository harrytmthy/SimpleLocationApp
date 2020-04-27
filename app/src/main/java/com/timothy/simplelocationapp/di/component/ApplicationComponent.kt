package com.timothy.simplelocationapp.di.component

import android.app.Application
import android.content.Context
import com.timothy.domain.location.repository.LocationRepository
import com.timothy.simplelocationapp.SimpleLocationApp
import com.timothy.simplelocationapp.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version ApplicationComponent, v 0.1 27/04/20 09.55 by Harry Timothy
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(simpleLocationApp: SimpleLocationApp)
    fun context(): Context
    fun application(): Application
    fun locationRepository(): LocationRepository
}