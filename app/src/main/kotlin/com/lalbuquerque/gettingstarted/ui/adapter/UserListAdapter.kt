package com.lalbuquerque.gettingstarted.ui.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lalbuquerque.gettingstarted.R
import com.lalbuquerque.gettingstarted.entity.User
import kotlinx.android.synthetic.main.user_item.view.*

class UserListAdapter(val usersList: List<User>) :
        RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    val NEGATIVE_AMOUNT = 0
    val POSITIVE_AMOUNT = 1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder {
        val userLayout = LayoutInflater.from(parent?.context)
                .inflate(R.layout.user_item, parent, false)

        with(userLayout) {

            when (viewType) {
                NEGATIVE_AMOUNT -> name.setTextColor(Color.RED)
                POSITIVE_AMOUNT -> name.setTextColor(Color.BLUE)
            }

            return UserViewHolder(this, name)
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        with(usersList[position]) {
            holder?.name?.text = name
            holder?.itemView?.setOnClickListener { onClick(this) }
        }
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun getItemViewType(position: Int): Int {
        with(usersList[position]) {

            when {
                amount.contains("-") -> return NEGATIVE_AMOUNT
                else -> return POSITIVE_AMOUNT
            }
        }
    }

    class UserViewHolder(itemView: View,
                         val name: TextView) : RecyclerView.ViewHolder(itemView)
}