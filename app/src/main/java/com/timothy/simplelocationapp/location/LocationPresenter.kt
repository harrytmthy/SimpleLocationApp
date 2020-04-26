package com.timothy.simplelocationapp.location

import com.timothy.domain.location.interactor.GetLocationUpdates
import com.timothy.simplelocationapp.di.PerActivity
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject


/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version LocationPresenter, v 0.1 27/04/20 01.05 by Harry Timothy
 */
@PerActivity
class LocationPresenter @Inject constructor(
    private val getLocationUpdates: GetLocationUpdates,
    private val view: LocationContract.View
) : LocationContract.Presenter {

    override fun getLocationUpdates() {
        getLocationUpdates.execute(object : DisposableObserver<String>() {
            override fun onNext(latLong: String) {
                view.onLocationUpdateSuccess(latLong)
            }

            override fun onError(e: Throwable) {
                view.onLocationUpdateError()
            }

            override fun onComplete() {
                // log or do anything
            }
        }, Unit)
    }

    override fun onDestroy() = getLocationUpdates.dispose()
}