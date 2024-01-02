package com.inuceng.evdesaglik.ui.dashboard.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.inuceng.evdesaglik.R
import com.inuceng.evdesaglik.databinding.FragmentHospitalBinding
import org.koin.android.ext.android.inject
import java.util.Calendar

class HospitalFragment : Fragment()
{
    var selectedDate = "a"


    companion object {
        fun newInstance() = HospitalFragment()
    }

    private val viewModel: HospitalViewModel by inject()
    private var binding: FragmentHospitalBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHospitalBinding.inflate(inflater)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

       var datePicker = binding!!.datePicker

        datePicker.setOnClickListener {
            showDatePickerDialog()
        }


        val spinner: Spinner = binding!!.spinner

        // ArrayAdapter ile Spinner'a veri bağlama
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.choices,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        // Spinner üzerinde bir seçim yapıldığında gerçekleşecek olayları dinleme
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                // Seçilen öğe ile ilgili yapılacak işlemler
                val selectedItem = parent.getItemAtPosition(position).toString()
                showToast("Seçilen öğe: $selectedItem")
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Hiçbir şey seçilmediğinde yapılacak işlemler
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)



        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, monthOfYear, dayOfMonth ->
                // Kullanıcı bir tarih seçtiğinde yapılacak işlemler
               selectedDate = "$dayOfMonth-${monthOfYear + 1}-$year"
                // Burada seçilen tarih ile istediğiniz işlemleri yapabilirsiniz
                binding!!.editText.setText(selectedDate)
            },
            day,
            month,
            year
        )

        // Dialog'un kapatılabilmesi için CancelListener ekleniyor
        datePickerDialog.setOnCancelListener {
            // Kullanıcı iptal ettiğinde yapılacak işlemler
        }

        datePickerDialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()}

}
