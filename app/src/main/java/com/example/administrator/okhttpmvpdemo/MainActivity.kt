package com.example.administrator.okhttpmvpdemo

import android.view.KeyEvent
import android.widget.FrameLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.administrator.okhttpmvpdemo.base.BaseActivity
import com.example.administrator.okhttpmvpdemo.fragment.FragmentBuilder
import com.example.administrator.okhttpmvpdemo.fragment.OkHttpFragment
import com.example.administrator.okhttpmvpdemo.fragment.RetrofitFragment


class MainActivity : BaseActivity()  {
    var fragment_container:FrameLayout ?=null
    var rg_group:RadioGroup ?=null
    var rb_Okhttp:RadioButton ?=null
    var rb_Retrofit:RadioButton ?=null
    var mExitTime:Long ?=0
    override fun initActivityListener() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        rg_group!!.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rb_Okhttp ->{
                    FragmentBuilder.instance.start(R.id.fragment_container,OkHttpFragment ::class.java).buid()
                }
                R.id.rb_Retrofit ->{
                    FragmentBuilder.instance.start(R.id.fragment_container,RetrofitFragment ::class.java).buid()
                }

            }
        }
    }

    override fun initActivityData() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        FragmentBuilder.instance.start(R.id.fragment_container,OkHttpFragment ::class.java).buid()
    }

    override fun initActivityView() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        setTitleBar("宇航制造")
        fragment_container = findViewById(R.id.fragment_container) as FrameLayout
        rg_group = findViewById(R.id.rg_group) as RadioGroup
        rb_Okhttp = findViewById(R.id.rb_Okhttp) as RadioButton
        rb_Retrofit = findViewById(R.id.rb_Retrofit) as RadioButton

    }


    override fun getActivityLayout(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return R.layout.activity_main
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.repeatCount == 0) {
            exit()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun exit() {
        if (System.currentTimeMillis() - mExitTime!! > 2000) {
            showToast("再按一次退出程序")
            mExitTime = System.currentTimeMillis()
        } else {
            finish()
            System.exit(0)
        }
    }

}
