package com.inuceng.evdesaglik.di

import com.inuceng.evdesaglik.repository.UserRepository
import com.inuceng.evdesaglik.ui.auth.login.LoginViewModel
import com.inuceng.evdesaglik.ui.auth.register.RegisterViewModel
import com.inuceng.evdesaglik.ui.dashboard.fragments.HospitalViewModel
import com.inuceng.evdesaglik.ui.dashboard.fragments.PharmacyViewModel
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

    viewModel {
        RegisterViewModel(
            userRepository = get()
        )
    }

    viewModel {
        HospitalViewModel(

        )

    }
    viewModel{
        PharmacyViewModel(

        )
    }
}