package com.inuceng.evdesaglik.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.inuceng.evdesaglik.data.Appointment

class AppointmentRepository(val db: FirebaseFirestore = Firebase.firestore) {

    companion object {
        const val DATABASE_TABLE_APPOINTMENT = "randevular"
    }

    fun createAppointment(appointment: Appointment, onSuccess: () -> Unit) {

        val newAppointment = hashMapOf(
            "user" to appointment.user,
            "doctor" to appointment.doctor,
            "date" to appointment.date,
            "time" to appointment.time,
        )

        db.collection(DATABASE_TABLE_APPOINTMENT)
            .add(newAppointment)
            .addOnSuccessListener { documentReference ->
                onSuccess.invoke()
            }
    }

    fun queryAppointmentsByUser(tc: String, onSuccess: (List<Appointment>) -> Unit) {
        db.collection(DATABASE_TABLE_APPOINTMENT)
            .whereEqualTo("user", tc)
            .get()
            .addOnSuccessListener { documents ->
                onSuccess(
                    documents.map { document ->
                        Appointment(
                            user = document.get("user").toString(),
                            doctor = document.get("doctor").toString(),
                            date = document.get("date").toString(),
                            time = document.get("time").toString(),
                        )
                    }
                )
            }
    }

}