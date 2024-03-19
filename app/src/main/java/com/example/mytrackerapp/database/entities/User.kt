package com.example.mytrackerapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    var email: String?=null,
    var password: String?=null,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)