package com.supplyop.driveop.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ActivityChatBinding
import com.supplyop.driveop.databinding.ActivityDashboardBinding
import com.supplyop.driveop.databinding.ActivityShipmentDetailsBinding

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChatBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        supportActionBar?.hide()
        toolbarHeader()
    }

    private fun toolbarHeader() {
        binding.chatHeader.apply {
            headerTitle.text = String.format("Chat")
            menuItem.setBackgroundResource(R.drawable.arrow_back)
            menuItem.setOnClickListener { finish() }
        }
    }

}