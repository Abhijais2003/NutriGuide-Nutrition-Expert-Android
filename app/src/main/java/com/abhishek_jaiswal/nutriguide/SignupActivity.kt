package com.abhishek_jaiswal.nutriguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abhishek_jaiswal.nutriguide.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebashaut: FirebaseAuth
    private lateinit var authStateListener : FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
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

        binding.signupbutton.setOnClickListener {
            val email = binding.signupuser.text.toString()
            val pass = binding.Passwordsignup.text.toString()
            val confirmpasss = binding.confirmPasswordsignup.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmpasss.isNotEmpty()) {
                if (pass == confirmpasss) {
                    firebashaut.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {

                        if (it.isSuccessful) {
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Error creating account", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else {
                    Toast.makeText(this, "Password not matches", Toast.LENGTH_SHORT).show()

                }
            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signuptologginbutton.setOnClickListener {
            val loginintent = Intent(this, LoginActivity::class.java)
            startActivity(loginintent)
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