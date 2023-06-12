package com.supplyop.driveop.login.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.supplyop.driveop.login.fragment.ShortestDistanceFragment


class WelcomeNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.supplyop.driveop.R.layout.activity_welcome_note)

        supportActionBar?.hide()

        val btn1 = findViewById<Button>(com.supplyop.driveop.R.id.btn2)
        btn1.setOnClickListener {
            val fragment: Fragment = ShortestDistanceFragment()
            val fragmentManager: FragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().replace(com.supplyop.driveop.R.id.shipfram, fragment).commit()
        }

    }
}