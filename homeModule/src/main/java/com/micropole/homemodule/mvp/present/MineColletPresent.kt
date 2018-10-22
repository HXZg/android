package com.micropole.homemodule.mvp.present

import com.micropole.homemodule.mvp.constract.MineColletConstract
import com.micropole.homemodule.mvp.model.MineColletModel

/**
 * @ClassName       MineColletPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 14:31
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineColletPresent : MineColletConstract.Present(){
    override fun createModel(): MineColletConstract.Model {
        return MineColletModel()
    }
}