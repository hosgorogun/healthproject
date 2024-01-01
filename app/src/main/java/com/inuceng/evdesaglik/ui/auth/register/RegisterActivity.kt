package com.inuceng.evdesaglik.ui.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.inuceng.evdesaglik.data.User
import com.inuceng.evdesaglik.databinding.ActivityRegisterBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class RegisterActivity : AppCompatActivity() {

    private val viewModel: RegisterViewModel by inject()

    private val binding by lazy {
        ActivityRegisterBinding.inflate(LayoutInflater.from(this))
    }

    private fun isValidPassword(password: String): Boolean {
        val passwordRegex = "^(?=.*[!@#$%^&*()\\-_=+{};:,<.>]).{6,}$".toRegex()
        return passwordRegex.matches(password)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonKaydet.setOnClickListener {
            val tc  = binding.editTextTc.text.toString()
            val password = binding.editTextSifre.text.toString()
            if(tc.length != 11) {
                Toast.makeText(this@RegisterActivity, "TC no hatali!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(isValidPassword(password).not()) {
                Toast.makeText(this@RegisterActivity, "Sifre hatali!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(
                tc = binding.editTextTc.text.toString() ,
                name = binding.editTextIsim.text.toString(),
                password = binding.editTextSifre.text.toString(),
                dateOfBirth = binding.editTextDgmtrh.text.toString(),
                lastName = binding.editTextSoyisim.text.toString(),
            )

            viewModel.registerUser(user = user)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.registerResult.collectLatest { result ->
                    if (result) {
                        Toast.makeText(this@RegisterActivity, "Kullanıcı olusturuldu!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            }
        }
    }
}