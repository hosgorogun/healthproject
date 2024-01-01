package com.inuceng.evdesaglik.ui.auth.register

import androidx.lifecycle.ViewModel
import com.inuceng.evdesaglik.data.User
import com.inuceng.evdesaglik.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _registerResult: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val registerResult = _registerResult.asStateFlow()

    fun registerUser(user: User) {
        userRepository.registerUser(
            user,
            onSuccess = {
                _registerResult.value = true
            })
    }
}