package com.supplyop.driveop.login.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.supplyop.driveop.R
import com.supplyop.driveop.ui.activity.DashboardActivity


class EmailVerifyFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_email_verify, container, false)

        val btn = view.findViewById<TextView>(R.id.btnSubmit)
        btn.setOnClickListener {
            val intent = Intent(context, DashboardActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return view
    }


}