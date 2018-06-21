package com.wangzexin.findvideokotlin.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import me.bakumon.statuslayoutmanager.library.DefaultOnStatusChildClickListener
import me.bakumon.statuslayoutmanager.library.StatusLayoutManager

/**
 *
 * @author wangzexin
 * @date 2018/1/18
 * @describe
 */
abstract class BaseActivity : AppCompatActivity() {

    //多状态布局管理器
    private var statusLayoutManager: StatusLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView()
        initData()
        requestData()
    }

    /**
     * 获取布局id
     */
    abstract fun layoutId(): Int

    /**
     * 初始化view
     */
    abstract fun initView()

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 请求数据
     */
    abstract fun requestData()

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

    /**
     * 打开软键盘
     */
    fun openKeyBord(mEditText: EditText, mContext: Context) {
        val imm = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN)
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    /**
     * 关闭软键盘
     */
    fun closeKeyBord(mEditText: EditText, mContext: Context) {
        val imm = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mEditText.windowToken, 0)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}