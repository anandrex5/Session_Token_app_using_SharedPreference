package com.example.sessioninandroidappusingsharedpreference

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sessioninandroidappusingsharedpreference.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSession()
    }

    private fun getSession() {
        val sharedPreferences = getSharedPreferences(MainActivity.PREFS_NAME, Context.MODE_PRIVATE)
        val sessionId = sharedPreferences.getString(MainActivity.SESSION_ID, null)

        if (sessionId != null) {
            Log.d("AnotherActivity", "Retrieved Session ID: $sessionId")

            // Update the TextView with the retrieved session ID
            binding.tvSessionId.text = "Session ID: $sessionId"

        } else {
            Log.d("AnotherActivity", "No session found!")
            binding.tvSessionId.text = "No session found!"

        }
    }
}