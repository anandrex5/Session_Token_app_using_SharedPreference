package com.example.sessioninandroidappusingsharedpreference

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sessioninandroidappusingsharedpreference.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    companion object {
        const val PREFS_NAME = "user_session"
        const val SESSION_ID = "session_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            createSession()
        }

    }

    fun createSession() {
        val sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val sessionId = UUID.randomUUID().toString()
        sharedPreferences.edit().putString(SESSION_ID,sessionId).apply()

        Log.d("LogActivity","Session created with ID: $sessionId")

        val intent  = Intent(this,SecondActivity::class.java)
        startActivity(intent)
    }

}