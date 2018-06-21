package com.wangzexin.findvideokotlin.mvp.model

import com.hazz.kotlinmvp.rx.scheduler.SchedulerUtils
import com.wangzexin.findvideokotlin.mvp.model.bean.HomeBean
import com.wangzexin.findvideokotlin.net.RetrofitManager
import io.reactivex.Observable

/**
 *
 * @author wangzexin
 * @date 2018/1/24
 * @describe
 */
class HomeModel {

    /**
     * 请求首页数据
     */
    fun requestHomeData(num: Int): Observable<HomeBean> {
        return RetrofitManager.service.getFirstHomeData(num)
                .compose(SchedulerUtils.ioToMain())
    }
}