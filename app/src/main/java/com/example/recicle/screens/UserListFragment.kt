package com.example.recicle.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recicle.UserActionListener
import com.example.recicle.UsersAdapter
import com.example.recicle.databinding.FragmentUserDatailsBinding
import com.example.recicle.databinding.FragmentUsersListBinding
import com.example.recicle.model.User


class UserListFragment: Fragment() {


    private lateinit var binding: FragmentUsersListBinding
    private lateinit var adapter: UsersAdapter

    private val viewModel: UsersListViewModel by viewModels{factory()}


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersListBinding.inflate(inflater,container,false)
        adapter = UsersAdapter(object: UserActionListener {
            override fun onUserMove(user: User, moveBy: Int) {
                viewModel.moveUser(user, moveBy)
            }

            override fun onUserDelete(user: User) {
                viewModel.deleteUser(user)
            }

            override fun onUserDetails(user: User) {

            }

        })

        viewModel.users.observe(viewLifecycleOwner, Observer {
          //  Toast.makeText(activity, "User: ", Toast.LENGTH_SHORT).show()

            adapter.users = it
        })
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager= layoutManager
        binding.recyclerView.adapter = adapter

        return binding.root
    }

}