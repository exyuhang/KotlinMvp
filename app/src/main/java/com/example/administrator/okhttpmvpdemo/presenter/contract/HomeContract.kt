package com.example.administrator.okhttpmvpdemo.presenter.contract

import com.example.administrator.okhttpmvpdemo.View.BaseView
import com.example.administrator.okhttpmvpdemo.model.entity.InfoBean
import com.example.administrator.okhttpmvpdemo.presenter.BasePresenter

interface HomeContract {
    interface OkHttpFragmentView :BaseView<OkHttpFragmentPresenter>{
        fun setInfoResult(infoBean: InfoBean)
    }

    interface OkHttpFragmentPresenter :BasePresenter.OkHttpFragmentPresenter{

    }

}