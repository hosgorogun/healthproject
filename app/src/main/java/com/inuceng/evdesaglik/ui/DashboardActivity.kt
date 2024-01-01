package com.inuceng.evdesaglik.ui

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.inuceng.evdesaglik.databinding.ActivityDashboardBinding


class DashboardActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDashboardBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textWelcome.text = "Hosgeldiniz, ${intent.extras?.getString("name")}"
        

    }

}