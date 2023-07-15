package com.codersinvasion.articlo.app.di


import com.codersinvasion.articlo.ui.create_account.viewModel.CreateAccountViewModel
import com.codersinvasion.articlo.ui.login.viewModel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val viewModelModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::CreateAccountViewModel)
}