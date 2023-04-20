package com.example.recicle.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.recicle.R
import com.example.recicle.databinding.FragmentUserDatailsBinding

class UserDetailsFragment: Fragment() {
    private lateinit var binding: FragmentUserDatailsBinding
    private val viewModel: UserDetailsViewModel by viewModels {factory()}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadUser(requireArguments().getLong(ARG_USER_ID))


    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDatailsBinding.inflate(inflater,container,false)

        viewModel.userDetails.observe(viewLifecycleOwner, Observer {
            binding.userNameTextView.text = it.user.name
            if(it.user.photo.isNotBlank()){
                Glide.with(this)
                    .load(it.user.photo)
                    .circleCrop()
                    .into(binding.photoImageView)
            }else{
                Glide.with(this)
                    .load(R.drawable.ic_user_avatar)
                    .into(binding.photoImageView)

            }
            binding.userDetailsTextView.text = it.details

        })

        binding.deleteButton.setOnClickListener{
            viewModel.deleteUser()
            //todo
        }







        return binding.root
    }

    companion object {

        private const val ARG_USER_ID = "ARG_USER_ID"

        fun newInstance(userId: Long): UserDetailsFragment {
            val fragment = UserDetailsFragment()
            fragment.arguments = bundleOf(ARG_USER_ID to userId)
            return fragment
        }

    }
}