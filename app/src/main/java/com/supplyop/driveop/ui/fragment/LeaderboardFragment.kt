package com.supplyop.driveop.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.supplyop.driveop.databinding.FragmentLeaderboardBinding
import com.supplyop.driveop.ui.ViewModel.LeaderboardViewModel

class LeaderboardFragment : Fragment() {

    private var _binding: FragmentLeaderboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val leaderboardViewModel = ViewModelProvider(this)[LeaderboardViewModel::class.java]

        _binding = FragmentLeaderboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        leaderboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}