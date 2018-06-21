package com.wangzexin.findvideokotlin.ui.fragment

import com.wangzexin.findvideokotlin.R
import com.wangzexin.findvideokotlin.base.BaseFragment

class MineFragment : BaseFragment() {


    companion object {
        fun getInstance(title: String): MineFragment {
            val mineFragment = MineFragment()
            return mineFragment
        }
    }

    override fun layoutId(): Int = R.layout.fragment_mine

    override fun initView() {

    }

    override fun lazyLoad() {

    }


}