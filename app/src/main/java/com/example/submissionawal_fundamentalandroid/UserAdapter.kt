package com.example.githubuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load

import com.example.githubuser.databinding.ItemUserBinding
import com.example.submissionawal_fundamentalandroid.data.model.Item
import com.example.submissionawal_fundamentalandroid.data.model.ResponseUserGithub

class UserAdapter (private val data:MutableList<ResponseUserGithub.Item> = mutableListOf()):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    fun setData(data: List<ResponseUserGithub.Item>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    class UserViewHolder(private val v: ItemUserBinding) : RecyclerView.ViewHolder(v.root){
        fun bind(item: ResponseUserGithub.Item){
            v.image.load(item.avatar_url){

            }
    v.nama.text = item.login


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = data.size
}