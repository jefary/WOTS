package com.example.stow
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class User (
    @PrimaryKey val userID: String,
    val name: String,
    val rate: Int
)