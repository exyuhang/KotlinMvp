package com.example.administrator.okhttpmvpdemo.presenter

import com.example.administrator.okhttpmvpdemo.model.entity.InfoBean
import com.example.administrator.okhttpmvpdemo.model.zip.OkHttpFragmentImpl
import com.example.administrator.okhttpmvpdemo.net.MyCallBack
import com.example.administrator.okhttpmvpdemo.presenter.contract.HomeContract

class OkHttpFragmentPresenter : HomeContract.OkHttpFragmentPresenter{
    private var okHttpFragmentView :HomeContract.OkHttpFragmentView ?=null
    private  var iOkhttpFragmentModel :OkHttpFragmentImpl ?=null

    constructor(okHttpFragmentView: HomeContract.OkHttpFragmentView){
        this.okHttpFragmentView=okHttpFragmentView
        iOkhttpFragmentModel = OkHttpFragmentImpl()
        okHttpFragmentView.setPresenter(this)
    }

    override fun startInfoResult() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        iOkhttpFragmentModel!!.getInfo(object :MyCallBack<InfoBean>{
            override fun Success(t: InfoBean) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                okHttpFragmentView!!.setInfoResult(t)
            }

            override fun Error(error: String) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }


}