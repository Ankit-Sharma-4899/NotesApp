package com.example.notesapp.DataBase

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.Dao.UserDao
import com.example.notesapp.model.User
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(entities =[User::class,] , version = 1,exportSchema =false)
abstract class UserDataBase : RoomDatabase(){
    abstract fun getDao():UserDao

    companion object{
        private const val DATABASE_NAME ="UserDatabase"

        @Volatile
        var instance:UserDataBase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context: Context):UserDataBase?{

            if(instance==null){
                synchronized(UserDataBase:: class.java){
                    if(instance==null){
                        instance=Room.databaseBuilder(context,UserDataBase:: class.java,
                            DATABASE_NAME)
                            .build()

                    }
                }
            }

            return instance
        }
    }

}