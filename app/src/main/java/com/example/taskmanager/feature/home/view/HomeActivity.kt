package com.example.taskmanager.feature.home.view

import android.view.View
import com.example.taskmanager.BR
import com.example.taskmanager.R
import com.example.taskmanager.base.BaseActivity
import com.example.taskmanager.databinding.ActivityMainBinding
import com.example.taskmanager.feature.home.HomeNavigation
import com.example.taskmanager.feature.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity(
    override val bindingVariable: Int = BR.vm,
    override val layoutId: Int = R.layout.activity_main
) : BaseActivity<ActivityMainBinding, HomeViewModel>(), HomeNavigation {

    override fun onViewClicked(view: View?) {

    }

    override fun handleError(throwable: Throwable) {

    }
}