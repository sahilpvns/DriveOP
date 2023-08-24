package com.supplyop.driveop.login.fragment

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentLoginHomeBinding
import com.supplyop.driveop.login.activity.DashboardActivity
import com.supplyop.driveop.login.network.BaseResponse
import com.supplyop.driveop.login.network.LoginResponse
import com.supplyop.driveop.login.utils.Utils.withColor
import com.supplyop.driveop.login.viewmodel.LoginViewModel

class LoginHomeFragment : Fragment() {
    private val binding get() = _binding!!
    private var _binding: FragmentLoginHomeBinding? = null

    var sharedPreferences: SharedPreferences? = null

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentLoginHomeBinding.inflate(inflater, container, false)


        binding.ivHidePwd.setOnClickListener {
            togglePasswordVisibility(binding.etPassword)
            toggleEyeIcon(binding.ivHidePwd, binding.etPassword.transformationMethod !is PasswordTransformationMethod)
        }


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
            forgotPasswordFragment()
        }

        return binding.root
    }

    private fun forgotPasswordFragment() {
        val fragment: Fragment = ForgotPasswordFragment()
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    private fun toggleEyeIcon(ivHidePwd: ImageView, showPassword: Boolean) {
        if (showPassword) {
            ivHidePwd.setImageResource(R.drawable.visibility_on_pwd)
        } else {
            ivHidePwd.setImageResource(R.drawable.visibility_off_pwd)
        }
    }

    private fun togglePasswordVisibility(etPassword: TextInputEditText) {
        val isPasswordVisible = etPassword.transformationMethod !is PasswordTransformationMethod
        etPassword.transformationMethod = if (isPasswordVisible) PasswordTransformationMethod() else null
        etPassword.setSelection(etPassword.text?.length ?: 0)
    }

    private fun doLogin() {

        binding.apply {
            if (etEmail.length() == 0) {
                etEmail.requestFocus()
                tvEmailErrorTxt.visibility = View.VISIBLE
                tvPasswordTxt.visibility = View.GONE
            } else if (etPassword.length() == 0) {
                etPassword.requestFocus()
                tvPasswordTxt.visibility = View.VISIBLE
                tvEmailErrorTxt.visibility = View.GONE
            } else {
                tvPasswordTxt.visibility = View.GONE
                tvEmailErrorTxt.visibility = View.GONE

                                val username = etEmail.text.toString()
                val pwd = etPassword.text.toString()
                viewModel.loginUser(username = username, pwd = pwd)

                sharedPreferences = activity?.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)
                val editor = sharedPreferences?.edit()

                editor?.putString(KEY_NAME, etEmail.text.toString())
                editor?.putString(KEY_NUMBER, etPassword.text.toString())
                editor?.apply()
                viewModel.loginUser(username = username, pwd = pwd)

            }
        }

    }

    private fun processError(msg: String?) {
        Toast.makeText(context, "please fill valid username & password", Toast.LENGTH_SHORT).show()
        stopLoading()
    }


    private fun processLogin(data: LoginResponse?) {
        if (data?.message.equals("Success")) {
            navigateToHome()
        } else {
            Snackbar.make(binding.root, data?.message.toString(), Snackbar.LENGTH_LONG).withColor(Color.RED).show()
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

    companion object {
        private const val SHARED_PREF_NAME = "MyPref"
        private const val KEY_NAME = "name"
        private const val KEY_NUMBER = "number"
    }


}