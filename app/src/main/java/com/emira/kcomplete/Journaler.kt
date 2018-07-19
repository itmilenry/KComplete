package com.journaler

import android.app.Application
import android.content.Context
import android.util.Log



class Journaler : Application() {
    companion object{
        var ctx: Context? = null
        val tag = "KComplete Application"
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
        Log.v( tag, "[ ON CREATE ]")
    }


    override fun onLowMemory() {
        super.onLowMemory()
        Log.v(tag, "[ ON LOW MEMORY ]")
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.v( tag, "[ ON TRIM MEMORY: $level ]")
    }


}