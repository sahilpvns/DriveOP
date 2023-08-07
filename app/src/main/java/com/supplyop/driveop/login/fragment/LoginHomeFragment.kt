package com.supplyop.driveop.login.fragment

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentLoginHomeBinding
import com.supplyop.driveop.login.network.BaseResponse
import com.supplyop.driveop.login.network.LoginResponse
import com.supplyop.driveop.login.viewmodel.LoginViewModel
import com.supplyop.driveop.login.activity.DashboardActivity
import com.supplyop.driveop.login.utils.Utils.withColor

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

        if (binding.etEmail.length() == 0) {
            Snackbar.make(binding.root, "Please fill valid Email", Snackbar.LENGTH_LONG).withColor(Color.RED).show()
        } else if (binding.etPassword.length() == 0) {
            Snackbar.make(binding.root, "Please fill valid Password", Snackbar.LENGTH_LONG).withColor(Color.RED).show()
        } else {
            val username = binding.etEmail.text.toString()
            val pwd = binding.etPassword.text.toString()
            viewModel.loginUser(username = username, pwd = pwd)

            sharedPreferences = activity?.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)
            val editor = sharedPreferences?.edit()

            editor?.putString(KEY_NAME, binding.etEmail.text.toString())
            editor?.putString(KEY_NUMBER, binding.etPassword.text.toString())
            editor?.apply()
            viewModel.loginUser(username = username, pwd = pwd)
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