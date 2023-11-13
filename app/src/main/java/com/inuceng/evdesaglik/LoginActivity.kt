package com.inuceng.evdesaglik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.inuceng.evdesaglik.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(LayoutInflater.from(this))
    }

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonGotoRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.buttonLogin.setOnClickListener {

            db.collection("kullanicilar")
                .whereEqualTo("tc", binding.editTextTc.text.toString())
                .whereEqualTo("sifre", binding.editTextSifre.text.toString())
                .get()
                .addOnSuccessListener { documents ->
                    if (documents.isEmpty.not()) {
                        val intent = Intent(this, DashboardActivity::class.java)
                        intent.putExtra("name", documents.first().get("isim").toString())
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Kullanıcı adı veya sifre hatalı girdiniz", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Hata", Toast.LENGTH_SHORT).show()
                }
        }
    }
}