package com.example.myapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ResourceDao {
    @Insert
    fun insert(vararg resource: Resource)

    @Query("DELETE FROM resource WHERE id NOT IN (" +
            "SELECT id FROM resource ORDER BY id LIMIT 10)")
    fun delete()

    @Query("SELECT * FROM resource;")
    fun selectAll(): List<Resource>
}