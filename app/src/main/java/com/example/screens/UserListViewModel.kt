package com.example.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recicle.model.User
import com.example.recicle.model.UserService
import com.example.recicle.model.UsersListener

class UserListViewModel(
    private val userService: UserService
):ViewModel() {


    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        loadUsers()
    }

    override fun onCleared() {
        super.onCleared()
        userService.removeListener { listener  }
    }
    fun loadUsers(){
        userService.addListener { listener }

    }

    fun moveUser(user:User, moveBy:Int)
    {
        userService.moveUser(user,moveBy)

    }

    fun deleteUser(user: User){
        userService.deleteUser(user)

    }

    private val listener: UsersListener= {
            _users.value = it
    }

}