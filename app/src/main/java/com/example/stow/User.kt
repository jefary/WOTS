package com.example.stow
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class User (
    @PrimaryKey val name: String,
    val rate: Int,
)
/*
{
    val userID:String,
    var rate: Int,
    var password: String
}
*/