package com.inuceng.evdesaglik.ui.dashboard.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inuceng.evdesaglik.R
import com.inuceng.evdesaglik.databinding.FragmentPhysiotherapyBinding
import com.inuceng.evdesaglik.databinding.FragmentPsychologyBinding
import org.koin.android.ext.android.inject

class PsychologyFragment : Fragment() {
    private var binding: FragmentPsychologyBinding? = null

    private val viewModel: PhysiotherapyViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPsychologyBinding.inflate(inflater)
        return binding?.root
    }

}