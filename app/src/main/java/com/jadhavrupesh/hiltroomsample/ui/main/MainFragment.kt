package com.jadhavrupesh.hiltroomsample.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.jadhavrupesh.hiltroomsample.R
import com.jadhavrupesh.hiltroomsample.databinding.MainFragmentBinding
import com.jadhavrupesh.hiltroomsample.model.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainFragment : Fragment() {
    val viewModel by viewModels<MainViewModel>()
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllUsersStream().observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                it.forEach { user ->
                    Timber.d("current User is ${user}")
                }
            }
        }

        binding.getUsers.setOnClickListener {
            viewModel.getAllUsers()
        }

        binding.addButton.setOnClickListener {
            val user = User(
                2,
                2,
                "Rupesh2",
                "Jadhav2",
                "382"
            )
            viewModel.insertData(user)
        }

    }
}