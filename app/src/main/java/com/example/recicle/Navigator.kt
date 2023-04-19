package com.example.recicle

import com.example.recicle.model.User

interface Navigator {
    fun showDetails(user: User)

    fun goBack()

    fun toast(messageRes: Int)
}