package com.abhishek_jaiswal.nutriguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splashScreen : AppCompatActivity() {
    private val splac_time:Long=2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed(
            {
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            },splac_time)
    }
}