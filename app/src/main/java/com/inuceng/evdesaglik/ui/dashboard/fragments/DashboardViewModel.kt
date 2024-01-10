package com.inuceng.evdesaglik.ui.dashboard.fragments

import androidx.lifecycle.ViewModel
import com.inuceng.evdesaglik.data.Appointment
import com.inuceng.evdesaglik.repository.AppointmentRepository
import com.inuceng.evdesaglik.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel(
    private val appointmentRepository: AppointmentRepository,
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _appointments: MutableStateFlow<List<Appointment>> = MutableStateFlow(emptyList())
    val appointments = _appointments.asStateFlow()

    fun loadAppointmentsForUser() {
        appointmentRepository.queryAppointmentsByUser(
            tc = userRepository.currentUser.tc,
            onSuccess = {
                _appointments.value = it
            }
        )
    }
}