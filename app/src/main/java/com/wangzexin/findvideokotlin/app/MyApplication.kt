package com.wangzexin.findvideokotlin.app

import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.wangzexin.findvideokotlin.BuildConfig
import kotlin.properties.Delegates

/**
 * @author wangzexin
 * @date 2018/1/18
 * @describe
 */
class MyApplication : Application() {

    //相当于java的静态内部类，随类的初始化而初始化
    companion object {
        private val TAG = "MyApplication"
        var context: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initLoggerConfig()
    }

    /**
     * 初始化Logger
     */
    private fun initLoggerConfig() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // 隐藏线程信息 默认：显示
                .methodCount(0)         // 决定打印多少行（每一行代表一个方法）默认：2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("hao_zz")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }
}
