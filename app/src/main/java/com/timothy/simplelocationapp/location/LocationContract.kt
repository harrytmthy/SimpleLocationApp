package com.timothy.simplelocationapp.location

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version LocationContract, v 0.1 27/04/20 01.04 by Harry Timothy
 */
interface LocationContract {

    interface Presenter {
        fun getLocationUpdates()
        fun onDestroy()
    }

    interface View {
        fun onLocationUpdateSuccess(latLong: String)
        fun onLocationUpdateError()
    }
}