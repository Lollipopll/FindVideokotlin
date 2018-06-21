package com.wangzexin.findvideokotlin.ui.fragment

import com.wangzexin.findvideokotlin.R
import com.wangzexin.findvideokotlin.base.BaseFragment

class HotFragment : BaseFragment() {


    companion object {
        fun getInstance(title: String): HotFragment {
            val hotFragment = HotFragment()
            return hotFragment
        }
    }

    override fun layoutId(): Int = R.layout.fragment_hot

    override fun initView() {

    }

    override fun lazyLoad() {

    }


}