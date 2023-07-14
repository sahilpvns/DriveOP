package com.supplyop.driveop.login.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.supplyop.driveop.R

class SplashActivity : AppCompatActivity() {

    var sharedPreferences: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)

        val stringName = sharedPreferences?.getString(KEY_NAME, null)
        val stringNumber = sharedPreferences?.getString(KEY_NUMBER, null)

        Handler(Looper.getMainLooper()).postDelayed({
            if (stringName != null  && stringNumber != null) {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, OnboardingActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 2000) // 2 sec

    }

    companion object {
        private const val SHARED_PREF_NAME = "MyPref"
        private const val KEY_NAME = "name"
        private const val KEY_NUMBER = "number"
    }
}