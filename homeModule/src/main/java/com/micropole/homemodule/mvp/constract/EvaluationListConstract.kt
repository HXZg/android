package com.micropole.homemodule.mvp.constract

import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * @ClassName       EvaluationListConstract
 * @Description     评论列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 11:13
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationListConstract {

    interface View : BaseMvpView{

    }

    abstract class Model{

    }

    abstract class Present : BaseMvpPresenter<Model,View>(){

    }
}