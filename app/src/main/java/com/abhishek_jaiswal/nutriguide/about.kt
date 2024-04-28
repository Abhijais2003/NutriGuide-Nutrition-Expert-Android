package com.abhishek_jaiswal.nutriguide

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class about : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    fun openInstagram(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_abhishek_jaiswal_official/"))
        startActivity(browserIntent)
    }

    fun openGithub(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Abhijais2003"))
        startActivity(browserIntent)
    }

    fun openLinkedIn(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/20abhishek/"))
        startActivity(browserIntent)
    }

    fun openInstagram1(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/princekumar.9199?utm_source=qr&igsh=MTloNjVvcDV2d2Joaw%3D%3D"))
        startActivity(browserIntent)
    }

    fun openLinkedIn1(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/prince-kumar-164376227/?originalSubdomain=in"))
        startActivity(browserIntent)
    }

    fun openGithub1(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Prince-kumar27"))
        startActivity(browserIntent)
    }
}
