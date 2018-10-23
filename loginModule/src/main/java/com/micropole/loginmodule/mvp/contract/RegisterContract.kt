package com.micropole.loginmodule.mvp.contract

import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:
 */
interface RegisterContract {
    interface View :BaseMvpView{
    }
    interface Model{

    }
    abstract class Presenter:BaseMvpPresenter<Model,View>(){
    }
}