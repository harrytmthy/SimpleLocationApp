package com.timothy.simplelocationapp.di.component

import com.timothy.simplelocationapp.MainActivity
import com.timothy.simplelocationapp.di.PerActivity
import com.timothy.simplelocationapp.di.module.LocationModule
import dagger.Component

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version LocationComponent, v 0.1 27/04/20 11.34 by Harry Timothy
 */
@PerActivity
@Component(dependencies = [ApplicationComponent::class],
    modules = [LocationModule::class])
interface LocationComponent {
    fun inject(mainActivity: MainActivity)
}