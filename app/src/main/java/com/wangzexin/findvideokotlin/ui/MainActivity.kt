package com.wangzexin.findvideokotlin.ui

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.wangzexin.findvideokotlin.R
import com.wangzexin.findvideokotlin.base.BaseActivity
import com.wangzexin.findvideokotlin.mvp.model.bean.TabEntity
import com.wangzexin.findvideokotlin.ui.fragment.DailyFragment
import com.wangzexin.findvideokotlin.ui.fragment.DiscoveryFragment
import com.wangzexin.findvideokotlin.ui.fragment.HotFragment
import com.wangzexin.findvideokotlin.ui.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mTitles = arrayOf("每日精选", "发现", "热门", "我的")
    private val mSelectedIcon = arrayOf(R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected)
    private val mUnSelectedIcon = arrayOf(R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal)
    private val mTabEntities = ArrayList<CustomTabEntity>()

    private var mDailyFragment: DailyFragment? = null
    private var mDiscoveryFragment: DiscoveryFragment? = null
    private var mHotFragment: HotFragment? = null
    private var mMineFragment: MineFragment? = null

    //当前选择的tab下标
    private var mCurrentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        if (null != savedInstanceState) {
            mCurrentIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (null != tab_layout) {
            outState!!.putInt("currTabIndex", mCurrentIndex)
        }
    }

    override fun layoutId(): Int = R.layout.activity_main

    override fun initView() {
        //将现有数据转化为其他数据然后加入到目的集合中
        (0 until mTitles.size).mapTo(mTabEntities) { TabEntity(mTitles[it], mSelectedIcon[it], mUnSelectedIcon[it]) }
        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {

            }
        })
//        tab_layout.currentTab = mCurrentIndex
        switchFragment(mCurrentIndex)
    }


    override fun initData() {

    }

    override fun requestData() {

    }

    private fun switchFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)

        when (position) {
            0 //每日
            -> {
                if (null == mDailyFragment) {
                    mDailyFragment = DailyFragment.getInstance(mTitles[position])

                    transaction.add(R.id.fl_container, mDailyFragment, "mDailyFragment")
                } else {
                    transaction.show(mDailyFragment)
                }

            }

            1//发现
            -> {
                if (null == mDiscoveryFragment) {
                    mDiscoveryFragment = DiscoveryFragment.getInstance(mTitles[position])

                    transaction.add(R.id.fl_container, mDiscoveryFragment, "mDiscoveryFragment")
                } else {
                    transaction.show(mDiscoveryFragment)
                }

            }

            2//热门
            -> {
                if (null == mHotFragment) {
                    mHotFragment = HotFragment.getInstance(mTitles[position])

                    transaction.add(R.id.fl_container, mHotFragment, "mHotFragment")
                } else {
                    transaction.show(mHotFragment)
                }

            }

            3//我的
            -> {
                if (null == mMineFragment) {
                    mMineFragment = MineFragment.getInstance(mTitles[position])

                    transaction.add(R.id.fl_container, mMineFragment, "mMineFragment")
                } else {
                    transaction.show(mMineFragment)
                }

            }
        }
        mCurrentIndex = position
//        tab_layout.currentTab = mCurrentIndex
        transaction.commitAllowingStateLoss()

    }

    private fun hideFragments(transaction: FragmentTransaction) {

        if (null != mDailyFragment) {
            transaction.hide(mDailyFragment)
        }
        if (null != mDiscoveryFragment) {
            transaction.hide(mDiscoveryFragment)
        }
        if (null != mHotFragment) {
            transaction.hide(mHotFragment)
        }
        if (null != mMineFragment) {
            transaction.hide(mMineFragment)
        }
    }

}

