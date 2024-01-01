package com.inuceng.evdesaglik.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.inuceng.evdesaglik.data.User
import com.inuceng.evdesaglik.databinding.ActivityRegisterBinding
import com.inuceng.evdesaglik.repository.UserRepository

class RegisterActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityRegisterBinding.inflate(LayoutInflater.from(this))
    }

    private val userRepository = UserRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (binding.editTextTc.toString().length==11)
        {
            
        }
        binding.buttonKaydet.setOnClickListener {

            val user = User(
                tc = binding.editTextTc.text.toString() ,
                name = binding.editTextIsim.text.toString(),
                password = binding.editTextSifre.text.toString(),
                dateOfBirth = binding.editTextDgmtrh.text.toString(),
                lastName = binding.editTextSoyisim.text.toString(),
            )

            userRepository.registerUser(
                user = user,
                onSuccess = ::handleSuccessRegister
            )
        }
    }

    private fun handleSuccessRegister() {
        Toast.makeText(this, "Kullanıcı olusturuldu!", Toast.LENGTH_SHORT).show()
        finish()
    }
}