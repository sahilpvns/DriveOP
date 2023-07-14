package com.supplyop.driveop.login.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentCommentsBinding
import com.supplyop.driveop.databinding.FragmentDigitalCopiesBinding
import com.supplyop.driveop.databinding.FragmentShipmentGeneralDetailsBinding


class DigitalCopiesFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentDigitalCopiesBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentDigitalCopiesBinding.inflate(inflater, container, false)

        binding.apply {

            btnCapturePOD.setOnClickListener {
                Toast.makeText(context, "Capture POD", Toast.LENGTH_SHORT).show()
            }
            btnRecordException.setOnClickListener {
                Toast.makeText(context, "Record Exception", Toast.LENGTH_SHORT).show()
            }
            btnDownloadInvoice.setOnClickListener {
                Toast.makeText(context, "Download Invoice", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root

    }


}