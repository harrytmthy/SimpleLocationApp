package com.timothy.simplelocationapp.di.module

import com.timothy.simplelocationapp.location.LocationContract
import com.timothy.simplelocationapp.location.LocationPresenter
import dagger.Module
import dagger.Provides

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version LocationModule, v 0.1 27/04/20 11.30 by Harry Timothy
 */
@Module
class LocationModule(private val locationView: LocationContract.View) {

    @Provides
    fun provideLocationPresenter(locationPresenter: LocationPresenter): LocationContract.Presenter {
        return locationPresenter
    }

    @Provides
    fun provideLocationView(): LocationContract.View = locationView
}