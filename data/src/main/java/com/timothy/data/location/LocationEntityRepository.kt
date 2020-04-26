package com.timothy.data.location

import com.timothy.data.common.Source
import com.timothy.data.location.source.LocationDataFactory
import com.timothy.domain.location.repository.LocationRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version LocationEntityRepository, v 0.1 27/04/20 00.22 by Harry Timothy
 */
@Singleton
class LocationEntityRepository @Inject constructor(
    private val locationDataFactory: LocationDataFactory
) : LocationRepository {

    override fun getLocation(): Observable<String> = createNetworkData()
        .getLocation()
        .onErrorResumeNext(getCachedLocationData()) // get cached location instead on error
        .doOnNext(::saveLocationData) // cache the location

    private fun getCachedLocationData() = createLocalData().getLocation()

    private fun saveLocationData(latLong: String) {
        if (latLong.isNotEmpty()) {
            createNetworkData().saveLocation(latLong)
        }
    }

    private fun createLocalData() = locationDataFactory.createData(Source.Local)

    private fun createNetworkData() = locationDataFactory.createData(Source.Network)
}