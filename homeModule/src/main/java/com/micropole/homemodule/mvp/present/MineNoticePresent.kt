package com.micropole.homemodule.mvp.present

import com.micropole.homemodule.mvp.constract.MineNoticeConstract
import com.micropole.homemodule.mvp.model.MineNoticeModel

/**
 * @ClassName       MineColletPresent
 * @Description     消息列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 14:31
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineNoticePresent : MineNoticeConstract.Present(){
    override fun createModel(): MineNoticeConstract.Model {
        return MineNoticeModel()
    }
}