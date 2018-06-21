package com.wangzexin.findvideokotlin.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *
 * @author wangzexin
 * @date 2018/1/23
 * @describe
 */
open class BasePresenter<T : IBaseView> : IBasePresenter<T> {

    var mRootView: T? = null

    private var compositeDisposable = CompositeDisposable()

    override fun attachView(mRootView: T) {
        this.mRootView = mRootView

    }

    override fun detachView() {
        this.mRootView = null

        //取消正在执行的订阅
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }

    }

    /**
     * 添加到订阅
     */
    fun addSubscription(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

}