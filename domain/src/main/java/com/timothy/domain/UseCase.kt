package com.timothy.domain

import com.timothy.domain.executor.PostExecutionThread
import com.timothy.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version UseCase, v 0.1 27/04/20 00.03 by Harry Timothy
 */
abstract class UseCase<T, Params> constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {
    private val compositeDisposable by lazy { CompositeDisposable() }

    protected abstract fun buildUseCaseObservable(params: Params): Observable<T>

    fun execute(observer: DisposableObserver<T>, params: Params) = launch {
        buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
            .subscribeWith(observer)
    }

    fun dispose() = compositeDisposable.dispose()

    private inline fun launch(action: () -> Disposable) = compositeDisposable.add(action())
}