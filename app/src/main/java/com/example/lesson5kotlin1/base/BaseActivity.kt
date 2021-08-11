 package com.example.lesson5kotlin1.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(private val layout:Int) : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        showDisconnectState()
        setUpUI()
        setUpLiveData()

    }

    abstract fun setUpLiveData()

    abstract fun setUpUI()

    abstract fun showDisconnectState()
}