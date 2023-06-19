package com.supplyop.driveop.login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.supplyop.driveop.R
import com.supplyop.driveop.login.fragment.ShortestDistanceFragment


class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_note)

        supportActionBar?.hide()

        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            val fragment: Fragment = ShortestDistanceFragment()
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commitAllowingStateLoss()
        }

    }
}