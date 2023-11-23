package com.inuceng.evdesaglik.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
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