package com.inuceng.evdesaglik.ui.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.inuceng.evdesaglik.databinding.FragmentDashboardBinding
import org.koin.android.ext.android.inject

class DashboardFragment : Fragment() {

    companion object {
        fun newInstance() = DashboardFragment()
    }

    private val viewModel: DashboardViewModel by inject()
    private var binding: FragmentDashboardBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater)

        binding?.buttonHastane?.setOnClickListener {
            this@DashboardFragment.findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToHospitalFragment())
        }
        binding?.buttonEczane?.setOnClickListener {
            this@DashboardFragment.findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToPharmacyFragment())
        }
        binding?.buttonFizyoterapist?.setOnClickListener {
            this@DashboardFragment.findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToPhysiotherapyFragment())
        }
        binding?.buttonPsikolog?.setOnClickListener {
            this@DashboardFragment.findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToPsychologyFragment())
        }

        return binding?.root
    }


}