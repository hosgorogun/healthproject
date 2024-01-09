package com.inuceng.evdesaglik.ui.dashboard.fragments

import androidx.lifecycle.ViewModel
import com.inuceng.evdesaglik.data.Appointment
import com.inuceng.evdesaglik.repository.AppointmentRepository
import com.inuceng.evdesaglik.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HospitalViewModel(
    private val appointmentRepository: AppointmentRepository,
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _createResult: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val createResult = _createResult.asStateFlow()

    fun createAppointment(appointment: Appointment) {
        val appointment = appointment.copy(user = userRepository.currentUser.tc)
        appointmentRepository.createAppointment(
            appointment = appointment,
            onSuccess = {
                _createResult.value = true
            }
        )
    }
}