package com.inuceng.evdesaglik.ui.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inuceng.evdesaglik.databinding.FragmentHospitalBinding
import org.koin.android.ext.android.inject

class HospitalFragment : Fragment() {

    companion object {
        fun newInstance() = HospitalFragment()
    }

    private val viewModel: HospitalViewModel by inject()
    private var binding: FragmentHospitalBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHospitalBinding.inflate(inflater)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}