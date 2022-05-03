package com.jadhavrupesh.hiltroomsample.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jadhavrupesh.hiltroomsample.model.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        const val DB_NAME_OLD = "room-database"
        const val DB_NAME_NEW = "ROOM-DB"
        const val DB_VERSION = 1
    }
}