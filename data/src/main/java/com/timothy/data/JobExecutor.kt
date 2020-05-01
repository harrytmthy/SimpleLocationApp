package com.timothy.data

import com.timothy.domain.executor.ThreadExecutor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version JobExecutor, v 0.1 02/05/20 01.21 by Harry Timothy
 */
@Singleton
class JobExecutor @Inject constructor() : ThreadExecutor {

    private val threadPoolExecutor by lazy {
        ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS,
            LinkedBlockingQueue(), JobThreadFactory())
    }

    override fun execute(runnable: Runnable) = threadPoolExecutor.execute(runnable)

    class JobThreadFactory : ThreadFactory {

        private var counter = 0

        override fun newThread(runnable: Runnable) = Thread(runnable, "android_" + counter++)
    }
}