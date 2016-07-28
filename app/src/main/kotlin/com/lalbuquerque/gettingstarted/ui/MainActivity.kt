package com.lalbuquerque.gettingstarted.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lalbuquerque.gettingstarted.R
import com.lalbuquerque.gettingstarted.entity.User
import com.lalbuquerque.gettingstarted.extension.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val user = User(name = "Lucas", amount = "-150,00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userTextView.text = "Look at me using Kotlin Extensions"

        val onDummyButtonClick: (User) -> Unit = {
            toast("${it.name}, your current amount is: ${it.amount}")
        }

        dummyButton.setOnClickListener {
            onDummyButtonClick(user)
            startActivity(Intent(MainActivity@this, UsersActivity::class.java))
        }
    }

}



