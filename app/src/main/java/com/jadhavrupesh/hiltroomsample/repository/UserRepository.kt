package com.jadhavrupesh.hiltroomsample.repository

import com.jadhavrupesh.hiltroomsample.model.User
import com.jadhavrupesh.hiltroomsample.roomDb.UserDao
import timber.log.Timber
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao,
) {

    suspend fun addData(user: User) {
        Timber.d("Inserting user $user")
        userDao.insertUser(user)
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

}