package com.inuceng.evdesaglik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.inuceng.evdesaglik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonKaydet.setOnClickListener {
            val yeniKullanici = hashMapOf(
                "tc" to binding.editTextTc.text.toString(),
                "isim" to binding.editTextIsim.text.toString(),
                "sifre" to binding.editTextSifre.text.toString(),
            )

            db.collection("kullanicilar")
                .add(yeniKullanici)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this, "Kullanıcı olusturuldu!", Toast.LENGTH_SHORT).show()
                    binding.editTextTc.setText("")
                    binding.editTextIsim.setText("")
                    binding.editTextSifre.setText("")
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Hata", Toast.LENGTH_SHORT).show()
                }
        }
    }
}