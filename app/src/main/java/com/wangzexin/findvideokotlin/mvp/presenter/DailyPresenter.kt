package com.wangzexin.findvideokotlin.mvp.presenter

import com.wangzexin.findvideokotlin.base.BasePresenter
import com.wangzexin.findvideokotlin.mvp.contract.DailyContract
import com.wangzexin.findvideokotlin.mvp.model.DailyModel
import com.wangzexin.findvideokotlin.mvp.model.bean.DailyBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class DailyPresenter : BasePresenter<DailyContract.View>(), DailyContract.Presenter {
    private val mDailyModel by lazy {
        DailyModel()
    }

    override fun requestDailyData() {

        mRootView?.showLoading()
        mDailyModel.requestDailyData(0).subscribe(object : Observer<DailyBean> {
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
                addSubscription(d)
            }

            override fun onNext(t: DailyBean) {

            }

            override fun onError(e: Throwable) {

            }
        })

    }

    override fun requestMroeDailyData() {

    }

    override fun attachView(mRootView: DailyContract.View) {

    }

    override fun detachView() {

    }

}