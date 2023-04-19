package com.example.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recicle.App
import androidx.fragment.app.Fragment

class ViewModelFactory(
    private val app: App
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel:UserListViewModel = when(modelClass){
            UserListViewModel::class.java -> {
                UserListViewModel(app.userService)
            }else ->{
                throw IllegalStateException("Unknown view model class")

            }
        }
        return viewModel as T
    }

}
fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as App)