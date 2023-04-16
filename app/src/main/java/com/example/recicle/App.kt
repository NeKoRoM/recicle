package com.example.recicle

import android.app.Application
import com.example.recicle.model.UserService

class App: Application() {
    val userService= UserService()

}