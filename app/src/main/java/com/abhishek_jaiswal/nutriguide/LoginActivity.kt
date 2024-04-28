package com.abhishek_jaiswal.nutriguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abhishek_jaiswal.nutriguide.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebashaut: FirebaseAuth
    private lateinit var authStateListener : FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebashaut = FirebaseAuth.getInstance()

        authStateListener = FirebaseAuth.AuthStateListener {
            val firebaseUser = it.currentUser
            if (firebaseUser != null) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        binding.loginbutton.setOnClickListener {
            val email = binding.useremail.text.toString()
            val pass = binding.Passwordlogin.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebashaut.signInWithEmailAndPassword(email, pass).addOnCompleteListener {

                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Invalid email && Password", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Field can't be empty", Toast.LENGTH_SHORT).show()
            }
        }
        binding.logintosignupbutton.setOnClickListener {
            val signintent = Intent(this, SignupActivity::class.java)
            startActivity(signintent)
        }
    }

    override fun onStart() {
        super.onStart()
        firebashaut.addAuthStateListener(authStateListener)
    }

    override fun onStop() {
        super.onStop()
        if (authStateListener != null) {
            firebashaut.removeAuthStateListener(authStateListener)
        }
    }
}
