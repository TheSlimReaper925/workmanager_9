package com.example.myapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resource")
data class Resource (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "year")
    val year: Int?,

    @ColumnInfo(name = "color")
    val color: String?,

    @ColumnInfo(name = "pantone_value")
    val pantoneValue: String?
    )