package com.xx.baseutilslibrary.network.exception

import java.io.IOException

/**
 * TokenInvalidException
 * (。・∀・)ノ
 * Describe：权限码失效异常,单token时使用
 * Created by 雷小星🍀 on 2017/8/22 10:34.
 */

class TokenInvalidException(message: String) : IOException(message)
