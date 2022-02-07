package com.example.notesapp.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notesapp.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (user:User)
    @Query("SELECT * FROM user ORDER BY id asc")
    fun getAllUserData():LiveData<List<User>>
}
