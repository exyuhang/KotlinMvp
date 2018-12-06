package com.example.administrator.okhttpmvpdemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import android.widget.Toast

import com.example.administrator.okhttpmvpdemo.App
import com.example.administrator.okhttpmvpdemo.R


abstract class  BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.mActivity=this
        App.mFragmentActivity=this
        setContentView(getActivityLayout())
        initActivityView();
        initActivityData();
        initActivityListener();
    }

    abstract fun initActivityListener()

    abstract fun initActivityData()

    abstract fun initActivityView()

    abstract fun getActivityLayout(): Int
    fun showToast( toast : String){
        Toast.makeText(this,toast,Toast.LENGTH_SHORT).show()
    }


    fun setTitleBar(title :String){
        var tb_mToolbar : Toolbar?= findViewById(R.id.tb_mToolbar) as Toolbar
        var tb_title :TextView ?= findViewById(R.id.tb_title) as TextView
        if (tb_mToolbar!=null){
            tb_mToolbar.setNavigationIcon(R.mipmap.return_icon_btn)
            tb_mToolbar.setNavigationOnClickListener(View.OnClickListener {
                finish()
                System.exit(0)
            })
        }
        if (tb_title!=null){
            tb_title.setText(title)
        }
    }

}