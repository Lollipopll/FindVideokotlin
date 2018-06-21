package com.wangzexin.findvideokotlin.api

import com.wangzexin.findvideokotlin.mvp.model.bean.DailyBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * @author wangzexin
 * @date 2018/1/23
 * @describe api服务
 */
interface ApiService {

    /**
     * 首页精选
     */
    @GET("v2/feed?")
    fun getFirstHomeData(@Query("num") num: Int): Observable<DailyBean>

}