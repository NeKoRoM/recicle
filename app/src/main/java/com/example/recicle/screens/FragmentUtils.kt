package com.example.recicle.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recicle.App
import androidx.fragment.app.Fragment

class ViewModelFactory(
    private val app: App
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel: ViewModel = when(modelClass){
            UsersListViewModel::class.java -> {
                UsersListViewModel(app.userService)
            }
            UserDetailsViewModel::class.java -> {
                UserDetailsViewModel(app.userService)
            }
            else ->{
                throw IllegalStateException("Unknown view model class")

            }
        }
        return viewModel as T
    }

}
fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as App)