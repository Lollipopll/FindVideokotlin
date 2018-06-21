package com.wangzexin.findvideokotlin.mvp.model

import com.hazz.kotlinmvp.rx.scheduler.SchedulerUtils
import com.wangzexin.findvideokotlin.mvp.model.bean.DailyBean
import com.wangzexin.findvideokotlin.net.RetrofitManager
import io.reactivex.Observable

class DailyModel {
    /**
     * 请求数据
     */
    fun requestDailyData(num: Int): Observable<DailyBean> {
        return RetrofitManager.service.getFirstHomeData(num)
                .compose(SchedulerUtils.ioToMain())
    }
}