package com.example.lesson5kotlin1.ui.disconnect


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.lesson5kotlin1.R
import com.example.youtubeparser27.ui.disconnect.NetworkCheker
import kotlinx.android.synthetic.main.activity_network.*

class NetworkActivity : AppCompatActivity() {
    private lateinit var networkChecker: NetworkCheker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        networkChecker = NetworkCheker(this)


        btn1.setOnClickListener {
            if(isNetworkAvailable()){
                finish()
            }else{
                Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun isNetworkAvailable(): Boolean {
        var isAvailable: Boolean = false
        networkChecker.observe(
            this,
            Observer {
                isAvailable = it })
        return isAvailable
    }

}