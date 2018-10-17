package com.xx.baseutilslibrary.entity

/**
 * ResponseEntity
 * 类描述: 公共响应体
 * 作者: LeiXiaoXing on 2017/1/9 20:08
 */

open class BaseResponseStatusEntity {

    var status: String? = FAILE
    var code: String? = null
    var msg: String? = null


    /**
     * 构造方法,模拟数据用
     *
     * @param result 响应结果
     */
    constructor(status: String) {
        this.status = status
    }

    /**
     * 构造方法,模拟数据用
     *
     * @param result 响应结果
     */
    constructor(status: Int) {
        this.status = status.toString()
    }

    /**
     * 构造方法,模拟数据用
     *
     * @param result 响应结果 1为成功
     * @param msg    响应消息
     */
    constructor(status: String, msg: String) {
        this.status = status
        this.msg = msg
    }

    /**
     * 构造方法,模拟数据用
     *
     * @param result 响应结果 1为成功
     * @param msg    响应消息
     */
    constructor(status: Int, msg: String) {
        this.status = status.toString()
        this.msg = msg
    }


    companion object {
        /**
         * 成功状态
         */
        val SUCCESS = "1"
        /**
         * 失败状态
         */
        val FAILE = "0"
    }
}
