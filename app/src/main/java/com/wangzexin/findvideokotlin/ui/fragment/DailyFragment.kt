package com.wangzexin.findvideokotlin.ui.fragment

import com.wangzexin.findvideokotlin.R
import com.wangzexin.findvideokotlin.base.BaseFragment
import com.wangzexin.findvideokotlin.mvp.contract.DailyContract
import com.wangzexin.findvideokotlin.mvp.presenter.DailyPresenter
import kotlinx.android.synthetic.main.fragment_daily.*

class DailyFragment : BaseFragment(), DailyContract.View {
    private val mPresenter by lazy { DailyPresenter() }

    companion object {
        fun getInstance(title: String): DailyFragment {
            val dailyFragment = DailyFragment()
            return dailyFragment
        }
    }

    override fun layoutId(): Int = R.layout.fragment_daily


    override fun initView() {
        mPresenter.attachView(this)
        refresh_layout.setOnRefreshListener {
            mPresenter.requestDailyData()
        }


    }

    override fun lazyLoad() {
        mPresenter.requestDailyData()
    }

    override fun setDailyData() {

    }

    override fun setMoreDailyDatd() {

    }

    override fun showError(msg: String, errorCode: Int) {

    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

}