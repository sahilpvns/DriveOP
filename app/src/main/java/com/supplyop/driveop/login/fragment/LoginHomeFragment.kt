package com.supplyop.driveop.login.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.supplyop.driveop.R
import com.supplyop.driveop.login.api.method.BaseResponse
import com.supplyop.driveop.login.api.method.LoginResponse
import com.supplyop.driveop.login.viewmodel.LoginViewModel
import com.supplyop.driveop.ui.activity.DashboardActivity

class LoginHomeFragment : Fragment() {

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login_home, container, false)


        viewModel.loginResult.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    stopLoading()
                    processLogin(it.data)
                }

                is BaseResponse.Error -> {
                    processError(it.msg)
                }

                else -> {
                    stopLoading()
                }
            }
        }


        val btn = view.findViewById<TextView>(R.id.btnLogin)
        btn.setOnClickListener {
            doLogin()
        }

        val forgotPassword = view.findViewById<TextView>(R.id.tvForgotPassword)
        forgotPassword.setOnClickListener {
            val fragment: Fragment = ForgotPasswordFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        }

        return view
    }

    private fun doLogin() {
        val etEmail = view?.findViewById<EditText>(R.id.etEmail)
        val etPassword = view?.findViewById<EditText>(R.id.etPassword)

        val email = etEmail?.text.toString()
        val pwd = etPassword?.text.toString()

        viewModel.loginUser(email = email, pwd = pwd)
    }

    private fun processError(msg: String?) {
        showToast("Error:$msg")
    }

    private fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    private fun processLogin(data: LoginResponse?) {
        if (data?.message.equals("Success")) {
            navigateToHome()
        } else {
            Toast.makeText(context, data?.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToHome() {
        val intent = Intent(context, DashboardActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        startActivity(intent)
        activity?.finish()
    }

    val prgbar = view?.findViewById<ProgressBar>(R.id.prgbar)

    private fun stopLoading() {
        prgbar?.visibility = View.GONE
    }

    private fun showLoading() {
        prgbar?.visibility = View.VISIBLE
    }


}