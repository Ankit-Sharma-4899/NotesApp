package com.example.notesapp.UserViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.notesapp.Repository.UserRepository
import com.example.notesapp.model.User

class UserViewModel:ViewModel() {

    fun insert(context: Context,user: User) {
        UserRepository.insert(context,user)
    }
    fun getAllUserData(context: Context):LiveData<List<User>>?{
        return UserRepository.getAllUserData(context)
    }
}