package com.jadhavrupesh.hiltroomsample.roomDb

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jadhavrupesh.hiltroomsample.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * from user")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * from user where id = :id")
    suspend fun getUserBId(id: Int): User
}