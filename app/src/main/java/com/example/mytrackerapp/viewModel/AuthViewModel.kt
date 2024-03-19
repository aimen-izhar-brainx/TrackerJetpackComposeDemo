package com.example.mytrackerapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrackerapp.database.entities.User
import com.example.mytrackerapp.database.repo.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepo: UserRepo,

    ) : ViewModel() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    fun insertUserIntoDb(user: User) = viewModelScope.launch {
        userRepo.insertStudentItem(user)
    }

    fun getUser() :Flow<List<User>> {
        return userRepo.getUser()
    }
}