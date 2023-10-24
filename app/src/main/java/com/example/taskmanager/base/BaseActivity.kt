package com.example.taskmanager.base

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.taskmanager.utils.hideSoftKeyboard
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding?, V : BaseViewModel<*>> :
    AppCompatActivity(), BaseFragment.Callback {
    private var viewDataBinding: T? = null

    //injecting the viewmodel
    @Inject
    lateinit var viewModel: V

    //method for getting the binding variable - viewmodel reference
    abstract val bindingVariable: Int

    @get:LayoutRes
    abstract val layoutId: Int

    fun showToast(str: String?) {
        Toast.makeText(viewDataBinding!!.root.context, str, Toast.LENGTH_SHORT).show()
    }

    override fun onFragmentAttached() {}
    override fun onFragmentDetached(tag: String) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    fun getViewDataBinding() = viewDataBinding!!

    fun hasPermission(permission: String?): Boolean {
        return checkSelfPermission(permission!!) == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermissionsSafely(permissions: Array<String?>?, requestCode: Int) {
        requestPermissions(permissions!!, requestCode)
    }

    protected abstract fun onViewClicked(view: View?)
    var clickListener =
        View.OnClickListener { view ->
            hideSoftKeyboard()
            onViewClicked(view)
        }

    //setting the binding variable
    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        viewDataBinding!!.setVariable(bindingVariable, viewModel)
        viewDataBinding!!.executePendingBindings()
    }
}



