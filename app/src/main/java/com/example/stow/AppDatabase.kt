package com.example.stow

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [User::class, Vehicle::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDAO(): UserDAO
    abstract fun VehicleDAO(): VehicleDAO

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "invertory_db"
                ).build().also {instance = it }
            }
    }
}