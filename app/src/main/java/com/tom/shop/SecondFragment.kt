package com.tom.shop

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import com.tom.shop.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val cameraPermission = Manifest.permission.CAMERA
    val testCameraPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                takePoto()
            } else {
                binding.textviewSecond.text = "you no Camera permission"
            }
        }

    private fun takePoto() {
        binding.textviewSecond.text = "Opening Camera"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        if (ActivityCompat.checkSelfPermission(requireContext(), cameraPermission) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            takePoto()
        } else {
            testCameraPermission.launch(cameraPermission)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}