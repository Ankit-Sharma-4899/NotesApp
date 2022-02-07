package com.example.notesapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.model.User

class UserAdapter(private val context: Context, private var userList: ArrayList<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user:User=userList[position]
        holder.name.text=user.name
        holder.age.text=user.age.toString()
    }
    fun setData(userList: ArrayList<User>){
        this.userList=userList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = userList.size

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val name:TextView=itemView.findViewById(R.id.name)
        val age:TextView=itemView.findViewById(R.id.age)
    }


}