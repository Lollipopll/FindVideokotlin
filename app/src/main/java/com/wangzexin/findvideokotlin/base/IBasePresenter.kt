package com.wangzexin.findvideokotlin.base

/**
 *
 * @author wangzexin
 * @date 2018/1/18
 * @describe
 */
interface IBasePresenter< in V : IBaseView> {

    fun attachView(mRootView: V)

    fun detachView()

}