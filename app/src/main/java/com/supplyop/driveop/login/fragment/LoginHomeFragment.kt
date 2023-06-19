package com.supplyop.driveop.login.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentLoginHomeBinding
import com.supplyop.driveop.login.api.method.BaseResponse
import com.supplyop.driveop.login.api.method.LoginResponse
import com.supplyop.driveop.login.viewmodel.LoginViewModel
import com.supplyop.driveop.ui.activity.DashboardActivity

class LoginHomeFragment : Fragment() {
    private val binding get() = _binding!!
    private var _binding: FragmentLoginHomeBinding? = null

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginHomeBinding.inflate(inflater, container, false)


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

        binding.btnLogin.setOnClickListener {
            doLogin()
        }

        binding.tvForgotPassword.setOnClickListener {
            val fragment: Fragment = ForgotPasswordFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        }

        return binding.root
    }

    private fun doLogin() {
        val email = binding.etEmail.text.toString()
        val pwd = binding.etPassword.text.toString()
        viewModel.loginUser(email = email, pwd = pwd)
    }

    private fun processError(msg: String?) {
        Toast.makeText(context, "$msg Something went wrong", Toast.LENGTH_SHORT).show()
        stopLoading()
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

    private fun stopLoading() {
        binding.prgbar.visibility = View.GONE
    }

    private fun showLoading() {
        binding.prgbar.visibility = View.VISIBLE
    }


}