package com.inuceng.evdesaglik.ui.dashboard.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inuceng.evdesaglik.R
import com.inuceng.evdesaglik.databinding.FragmentDashboardBinding
import com.inuceng.evdesaglik.databinding.FragmentPharmacyBinding
import org.koin.android.ext.android.inject

class PharmacyFragment : Fragment() {
    private var binding: FragmentPharmacyBinding? = null

    private val viewModel: PharmacyViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPharmacyBinding.inflate(inflater)
        return binding?.root
    }


}