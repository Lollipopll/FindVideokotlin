package com.wangzexin.findvideokotlin.ui.fragment

import com.wangzexin.findvideokotlin.R
import com.wangzexin.findvideokotlin.base.BaseFragment

class DiscoveryFragment : BaseFragment() {


    companion object {
        fun getInstance(title: String): DiscoveryFragment {
            val discoveryFragment = DiscoveryFragment()
            return discoveryFragment
        }
    }

    override fun layoutId(): Int = R.layout.fragment_discovery

    override fun initView() {

    }

    override fun lazyLoad() {

    }


}