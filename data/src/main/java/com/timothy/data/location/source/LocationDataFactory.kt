package com.timothy.data.location.source

import android.content.Context
import com.timothy.data.common.Source
import com.timothy.data.location.LocationEntityData
import com.timothy.data.location.source.local.LocalLocationEntityData
import com.timothy.data.location.source.network.NetworkLocationEntityData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version LocationDataFactory, v 0.1 26/04/20 23.14 by Harry Timothy
 */
@Singleton
class LocationDataFactory @Inject constructor(
    private val context: Context
) {
    fun createData(source: Source): LocationEntityData {
        return when (source) {
            Source.Network -> NetworkLocationEntityData(context)
            Source.Local -> LocalLocationEntityData(context)
            // Source.Mock -> MockLocationEntityData(context)
            // ...
        }
    }
}