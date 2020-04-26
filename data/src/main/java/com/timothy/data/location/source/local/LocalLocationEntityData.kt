package com.timothy.data.location.source.local

import android.content.Context
import androidx.preference.PreferenceManager
import com.timothy.data.location.LocationEntityData
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version LocalLocationEntityData, v 0.1 26/04/20 23.01 by Harry Timothy
 */
@Singleton
class LocalLocationEntityData @Inject constructor(
    private val context: Context
) : LocationEntityData {

    private val preferences by lazy { PreferenceManager.getDefaultSharedPreferences(context) }

    override fun getLocation(): Observable<String> {
        return Observable.just(preferences.getString(KEY_LOCATION, ""))
    }

    override fun saveLocation(latLong: String) {
        preferences.edit().putString(KEY_LOCATION, latLong).apply()
    }

    companion object {
        const val KEY_LOCATION = "location_key"
    }
}