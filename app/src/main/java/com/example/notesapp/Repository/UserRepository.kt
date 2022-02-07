package com.example.notesapp.Repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import com.example.notesapp.DataBase.UserDataBase
import com.example.notesapp.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepository {
    companion object{
        private var userDataBase:UserDataBase?=null
        fun initialiseDB(context: Context): UserDataBase? {
            return UserDataBase.getInstance(context)

        }
        fun insert(context: Context, user: User){
            userDataBase= initialiseDB(context)
            CoroutineScope(IO).launch {
                userDataBase?.getDao()?.insert(user)
            }
        }

        fun getAllUserData(context: Context): LiveData<List<User>>? {
            userDataBase= initialiseDB(context)
            return userDataBase?.getDao()?.getAllUserData()
        }
    }
}


