package com.example.mytrackerapp.database.repo

import androidx.lifecycle.LiveData
import com.example.mytrackerapp.database.entities.User
import kotlinx.coroutines.flow.Flow

interface UserRepo {

    suspend fun insertStudentItem(user: User)
    fun getUser(): Flow<List<User>>

}