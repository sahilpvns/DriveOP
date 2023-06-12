package com.supplyop.driveop.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.supplyop.driveop.R
import com.supplyop.driveop.login.fragment.LoginHomeFragment
import com.supplyop.driveop.login.fragment.ShortestDistanceFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            val fragment: Fragment = LoginHomeFragment()
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commitAllowingStateLoss()
        }


    }
}