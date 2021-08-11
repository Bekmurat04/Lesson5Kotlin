package com.example.lesson5kotlin1.ui.videos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson5kotlin1.R

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)


        var text = intent.getStringExtra("key")
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}