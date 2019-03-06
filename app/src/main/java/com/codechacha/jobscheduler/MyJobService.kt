package com.codechacha.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import kotlin.concurrent.thread

class MyJobService : JobService() {
    companion object {
        private val TAG = "MyJobService"
    }

    override
    fun onStartJob(params: JobParameters): Boolean {
        Log.d(TAG, "onStartJob: ${params.jobId}")

        thread(start = true) {
            Thread.sleep(1000)
            Log.d(TAG, "doing Job in other thread")
            jobFinished(params, false)
        }

        return true
    }

    override
    fun onStopJob(params: JobParameters): Boolean {
        Log.d(TAG, "onStopJob: ${params.jobId}")
        return false
    }
}