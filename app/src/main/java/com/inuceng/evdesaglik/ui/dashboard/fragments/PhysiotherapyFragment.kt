package com.inuceng.evdesaglik.ui.dashboard.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inuceng.evdesaglik.R
import com.inuceng.evdesaglik.databinding.FragmentPharmacyBinding
import com.inuceng.evdesaglik.databinding.FragmentPhysiotherapyBinding
import org.koin.android.ext.android.inject

class PhysiotherapyFragment : Fragment() {
    private var binding: FragmentPhysiotherapyBinding? = null

    private val viewModel: PhysiotherapyViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhysiotherapyBinding.inflate(inflater)
        return binding?.root
    }

}