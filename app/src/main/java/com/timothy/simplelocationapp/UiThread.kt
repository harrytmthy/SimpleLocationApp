package com.timothy.simplelocationapp

import com.timothy.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version UiThread, v 0.1 02/05/20 01.28 by Harry Timothy
 */
@Singleton
class UiThread @Inject constructor() : PostExecutionThread {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}