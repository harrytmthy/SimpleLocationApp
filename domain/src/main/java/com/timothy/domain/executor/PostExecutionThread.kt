package com.timothy.domain.executor

import io.reactivex.Scheduler

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version PostExecutionThread, v 0.1 26/04/20 23.38 by Harry Timothy
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}