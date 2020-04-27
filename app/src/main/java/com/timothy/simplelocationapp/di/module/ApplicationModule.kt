package com.timothy.simplelocationapp.di.module

import android.app.Application
import android.content.Context
import com.timothy.data.location.LocationEntityRepository
import com.timothy.domain.location.repository.LocationRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version ApplicationModule, v 0.1 27/04/20 10.04 by Harry Timothy
 */
@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideApplication() = application

    @Provides
    @Singleton
    fun provideLocationRepository(
        locationEntityRepository: LocationEntityRepository
    ): LocationRepository = locationEntityRepository

}