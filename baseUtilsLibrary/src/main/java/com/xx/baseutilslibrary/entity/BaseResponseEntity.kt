package com.xx.baseutilslibrary.entity

/**
 * ResponseEntity
 * 类描述: 公共响应体
 * 作者: LeiXiaoXing on 2017/1/9 20:08
 */

class BaseResponseEntity<T> : BaseResponseStatusEntity {

    var data: T? = null

    constructor(status: String, data: T?) : super(status) {
        this.data = data
    }

    constructor(status: Int, data: T?) : super(status) {
        this.data = data
    }

    constructor(status: String, msg: String, data: T?) : super(status, msg) {
        this.data = data
    }

    constructor(status: Int, msg: String, data: T?) : super(status, msg) {
        this.data = data
    }
}
