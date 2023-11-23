package com.inuceng.evdesaglik.viewmodel

import androidx.lifecycle.ViewModel
import com.inuceng.evdesaglik.data.User
import com.inuceng.evdesaglik.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel(
    private val userRepository: UserRepository
): ViewModel() {

    private val _loginResult: MutableStateFlow<User?> = MutableStateFlow(null)
    val loginResult = _loginResult.asStateFlow()

    fun login(tc: String, password: String) {
        userRepository.loginUser(
            tc = tc,
            password = password,
            onSuccess = ::handleSuccessLogin)
    }

    private fun handleSuccessLogin(user: User) {
        _loginResult.value = user
    }


}