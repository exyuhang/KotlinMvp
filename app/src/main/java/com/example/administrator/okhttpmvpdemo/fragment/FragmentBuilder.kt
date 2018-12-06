package com.example.administrator.okhttpmvpdemo.fragment

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.example.administrator.okhttpmvpdemo.App
import com.example.administrator.okhttpmvpdemo.base.BaseFragment


class FragmentBuilder  {
    private var mFragmentManager: FragmentManager? = null
    private var mFragmentTransaction: FragmentTransaction? = null
    private var mBaseNowFragment: BaseFragment? = null

    constructor(){
        init()
    }


    /**
     * 初始化FragmentManager
     */
    private fun init() {

        mFragmentManager = App.mFragmentActivity!!.FragmentManager


    }



    fun start(containerId: Int, fragmentClass: Class<out BaseFragment>): FragmentBuilder {
        mFragmentTransaction = mFragmentManager!!.beginTransaction()
        val fragmentTagName = fragmentClass.simpleName
        mBaseNowFragment = mFragmentManager!!
                .findFragmentByTag(fragmentTagName) as BaseFragment?

        try {
            if (mBaseNowFragment == null) {
                mBaseNowFragment = fragmentClass.newInstance()
                mFragmentTransaction!!.add(containerId, mBaseNowFragment, fragmentTagName)
            }
            if (App.mFragment != null) {
                mFragmentTransaction!!.hide(App.mFragment)
            }

            mFragmentTransaction!!.show(mBaseNowFragment)
            mFragmentTransaction!!.addToBackStack(fragmentTagName)
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

        return this
    }

    /**
     * 链式调用的Build()方法
     */
    fun buid(): FragmentBuilder {
        //吧当前的fragment对象赋值给了上一个fragmet
        App.mFragment = mBaseNowFragment
        //提交事务
        mFragmentTransaction!!.commit()
        return this
    }

    fun getFragmentBundle(bundle: Bundle?): BaseFragment? {
        if (bundle != null) {
            mBaseNowFragment!!.setBundle(bundle)
        }
        return mBaseNowFragment
    }

    companion object {
        private var mFragmentBuilder: FragmentBuilder? = null

        val instance: FragmentBuilder
            @Synchronized get() {
                if (mFragmentBuilder == null)
                    mFragmentBuilder = FragmentBuilder()
                return mFragmentBuilder!!

            }
    }


}