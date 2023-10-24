package com.example.taskmanager.feature.login.view

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.taskmanager.BR
import com.example.taskmanager.R
import com.example.taskmanager.base.BaseActivity
import com.example.taskmanager.databinding.ActivityLoginBinding
import com.example.taskmanager.feature.home.view.HomeActivity
import com.example.taskmanager.feature.login.LoginNavigation
import com.example.taskmanager.feature.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity(
    override val bindingVariable: Int = BR.loginVm,
    override val layoutId: Int = R.layout.activity_login
) : BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginNavigation {
    private lateinit var binding: ActivityLoginBinding
    override fun onViewClicked(view: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewDataBinding()
        viewModel.setNavigator(this)

        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.splash_fade_in)
        fadeIn.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                navigateToHome()
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })
        binding.ivAppLogo.startAnimation(fadeIn)
    }

    override fun navigateToHome() {
        HomeActivity.present(this@LoginActivity)
        finish()
    }
}