package com.inuceng.evdesaglik.ui.dashboard.fragments
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.inuceng.evdesaglik.data.Appointment
import com.inuceng.evdesaglik.databinding.FragmentHospitalBinding
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class HospitalFragment : Fragment() {

    private lateinit var binding: FragmentHospitalBinding
    private val doctors = listOf("Dr.Ogün Hoşgör", "Dr.ULaş Can Yazıcı", "Dr.Umut Çalışkan") // Örnek doktor listesi
    private val calendar = Calendar.getInstance()

    private val viewModel: HospitalViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHospitalBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDatePicker()
        setupDoctorSpinner()
        setupTimeSlots()

        binding.createAppointmentButton.setOnClickListener {
            createAppointment()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.createResult.collectLatest { result ->
                if(result) {
                    findNavController().navigate(HospitalFragmentDirections.actionHospitalFragmentToDashboardFragment())
                }
            }
        }
    }

    private fun setupDatePicker() {
        updateDateInView()

        binding.datePickerButton.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                { _, year, month, dayOfMonth ->
                    calendar.set(year, month, dayOfMonth)
                    updateDateInView()
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun updateDateInView() {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val selectedDate = dateFormat.format(calendar.time)
        binding.selectedDateText.text = selectedDate
    }

    private fun setupDoctorSpinner() {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, doctors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.doctorSpinner.adapter = adapter
    }

    private fun setupTimeSlots() {
        val timeSlots = (9..15).map { "$it:00" } // 9:00'dan 15:00'a saat aralıkları
        val timeSlotAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, timeSlots)
        timeSlotAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.timeSlotSpinner.adapter = timeSlotAdapter
    }

    private fun createAppointment() {
        val selectedDate = binding.selectedDateText.text.toString()
        val selectedDoctor = binding.doctorSpinner.selectedItem.toString()
        val selectedTimeSlot = binding.timeSlotSpinner.selectedItem.toString()

        viewModel.createAppointment(
            Appointment(
                doctor = selectedDoctor,
                date = selectedDate,
                time = selectedTimeSlot,
                user = ""
            )
        )

    }
}

