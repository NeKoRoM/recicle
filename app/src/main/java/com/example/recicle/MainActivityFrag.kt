package com.example.recicle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recicle.databinding.ActivityMainBinding
import com.example.recicle.databinding.ActivityMainFragBinding
import com.example.recicle.databinding.FragmentUsersListBinding
import com.example.recicle.model.User
import com.example.recicle.screens.UserListFragment

class MainActivityFrag : AppCompatActivity(),Navigator {

    private lateinit var binding: ActivityMainFragBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainFragBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, UserListFragment())
                .commit()
        }
    }

    override fun showDetails(user: User) {
        TODO("Not yet implemented")
    }

    override fun goBack() {
        TODO("Not yet implemented")
    }

    override fun toast(messageRes: Int) {
        TODO("Not yet implemented")
    }
}