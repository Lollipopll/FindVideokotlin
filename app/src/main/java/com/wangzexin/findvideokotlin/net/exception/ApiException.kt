package com.wangzexin.findvideokotlin.net.exception

/**
 *
 * @author wangzexin
 * @date 2018/1/23
 * @describe
 */
class ApiException : RuntimeException {
    private var code: Int? = null

    //类没有主构造函数，次构造函数使用关键字 super初始化其类型
    constructor(message: String) : super(Throwable(message))

    constructor(throwable: Throwable, code: Int) : super(throwable) {
        this.code = code
    }
}