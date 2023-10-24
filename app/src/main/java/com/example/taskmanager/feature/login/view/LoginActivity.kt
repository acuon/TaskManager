package com.example.taskmanager.feature.login.view

import android.view.View
import com.example.taskmanager.BR
import com.example.taskmanager.R
import com.example.taskmanager.base.BaseActivity
import com.example.taskmanager.databinding.ActivityLoginBinding
import com.example.taskmanager.feature.login.LoginNavigation
import com.example.taskmanager.feature.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity(
    override val bindingVariable: Int = BR.loginVm,
    override val layoutId: Int = R.layout.activity_login
) : BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginNavigation {
    override fun onViewClicked(view: View?) {

    }
}