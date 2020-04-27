package com.timothy.data.location.source.network

import android.content.Context
import android.location.Location
import android.os.Looper
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.timothy.data.location.LocationEntityData
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version NetworkLocationEntityData, v 0.1 26/04/20 22.29 by Harry Timothy
 */
@Singleton
class NetworkLocationEntityData @Inject constructor(
    private val context: Context
) : LocationEntityData {

    private val locationRequest by lazy {
        LocationRequest.create()
            .setInterval(LOCATION_REQUEST_INTERVAL)
            .setFastestInterval(LOCATION_REQUEST_FASTEST_INTERVAL)
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
    }

    private val locationCallback: LocationCallback by lazy {
        object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult?.locations?.let { locations ->
                    if (locations.isNotEmpty()) {
                        val location: Location = locations.last() // the newest location
                        val latLong = "${location.latitude}, ${location.longitude}"
                        launch {
                            Observable.just(latLong).subscribe(locationSubject::onNext)
                        }
                        //optional: locationClient.removeLocationUpdates(locationCallback)
                    }
                }
            }
        }
    }

    private val locationClient by lazy { LocationServices.getFusedLocationProviderClient(context) }

    private val compositeDisposable by lazy { CompositeDisposable() }

    private val locationSubject by lazy { PublishSubject.create<String>() }

    private inline fun launch(action: () -> Disposable) = compositeDisposable.add(action())

    override fun getLocation() = locationSubject.also {
        locationClient.requestLocationUpdates(locationRequest, locationCallback,
            Looper.getMainLooper())
    }

    companion object {
        const val LOCATION_REQUEST_INTERVAL = 8000L
        const val LOCATION_REQUEST_FASTEST_INTERVAL = 4000L
    }
}