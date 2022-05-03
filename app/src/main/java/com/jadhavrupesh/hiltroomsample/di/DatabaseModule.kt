package com.jadhavrupesh.hiltroomsample.di

import android.content.Context
import androidx.room.Room
import com.jadhavrupesh.hiltroomsample.roomDb.UserDao
import com.jadhavrupesh.hiltroomsample.roomDb.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(context, UserDatabase::class.java, UserDatabase.DB_NAME_NEW)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideOrderDao(userRoomDb: UserDatabase): UserDao {
        return userRoomDb.userDao()
    }

}