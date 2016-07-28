package com.lalbuquerque.gettingstarted.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.lalbuquerque.gettingstarted.R
import com.lalbuquerque.gettingstarted.entity.User
import com.lalbuquerque.gettingstarted.extension.toast
import com.lalbuquerque.gettingstarted.ui.adapter.UserListAdapter
import kotlinx.android.synthetic.main.activity_users.*

class UsersActivity : AppCompatActivity() {

    val onUserClick: (User) -> Unit = {
        toast("${it.name}, your current amount is: ${it.amount}")
    }

    val list = listOf(User("Lucas", "-150,00", onUserClick),
            User("Luke", "150,00", onUserClick),
            User("lukas", "1500,00", onUserClick))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        val facetedList = list.filter { it.name.endsWith("as") }
                .apply { this.forEach { it.name.capitalize() } }

        val userListAdapter = UserListAdapter(facetedList)

        usersRecyclerView.layoutManager = LinearLayoutManager(this)
        usersRecyclerView.adapter = userListAdapter
    }

}
