package com.lalbuquerque.gettingstarted.entity

    data class User(val name: String,
                     val amount: String,
                     val onClick: (User) -> Unit = {})