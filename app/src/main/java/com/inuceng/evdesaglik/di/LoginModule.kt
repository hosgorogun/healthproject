package com.inuceng.evdesaglik.di

import com.inuceng.evdesaglik.repository.UserRepository
import com.inuceng.evdesaglik.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {

    single {
        UserRepository()
    }

    viewModel {
        LoginViewModel(
            userRepository = get()
        )
    }
}