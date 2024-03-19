package com.example.mytrackerapp.database.repo

import com.example.mytrackerapp.database.dao.UserDao
import com.example.mytrackerapp.database.entities.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultUserRepo @Inject constructor(
    private val userDao: UserDao,
) : UserRepo {
    override suspend fun insertStudentItem(user: User) {
        userDao.insertUser(user)
    }

    override fun getUser(): Flow<List<User>> {
        return  userDao.getUser()
    }
}