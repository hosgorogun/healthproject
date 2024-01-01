package com.inuceng.evdesaglik.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.inuceng.evdesaglik.databinding.ActivityLoginBinding
import com.inuceng.evdesaglik.ui.auth.register.RegisterActivity
import com.inuceng.evdesaglik.ui.dashboard.HostActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(LayoutInflater.from(this))
    }

    private val viewModel: LoginViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonGotoRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.buttonLogin.setOnClickListener {
            viewModel.login(
                tc = binding.editTextTc.text.toString(),
                password = binding.editTextSifre.text.toString(),
            )
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loginResult.collectLatest { user ->
                    if (user != null) {
                        val intent = Intent(this@LoginActivity, HostActivity::class.java)
                        intent.putExtra("name", user.name)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }
}