package com.abhishek_jaiswal.nutriguide

import EdamamResponse
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abhishek_jaiswal.nutriguide.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, NutritionFragment())
                .commit()
        }

        binding.submitBtn.setOnClickListener {
            val foodName = binding.editText.text.toString().trim()

            if (foodName.isEmpty()) {
                Toast.makeText(this, "Please enter a food name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Make API request with Retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.edamam.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService = retrofit.create(EdamamApiService::class.java)
            val call = apiService.getNutritionData("89c00de8", "5be60b13561740c65d06e33ac0b4f8c1", foodName)
            call.enqueue(object : Callback<EdamamResponse> {
                override fun onResponse(call: Call<EdamamResponse>, response: Response<EdamamResponse>) {
                    if (response.isSuccessful) {
                        val edamamResponse = response.body()
                        Log.d("API Response", "Response received: $edamamResponse")
                        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
                        if (fragment is NutritionFragment && fragment.view != null && edamamResponse != null) {
                            fragment.displayNutrition(edamamResponse)
                        }
                    } else {
                        // Handle error response
                        Log.d("API Error", "Response received but not successful. Error code: ${response.code()}, message: ${response.message()}")
                        Toast.makeText(applicationContext, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<EdamamResponse>, t: Throwable) {
                    // Handle network error
                    Log.d("API Failure", "No response received. Failure message: ${t.message}")
                    if (t is IOException) {
                        Toast.makeText(applicationContext, "Network error occurred", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, "An error occurred", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.drawer_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about-> {
                val intent = Intent(this, about::class.java)
                startActivity(intent)
                true
            }
            R.id.contact -> {
                val intent = Intent(this, contact::class.java)
                startActivity(intent)
                true
            }
            R.id.version -> {
                val intent = Intent(this, version::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
