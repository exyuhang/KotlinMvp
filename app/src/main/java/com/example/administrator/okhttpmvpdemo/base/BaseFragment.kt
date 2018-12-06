package com.example.administrator.okhttpmvpdemo.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.administrator.okhttpmvpdemo.App

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        App.mFragment=this
        val inflate:View = inflater!!.inflate(getFragmentLayout(), container, false)
        initFragmentView(inflate)
        return inflate
    }

    abstract fun initFragmentView(inflate: View)

    abstract fun getFragmentLayout():Int

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragmentData()
        initFragmentListener()
    }

    abstract fun initFragmentListener()

    abstract fun initFragmentData()

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden){
            initFragmentHidden()
        }else{
            initFragmentShow()
        }
    }

    abstract fun initFragmentShow()

    abstract fun initFragmentHidden()

    fun showToast(toast :String){
        Toast.makeText(context,toast,Toast.LENGTH_SHORT).show()
    }

    abstract fun setBundle(bundle: Bundle)

}