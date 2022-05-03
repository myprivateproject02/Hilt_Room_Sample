package com.jadhavrupesh.hiltroomsample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jadhavrupesh.hiltroomsample.model.User
import com.jadhavrupesh.hiltroomsample.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    var repository: UserRepository
) : ViewModel() {

    var userFinalList: LiveData<List<User>> = MutableLiveData<List<User>>()

    private val allUsers = MutableLiveData<List<User>>()
    fun getAllUsersStream(): LiveData<List<User>> = allUsers

    init {
        getAllUsers()
    }

    fun getAllUsers() {
        viewModelScope.launch {
            val allUsersData = repository.getAllUsers()
            allUsers.postValue(allUsersData)
        }
    }

    fun insertData(user: User) {
        viewModelScope.launch {
            Timber.d("Inserting user in viewmodel is ${user}")
            repository.addData(user)
        }
    }

}