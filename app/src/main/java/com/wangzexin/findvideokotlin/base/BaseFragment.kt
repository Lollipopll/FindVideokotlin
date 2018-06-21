package com.wangzexin.findvideokotlin.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.bakumon.statuslayoutmanager.library.DefaultOnStatusChildClickListener
import me.bakumon.statuslayoutmanager.library.StatusLayoutManager

/**
 *
 * @author wangzexin
 * @date 2018/1/18
 * @describe
 */
abstract class BaseFragment : Fragment() {
    //View是否加载完毕
    private var isViewPrepare = false
    //是否加载过数据
    private var hasLoad = false

    //多状态布局管理器
    private var statusLayoutManager: StatusLayoutManager? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(layoutId(), null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepare = true
        initView()
        lazyLoadIfPrepare()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadIfPrepare()
        }
    }

    /**
     * 加载布局文件
     */
    abstract fun layoutId(): Int


    /**
     * 初始化view
     */
    abstract fun initView()


    /**
     * 加载数据
     */
    abstract fun lazyLoad()


    private fun lazyLoadIfPrepare() {
        if (userVisibleHint && isViewPrepare && !hasLoad) {
            lazyLoad()
            hasLoad = true
        }
    }

    /**
     * 初始化多状态布局管理器
     *
     * @param view 要嵌套的view
     */
    fun initStatusLayoutMnager(view: View) {

        statusLayoutManager = StatusLayoutManager.Builder(view)
                // 设置重试事件监听器
                .setOnStatusChildClickListener(object : DefaultOnStatusChildClickListener() {
                    override fun onEmptyChildClick(view: View?) {

                    }

                    override fun onErrorChildClick(view: View?) {

                    }
                })
                .build()
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}


