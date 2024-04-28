package com.abhishek_jaiswal.nutriguide

// VersionActivity.kt
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class version : AppCompatActivity() {

    private lateinit var checkUpdateButton: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_version)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        checkUpdateButton = findViewById(R.id.btn)
        progressBar = findViewById(R.id.progress_bar)

        checkUpdateButton.setOnClickListener {

            progressBar.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.GONE

                Toast.makeText(this, "No updates available", Toast.LENGTH_SHORT).show()
            }, 3000)
        }
    }
}
