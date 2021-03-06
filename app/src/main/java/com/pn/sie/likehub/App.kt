package com.pn.sie.likehub

import android.app.Activity
import android.support.multidex.MultiDexApplication
import android.support.v4.app.Fragment
import com.pn.sie.likehub.di.AppInjector
import com.pn.sie.likehub.xutil.LogPrinter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created With Android Studio
 * Email: sielee@163.com
 * Author: Lee Sie
 * CopyRight: CL
 * <p>
 * Description: TODO
 * </p>
 */
class App : MultiDexApplication(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    override fun activityInjector(): DispatchingAndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        self = this
        AppInjector.init(this)
        testFunc()
    }

    companion object {
        lateinit var self: App

        var enter = "_"

        fun gate(value: String) {
            enter = value
        }

        fun entered(): String {
            return enter
        }
    }

    private fun testFunc() {
        if (BuildConfig.DEBUG) {
            LogPrinter.enableRel(2, true)
            LogPrinter.addUserLogger("Sie")
            LogPrinter.takeOver("Sie")
        }
    }
}