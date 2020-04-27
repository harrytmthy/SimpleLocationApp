package com.timothy.data.location

import io.reactivex.Observable

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version LocationEntityData, v 0.1 26/04/20 21.28 by Harry Timothy
 */
interface LocationEntityData {
    fun getLocation(): Observable<String>
    fun saveLocation(latLong: String) { /* default implementation */ }
}