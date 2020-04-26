package com.timothy.domain.location.interactor

import com.timothy.domain.UseCase
import com.timothy.domain.executor.PostExecutionThread
import com.timothy.domain.executor.ThreadExecutor
import com.timothy.domain.location.repository.LocationRepository
import javax.inject.Inject

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version GetLocationUpdates, v 0.1 27/04/20 00.59 by Harry Timothy
 */
class GetLocationUpdates @Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val locationRepository: LocationRepository
) : UseCase<String, Unit>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Unit) = locationRepository.getLocation()
}