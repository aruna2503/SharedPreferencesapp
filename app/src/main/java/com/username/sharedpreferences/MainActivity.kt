package com.username.sharedpreferences

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.username.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: Editor
    lateinit var someThing:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            btnSave.setOnClickListener {
                preferences()
                editor.putString("Something",etSomething.text.toString())//it is used to store the data
                editor.commit()//without using commit data will not store

            }
            btnRead.setOnClickListener {
                preferences()
                someThing= sharedPreferences.getString("Something","").toString()
                tvSomething.text=someThing

            }
            btnClear.setOnClickListener {
                editor.clear()
                editor.commit()
            }
        }

    }

    private fun preferences() {
        sharedPreferences = getSharedPreferences("MAIN", MODE_PRIVATE)
        editor=sharedPreferences.edit()

    }


}
