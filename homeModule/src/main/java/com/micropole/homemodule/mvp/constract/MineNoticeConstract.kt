package com.micropole.homemodule.mvp.constract

import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       MineColletConstract
 * @Description     收藏，足迹
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 14:29
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineNoticeConstract {

    interface View:BaseMvpView{}

    abstract class Model {}

    abstract class Present : BaseMvpPresenter<Model,View>(){}
}