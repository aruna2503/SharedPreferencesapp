package com.username.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.username.sharedpreferences.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var number:String
    lateinit var password:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences()
        number=sharedPreferences.getString("Number","").toString()
        binding.tvNumber.text=number
        password=sharedPreferences.getString("password","").toString()
        binding.tvPassword.text=password

        binding.apply {
            btnLogout.setOnClickListener {
                editor.clear()
                editor.commit()
                startActivity(Intent(this@HomePage,LoginPage::class.java))
                finish()

            }
        }
    }
    private fun preferences() {
        sharedPreferences = getSharedPreferences("LOGIN", MODE_PRIVATE)
        editor=sharedPreferences.edit()

    }


}