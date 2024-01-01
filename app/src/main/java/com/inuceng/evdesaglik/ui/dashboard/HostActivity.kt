package com.inuceng.evdesaglik.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.inuceng.evdesaglik.databinding.ActivityHostBinding

class HostActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityHostBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}