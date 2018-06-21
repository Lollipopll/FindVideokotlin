package com.wangzexin.findvideokotlin.net

/**
 *
 * @author wangzexin
 * @date 2018/1/23
 * @describe
 */
class BaseResponse<T>(val code: Int, val msg: String, val data: T)