package com.wangzexin.findvideokotlin.net.exception

/**
 *
 * @author wangzexin
 * @date 2018/1/23
 * @describe
 */
object ErrorStatus {

    /**
     * 响应成功
     *  @JvmField 注解可以阻止该变量自动生成getset方法
     */
    @JvmField
    val SUCCESS = 0

    /**
     * 未知错误
     */
    @JvmField
    val UNKNOWN_ERROR = 1002

    /**
     * 服务器内部错误
     */
    @JvmField
    val SERVER_ERROR = 1003

    /**
     * 网络连接超时
     */
    @JvmField
    val NETWORK_ERROR = 1004

    /**
     * API解析异常（或者第三方数据结构更改）等其他异常
     */
    @JvmField
    val API_ERROR = 1005

}