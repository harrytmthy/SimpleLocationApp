package com.timothy.domain.location.repository

import io.reactivex.Observable

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version LocationRepository, v 0.1 27/04/20 00.19 by Harry Timothy
 */
interface LocationRepository {
    fun getLocation(): Observable<String>
}