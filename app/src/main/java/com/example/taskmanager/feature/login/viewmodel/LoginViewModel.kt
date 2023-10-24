package com.example.taskmanager.feature.login.viewmodel

import com.example.taskmanager.base.BaseViewModel
import com.example.taskmanager.feature.login.LoginNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): BaseViewModel<LoginNavigation>() {

}