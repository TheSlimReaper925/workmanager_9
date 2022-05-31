package com.example.myapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Resource::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getResourceDao(): ResourceDao
}