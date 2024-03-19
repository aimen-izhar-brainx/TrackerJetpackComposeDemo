package com.example.mytrackerapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mytrackerapp.database.dao.UserDao
import com.example.mytrackerapp.database.entities.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class MyTrackerAppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}
