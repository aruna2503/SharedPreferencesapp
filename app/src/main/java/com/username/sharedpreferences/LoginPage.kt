package com.username.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.username.sharedpreferences.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {
    lateinit var binding: ActivityLoginPageBinding
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnLogin.setOnClickListener {
                preferences()
                editor.putString("Number", etNumber.text.toString())
                editor.putString("password", etPassword.text.toString())
                editor.putBoolean("Login_status", true)
                editor.commit()

                startActivity(Intent(this@LoginPage, HomePage::class.java))
                finish()

            }


        }

    }

    private fun preferences() {
        sharedPreferences = getSharedPreferences("LOGIN", MODE_PRIVATE)
        editor = sharedPreferences.edit()

    }

    override fun onStart() {
        super.onStart()
        preferences()
        if (
            sharedPreferences.getBoolean("Login_status",false)==true

        ){
            startActivity(Intent(this@LoginPage, HomePage::class.java))
            finish()
        }
        else
        {
            Toast.makeText(this, "please login", Toast.LENGTH_SHORT).show()
        }
    }
}