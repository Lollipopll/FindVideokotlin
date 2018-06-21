package com.wangzexin.findvideokotlin.mvp.contract

import com.wangzexin.findvideokotlin.base.IBasePresenter
import com.wangzexin.findvideokotlin.base.IBaseView

interface DailyContract {

    interface View : IBaseView {
        /**
         * 加载数据
         */
        fun setDailyData()

        /**
         * 加载更多
         */
        fun setMoreDailyDatd()

        /**
         * 显示错误信息
         */
        fun showError(msg: String, errorCode: Int)

    }

    interface Presenter : IBasePresenter<View> {
        /**
         * 请求数据
         */
        fun requestDailyData()

        /**
         * 请求更多
         */
        fun requestMroeDailyData()
    }


}