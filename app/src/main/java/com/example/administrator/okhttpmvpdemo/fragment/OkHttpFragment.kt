package com.example.administrator.okhttpmvpdemo.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.example.administrator.okhttpmvpdemo.R
import com.example.administrator.okhttpmvpdemo.base.BaseFragment
import com.example.administrator.okhttpmvpdemo.model.entity.InfoBean
import com.example.administrator.okhttpmvpdemo.presenter.OkHttpFragmentPresenter
import com.example.administrator.okhttpmvpdemo.presenter.contract.HomeContract


/**
 * A simple [Fragment] subclass.
 */
class OkHttpFragment : BaseFragment(), HomeContract.OkHttpFragmentView , View.OnClickListener  {

    private var btn_Load :Button ?=null
    private var btn_DownLoad :Button ?=null
    private var presenter: HomeContract.OkHttpFragmentPresenter ?=null
    companion object {
        var mapInfo :Map<String ,String> = HashMap<String , String>()
    }



    override fun setBundle(bundle: Bundle) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initFragmentView(inflate: View) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
         btn_Load  = inflate.findViewById<Button>(R.id.btn_Load)
         btn_DownLoad  = inflate.findViewById<Button>(R.id.btn_DownLoad)
    }

    override fun getFragmentLayout(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return R.layout.fragment_ok_http
    }

    override fun initFragmentListener() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        btn_Load!!.setOnClickListener(this)
        btn_DownLoad!!.setOnClickListener(this)
    }

    override fun initFragmentData() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var okHttpFragmentPresenter:OkHttpFragmentPresenter= OkHttpFragmentPresenter(this)
    }

    override fun initFragmentShow() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initFragmentHidden() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(v: View?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        when(v!!.id){
            R.id.btn_Load ->{
                (mapInfo as MutableMap<String, String>).put("key","097060266650f67b2cebd2a06aded587");
                (mapInfo as MutableMap<String, String>).put("type","yule");
                presenter!!.startInfoResult();
                (mapInfo as MutableMap<String, String>).clear()
            }
            R.id.btn_DownLoad ->{
                showToast("btn_DownLoad")
            }
        }
    }


    override fun setInfoResult(infoBean: InfoBean) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        showToast(infoBean.reason)
    }

    override fun setPresenter(presenter: HomeContract.OkHttpFragmentPresenter) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        this.presenter=presenter
    }





}// Required empty public constructor
