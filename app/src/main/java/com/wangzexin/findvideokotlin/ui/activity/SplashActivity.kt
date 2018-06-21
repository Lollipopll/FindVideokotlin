package com.wangzexin.findvideokotlin.ui.activity

import android.content.Intent
import android.os.Handler
import com.wangzexin.findvideokotlin.R
import com.wangzexin.findvideokotlin.app.MyApplication
import com.wangzexin.findvideokotlin.base.BaseActivity
import com.wangzexin.findvideokotlin.ui.MainActivity
import com.wangzexin.findvideokotlin.utils.AppUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    override fun layoutId(): Int = R.layout.activity_splash


    override fun initView() {

        tv_version.text = "v${AppUtils.getVerName(MyApplication.context)}"

        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }

    override fun initData() {

    }

    override fun requestData() {

    }

}
