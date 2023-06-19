package com.supplyop.driveop.login.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentEarnMoreBinding
import com.supplyop.driveop.databinding.FragmentEmailVerifyBinding
import com.supplyop.driveop.ui.activity.DashboardActivity


class EmailVerifyFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentEmailVerifyBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentEmailVerifyBinding.inflate(inflater, container, false)

       binding.btnSubmit.setOnClickListener {
            val intent = Intent(context, DashboardActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return binding.root
    }


}